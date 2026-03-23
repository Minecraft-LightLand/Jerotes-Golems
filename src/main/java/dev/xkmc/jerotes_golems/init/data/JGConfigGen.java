package dev.xkmc.jerotes_golems.init.data;

import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.l2library.serial.config.ConfigDataProvider;
import dev.xkmc.modulargolems.content.config.GolemMaterialConfig;
import dev.xkmc.modulargolems.init.ModularGolems;
import dev.xkmc.modulargolems.init.registrate.GolemModifiers;
import dev.xkmc.modulargolems.init.registrate.GolemTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.crafting.Ingredient;

public class JGConfigGen extends ConfigDataProvider {

	public JGConfigGen(DataGenerator generator) {
		super(generator, "Jerotes Golem Config");
	}

	public void add(ConfigDataProvider.Collector map) {

		map.add(ModularGolems.MATERIALS, JerotesGolems.loc(JerotesGolems.MODID), new GolemMaterialConfig()

				.addMaterial(JerotesGolems.loc("villager_metal"), Ingredient.of(JerotesVillageItems.VILLAGER_METAL_INGOT.get()))
				.addStat(GolemTypes.STAT_HEALTH.get(), 200)
				.addStat(GolemTypes.STAT_ATTACK.get(), 15)
				.end()

				.addMaterial(JerotesGolems.loc("qoaiku"), Ingredient.of(JerotesVillageItems.QOAIKU_METAL_INGOT.get()))
				.addStat(GolemTypes.STAT_HEALTH.get(), 250)
				.addStat(GolemTypes.STAT_ATTACK.get(), 20)
				.addModifier(GolemModifiers.SWIM.get(), 1)
				.addModifier(JGModifiers.QOAIKU_ATK.get(), 1)
				.end()

				.addMaterial(JerotesGolems.loc("serpon_alloy"), Ingredient.of(JerotesVillageItems.SERPON_ALLOY_INGOT.get()))
				.addStat(GolemTypes.STAT_HEALTH.get(), 300)
				.addStat(GolemTypes.STAT_ATTACK.get(), 25)
				.addStat(GolemTypes.STAT_SWEEP.get(), 1)
				.addModifier(JGModifiers.FIRE_AFFINITY.get(), 1)
				.end()

				.addMaterial(JerotesGolems.loc("meror"), Ingredient.of(JerotesVillageItems.MEROR_METAL_INGOT.get()))
				.addStat(GolemTypes.STAT_HEALTH.get(), 400)
				.addStat(GolemTypes.STAT_ATTACK.get(), 30)
				.addStat(GolemTypes.STAT_SWEEP.get(), 1)
				.addModifier(JGModifiers.FIRE_AFFINITY.get(), 1)
				.addModifier(JGModifiers.MEROR_ATK.get(), 1)
				.addModifier(JGModifiers.MEROR_DEF.get(), 1)
				.end()

				.addMaterial(JerotesGolems.loc("refine_meror"), Ingredient.of(JerotesVillageItems.REFINE_MEROR_METAL_INGOT.get()))
				.addStat(GolemTypes.STAT_HEALTH.get(), 400)
				.addStat(GolemTypes.STAT_ATTACK.get(), 30)
				.addStat(GolemTypes.STAT_SWEEP.get(), 1)
				.addModifier(JGModifiers.FIRE_AFFINITY.get(), 1)
				.addModifier(JGModifiers.MEROR_ATK.get(), 1)
				.addModifier(JGModifiers.MEROR_DEF.get(), 2)
				.addModifier(GolemModifiers.MAGIC_IMMUNE.get(), 1)
				.addModifier(GolemModifiers.ARMOR_BYPASS.get(), 2)
				.addModifier(GolemModifiers.ADD_SLOT.get(), 1)
				.end()
		);
	}

}
