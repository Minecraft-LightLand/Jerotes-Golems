package dev.xkmc.jerotes_golems.init.data;

import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import dev.xkmc.golemdungeons.content.config.EquipmentConfig;
import dev.xkmc.golemdungeons.content.config.ExtraEquipmentSlot;
import dev.xkmc.golemdungeons.content.config.SpawnConfig;
import dev.xkmc.golemdungeons.content.config.TrialConfig;
import dev.xkmc.golemdungeons.init.GolemDungeons;
import dev.xkmc.golemdungeons.init.data.spawn.AbstractGolemSpawn;
import dev.xkmc.jerotes_golems.content.fraction.JGFactionRegistry;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponMaterial;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.l2library.serial.config.ConfigDataProvider;
import dev.xkmc.modulargolems.init.material.GolemWeaponType;
import dev.xkmc.modulargolems.init.registrate.GolemItems;
import dev.xkmc.modulargolems.init.registrate.GolemTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class MerorGolemSpawn extends AbstractGolemSpawn {

	public static final ResourceLocation ITEM_LARGE_ARMOR = JerotesGolems.loc("meror_large_armor");
	public static final ResourceLocation ITEM_LARGE_ARMOR_REFINE = JerotesGolems.loc("meror_large_armor_refine");
	public static final ResourceLocation ITEM_LARGE_WEAPON = JerotesGolems.loc("meror_large_weapon");
	public static final ResourceLocation ITEM_LARGE_WEAPON_REFINE = JerotesGolems.loc("meror_large_weapon_refine");
	public static final ResourceLocation ITEM_HUMANOID_ARMOR = JerotesGolems.loc("meror_humanoid_armor");
	public static final ResourceLocation ITEM_HUMANOID_ARMOR_REFINE = JerotesGolems.loc("meror_humanoid_armor_refine");
	public static final ResourceLocation ITEM_HUMANOID_MELEE = JerotesGolems.loc("meror_humanoid_weapon_melee");
	public static final ResourceLocation ITEM_HUMANOID_BOW = JerotesGolems.loc("meror_humanoid_weapon_bow");
	public static final ResourceLocation ITEM_CHARGE = JerotesGolems.loc("meror_charge");

	public static final ResourceLocation MEROR_ALL = JerotesGolems.loc("meror");
	public static final ResourceLocation REFINE_MEROR_ALL = JerotesGolems.loc("refine_meror");

	public static final ResourceLocation LARGE_MEROR = JerotesGolems.loc("meror_large");
	public static final ResourceLocation LARGE_REFINE = JerotesGolems.loc("meror_large_refine");
	public static final ResourceLocation LARGE_CHARGED = JerotesGolems.loc("meror_large_refine_charged");

	public static final ResourceLocation HUMANOID_BASIC = JerotesGolems.loc("meror_humanoid_basic");
	public static final ResourceLocation HUMANOID_MELEE = JerotesGolems.loc("meror_humanoid_refine_melee");
	public static final ResourceLocation HUMANOID_RANGED = JerotesGolems.loc("meror_humanoid_refine_ranged");
	public static final ResourceLocation HUMANOID_MELEE_CHARGED = JerotesGolems.loc("meror_humanoid_refine_melee_charged");
	public static final ResourceLocation HUMANOID_RANGED_CHARGED = JerotesGolems.loc("meror_humanoid_refine_ranged_charged");

	public static void add(ConfigDataProvider.Collector map) {

		// metal golem equipments
		{
			map.add(GolemDungeons.ITEMS, ITEM_LARGE_ARMOR, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 100, JGItems.MEROR_HELMET, 30)
					.add(EquipmentSlot.CHEST, 100, JGItems.MEROR_CHESTPLATE, 30)
					.add(EquipmentSlot.LEGS, 100, JGItems.MEROR_SHINGUARD, 30)
			);

			map.add(GolemDungeons.ITEMS, ITEM_LARGE_WEAPON, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(JGWeaponMaterial.MEROR, GolemWeaponType.AXE), 30)
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(JGWeaponMaterial.MEROR, GolemWeaponType.SWORD), 30)
					.add(EquipmentSlot.MAINHAND, 50, getWeapon(JGWeaponMaterial.MEROR, GolemWeaponType.SPEAR), 30)
			);

			map.add(GolemDungeons.ITEMS, ITEM_LARGE_ARMOR_REFINE, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 100, JGItems.REFINE_MEROR_HELMET, 30)
					.add(EquipmentSlot.CHEST, 100, JGItems.REFINE_MEROR_CHESTPLATE, 30)
					.add(EquipmentSlot.LEGS, 100, JGItems.REFINE_MEROR_SHINGUARD, 30)
			);

			map.add(GolemDungeons.ITEMS, ITEM_LARGE_WEAPON_REFINE, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 100, getWeapon(JGWeaponMaterial.REFINE_MEROR, GolemWeaponType.AXE), 30)
					.add(EquipmentSlot.MAINHAND, 100, getWeapon(JGWeaponMaterial.REFINE_MEROR, GolemWeaponType.SWORD), 30)
					.add(EquipmentSlot.MAINHAND, 100, getWeapon(JGWeaponMaterial.REFINE_MEROR, GolemWeaponType.SPEAR), 30)
			);
		}

		// humanoid armors
		{
			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_ARMOR, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 100, JerotesVillageItems.MEROR_METAL_HELMET.get(), 30)
					.add(EquipmentSlot.CHEST, 100, JerotesVillageItems.MEROR_METAL_CHESTPLATE.get(), 30)
					.add(EquipmentSlot.LEGS, 100, JerotesVillageItems.MEROR_METAL_LEGGINGS.get(), 30)
					.add(EquipmentSlot.FEET, 100, JerotesVillageItems.MEROR_METAL_BOOTS.get(), 30)
			);

			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_ARMOR_REFINE, new EquipmentConfig()
					.add(EquipmentSlot.HEAD, 100, JerotesVillageItems.MEROR_STANDARD_HELMET.get(), 30)
					.add(EquipmentSlot.CHEST, 100, JerotesVillageItems.MEROR_STANDARD_CHESTPLATE.get(), 30)
					.add(EquipmentSlot.LEGS, 100, JerotesVillageItems.MEROR_STANDARD_LEGGINGS.get(), 30)
					.add(EquipmentSlot.FEET, 100, JerotesVillageItems.MEROR_STANDARD_BOOTS.get(), 30)
			);

		}

		// humanoid weapons
		{
			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_MELEE, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.MEROR_METAL_SWORD.get(), 30)
					.add(EquipmentSlot.OFFHAND, 100, JerotesVillageItems.MEROR_METAL_SHIELD.get(), 30)
			);

			map.add(GolemDungeons.ITEMS, ITEM_HUMANOID_BOW, new EquipmentConfig()
					.add(EquipmentSlot.MAINHAND, 100, JerotesVillageItems.MEROR_METAL_BOW.get(), 30)
					.add(EquipmentSlot.OFFHAND, 100, JerotesVillageItems.MEROR_METAL_ARROW.get())
			);

		}

		map.add(GolemDungeons.ITEMS, ITEM_CHARGE, new EquipmentConfig().add(ExtraEquipmentSlot.ARROW,
				new EquipmentConfig.EquipmentEntry(100, JGItems.ULTIMATE_ENERGY_REGIME.get())));

		// metal golem wave
		{
			map.add(GolemDungeons.SPAWN, LARGE_MEROR, createMeror()
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(300, ITEM_LARGE_ARMOR))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(300, ITEM_LARGE_WEAPON))
			);

			map.add(GolemDungeons.SPAWN, LARGE_REFINE, createRefine()
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_WEAPON_REFINE))
			);

			map.add(GolemDungeons.SPAWN, LARGE_CHARGED, createRefine()
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_WEAPON_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_CHARGE))
			);
		}

		// humanoid wave
		{
			map.add(GolemDungeons.SPAWN, HUMANOID_BASIC, createHumanoid(createMeror())
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_MELEE)
							.add(100, ITEM_HUMANOID_BOW))
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_MELEE, createHumanoid(createRefine())
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_MELEE))
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_RANGED, createHumanoid(createRefine())
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_BOW))
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_MELEE_CHARGED, createHumanoid(createRefine())
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_MELEE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_CHARGE))
			);

			map.add(GolemDungeons.SPAWN, HUMANOID_RANGED_CHARGED, createHumanoid(createRefine())
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_BOW))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_CHARGE))
			);

		}

		// generic wave
		{
			map.add(GolemDungeons.SPAWN, MEROR_ALL, new SpawnConfig(JGFactionRegistry.MEROR).asTrialKey(MEROR_ALL)
					.mat(JerotesGolems.loc("meror"), 100)
					.mat(JerotesGolems.loc("refine_meror"), 100)
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0)
							.add(GolemItems.SPEED.get(), 0.5f))
					.type(GolemTypes.TYPE_HUMANOID.get(), new SpawnConfig.GolemTypeEntry(40, 0.5)
							.addMount(GolemTypes.ENTITY_DOG.get(), 100))
					.type(GolemTypes.TYPE_DOG.get(), new SpawnConfig.GolemTypeEntry(0, 0)
							.add(GolemItems.DIAMOND.get(), 0.75f)
							.add(GolemItems.SIZE_UPGRADE.get(), 1))
					.upgrade(GolemItems.SPEED.get(), 100)
					.upgrade(GolemItems.QUARTZ.asItem(), 100)
					.upgrade(GolemItems.GOLD.asItem(), 100)
					.upgrade(GolemItems.SPEED.asItem(), 100)
					.upgrade(GolemItems.DIAMOND.asItem(), 30)
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_ARMOR)
							.add(100, ITEM_LARGE_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_WEAPON)
							.add(100, ITEM_LARGE_WEAPON_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR)
							.add(100, ITEM_HUMANOID_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_MELEE)
							.add(100, ITEM_HUMANOID_BOW))
			);

			map.add(GolemDungeons.SPAWN, REFINE_MEROR_ALL, createRefine().asTrialKey(REFINE_MEROR_ALL)
					.mat(JerotesGolems.loc("refine_meror"), 100)
					.type(GolemTypes.TYPE_GOLEM.get(), new SpawnConfig.GolemTypeEntry(30, 0)
							.add(GolemItems.SPEED.get(), 0.5f))
					.type(GolemTypes.TYPE_HUMANOID.get(), new SpawnConfig.GolemTypeEntry(40, 0.5)
							.addMount(GolemTypes.ENTITY_DOG.get(), 100))
					.type(GolemTypes.TYPE_DOG.get(), new SpawnConfig.GolemTypeEntry(0, 0)
							.add(GolemItems.DIAMOND.get(), 0.75f)
							.add(GolemItems.SIZE_UPGRADE.get(), 1))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_LARGE_WEAPON_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_GOLEM.get())
							.add(100, ITEM_CHARGE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_ARMOR_REFINE))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_HUMANOID_MELEE)
							.add(100, ITEM_HUMANOID_BOW))
					.equipments(new SpawnConfig.EquipmentGroup(GolemTypes.ENTITY_HUMANOID.get())
							.add(100, ITEM_CHARGE))
			);
		}

		// trial
		{
			map.add(GolemDungeons.TRIAL, MEROR_ALL, new TrialConfig().setReward(JGLootGen.MEROR)
					.setCost(200).setTriggerRange(22, -5, 16)
					.add(of(LARGE_MEROR, 1))
					.add(of(LARGE_MEROR, 1),
							of(HUMANOID_BASIC, 2))
					.add(of(LARGE_MEROR, 2),
							of(HUMANOID_BASIC, 3))
					.add(of(LARGE_REFINE, 1),
							of(HUMANOID_RANGED, 1))
					.add(of(LARGE_REFINE, 2),
							of(HUMANOID_MELEE, 1),
							of(HUMANOID_RANGED, 2))
					.add(of(LARGE_REFINE, 3),
							of(HUMANOID_MELEE, 2),
							of(HUMANOID_RANGED, 3))
					.add(of(LARGE_REFINE, 4),
							of(HUMANOID_MELEE, 4),
							of(HUMANOID_RANGED, 4))
			);

			map.add(GolemDungeons.TRIAL, REFINE_MEROR_ALL, new TrialConfig().setReward(JGLootGen.REFINE_MEROR)
					.setCost(200).setTriggerRange(22, -5, 16)
					.add(of(LARGE_REFINE, 1))
					.add(of(LARGE_REFINE, 1),
							of(HUMANOID_MELEE, 1),
							of(HUMANOID_RANGED, 2))
					.add(of(LARGE_REFINE, 3),
							of(HUMANOID_MELEE, 2),
							of(HUMANOID_RANGED, 2))
					.add(of(LARGE_CHARGED, 1))
					.add(of(LARGE_CHARGED, 1),
							of(HUMANOID_MELEE_CHARGED, 1),
							of(HUMANOID_RANGED_CHARGED, 2))
					.add(of(LARGE_CHARGED, 3),
							of(HUMANOID_MELEE_CHARGED, 2),
							of(HUMANOID_RANGED_CHARGED, 2))
			);
		}
	}

	private static SpawnConfig createMeror() {
		return new SpawnConfig(JGFactionRegistry.MEROR)
				.mat(JerotesGolems.loc("meror"), 100)
				.upgrade(GolemItems.SPEED.get(), 1)
				.upgrade(GolemItems.QUARTZ.asItem(), 100)
				.upgrade(GolemItems.GOLD.asItem(), 100)
				.upgrade(GolemItems.SPEED.asItem(), 100)
				.upgrade(GolemItems.DIAMOND.asItem(), 30);
	}

	private static SpawnConfig createRefine() {
		return new SpawnConfig(JGFactionRegistry.MEROR)
				.mat(JerotesGolems.loc("refine_meror"), 100)
				.upgrade(GolemItems.SPEED.get(), 1)
				.upgrade(GolemItems.QUARTZ.asItem(), 100)
				.upgrade(GolemItems.GOLD.asItem(), 100)
				.upgrade(GolemItems.SPEED.asItem(), 100)
				.upgrade(GolemItems.DIAMOND.asItem(), 30);
	}

	private static SpawnConfig createHumanoid(SpawnConfig base) {
		return base.type(GolemTypes.TYPE_HUMANOID.get(), new SpawnConfig.GolemTypeEntry(40, 0.5)
				.addMount(GolemTypes.ENTITY_DOG.get(), 100)
		).type(GolemTypes.TYPE_DOG.get(), new SpawnConfig.GolemTypeEntry(0, 0)
				.add(GolemItems.DIAMOND.get(), 0.75f)
				.add(GolemItems.SIZE_UPGRADE.get(), 0.5f)
		);
	}

	public static ItemStack getWeapon(JGWeaponMaterial mat, GolemWeaponType type) {
		return JGItems.WEAPONS[type.ordinal()][mat.ordinal()].asStack();
	}

}
