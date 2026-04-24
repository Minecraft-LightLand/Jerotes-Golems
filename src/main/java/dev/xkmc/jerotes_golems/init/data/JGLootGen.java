package dev.xkmc.jerotes_golems.init.data;

import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.tterrag.registrate.providers.loot.RegistrateLootTableProvider;
import dev.xkmc.golemdungeons.init.reg.GDItems;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.l2library.util.data.LootTableTemplate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class JGLootGen {

	public static final ResourceLocation CARVED = CarvedGolemSpawn.CARVED_ALL.withPrefix("trial_reward/");
	public static final ResourceLocation QOAIKU = QoaikuGolemSpawn.QOAIKU_ALL.withPrefix("trial_reward/");
	public static final ResourceLocation MEROR = MerorGolemSpawn.MEROR_ALL.withPrefix("trial_reward/");
	public static final ResourceLocation ENHANCED_CARVED = CarvedGolemSpawn.ENHANCED_ALL.withPrefix("trial_reward/");
	public static final ResourceLocation REFINE_MEROR = MerorGolemSpawn.REFINE_MEROR_ALL.withPrefix("trial_reward/");

	public static void genLoot(RegistrateLootTableProvider pvd) {
		pvd.addLootAction(LootContextParamSets.CHEST, (sub) -> sub.accept(CARVED, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(Items.EMERALD_BLOCK, 8, 16))
						.add(LootTableTemplate.getItem(Items.DIAMOND, 6, 12))
						.add(LootTableTemplate.getItem(Items.NETHERITE_INGOT, 4, 8)))
				.withPool(LootTableTemplate.getPool(1, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1)))
				.withPool(LootTableTemplate.getPool(1, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1).when(LootTableTemplate.chance(0.5f))))
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(GDItems.MEDAL_OF_CONQUEROR)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(Items.ENCHANTED_GOLDEN_APPLE, 2, 4))
						.add(LootTableTemplate.getItem(GDItems.TRIAL_MEDAL.get(), 1)))
		));

		pvd.addLootAction(LootContextParamSets.CHEST, (sub) -> sub.accept(QOAIKU, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(JerotesVillageItems.QOAIKU_METAL_INGOT.get(), 8, 16)))
				.withPool(LootTableTemplate.getPool(1, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1)))
				.withPool(LootTableTemplate.getPool(1, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1).when(LootTableTemplate.chance(0.5f))))
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(GDItems.MEDAL_OF_CONQUEROR)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(GDItems.TRIAL_MEDAL.get(), 1)))
		));

		pvd.addLootAction(LootContextParamSets.CHEST, (sub) -> sub.accept(MEROR, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(JerotesVillageItems.MEROR_METAL_INGOT.get(), 8, 16))
						.add(LootTableTemplate.getItem(JerotesVillageItems.REFINE_MEROR_METAL_INGOT.get(), 4, 8))
						.add(LootTableTemplate.getItem(JerotesVillageItems.MEROR_ENERGY_REGIME.get(), 2, 4)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(JGItems.ULTIMATE_ENERGY_REGIME.get(), 1)))
				.withPool(LootTableTemplate.getPool(2, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1)))
				.withPool(LootTableTemplate.getPool(2, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1).when(LootTableTemplate.chance(0.5f))))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(GDItems.MEDAL_OF_CONQUEROR.get(), 2, 4)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(GDItems.TRIAL_MEDAL.get(), 1, 2)))
		));

		pvd.addLootAction(LootContextParamSets.CHEST, (sub) -> sub.accept(ENHANCED_CARVED, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(Items.EMERALD_BLOCK, 32, 64)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(Items.DIAMOND_BLOCK, 6, 12)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(Items.NETHERITE_BLOCK, 8, 16)))
				.withPool(LootTableTemplate.getPool(2, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1)))
				.withPool(LootTableTemplate.getPool(2, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1).when(LootTableTemplate.chance(0.5f))))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(GDItems.MEDAL_OF_CONQUEROR.get(), 2, 4)))
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(JGModifiers.ITEM_VILLAGE.get())))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(GDItems.TRIAL_MEDAL.get(), 1, 2)))
		));

		pvd.addLootAction(LootContextParamSets.CHEST, (sub) -> sub.accept(REFINE_MEROR, LootTable.lootTable()
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(JerotesVillageItems.MEROR_METAL_BLOCK.get(), 8, 16)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get(), 4, 8)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(JerotesVillageItems.MEROR_ENERGY_REGIME.get(), 16, 32)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(JGItems.ULTIMATE_ENERGY_REGIME.get(), 4, 8)))
				.withPool(LootTableTemplate.getPool(2, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1)))
				.withPool(LootTableTemplate.getPool(2, 0)
						.add(LootTableTemplate.getItem(JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get(), 1).when(LootTableTemplate.chance(0.5f))))
				.withPool(LootPool.lootPool()
						.add(LootItem.lootTableItem(GDItems.MEDAL_OF_CONQUEROR)))
				.withPool(LootPool.lootPool()
						.add(LootTableTemplate.getItem(GDItems.TRIAL_MEDAL.get(), 2, 4)))
		));

	}

}
