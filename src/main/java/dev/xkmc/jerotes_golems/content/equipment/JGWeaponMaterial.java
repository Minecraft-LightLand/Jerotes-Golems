package dev.xkmc.jerotes_golems.content.equipment;

import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.init.material.IGolemWeaponMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.Locale;

public enum JGWeaponMaterial implements IGolemWeaponMaterial {
	VILLAGER_METAL(6, false, JerotesVillageItems.VILLAGER_METAL_INGOT::get),
	QOAIKU(8, false, JerotesVillageItems.QOAIKU_METAL_INGOT::get),
	SERPON(10, true, JerotesVillageItems.SERPON_ALLOY_INGOT::get),
	MEROR(12, true, JerotesVillageItems.MEROR_METAL_INGOT::get);

	private final int damage;
	private final boolean fireResistant;
	private final ItemLike ingot;

	JGWeaponMaterial(int damage, boolean fireResistant, ItemLike ingot) {
		this.damage = damage;
		this.fireResistant = fireResistant;
		this.ingot = ingot;
	}

	public int getDamage() {
		return this.damage;
	}

	public String getName() {
		return this.name().toLowerCase(Locale.ROOT);
	}

	public boolean fireResistant() {
		return this.fireResistant;
	}

	public Item getIngot() {
		return this.ingot.asItem();
	}

	public ResourceLocation modLoc(String s) {
		return JerotesGolems.loc(s);
	}

}
