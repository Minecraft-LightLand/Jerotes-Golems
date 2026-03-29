package dev.xkmc.jerotes_golems.init.data;

import com.tterrag.registrate.providers.RegistrateItemTagsProvider;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import dev.xkmc.jerotes_golems.init.reg.JGEffects;
import dev.xkmc.l2library.init.data.L2TagGen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.ForgeRegistries;

public class JGTagGen {

	public static void genItemTag(RegistrateItemTagsProvider pvd) {
	}

	public static void genEffectTag(RegistrateTagsProvider.IntrinsicImpl<MobEffect> pvd) {
		pvd.addTag(L2TagGen.TRACKED_EFFECTS).add(JGEffects.LEGENDARY.get());
		pvd.addTag(TagKey.create(ForgeRegistries.MOB_EFFECTS.getRegistryKey(), new ResourceLocation("l2complements", "skill_effect")))
				.add(JGEffects.NETHERITE_BOOST.get(), JGEffects.LEGENDARY.get());
	}

}
