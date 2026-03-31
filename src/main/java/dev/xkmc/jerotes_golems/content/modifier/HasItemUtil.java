package dev.xkmc.jerotes_golems.content.modifier;

import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.entity.common.SweepGolemEntity;
import net.minecraft.world.item.Item;

public class HasItemUtil {

	public static boolean hasItem(AbstractGolemEntity<?, ?> golem, Item item) {
		if (golem.getMainHandItem().is(item)) return true;
		if (golem.getOffhandItem().is(item)) return true;
		if (golem instanceof SweepGolemEntity<?, ?> e) {
			if (e.getBackupHand().getItem().is(item)) return true;
			if (e.getArrowSlot().getItem().is(item)) return true;
		}
		return false;
	}

}
