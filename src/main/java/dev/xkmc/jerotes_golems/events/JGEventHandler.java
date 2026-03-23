package dev.xkmc.jerotes_golems.events;

import com.jerotes.jerotes.forge.JerotesMerorDamageEvent;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JerotesGolems.MODID)
public class JGEventHandler {

	@SubscribeEvent
	public static void morerDamage(JerotesMerorDamageEvent event) {
		if (event.getDamageSource().is(L2DamageTypes.DIRECT) && event.getEntity() instanceof AbstractGolemEntity<?, ?> golem) {
			if (golem.getModifiers().containsKey(JGModifiers.MEROR_ATK.get())) {
				event.setMerorDamage(true);
			}
		}
	}

}
