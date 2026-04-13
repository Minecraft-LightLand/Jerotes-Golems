package dev.xkmc.jerotes_golems.init.data;

import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import dev.xkmc.golemdungeons.init.reg.GDItems;
import dev.xkmc.jerotes_golems.content.weapon.JGSpecialMaterial;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponMaterial;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.modulargolems.init.data.RecipeGen;
import dev.xkmc.modulargolems.init.material.GolemWeaponType;
import dev.xkmc.modulargolems.init.material.VanillaGolemWeaponMaterial;
import dev.xkmc.modulargolems.init.registrate.GolemItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.function.BiFunction;

public class JGRecipeGen {

	public static void genRecipe(RegistrateRecipeProvider pvd) {
		for (GolemWeaponType type : GolemWeaponType.values()) {
			for (JGWeaponMaterial mat : JGWeaponMaterial.values()) {
				Item item = JGItems.WEAPONS[type.ordinal()][mat.ordinal()].get();
				type.pattern(RecipeGen.unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, item)::unlockedBy, mat.getIngot()))
						.define('I', mat.getIngot())
						.define('S', Items.STICK)
						.define('T', GolemItems.GOLEM_TEMPLATE.get())
						.save(pvd);
			}
		}

		// deployer
		{

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JGItems.VILLAGER_METAL_DEPLOYER.get())::unlockedBy, JerotesVillageItems.CARVED_IRON_GOLEM_CORE.get())
					.pattern("ACA")
					.pattern("TIT")
					.pattern("AMA")
					.define('M', GDItems.MEDAL_OF_CONQUEROR)
					.define('T', GolemItems.GOLEM_TEMPLATE)
					.define('I', JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get())
					.define('C', JerotesVillageItems.CARVED_IRON_GOLEM_CORE.get())
					.define('A', JerotesVillageItems.VILLAGER_METAL_INGOT.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JGItems.QOAIKU_DEPLOYER.get())::unlockedBy, JerotesVillageItems.QOAIKU_METAL_INGOT.get())
					.pattern("ACA")
					.pattern("TIT")
					.pattern("AMA")
					.define('M', GDItems.MEDAL_OF_CONQUEROR)
					.define('T', GolemItems.GOLEM_TEMPLATE)
					.define('I', JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get())
					.define('C', Items.DIAMOND)
					.define('A', JerotesVillageItems.QOAIKU_METAL_INGOT.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JGItems.MEROR_DEPLOYER.get())::unlockedBy, JerotesVillageItems.MEROR_METAL_INGOT.get())
					.pattern("ACA")
					.pattern("TIT")
					.pattern("AMA")
					.define('M', GDItems.TRIAL_MEDAL)
					.define('T', GolemItems.GOLEM_TEMPLATE)
					.define('I', JerotesVillageItems.OMINOUS_BANNER_PROJECTION_EMERALD_FRAGMENT.get())
					.define('C', JerotesVillageItems.MEROR_ENERGY_REGIME.get())
					.define('A', JerotesVillageItems.MEROR_METAL_INGOT.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JGItems.ENHANCED_VILLAGER_METAL_DEPLOYER.get())::unlockedBy, Items.NETHERITE_INGOT)
					.pattern("ABA")
					.pattern("BIB")
					.pattern("ABA")
					.define('I', JGItems.VILLAGER_METAL_DEPLOYER.get())
					.define('A', Items.EMERALD_BLOCK)
					.define('B', Items.NETHERITE_BLOCK)
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JGItems.REFINE_MEROR_DEPLOYER.get())::unlockedBy, JerotesVillageItems.REFINE_MEROR_METAL_INGOT.get())
					.pattern("ABA")
					.pattern("BIB")
					.pattern("ABA")
					.define('I', JGItems.MEROR_DEPLOYER.get())
					.define('A', JerotesVillageItems.REFINE_MEROR_METAL_INGOT.get())
					.define('B', JerotesVillageItems.MEROR_ENERGY_REGIME.get())
					.save(pvd);
		}

		// upgrades
		{

			unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JGModifiers.ITEM_ABACK.get(),
					1)::unlockedBy, JerotesVillageItems.BRIGHT_LAND_DRUM.get())
					.requires(GolemItems.EMPTY_UPGRADE.get())
					.requires(JerotesVillageItems.BRIGHT_LAND_DRUM.get())
					.save(pvd);

			unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JGModifiers.ITEM_RAMPANT.get(),
					1)::unlockedBy, JerotesVillageItems.FROST_YETI_HAIR.get())
					.requires(GolemItems.EMPTY_UPGRADE.get())
					.requires(JerotesVillageItems.FROST_YETI_HAIR.get())
					.save(pvd);

			unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JGModifiers.ITEM_SEDIMENT.get(),
					1)::unlockedBy, JerotesVillageItems.SEDIMENT_LORD_ROBE_PIECES.get())
					.requires(GolemItems.EMPTY_UPGRADE.get())
					.requires(JerotesVillageItems.SEDIMENT_LORD_ROBE_PIECES.get())
					.save(pvd);

			unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JGModifiers.ITEM_PURPLE_SAND.get(),
					1)::unlockedBy, JerotesVillageItems.PURPLE_SAND_HAG_HAIR.get())
					.requires(GolemItems.EMPTY_UPGRADE.get())
					.requires(JerotesVillageItems.PURPLE_SAND_HAG_HAIR.get())
					.save(pvd);

			unlock(pvd, ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, JGModifiers.ITEM_PROSPEROUS_ENVOY.get(),
					1)::unlockedBy, JerotesVillageItems.PROSPEROUS_ENVOY_FLOWER.get())
					.requires(GolemItems.EMPTY_UPGRADE.get())
					.requires(JerotesVillageItems.PROSPEROUS_ENVOY_FLOWER.get())
					.save(pvd);

		}

		// misc
		{

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JGItems.MEROR_MACHINE_GUN.get())::unlockedBy, JerotesVillageItems.MEROR_ENERGY_REGIME.get())
					.pattern("BMR")
					.pattern("TER")
					.pattern("BMR")
					.define('E', JerotesVillageItems.MEROR_ENERGY_REGIME.get())
					.define('M', JerotesVillageItems.MEROR_METAL_INGOT.get())
					.define('R', JerotesVillageItems.REFINE_MEROR_METAL_INGOT.get())
					.define('B', JerotesVillageItems.MEROR_METAL_BLOCK.get())
					.define('T', JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.MISC, JGItems.MEROR_FLAME_THROWER.get())::unlockedBy, JerotesVillageItems.MEROR_ENERGY_REGIME.get())
					.pattern("BB ")
					.pattern("IER")
					.pattern("TMM")
					.define('E', JerotesVillageItems.MEROR_ENERGY_REGIME.get())
					.define('M', JerotesVillageItems.MEROR_METAL_INGOT.get())
					.define('R', JerotesVillageItems.REFINE_MEROR_METAL_INGOT.get())
					.define('B', JerotesVillageItems.MEROR_METAL_BLOCK.get())
					.define('T', JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get())
					.define('I', Items.BLAZE_ROD)
					.save(pvd);
		}

		// armor
		{
			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.WONDERLAND_HELMET.get())::unlockedBy, JerotesVillageItems.MOUNTAIN_REALM_HELMET.get())
					.pattern("AIA")
					.define('I', JerotesVillageItems.MOUNTAIN_REALM_HELMET.get())
					.define('A', GolemItems.GOLEM_TEMPLATE.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.WONDERLAND_CHESTPLATE.get())::unlockedBy, JerotesVillageItems.MOUNTAIN_REALM_CHESTPLATE.get())
					.pattern("AIA")
					.define('I', JerotesVillageItems.MOUNTAIN_REALM_CHESTPLATE.get())
					.define('A', GolemItems.GOLEM_TEMPLATE.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.WONDERLAND_SHINGUARD.get())::unlockedBy, JerotesVillageItems.MOUNTAIN_REALM_LEGGINGS.get())
					.pattern("AIA")
					.define('I', JerotesVillageItems.MOUNTAIN_REALM_LEGGINGS.get())
					.define('A', GolemItems.GOLEM_TEMPLATE.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.MEROR_HELMET.get())::unlockedBy, JerotesVillageItems.MEROR_METAL_HELMET.get())
					.pattern(" B ").pattern("III").pattern("IAI")
					.define('I', JerotesVillageItems.MEROR_METAL_HELMET.get())
					.define('A', GolemItems.GOLEM_TEMPLATE.get())
					.define('B', JerotesVillageItems.MEROR_METAL_NUGGET.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.MEROR_CHESTPLATE.get())::unlockedBy, JerotesVillageItems.MEROR_METAL_CHESTPLATE.get())
					.pattern("IAI").pattern("III").pattern("BIB")
					.define('I', JerotesVillageItems.MEROR_METAL_CHESTPLATE.get())
					.define('A', GolemItems.GOLEM_TEMPLATE.get())
					.define('B', JerotesVillageItems.MEROR_METAL_NUGGET.get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.MEROR_SHINGUARD.get())::unlockedBy, JerotesVillageItems.MEROR_METAL_LEGGINGS.get())
					.pattern("BIB").pattern(" A ").pattern("I I")
					.define('I', JerotesVillageItems.MEROR_METAL_LEGGINGS.get())
					.define('A', GolemItems.GOLEM_TEMPLATE.get())
					.define('B', JerotesVillageItems.MEROR_METAL_NUGGET.get())
					.save(pvd);

			unlock(pvd, SmithingTransformRecipeBuilder.smithing(
							Ingredient.of(JerotesVillageItems.MEROR_STANDARD_UPGRADE_SMITHING_TEMPLATE.get()),
							Ingredient.of(JGItems.MEROR_HELMET.get()),
							Ingredient.of(JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get()),
							RecipeCategory.COMBAT, JGItems.REFINE_MEROR_HELMET.get())::unlocks,
					JGItems.MEROR_HELMET.get())
					.save(pvd, JGItems.REFINE_MEROR_HELMET.getId());

			unlock(pvd, SmithingTransformRecipeBuilder.smithing(
							Ingredient.of(JerotesVillageItems.MEROR_STANDARD_UPGRADE_SMITHING_TEMPLATE.get()),
							Ingredient.of(JGItems.MEROR_CHESTPLATE.get()),
							Ingredient.of(JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get()),
							RecipeCategory.COMBAT, JGItems.REFINE_MEROR_CHESTPLATE.get())::unlocks,
					JGItems.MEROR_CHESTPLATE.get())
					.save(pvd, JGItems.REFINE_MEROR_CHESTPLATE.getId());

			unlock(pvd, SmithingTransformRecipeBuilder.smithing(
							Ingredient.of(JerotesVillageItems.MEROR_STANDARD_UPGRADE_SMITHING_TEMPLATE.get()),
							Ingredient.of(JGItems.MEROR_SHINGUARD.get()),
							Ingredient.of(JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get()),
							RecipeCategory.COMBAT, JGItems.REFINE_MEROR_SHINGUARD.get())::unlocks,
					JGItems.MEROR_SHINGUARD.get())
					.save(pvd, JGItems.REFINE_MEROR_SHINGUARD.getId());

		}

		//special weapon
		{
			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.ANESTHETIC_SPEAR.ordinal()].get())::unlockedBy, Items.DIAMOND)
					.pattern("III").pattern("IAI").pattern("III")
					.define('I', Ingredient.of(Items.POISONOUS_POTATO,
							JerotesVillageItems.GREEN_HUMANOID_CANE_STEMS.get(),
							JerotesVillageItems.GREEN_HUMANOID_CANE.get()
					))
					.define('A', GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SPEAR.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
					.save(pvd);

			unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.BRIGHT_LAND_BLADE.ordinal()].get())::unlockedBy, JerotesVillageItems.BRIGHT_LAND_BEAST_HORN.get())
					.pattern("  A").pattern("BI ").pattern("IB ")
					.define('I', Items.STICK)
					.define('A', JerotesVillageItems.BRIGHT_LAND_BEAST_HORN.get())
					.define('B', GolemItems.GOLEM_TEMPLATE)
					.save(pvd);

			unlock(pvd, SmithingTransformRecipeBuilder.smithing(
							Ingredient.of(JerotesVillageItems.ANCIENT_SECOND_ROUNDER_NOBLE_UPGRADE_SMITHING_TEMPLATE.get()),
							Ingredient.of(GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get()),
							Ingredient.of(Blocks.LAPIS_BLOCK),
							RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SEDIMENT_SWORD.ordinal()].get())::unlocks,
					GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
					.save(pvd, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SEDIMENT_SWORD.ordinal()].getId());

			unlock(pvd, SmithingTransformRecipeBuilder.smithing(
							Ingredient.of(JerotesVillageItems.THE_GRACE_OF_SERPENPERTH.get()),
							Ingredient.of(JGItems.WEAPONS[GolemWeaponType.SWORD.ordinal()][JGWeaponMaterial.SERPON.ordinal()].get()),
							Ingredient.of(Blocks.OBSIDIAN),
							RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SERPON_CHAIN_BLADE.ordinal()].get())::unlocks,
					JGItems.WEAPONS[GolemWeaponType.SWORD.ordinal()][JGWeaponMaterial.SERPON.ordinal()].get())
					.save(pvd, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SERPON_CHAIN_BLADE.ordinal()].getId());

			unlock(pvd, SmithingTransformRecipeBuilder.smithing(
							Ingredient.of(JerotesVillageItems.BITTER_COLD_FIRM_ICE.get()),
							Ingredient.of(GolemItems.METALGOLEM_WEAPON[GolemWeaponType.AXE.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get()),
							Ingredient.of(JerotesVillageItems.ICE_ROCK.get()),
							RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.BITTER_COLD_AXE.ordinal()].get())::unlocks,
					GolemItems.METALGOLEM_WEAPON[GolemWeaponType.AXE.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
					.save(pvd, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.BITTER_COLD_AXE.ordinal()].getId());

			unlock(pvd, SmithingTransformRecipeBuilder.smithing(
							Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
							Ingredient.of(GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get()),
							Ingredient.of(JerotesVillageItems.MOUNTAIN_REALM_NINE_RINGED_DAO.get()),
							RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.WONDERLAND_BLADE.ordinal()].get())::unlocks,
					GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
					.save(pvd, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.WONDERLAND_BLADE.ordinal()].getId());
		}
	}

	public static <T> T unlock(RegistrateRecipeProvider pvd, BiFunction<String, InventoryChangeTrigger.TriggerInstance, T> func, Item item) {
		return func.apply("has_" + pvd.safeName(item), DataIngredient.items(item).getCritereon(pvd));
	}

}
