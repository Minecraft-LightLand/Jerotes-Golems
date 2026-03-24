package dev.xkmc.jerotes_golems.init.data;

import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.l2damagetracker.init.data.DamageTypeAndTagsGen;
import dev.xkmc.modulargolems.init.ModularGolems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class JGDamageTypes extends DamageTypeAndTagsGen {

	public static final ResourceKey<DamageType> FIRE = createDamage("fire_attack");

	public JGDamageTypes(PackOutput output, CompletableFuture<HolderLookup.Provider> pvd, ExistingFileHelper helper) {
		super(output, pvd, helper, JerotesGolems.MODID);
		new DamageTypeHolder(FIRE, new DamageType("on_fire", 0.1f))
				.add(DamageTypeTags.BYPASSES_COOLDOWN, DamageTypeTags.BYPASSES_ARMOR, DamageTypeTags.IS_FIRE);
	}

	private static ResourceKey<DamageType> createDamage(String id) {
		return ResourceKey.create(Registries.DAMAGE_TYPE, ModularGolems.loc(id));
	}

}
