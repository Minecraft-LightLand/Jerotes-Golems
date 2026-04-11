package dev.xkmc.jerotes_golems.events;

import com.jerotes.jerotes.forge.JerotesMerorDamageEvent;
import com.jerotes.jerotes.item.Interface.ItemTwoHanded;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.entity.humanoid.HumanoidGolemEntity;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JerotesGolems.MODID)
public class JGEventHandler {

	@SubscribeEvent
	public static void morerDamage(JerotesMerorDamageEvent event) {
		if (event.getEntity() instanceof AbstractGolemEntity<?, ?> golem) {
			if (golem.getModifiers().containsKey(JGModifiers.MEROR_ATK.get())) {
				event.setMerorDamage(true);
			}
		}
	}

	@SubscribeEvent
	public static void humanoidBlock(LivingEvent.LivingTickEvent event) {
		if (event.getEntity() instanceof HumanoidGolemEntity golem) {
			if (golem.getMainHandItem().getItem() instanceof ItemTwoHanded item && item.canBlock()) {
				if (golem.getOffhandItem().isEmpty()) {
					if (!golem.isUsingItem()) {
						golem.startUsingItem(InteractionHand.MAIN_HAND);
					}
				}
			}
		}
	}

}
