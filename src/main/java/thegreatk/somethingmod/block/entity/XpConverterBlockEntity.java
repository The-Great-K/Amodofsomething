package thegreatk.somethingmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import thegreatk.somethingmod.init.BlockEntityInit;

public class XpConverterBlockEntity extends BlockEntity {

	private int ticks;

	public XpConverterBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.XP_CONVERTER.get(), pos, state);
	}

	@Override
	public CompoundTag save(CompoundTag nbt) {
		return super.save(nbt);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (!level.isClientSide) {
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

	public void tick(BlockPos pos, Level level) {
		if (ticks == 100) {
			LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
			bolt.setPos(pos.getX() + RANDOM);
		}
		ticks++;
	}

}