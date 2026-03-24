package dev.xkmc.jerotes_golems.init.data;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import dev.xkmc.jerotes_golems.content.weapon.JGWeaponMaterial;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.modulargolems.init.data.RecipeGen;
import dev.xkmc.modulargolems.init.material.GolemWeaponType;
import dev.xkmc.modulargolems.init.registrate.GolemItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

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
	}

	public static <T> T unlock(RegistrateRecipeProvider pvd, BiFunction<String, InventoryChangeTrigger.TriggerInstance, T> func, Item item) {
		return func.apply("has_" + pvd.safeName(item), DataIngredient.items(item).getCritereon(pvd));
	}


}
