package thegreatk.somethingmod.block;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.block.entity.XpConverterBlockEntity;
import thegreatk.somethingmod.init.BlockEntityInit;

public class XpConverterBlock extends HorizontalDirectionalBlock implements EntityBlock {

	private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public XpConverterBlock(Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
		runCalculation(SHAPE.orElse(Shapes.block()));
	}

	private static final Optional<VoxelShape> SHAPE = Stream.of(Block.box(6, 4, -2, 10, 5, 2),
			Block.box(6, 5, -1, 7, 7, 2), Block.box(9, 5, -1, 10, 7, 2), Block.box(10, 10, 10, 12, 16, 12),
			Block.box(4, 10, 10, 6, 16, 12), Block.box(10, 10, 4, 12, 16, 6), Block.box(4, 10, 4, 6, 16, 6),
			Block.box(1, 2, 1, 15, 11, 15), Block.box(2, 2, 2, 14, 10, 14), Block.box(0, 0, 0, 16, 2, 16))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

	protected void runCalculation(VoxelShape shape) {
		for (Direction direction : Direction.values()) {
			SHAPES.put(direction, ModOfSomething.calculateShapes(direction, shape));
		}
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return SHAPES.get(state.getValue(FACING));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (!level.isClientSide && !player.isShiftKeyDown()) {
			if (player.experienceLevel <= 1 && !player.isCreative()) {
				level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
				player.giveExperienceLevels(-10);
				return InteractionResult.FAIL;
			} else {
				level.playSound(player, pos, SoundEvents.ENDERMAN_DEATH, SoundSource.PLAYERS, 1.0F, 1.0F);
				for (int index = 0; index < this.RANDOM.nextInt(10) + 7; index++) {
					MushroomCow cow = EntityType.MOOSHROOM.create(level);
					cow.setPos(pos.getX() + this.RANDOM.nextInt(10) - 5, pos.getY(),
							pos.getZ() + this.RANDOM.nextInt(10) - 5);
					cow.addTag("Slave");
					level.addFreshEntity(cow);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.XP_CONVERTER.get().create(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> type) {
		return level.isClientSide ? null
				: (level0, pos, state0, blockEntity) -> ((XpConverterBlockEntity) blockEntity).tick();
	}

}
