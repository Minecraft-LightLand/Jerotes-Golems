package dev.xkmc.jerotes_golems.init.reg;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.xkmc.jerotes_golems.content.armor.MerorArmorItem;
import dev.xkmc.jerotes_golems.content.armor.RefineMerorArmorItem;
import dev.xkmc.jerotes_golems.content.armor.WonderlandArmorItem;
import dev.xkmc.jerotes_golems.content.client.JGModelPaths;
import dev.xkmc.jerotes_golems.content.item.DeployerItem;
import dev.xkmc.jerotes_golems.content.ranged.MerorFlameThrowerItem;
import dev.xkmc.jerotes_golems.content.ranged.MerorMachineGunItem;
import dev.xkmc.jerotes_golems.content.weapon.JGSpecialMaterial;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponGen;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponMaterial;
import dev.xkmc.jerotes_golems.content.weapon.UltimateMerorWeaponItem;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import dev.xkmc.modulargolems.init.ModularGolems;
import dev.xkmc.modulargolems.init.data.MGTagGen;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder;

public class JGItems {

	public static final RegistryEntry<CreativeModeTab> TAB;

	public static final ItemEntry<DeployerItem> VILLAGER_METAL_DEPLOYER, QOAIKU_DEPLOYER, MEROR_DEPLOYER,
			ENHANCED_VILLAGER_METAL_DEPLOYER, REFINE_MEROR_DEPLOYER;

	public static final ItemEntry<Item> ULTIMATE_ENERGY_REGIME;

	public static final ItemEntry<WonderlandArmorItem> WONDERLAND_HELMET, WONDERLAND_CHESTPLATE, WONDERLAND_SHINGUARD;
	public static final ItemEntry<MerorArmorItem> MEROR_HELMET, MEROR_CHESTPLATE, MEROR_SHINGUARD;
	public static final ItemEntry<RefineMerorArmorItem> REFINE_MEROR_HELMET, REFINE_MEROR_CHESTPLATE, REFINE_MEROR_SHINGUARD;

	public static final ItemEntry<MetalGolemWeaponItem>[][] WEAPONS;
	public static final ItemEntry<MetalGolemWeaponItem>[] SPECIAL_WEAPONS;
	public static final ItemEntry<UltimateMerorWeaponItem> ULTIMATE_MEROR_SPEAR;

	public static final ItemEntry<MerorFlameThrowerItem> MEROR_FLAME_THROWER;
	public static final ItemEntry<MerorMachineGunItem> MEROR_MACHINE_GUN;


	static {
		TAB = JerotesGolems.REGISTRATE.buildL2CreativeTab("main", "Jerotes Village Golems", b ->
				b.icon(() -> JGItems.SPECIAL_WEAPONS[0].asStack()));

		VILLAGER_METAL_DEPLOYER = JerotesGolems.REGISTRATE.item("villager_metal_deployer",
						p -> new DeployerItem(p, JerotesGolems.loc("villager_metal")))
				.register();

		QOAIKU_DEPLOYER = JerotesGolems.REGISTRATE.item("qoaiku_deployer",
						p -> new DeployerItem(p, JerotesGolems.loc("qoaiku")))
				.register();

		MEROR_DEPLOYER = JerotesGolems.REGISTRATE.item("meror_deployer",
						p -> new DeployerItem(p, JerotesGolems.loc("meror")))
				.register();

		ENHANCED_VILLAGER_METAL_DEPLOYER = JerotesGolems.REGISTRATE.item("enhanced_villager_metal_deployer",
						p -> new DeployerItem(p, JerotesGolems.loc("enhanced_villager_metal")))
				.register();

		REFINE_MEROR_DEPLOYER = JerotesGolems.REGISTRATE.item("refine_meror_deployer",
						p -> new DeployerItem(p, JerotesGolems.loc("refine_meror")))
				.register();

		ULTIMATE_ENERGY_REGIME = JerotesGolems.REGISTRATE.item("ultimate_energy_regime", Item::new)
				.properties(p -> p.rarity(Rarity.EPIC)).register();

		WONDERLAND_HELMET = JerotesGolems.REGISTRATE.item("wonderland_helmet", p -> new WonderlandArmorItem(p.stacksTo(1),
						ArmorItem.Type.HELMET, 11, 6, JGModelPaths.WONDERLAND_HELMETS))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();
		WONDERLAND_CHESTPLATE = JerotesGolems.REGISTRATE.item("wonderland_chestplate", p -> new WonderlandArmorItem(p.stacksTo(1),
						ArmorItem.Type.CHESTPLATE, 14, 6, JGModelPaths.WONDERLAND_CHESTPLATES))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();
		WONDERLAND_SHINGUARD = JerotesGolems.REGISTRATE.item("wonderland_shinguard", p -> new WonderlandArmorItem(p.stacksTo(1),
						ArmorItem.Type.LEGGINGS, 8, 6, JGModelPaths.WONDERLAND_LEGGINGS))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();

		MEROR_HELMET = JerotesGolems.REGISTRATE.item("meror_helmet", p -> new MerorArmorItem(p.stacksTo(1),
						ArmorItem.Type.HELMET, 12, 8, JGModelPaths.MEROR_HELMETS))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();
		MEROR_CHESTPLATE = JerotesGolems.REGISTRATE.item("meror_chestplate", p -> new MerorArmorItem(p.stacksTo(1),
						ArmorItem.Type.CHESTPLATE, 16, 8, JGModelPaths.MEROR_CHESTPLATES))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();
		MEROR_SHINGUARD = JerotesGolems.REGISTRATE.item("meror_shinguard", p -> new MerorArmorItem(p.stacksTo(1),
						ArmorItem.Type.LEGGINGS, 9, 8, JGModelPaths.MEROR_LEGGINGS))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();

		REFINE_MEROR_HELMET = JerotesGolems.REGISTRATE.item("refine_meror_helmet", p -> new RefineMerorArmorItem(p.stacksTo(1),
						ArmorItem.Type.HELMET, 13, 10, JGModelPaths.REFINE_MEROR_HELMETS))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();
		REFINE_MEROR_CHESTPLATE = JerotesGolems.REGISTRATE.item("refine_meror_chestplate", p -> new RefineMerorArmorItem(p.stacksTo(1),
						ArmorItem.Type.CHESTPLATE, 18, 10, JGModelPaths.REFINE_MEROR_CHESTPLATES))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();
		REFINE_MEROR_SHINGUARD = JerotesGolems.REGISTRATE.item("refine_meror_shinguard", p -> new RefineMerorArmorItem(p.stacksTo(1),
						ArmorItem.Type.LEGGINGS, 10, 10, JGModelPaths.REFINE_MEROR_LEGGINGS))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();

		SPECIAL_WEAPONS = JGWeaponGen.buildSpecial(JGSpecialMaterial.values());
		WEAPONS = JGWeaponGen.build(JGWeaponMaterial.values());
		ULTIMATE_MEROR_SPEAR = JerotesGolems.REGISTRATE.item("ultimate_meror_spear", (p) ->
						new UltimateMerorWeaponItem(p.fireResistant().stacksTo(1), 0, 1, 2, 2))
				.model((ctx, pvd) -> pvd.getBuilder(ctx.getName())
						.parent(new ModelFile.UncheckedModelFile(ModularGolems.loc("item/long_weapon")))
						.texture("layer0", JerotesGolems.loc("item/equipments/" + ctx.getName()))
						.override().predicate(JerotesGolems.loc("charged"), 1)
						.model(pvd.getBuilder(ctx.getName() + "_charged")
								.customLoader(ItemLayerModelBuilder::begin)
								.emissive(15, 15, 0).end()
								.parent(new ModelFile.UncheckedModelFile(ModularGolems.loc("item/long_weapon")))
								.texture("layer0", JerotesGolems.loc("item/equipments/" + ctx.getName() + "_charged"))
						).end())
				.tag(MGTagGen.SHIELD_BREAKER_WEAPONS, MGTagGen.TOUGH_ITEM)
				.register();

		MEROR_FLAME_THROWER = JerotesGolems.REGISTRATE.item("meror_flame_thrower", p -> new MerorFlameThrowerItem(p.stacksTo(1)))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.tag(MGTagGen.TOUGH_ITEM).register();
		MEROR_MACHINE_GUN = JerotesGolems.REGISTRATE.item("meror_machine_gun", p -> new MerorMachineGunItem(p.stacksTo(1)))
				.model((ctx, pvd) -> pvd.generated(ctx, pvd.modLoc("item/equipments/" + ctx.getName())))
				.tag(MGTagGen.TOUGH_ITEM).register();
	}

	public static void register() {

	}

}
