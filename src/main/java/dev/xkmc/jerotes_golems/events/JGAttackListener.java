package dev.xkmc.jerotes_golems.events;

import dev.xkmc.jerotes_golems.content.weapon.IDamageListenerWeapon;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.AttackListener;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import net.minecraft.world.item.ItemStack;

public class JGAttackListener implements AttackListener {

	@Override
	public void onAttack(AttackCache cache, ItemStack weapon) {
		var event = cache.getLivingHurtEvent();
		assert event != null;
		var source = event.getSource();
		if (cache.getAttacker() instanceof MetalGolemEntity e) {
			if (source.is(L2DamageTypes.DIRECT)) {
				var stack = e.getMainHandItem();
				if (stack.getItem() instanceof IDamageListenerWeapon item) {
					item.onAttack(cache, source, e, stack);
				}
			}
		}
	}

	@Override
	public void onHurt(AttackCache cache, ItemStack weapon) {
		var event = cache.getLivingHurtEvent();
		assert event != null;
		var source = event.getSource();
		if (cache.getAttacker() instanceof MetalGolemEntity e) {
			if (source.is(L2DamageTypes.DIRECT)) {
				var stack = e.getMainHandItem();
				if (stack.getItem() instanceof IDamageListenerWeapon item) {
					item.onHurt(cache, source, e, stack);
				}
			}
		}
	}

	@Override
	public void onDamage(AttackCache cache, ItemStack weapon) {
		var event = cache.getLivingHurtEvent();
		assert event != null;
		var source = event.getSource();
		if (cache.getAttacker() instanceof MetalGolemEntity e) {
			if (source.is(L2DamageTypes.DIRECT)) {
				var stack = e.getMainHandItem();
				if (stack.getItem() instanceof IDamageListenerWeapon item) {
					item.onDamage(cache, source, e, stack);
				}
			}
		}
	}
}
