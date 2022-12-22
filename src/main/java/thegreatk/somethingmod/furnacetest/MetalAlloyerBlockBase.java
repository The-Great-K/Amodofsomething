package thegreatk.somethingmod.furnacetest;

import java.util.Random;

import javax.annotation.Nullable;

import com.mojang.math.Vector3d;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import thegreatk.somethingmod.block.entity.MetalAlloyerBlockEntityBase;

public abstract class MetalAlloyerBlockBase extends Block implements EntityBlock {

	public MetalAlloyerBlockBase(Properties properties) {
		super(properties.destroyTime(3F));
		this.registerDefaultState(this.defaultBlockState().setValue(BlockStateProperties.LIT, false));
	}

	public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
		BlockEntity blockentity = level.getBlockEntity(pos);
		return blockentity instanceof MenuProvider ? (MenuProvider) blockentity : null;
	}

	@Override
	public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
		return state.getValue(BlockStateProperties.LIT) ? 14 : 0;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return (BlockState) this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING,
				ctx.getHorizontalDirection().getOpposite());
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity entity,
			ItemStack stack) {
		if (entity != null) {
			MetalAlloyerBlockEntityBase te = (MetalAlloyerBlockEntityBase) world.getBlockEntity(pos);
			if (stack.hasCustomHoverName()) {
				if (!(stack.getDisplayName().getString().contains("["))) {
					te.setCustomName(stack.getDisplayName());
				}
			}
			te.totalCookTime = te.getCookTimeConfig().get();
			te.placeConfig();
		}
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult result) {
		if (world.isClientSide) {
			return InteractionResult.SUCCESS;
		}
		this.interactWith(world, pos, player);
		return InteractionResult.SUCCESS;

	}

	private void interactWith(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			BlockEntity tileEntity = world.getBlockEntity(pos);
			if (tileEntity instanceof MenuProvider) {
				NetworkHooks.openGui((ServerPlayer) player, (MenuProvider) tileEntity, tileEntity.getBlockPos());
				player.awardStat(Stats.INTERACT_WITH_FURNACE);
				if (tileEntity instanceof MetalAlloyerBlockEntityBase) {
					((MetalAlloyerBlockEntityBase) tileEntity).metalAlloyerSettings.set(10, 0);
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
		if (state.getValue(BlockStateProperties.LIT)) {
			if (world.getBlockEntity(pos) == null) {
				return;
			}
			if (!(world.getBlockEntity(pos) instanceof MetalAlloyerBlockEntityBase)) {
				return;
			}
			MetalAlloyerBlockEntityBase tile = ((MetalAlloyerBlockEntityBase) world.getBlockEntity(pos));

			double lvt_5_1_ = (double) pos.getX() + 0.5D;
			double lvt_7_1_ = (double) pos.getY();
			double lvt_9_1_ = (double) pos.getZ() + 0.5D;
			if (rand.nextDouble() < 0.1D) {
				world.playLocalSound(lvt_5_1_, lvt_7_1_, lvt_9_1_, SoundEvents.BLASTFURNACE_FIRE_CRACKLE,
						SoundSource.BLOCKS, 1.0F, 1.0F, false);
			}

			Direction lvt_11_1_ = (Direction) state.getValue(BlockStateProperties.HORIZONTAL_FACING);
			Direction.Axis lvt_12_1_ = lvt_11_1_.getAxis();
			double lvt_13_1_ = 0.52D;
			double lvt_15_1_ = rand.nextDouble() * 0.6D - 0.3D;
			double lvt_17_1_ = lvt_12_1_ == Direction.Axis.X ? (double) lvt_11_1_.getStepX() * 0.52D : lvt_15_1_;
			double lvt_19_1_ = rand.nextDouble() * 9.0D / 16.0D;
			double lvt_21_1_ = lvt_12_1_ == Direction.Axis.Z ? (double) lvt_11_1_.getStepZ() * 0.52D : lvt_15_1_;
			world.addParticle(ParticleTypes.SMOKE, lvt_5_1_ + lvt_17_1_, lvt_7_1_ + lvt_19_1_, lvt_9_1_ + lvt_21_1_,
					0.0D, 0.0D, 0.0D);
		}

	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean obj) {
		if (state.getBlock() != oldState.getBlock()) {
			BlockEntity te = world.getBlockEntity(pos);
			if (te instanceof MetalAlloyerBlockEntityBase) {

				MetalAlloyerBlockEntityBase furnace = ((MetalAlloyerBlockEntityBase) te);

				Containers.dropContents(world, pos, furnace);
				furnace.grantStoredRecipeExperience(world, new Vector3d(pos.getX(), pos.getY(), pos.getZ()));
				world.updateNeighbourForOutputSignal(pos, this);
			}

			super.onRemove(state, world, pos, oldState, obj);
		}
	}

	public int getComparatorInputOverride(BlockState state, Level world, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromContainer((WorldlyContainer) world.getBlockEntity(pos));

	}

	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	public BlockState rotate(BlockState state, Rotation facing) {
		return (BlockState) state.setValue(BlockStateProperties.HORIZONTAL_FACING,
				facing.rotate((Direction) state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation((Direction) state.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	private int calculateOutput(Level worldIn, BlockPos pos, BlockState state) {
		MetalAlloyerBlockEntityBase tile = ((MetalAlloyerBlockEntityBase) worldIn.getBlockEntity(pos));
		int i = this.getComparatorInputOverride(state, worldIn, pos);
		if (tile != null) {
			int j = tile.metalAlloyerSettings.get(9);
			return tile.metalAlloyerSettings.get(8) == 4 ? Math.max(i - j, 0) : i;
		}
		return 0;
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}

	@Override
	public int getSignal(BlockState state, BlockGetter getter, BlockPos pos, Direction facing) {
		return super.getDirectSignal(state, getter, pos, facing);
	}

	@Override
	public int getDirectSignal(BlockState blockState, BlockGetter world, BlockPos pos, Direction direction) {
		MetalAlloyerBlockEntityBase furnace = ((MetalAlloyerBlockEntityBase) world.getBlockEntity(pos));
		if (furnace != null) {
			int mode = furnace.metalAlloyerSettings.get(8);
			if (mode == 0) {
				return 0;
			} else if (mode == 1) {
				return 0;
			} else if (mode == 2) {
				return 0;
			} else {
				return calculateOutput(furnace.getLevel(), pos, blockState);
			}
		}
		return 0;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT);
	}

	@Nullable
	protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(
			BlockEntityType<A> $1type, BlockEntityType<E> $2type, BlockEntityTicker<? super E> $3type) {
		return $2type == $1type ? (BlockEntityTicker<A>) $3type : null;
	}

	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level level,
			BlockEntityType<T> $1type, BlockEntityType<? extends MetalAlloyerBlockEntityBase> $2type) {
		return level.isClientSide ? null : createTickerHelper($1type, $2type, MetalAlloyerBlockEntityBase::tick);
	}

}