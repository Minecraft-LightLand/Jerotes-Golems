package dev.xkmc.jerotes_golems.content.weapon;

import com.tterrag.registrate.util.entry.ItemEntry;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import dev.xkmc.modulargolems.init.material.IGolemWeaponFactory;
import dev.xkmc.modulargolems.init.material.IGolemWeaponMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Locale;

public enum JGSpecialMaterial implements IGolemWeaponMaterial {
	WONDERLAND_BLADE(JGWeaponGen.SWORD, WonderlandBlade::new, 10, true),
	SERPON_CHAIN_BLADE(JGWeaponGen.SWORD, SerponChainBlade::new, 10, true),
	SEDIMENT_SWORD(JGWeaponGen.SWORD, SedimentSword::new, 8, false),
	BITTER_COLD_AXE(JGWeaponGen.AXE, BitterColdAxe::new, 6, false),
	ANESTHETIC_SPEAR(JGWeaponGen.SPEAR, AnestheticSpear::new, 0, false),
	BRIGHT_LAND_BLADE(JGWeaponGen.SPEAR, BrightLandBlade::new, 0, false);

	private final JGWeaponGen type;
	private final IGolemWeaponFactory factory;
	private final int damage;
	private final boolean fireResistant;

	JGSpecialMaterial(JGWeaponGen type, IGolemWeaponFactory factory, int damage, boolean fireResistant) {
		this.type = type;
		this.factory = factory;
		this.damage = damage;
		this.fireResistant = fireResistant;
	}

	public ItemEntry<MetalGolemWeaponItem> buildItem() {
		return type.buildItem(this, getName());
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
		return Items.AIR;
	}

	public ResourceLocation modLoc(String s) {
		return JerotesGolems.loc(s);
	}

	@Override
	public IGolemWeaponFactory factory() {
		return factory;
	}

}
