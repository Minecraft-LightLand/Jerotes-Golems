package dev.xkmc.jerotes_golems.content.behavior;

import com.jerotes.jerotes.item.Interface.JerotesItemThrownJavelinUse;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.mob_weapon_api.registry.WeaponRegistry;
import dev.xkmc.mob_weapon_api.registry.WeaponStatus;

public class JerotesBehaviorRegistry {

	public static void register() {
		WeaponRegistry.HOLD.register(JerotesGolems.loc("jerotes_javelin"),
				(stack) -> WeaponStatus.OFFENSIVE.of(stack.getItem() instanceof JerotesItemThrownJavelinUse),
				(e, stack) -> new JerotesJavelinBehavior(), 11);
		WeaponRegistry.CROSSBOW.register(JerotesGolems.loc("meror_shotgun"),
				(stack) -> WeaponStatus.RANGED.of(stack.is(JerotesVillageItems.MEROR_SHOTGUN.get())),
				(e, stack) -> new MerorShotgunBehavior(), 80);
		WeaponRegistry.INSTANT.register(JerotesGolems.loc("meror_pistol"),
				(stack) -> WeaponStatus.RANGED.of(stack.is(JerotesVillageItems.MEROR_IMPACT_PISTOL.get())),
				(e, stack) -> new MerorImpactPistolBehavior(), 80);
	}

}
