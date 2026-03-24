package dev.xkmc.jerotes_golems.content.equipment;

import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.ItemStack;

public interface IDamageListenerWeapon {

	void onHurt(AttackCache cache, DamageSource source, MetalGolemEntity e, ItemStack stack);

}
