package dev.xkmc.jerotes_golems.content.behavior;

import com.jerotes.jerotes.item.Interface.JerotesItemThrownJavelinUse;
import dev.xkmc.mob_weapon_api.api.projectile.ProjectileWeaponUser;
import dev.xkmc.mob_weapon_api.example.behavior.ThrowableBehavior;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class JerotesJavelinBehavior extends ThrowableBehavior {

	@Override
	public float getSpeed(ItemStack stack, Projectile proj) {
		if (stack.getItem() instanceof JerotesItemThrownJavelinUse javelin)
			return javelin.getJavelinSpeed();
		return super.getSpeed(stack, proj);
	}

	protected @Nullable Projectile getProjectile(ProjectileWeaponUser user, ItemStack stack, LivingEntity target, int time) {
		if (!(stack.getItem() instanceof JerotesItemThrownJavelinUse javelin)) return null;
		var ans = javelin.JerotesThrownJavelin(user.user(), stack);
		if (ans instanceof AbstractArrow arrow)
			arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
		return ans;
	}

}
