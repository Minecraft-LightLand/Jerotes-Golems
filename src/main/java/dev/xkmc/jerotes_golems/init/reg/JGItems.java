package dev.xkmc.jerotes_golems.init.reg;

import com.tterrag.registrate.util.entry.ItemEntry;
import dev.xkmc.jerotes_golems.content.equipment.JGWeaponGen;
import dev.xkmc.jerotes_golems.content.equipment.JGWeaponMaterial;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;

public class JGItems {

	public static final ItemEntry<MetalGolemWeaponItem>[][] WEAPONS;

	static {
		WEAPONS = JGWeaponGen.build(JGWeaponMaterial.values());
	}

	public static void register() {

	}

}
