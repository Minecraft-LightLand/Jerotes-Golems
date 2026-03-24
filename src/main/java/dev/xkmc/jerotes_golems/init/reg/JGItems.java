package dev.xkmc.jerotes_golems.init.reg;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.xkmc.jerotes_golems.content.armor.MerorArmorItem;
import dev.xkmc.jerotes_golems.content.armor.RefineMerorArmorItem;
import dev.xkmc.jerotes_golems.content.armor.WonderlandArmorItem;
import dev.xkmc.jerotes_golems.content.client.JGModelPaths;
import dev.xkmc.jerotes_golems.content.weapon.JGSpecialMaterial;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponGen;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponMaterial;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;

public class JGItems {

	public static final RegistryEntry<CreativeModeTab> TAB;

	public static final ItemEntry<WonderlandArmorItem> WONDERLAND_HELMET, WONDERLAND_CHESTPLATE, WONDERLAND_SHINGUARD;
	public static final ItemEntry<MerorArmorItem> MEROR_HELMET, MEROR_CHESTPLATE, MEROR_SHINGUARD;
	public static final ItemEntry<RefineMerorArmorItem> REFINE_MEROR_HELMET, REFINE_MEROR_CHESTPLATE, REFINE_MEROR_SHINGUARD;

	public static final ItemEntry<MetalGolemWeaponItem>[][] WEAPONS;
	public static final ItemEntry<MetalGolemWeaponItem>[] SPECIAL_WEAPONS;


	static {
		TAB = JerotesGolems.REGISTRATE.buildL2CreativeTab("main", "Jerotes Village Golems", b ->
				b.icon(() -> JGItems.SPECIAL_WEAPONS[0].asStack()));


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
	}

	public static void register() {

	}

}
