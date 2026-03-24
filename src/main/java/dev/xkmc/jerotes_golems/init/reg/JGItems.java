package dev.xkmc.jerotes_golems.init.reg;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.xkmc.jerotes_golems.content.equipment.JGSpecialMaterial;
import dev.xkmc.jerotes_golems.content.equipment.JGWeaponGen;
import dev.xkmc.jerotes_golems.content.equipment.JGWeaponMaterial;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import net.minecraft.world.item.CreativeModeTab;

public class JGItems {

	public static final RegistryEntry<CreativeModeTab> TAB;

	public static final ItemEntry<MetalGolemWeaponItem>[][] WEAPONS;
	public static final ItemEntry<MetalGolemWeaponItem>[] SPECIAL_WEAPONS;

	static {
		TAB = JerotesGolems.REGISTRATE.buildL2CreativeTab("main", "Jerotes Village Golems", b ->
				b.icon(() -> JGItems.SPECIAL_WEAPONS[0].asStack()));
		SPECIAL_WEAPONS = JGWeaponGen.buildSpecial(JGSpecialMaterial.values());
		WEAPONS = JGWeaponGen.build(JGWeaponMaterial.values());
	}

	public static void register() {

	}

}
