package dev.xkmc.jerotes_golems.init.reg;

import com.tterrag.registrate.builders.NoConfigBuilder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import dev.xkmc.jerotes_golems.content.effect.MerorEnergy;
import dev.xkmc.jerotes_golems.content.effect.NetheriteBoost;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class JGEffects {

	public static final RegistryEntry<MobEffect> NETHERITE_BOOST = genEffect("netherite_boost",
			() -> new NetheriteBoost(MobEffectCategory.BENEFICIAL, 0),
			"Increase golem attack speed");

	public static final RegistryEntry<MobEffect> LEGENDARY = genEffect("meror_energy",
			() -> new MerorEnergy(MobEffectCategory.BENEFICIAL, 0),
			"Legendary Status");


	private static <T extends MobEffect> RegistryEntry<T> genEffect(String name, NonNullSupplier<T> sup, String desc) {
		return ((NoConfigBuilder) JerotesGolems.REGISTRATE.effect(name, sup, desc).lang(MobEffect::getDescriptionId)).register();
	}

	public static void register() {

	}

}
