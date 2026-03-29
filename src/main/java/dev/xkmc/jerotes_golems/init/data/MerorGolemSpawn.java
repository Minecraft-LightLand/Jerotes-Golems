package dev.xkmc.jerotes_golems.init.data;

import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import dev.xkmc.golemdungeons.content.config.EquipmentConfig;
import dev.xkmc.golemdungeons.content.config.SpawnConfig;
import dev.xkmc.golemdungeons.content.config.TrialConfig;
import dev.xkmc.golemdungeons.content.faction.DungeonFactionRegistry;
import dev.xkmc.golemdungeons.init.GolemDungeons;
import dev.xkmc.golemdungeons.init.data.loot.GDLootGen;
import dev.xkmc.golemdungeons.init.data.spawn.AbstractGolemSpawn;
import dev.xkmc.jerotes_golems.content.fraction.JGFactionRegistry;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.l2library.serial.config.ConfigDataProvider;
import dev.xkmc.modulargolems.init.material.GolemWeaponType;
import dev.xkmc.modulargolems.init.material.VanillaGolemWeaponMaterial;
import dev.xkmc.modulargolems.init.registrate.GolemItems;
import dev.xkmc.modulargolems.init.registrate.GolemTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;

public class MerorGolemSpawn extends AbstractGolemSpawn {

	public static final ResourceLocation ITEM_LARGE_ARMOR = JerotesGolems.loc("meror_large_armor");
	public static final ResourceLocation ITEM_LARGE_ARMOR_BETTER = JerotesGolems.loc("meror_large_armor_better");
	public static final ResourceLocation ITEM_LARGE_WEAPON = JerotesGolems.loc("meror_large_weapon");
	public static final ResourceLocation ITEM_LARGE_WEAPON_BETTER = JerotesGolems.loc("meror_large_weapon_better");
	public static final ResourceLocation ITEM_HUMANOID_ARMOR_MISC = JerotesGolems.loc("meror_humanoid_armor_misc");
	public static final ResourceLocation ITEM_HUMANOID_ARMOR_CHAIN = JerotesGolems.loc("meror_humanoid_armor_chain");
	public static final ResourceLocation ITEM_HUMANOID_ARMOR_GOLD = JerotesGolems.loc("meror_humanoid_armor_gold");
	public static final ResourceLocation ITEM_HUMANOID_MELEE = JerotesGolems.loc("meror_humanoid_weapon_melee");
	public static final ResourceLocation ITEM_HUMANOID_BOW = JerotesGolems.loc("meror_humanoid_weapon_bow");
	public static final ResourceLocation ITEM_HUMANOID_TIPPED = JerotesGolems.loc("meror_humanoid_weapon_tipped_arrow");
	public static final ResourceLocation ITEM_HUMANOID_ROCKET = JerotesGolems.loc("meror_humanoid_weapon_rocket_crossbow");
	public static final ResourceLocation ITEM_HORSE_ARMOR = JerotesGolems.loc("meror_horse_armor");

	public static final ResourceLocation MEROR_ALL = JerotesGolems.loc("meror");

	public static final ResourceLocation LARGE_1 = JerotesGolems.loc("meror_large_1");
	public static final ResourceLocation LARGE_2 = JerotesGolems.loc("meror_large_2");
	public static final ResourceLocation LARGE_3 = JerotesGolems.loc("meror_large_3");

	public static final ResourceLocation HUMANOID_BASIC = JerotesGolems.loc("meror_humanoid_basic");
	public static final ResourceLocation HUMANOID_MELEE = JerotesGolems.loc("meror_humanoid_melee");
	public static final ResourceLocation HUMANOID_RANGED = JerotesGolems.loc("meror_humanoid_ranged");
	public static final ResourceLocation HUMANOID_TIPPED = JerotesGolems.loc("meror_humanoid_tipped");
	public static final ResourceLocation HUMANOID_ROCKET = JerotesGolems.loc("meror_humanoid_rocket");

	public static void add(ConfigDataProvider.Collector map) {

		// metal golem equipments
		{
			map.add(GolemDungeons.ITEMS, ITEM_LARGE_ARMOR, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 100, Items.AIR)
					.add(EquipmentSlot.HEAD, 20, GolemItems.GOLEMGUARD_HELMET, 20)
					.add(EquipmentSlot.CHEST, 100, Items.AIR)
					.add(EquipmentSlot.CHEST, 20, GolemItems.GOLEMGUARD_CHESTPLATE, 20)
					.add(EquipmentSlot.LEGS, 100, Items.AIR)
					.add(EquipmentSlot.LEGS, 20, GolemItems.GOLEMGUARD_SHINGUARD, 20)
			);

			map.add(GolemDungeons.ITEMS, ITEM_LARGE_WEAPON, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 100, Items.AIR)
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(VanillaGolemWeaponMaterial.IRON, GolemWeaponType.AXE), 20)
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(VanillaGolemWeaponMaterial.IRON, GolemWeaponType.SWORD), 20)
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(VanillaGolemWeaponMaterial.IRON, GolemWeaponType.SPEAR), 20)
			);

			map.add(GolemDungeons.ITEMS, ITEM_LARGE_ARMOR_BETTER, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 50, Items.AIR)
					.add(EquipmentSlot.HEAD, 100, GolemItems.GOLEMGUARD_HELMET, 20)
					.add(EquipmentSlot.CHEST, 50, Items.AIR)
					.add(EquipmentSlot.CHEST, 100, GolemItems.GOLEMGUARD_CHESTPLATE, 20)
					.add(EquipmentSlot.LEGS, 50, Items.AIR)
					.add(EquipmentSlot.LEGS, 100, GolemItems.GOLEMGUARD_SHINGUARD, 20)
			);

			map.add(GolemDungeons.ITEMS, ITEM_LARGE_WEAPON_BETTER, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(VanillaGolemWeaponMaterial.IRON, GolemWeaponType.AXE), 20)
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(VanillaGolemWeaponMaterial.IRON, GolemWeaponType.SWORD), 20)
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(VanillaGolemWeaponMaterial.IRON, GolemWeaponType.SPEAR), 20)
			);
		}

		// humanoid armors
		{
			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_ARMOR_MISC, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 20, JerotesVillageItems.CARVED_LEADER_HELMET.get(), 10)
					.add(EquipmentSlot.CHEST, 20, JerotesVillageItems.CARVED_LEADER_CHESTPLATE.get(), 10)
					.add(EquipmentSlot.LEGS, 20, JerotesVillageItems.CARVED_LEADER_LEGGINGS.get(), 10)
					.add(EquipmentSlot.FEET, 20, JerotesVillageItems.CARVED_LEADER_BOOTS.get(), 10)
					.add(EquipmentSlot.HEAD, 50, JerotesVillageItems.VILLAGER_METAL_HELMET.get(), 15)
					.add(EquipmentSlot.CHEST, 50, JerotesVillageItems.VILLAGER_METAL_CHESTPLATE.get(), 15)
					.add(EquipmentSlot.LEGS, 50, JerotesVillageItems.VILLAGER_METAL_LEGGINGS.get(), 15)
					.add(EquipmentSlot.FEET, 50, JerotesVillageItems.VILLAGER_METAL_BOOTS.get(), 15)
					.add(EquipmentSlot.HEAD, 50, Items.CHAINMAIL_HELMET, 20)
					.add(EquipmentSlot.CHEST, 50, Items.CHAINMAIL_CHESTPLATE, 20)
					.add(EquipmentSlot.LEGS, 50, Items.CHAINMAIL_LEGGINGS, 20)
					.add(EquipmentSlot.FEET, 50, Items.CHAINMAIL_BOOTS, 20)
					.add(EquipmentSlot.HEAD, 50, Items.GOLDEN_HELMET, 30)
					.add(EquipmentSlot.CHEST, 50, Items.GOLDEN_CHESTPLATE, 30)
					.add(EquipmentSlot.LEGS, 50, Items.GOLDEN_LEGGINGS, 30)
					.add(EquipmentSlot.FEET, 50, Items.GOLDEN_BOOTS, 30)
			);

			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_ARMOR_CHAIN, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 50, Items.CHAINMAIL_HELMET, 20)
					.add(EquipmentSlot.CHEST, 50, Items.CHAINMAIL_CHESTPLATE, 20)
					.add(EquipmentSlot.LEGS, 50, Items.CHAINMAIL_LEGGINGS, 20)
					.add(EquipmentSlot.FEET, 50, Items.CHAINMAIL_BOOTS, 20)
			);

			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_ARMOR_GOLD, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 50, Items.GOLDEN_HELMET, 30)
					.add(EquipmentSlot.CHEST, 50, Items.GOLDEN_CHESTPLATE, 30)
					.add(EquipmentSlot.LEGS, 50, Items.GOLDEN_LEGGINGS, 30)
					.add(EquipmentSlot.FEET, 50, Items.GOLDEN_BOOTS, 30)
			);

			map.add(GolemDungeons.ITEMS, ITEM_HORSE_ARMOR, new EquipmentConfig()
					.add(EquipmentSlot.CHEST, 30, Items.LEATHER_HORSE_ARMOR)
					.add(EquipmentSlot.CHEST, 40, JerotesVillageItems.VILLAGER_METAL_WAR_BEAST_ARMOR.get())
					.add(EquipmentSlot.CHEST, 30, Items.GOLDEN_HORSE_ARMOR)
					.add(EquipmentSlot.CHEST, 20, Items.DIAMOND_HORSE_ARMOR)
			);

		}

		// humanoid weapons
		{
			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_MELEE, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 200, Items.STONE_AXE, 10)
					.add(EquipmentSlot.MAINHAND, 200, JerotesVillageItems.VILLAGER_METAL_DAGGER.get(), 20)
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.VILLAGER_METAL_HAMMER.get(), 10)
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.VILLAGER_METAL_AXE.get(), 10)
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.VILLAGER_METAL_SWORD.get(), 20)
					.add(EquipmentSlot.MAINHAND, 50, JerotesVillageItems.VILLAGER_METAL_PICKAXE.get(), 10)
					.add(EquipmentSlot.MAINHAND, 150, JerotesVillageItems.VILLAGER_METAL_JAVELIN.get(), 10)
					.add(EquipmentSlot.OFFHAND, 100, Items.SHIELD, 20)
					.add(EquipmentSlot.OFFHAND, 100, Items.AIR)
			);

			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_BOW, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.VILLAGER_METAL_BOW.get(), 30)
					.add(EquipmentSlot.OFFHAND, 100, JerotesVillageItems.CARVED_VILLAGER_SPECTRAL_ARROW.get())
			);

			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_TIPPED, new EquipmentConfig()
					.add(EquipmentSlot.OFFHAND, 100, tipped(Potions.POISON))
					.add(EquipmentSlot.OFFHAND, 100, tipped(Potions.SLOWNESS))
					.add(EquipmentSlot.OFFHAND, 100, tipped(Potions.WEAKNESS))
					.add(EquipmentSlot.OFFHAND, 100, tipped(Potions.HARMING))
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.VILLAGER_METAL_BOW.get(), 10)
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.VILLAGER_METAL_CROSSBOW.get(), 10)
			);

			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_ROCKET, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.VILLAGER_METAL_CROSSBOW.get(), 30)
					.add(EquipmentSlot.OFFHAND, 100, Items.FIREWORK_ROCKET, 7, 0)
			);
		}

		// metal golem wave
		{
			map.add(GolemDungeons.SPAWN, LARGE_1, new SpawnConfig(JGFactionRegistry.MEROR)
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0))
					.mat(JerotesGolems.loc("meror"), 100)
			);


			map.add(GolemDungeons.SPAWN, LARGE_2, new SpawnConfig(JGFactionRegistry.MEROR)
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0))
					.mat(JerotesGolems.loc("meror"), 100)
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_ARMOR))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_WEAPON))
			);


			map.add(GolemDungeons.SPAWN, LARGE_3, createBase()
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0)
							.add(GolemItems.SPEED.get(), 0.5f)
					)
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_ARMOR_BETTER))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_WEAPON_BETTER))
			);
		}

		// humanoid wave
		{
			map.add(GolemDungeons.SPAWN, HUMANOID_BASIC, new SpawnConfig(JGFactionRegistry.CARVED)
					.type(GolemTypes.TYPE_HUMANOID.get(), new SpawnConfig.GolemTypeEntry(40, 0))
					.mat(JerotesGolems.loc("meror"), 100)
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_MELEE, createBaseHumanoid()
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR_MISC))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_MELEE))
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_RANGED, createBaseHumanoid()
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(20, ITEM_HUMANOID_ARMOR_CHAIN))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(30, ITEM_HUMANOID_BOW))
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_TIPPED, createBaseHumanoid()
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(20, ITEM_HUMANOID_ARMOR_CHAIN))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(50, ITEM_HUMANOID_TIPPED))
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_ROCKET, createBaseHumanoid()
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(20, ITEM_HUMANOID_ARMOR_CHAIN))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(20, ITEM_HUMANOID_ROCKET))
			);

		}

		// generic wave
		{
			map.add(GolemDungeons.SPAWN, MEROR_ALL, createBaseHumanoid().asTrialKey(MEROR_ALL)
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0)
							.add(GolemItems.SPEED.get(), 0.5f)
					)
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_ARMOR_BETTER))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_WEAPON_BETTER))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR_MISC)
							.add(20, ITEM_HUMANOID_ARMOR_CHAIN)
							.add(20, ITEM_HUMANOID_ARMOR_GOLD))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_MELEE)
							.add(30, ITEM_HUMANOID_BOW)
							.add(50, ITEM_HUMANOID_TIPPED)
							.add(20, ITEM_HUMANOID_ROCKET))
			);
		}

		// trial
		{
			map.add(GolemDungeons.TRIAL, MEROR_ALL, new TrialConfig().setReward(GDLootGen.FACTORY)
					.setCost(200).setTriggerRange(22, -5, 16)
					.add(of(LARGE_1, 1))
					.add(of(LARGE_1, 1),
							of(HUMANOID_BASIC, 2))
					.add(of(LARGE_1, 2),
							of(HUMANOID_MELEE, 1),
							of(HUMANOID_RANGED, 2))
					.add(of(LARGE_1, 1),
							of(LARGE_2, 1),
							of(HUMANOID_MELEE, 1),
							of(HUMANOID_RANGED, 1),
							of(HUMANOID_TIPPED, 1))
					.add(of(LARGE_2, 3),
							of(HUMANOID_MELEE, 2),
							of(HUMANOID_RANGED, 2),
							of(HUMANOID_TIPPED, 2),
							of(HUMANOID_ROCKET, 1))
					.add(of(LARGE_3, 2),
							of(HUMANOID_MELEE, 2),
							of(HUMANOID_RANGED, 1),
							of(HUMANOID_TIPPED, 2),
							of(HUMANOID_ROCKET, 1),
							of(MEROR_ALL, 3))
					.add(of(LARGE_3, 3),
							of(HUMANOID_MELEE, 2),
							of(HUMANOID_RANGED, 1),
							of(HUMANOID_TIPPED, 2),
							of(HUMANOID_ROCKET, 2),
							of(MEROR_ALL, 5))
			);
		}
	}

	private static SpawnConfig createBase() {
		return new SpawnConfig(JGFactionRegistry.MEROR)
				.mat(JerotesGolems.loc("meror"), 100)
				.upgrade(GolemItems.SPEED.get(), 1)
				.upgrade(GolemItems.QUARTZ.asItem(), 100)
				.upgrade(GolemItems.GOLD.asItem(), 100)
				.upgrade(GolemItems.SPEED.asItem(), 100)
				.upgrade(GolemItems.DIAMOND.asItem(), 30);
	}

	private static SpawnConfig createBaseHumanoid() {
		return createBase()
				.type(GolemTypes.TYPE_HUMANOID.get(), new SpawnConfig.GolemTypeEntry(40, 0.5)
						.addMount(GolemTypes.ENTITY_DOG.get(), 100)
				)
				.type(GolemTypes.TYPE_DOG.get(), new SpawnConfig.GolemTypeEntry(0, 0)
						.add(GolemItems.DIAMOND.get(), 0.75f)
						.add(GolemItems.SIZE_UPGRADE.get(), 0.5f)
				);
	}

}
