package dev.xkmc.jerotes_golems.init.data;

import com.jerotes.jerotes.init.JerotesItems;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import dev.xkmc.jerotes_golems.content.armor.WonderlandArmorItem;
import dev.xkmc.jerotes_golems.content.weapon.JGSpecialMaterial;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponMaterial;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.modulargolems.init.data.RecipeGen;
import dev.xkmc.modulargolems.init.material.GolemWeaponType;
import dev.xkmc.modulargolems.init.material.VanillaGolemWeaponMaterial;
import dev.xkmc.modulargolems.init.registrate.GolemItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.Objects;
import java.util.function.BiFunction;

import static dev.xkmc.modulargolems.init.data.RecipeGen.unlock;

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
	}

	public static <T> T unlock(RegistrateRecipeProvider pvd, BiFunction<String, InventoryChangeTrigger.TriggerInstance, T> func, Item item) {
		return func.apply("has_" + pvd.safeName(item), DataIngredient.items(item).getCritereon(pvd));
	}

    public static void genRecipe(RegistrateRecipeProvider pvd) {
        ITagManager<Item> manager = Objects.requireNonNull(ForgeRegistries.ITEMS.tags());

        // armor
        {
            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.WONDERLAND_HELMET.get())::unlockedBy, JerotesVillageItems.MOUNTAIN_REALM_HELMET.get())
                    .pattern("AIA")
                    .define('I', JerotesVillageItems.MOUNTAIN_REALM_HELMET)
                    .define('A', GolemItems.GOLEM_TEMPLATE.get())
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.WONDERLAND_CHESTPLATE.get())::unlockedBy, JerotesVillageItems.MOUNTAIN_REALM_CHESTPLATE.get())
                    .pattern("AIA")
                    .define('I', JerotesVillageItems.MOUNTAIN_REALM_CHESTPLATE)
                    .define('A', GolemItems.GOLEM_TEMPLATE.get())
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.WONDERLAND_SHINGUARD.get())::unlockedBy, JerotesVillageItems.MOUNTAIN_REALM_LEGGINGS.get())
                    .pattern("AIA")
                    .define('I', JerotesVillageItems.MOUNTAIN_REALM_LEGGINGS)
                    .define('A', GolemItems.GOLEM_TEMPLATE.get())
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.MEROR_HELMET.get())::unlockedBy, JerotesVillageItems.MEROR_METAL_HELMET.get())
                    .pattern(" B ").pattern("III").pattern("IAI")
                    .define('I', JerotesVillageItems.MEROR_METAL_HELMET)
                    .define('A', GolemItems.GOLEM_TEMPLATE.get())
                    .define('B', JerotesVillageItems.MEROR_METAL_NUGGET)
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.MEROR_CHESTPLATE.get())::unlockedBy, JerotesVillageItems.MEROR_METAL_CHESTPLATE.get())
                    .pattern("IAI").pattern("III").pattern("BIB")
                    .define('I', JerotesVillageItems.MEROR_METAL_CHESTPLATE)
                    .define('A', GolemItems.GOLEM_TEMPLATE.get())
                    .define('B', JerotesVillageItems.MEROR_METAL_NUGGET)
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.MEROR_SHINGUARD.get())::unlockedBy, JerotesVillageItems.MEROR_METAL_LEGGINGS.get())
                    .pattern("BIB").pattern(" A ").pattern("I I")
                    .define('I', JerotesVillageItems.MEROR_METAL_LEGGINGS)
                    .define('A', GolemItems.GOLEM_TEMPLATE.get())
                    .define('B', JerotesVillageItems.MEROR_METAL_NUGGET)
                    .save(pvd);

            unlock(pvd, SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(JerotesVillageItems.MEROR_STANDARD_UPGRADE_SMITHING_TEMPLATE.get()),
                            Ingredient.of(JGItems.MEROR_HELMET.get()),
                            Ingredient.of(JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get()),
                            RecipeCategory.COMBAT, JGItems.REFINE_MEROR_HELMET.get())::unlocks,
                    JGItems.MEROR_HELMET.get())
                    .save(output, JGItems.REFINE_MEROR_HELMET.getId());

            unlock(pvd, SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(JerotesVillageItems.MEROR_STANDARD_UPGRADE_SMITHING_TEMPLATE.get()),
                            Ingredient.of(JGItems.MEROR_CHESTPLATE.get()),
                            Ingredient.of(JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get()),
                            RecipeCategory.COMBAT, JGItems.REFINE_MEROR_CHESTPLATE.get())::unlocks,
                    JGItems.MEROR_CHESTPLATE.get())
                    .save(output, JGItems.REFINE_MEROR_CHESTPLATE.getId());

            unlock(pvd, SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(JerotesVillageItems.MEROR_STANDARD_UPGRADE_SMITHING_TEMPLATE.get()),
                            Ingredient.of(JGItems.MEROR_SHINGUARD.get()),
                            Ingredient.of(JerotesVillageItems.REFINE_MEROR_METAL_BLOCK.get()),
                            RecipeCategory.COMBAT, JGItems.REFINE_MEROR_SHINGUARD.get())::unlocks,
                    JGItems.MEROR_SHINGUARD.get())
                    .save(output, JGItems.REFINE_MEROR_SHINGUARD.getId());

        }
        //special weapon
        {
            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.ANESTHETIC_SPEAR.ordinal()].get())::unlockedBy,
                    .pattern("III").pattern("IAI").pattern("III")
                    .define('I', JerotesVillageItems.GREEN_HUMANOID_CANE)
                    .define('A', GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SPEAR.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.ANESTHETIC_SPEAR.ordinal()].get())::unlockedBy,
                    .pattern("III").pattern("IAI").pattern("III")
                    .define('I', JerotesVillageItems.GREEN_HUMANOID_CANE_STEMS)
                    .define('A', GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SPEAR.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.ANESTHETIC_SPEAR.ordinal()].get())::unlockedBy,
                    .pattern("III").pattern("IAI").pattern("III")
                    .define('I', Items.POISONOUS_POTATO)
                    .define('A', GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SPEAR.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
                    .save(pvd);

            unlock(pvd, ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.BRIGHT_LAND_BLADE.ordinal()].get())::unlockedBy, JerotesVillageItems.BRIGHT_LAND_BEAST_HORN.get())
                    .pattern("  A").pattern("BI ").pattern("IB ")
                    .define('I', Items.STICK)
                    .define('A', JerotesVillageItems.BRIGHT_LAND_BEAST_HORN)
                    .define('B', GolemItems.GOLEM_TEMPLATE)
                    .save(pvd);

            unlock(pvd, SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(JerotesVillageItems.ANCIENT_SECOND_ROUNDER_NOBLE_UPGRADE_SMITHING_TEMPLATE.get()),
                            Ingredient.of(GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get()),
                            Ingredient.of(Blocks.LAPIS_BLOCK.get()),
                            RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SEDIMENT_SWORD.ordinal()].get())::unlocks,
                    GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.DIAMOND.ordinal()].get())
                    .save(output, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SEDIMENT_SWORD.ordinal()].getId());

            unlock(pvd, SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(JerotesVillageItems.THE_GRACE_OF_SERPENPERTH.get()),
                            Ingredient.of(JGItems.WEAPONS[GolemWeaponType.SWORD.ordinal()][JGWeaponMaterial.SERPON.ordinal()].get()),
                            Ingredient.of(Blocks.OBSIDIAN.get()),
                            RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SERPON_CHAIN_BLADE.ordinal()].get())::unlocks,
                    JGItems.WEAPONS[GolemWeaponType.SWORD.ordinal()][JGWeaponMaterial.SERPON.ordinal()].get())
                    .save(output, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.SERPON_CHAIN_BLADE.ordinal()].getId());

            unlock(pvd, SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(JerotesVillageItems.BITTER_COLD_FIRM_ICE.get()),
                            Ingredient.of(GolemItems.METALGOLEM_WEAPON[GolemWeaponType.AXE.ordinal()][VanillaGolemWeaponMaterial.IRON.ordinal()].get()),
                            Ingredient.of(JerotesVillageItems.ICE_ROCK.get()),
                            RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.BITTER_COLD_AXE.ordinal()].get())::unlocks,
                    GolemItems.METALGOLEM_WEAPON[GolemWeaponType.AXE.ordinal()][VanillaGolemWeaponMaterial.IRON.ordinal()].get())
                    .save(output, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.BITTER_COLD_AXE.ordinal()].getId());

            unlock(pvd, SmithingTransformRecipeBuilder.smithing(
                            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                            Ingredient.of(GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.IRON.ordinal()].get()),
                            Ingredient.of(JerotesVillageItems.MOUNTAIN_REALM_NINE_RINGED_DAO.get()),
                            RecipeCategory.COMBAT, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.WONDERLAND_BLADE.ordinal()].get())::unlocks,
                    GolemItems.METALGOLEM_WEAPON[GolemWeaponType.SWORD.ordinal()][VanillaGolemWeaponMaterial.IRON.ordinal()].get())
                    .save(output, JGItems.SPECIAL_WEAPONS[JGSpecialMaterial.WONDERLAND_BLADE.ordinal()].getId());
        }
    }
}
