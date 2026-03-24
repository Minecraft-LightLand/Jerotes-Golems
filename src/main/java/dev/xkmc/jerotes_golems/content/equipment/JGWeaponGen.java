package dev.xkmc.jerotes_golems.content.equipment;

import com.tterrag.registrate.util.entry.ItemEntry;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import dev.xkmc.modulargolems.init.ModularGolems;
import dev.xkmc.modulargolems.init.material.IGolemWeaponFactory;
import dev.xkmc.modulargolems.init.material.IGolemWeaponMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;

import java.util.Locale;

public enum JGWeaponGen {
	SPEAR("item/long_weapon", (p, i, f) -> f.create(p, 0, i * 0.04, 2.0F, 0.0F)),
	AXE("item/battle_axe", (p, i, f) -> f.create(p, 0, i * 0.05, 0.0F, 2.0F)),
	SWORD("item/sword", (p, i, f) -> f.create(p, 0, i * 0.04, 1.0F, 2.0F));

	private final IWeaponConstructor factory;
	public final String model;

	JGWeaponGen(String model, IWeaponConstructor factory) {
		this.model = model;
		this.factory = factory;
	}

	public String getName() {
		return "golem_" + name().toLowerCase(Locale.ROOT);
	}

	public ItemEntry<MetalGolemWeaponItem> buildItem(IGolemWeaponMaterial material) {
		return JerotesGolems.REGISTRATE.item(material.getName() + "_" + this.getName(), (p) ->
						this.factory.create(material.modify(p.stacksTo(1)), material.getDamage(), material.factory()))
				.model((ctx, pvd) -> material.model(pvd.getBuilder(ctx.getName()))
						.parent(new ModelFile.UncheckedModelFile(ModularGolems.loc(this.model)))
						.texture("layer0", material.modLoc("item/equipments/" + ctx.getName())))
				.defaultLang().register();
	}

	public static ItemEntry<MetalGolemWeaponItem>[][] build(IGolemWeaponMaterial[] values) {
		ItemEntry<MetalGolemWeaponItem>[][] ans = new ItemEntry[values().length][values.length];
		for (int i = 0; i < values().length; ++i) {
			var type = values()[i];
			for (int j = 0; j < values.length; ++j) {
				IGolemWeaponMaterial mat = values[j];
				ans[i][j] = type.buildItem(mat);
			}
		}

		return ans;
	}

	interface IWeaponConstructor {
		MetalGolemWeaponItem create(Item.Properties var1, int var2, IGolemWeaponFactory var3);
	}
}
