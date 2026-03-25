package dev.xkmc.jerotes_golems.events;

import dev.xkmc.jerotes_golems.init.JerotesGolems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = JerotesGolems.MODID)
public class JGClientEventHandler {

	@SubscribeEvent
	public static void bossBar(CustomizeGuiOverlayEvent.BossEventProgress event) {

	}

}
