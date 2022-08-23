package thegreatk.somethingmod.block.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import thegreatk.somethingmod.init.BlockEntityInit;

public class XpConverterBlockEntity extends BlockEntity {

	public int ticks;
	public final Map<UUID, Integer> playerUses = new HashMap<>();

	public XpConverterBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.XP_CONVERTER.get(), pos, state);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);

		final ListTag playerUses = nbt.getList("PlayerUseMap", Tag.TAG_COMPOUND);
		playerUses.forEach(player -> {
			if (player instanceof final CompoundTag tag) {
				final UUID uuid = tag.getUUID("UUID");
				final int uses = tag.getInt("Uses");
				this.playerUses.put(uuid, uses);
			}
		});
	}

	@Override
	public CompoundTag save(CompoundTag nbt) {
		return super.save(nbt);
	}

	public void tick() {
	}

}