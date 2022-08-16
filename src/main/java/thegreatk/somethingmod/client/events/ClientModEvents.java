package thegreatk.somethingmod.client.events;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import thegreatk.somethingmod.ModOfSomething;
import thegreatk.somethingmod.init.BlockInit;

@Mod.EventBusSubscriber(modid = ModOfSomething.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

	private ClientModEvents() {
	}

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(BlockInit.XP_CONVERTER.get(), RenderType.cutoutMipped());
	}

}
