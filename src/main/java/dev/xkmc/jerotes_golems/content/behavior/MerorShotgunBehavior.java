package dev.xkmc.jerotes_golems.content.behavior;

import com.jerotes.jerotesvillage.entity.Shoot.Other.MerorBulletEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageEntityType;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import com.jerotes.jerotesvillage.item.MerorShotgun;
import dev.xkmc.mob_weapon_api.api.projectile.CrossbowUseContext;
import dev.xkmc.mob_weapon_api.api.projectile.ICrossbowBehavior;
import dev.xkmc.mob_weapon_api.api.projectile.ProjectileWeaponUser;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class MerorShotgunBehavior implements ICrossbowBehavior {

	@Override
	public int chargeTime(LivingEntity user, ItemStack stack) {
		return MerorShotgun.getChargeDuration(stack);
	}

	@Override
	public boolean hasProjectile(ProjectileWeaponUser user, ItemStack stack) {
		return user.bypassAllConsumption() || !user.getPreferredProjectile(stack).isEmpty();
	}

	@Override
	public List<ItemStack> getLoadedProjectile(LivingEntity user, ItemStack stack) {
		return MerorShotgun.getBullet(stack) > 0 ? List.of(JerotesVillageItems.MEROR_BULLET.get().getDefaultInstance()) : List.of();
	}

	@Override
	public void release(ItemStack stack) {
		int bullet = MerorShotgun.getBullet(stack);
		if (bullet > 0)
			MerorShotgun.setBullet(stack, bullet - 1);
	}

	@Override
	public boolean tryCharge(ProjectileWeaponUser user, ItemStack stack) {
		int bullet = MerorShotgun.getBullet(stack);
		if (bullet > 0) return true;
		if (!user.bypassAllConsumption()) {
			var ammo = user.getPreferredProjectile(stack);
			if (ammo.isEmpty()) return false;
			ammo.shrink(1);
		}
		MerorShotgun.setBullet(stack, 8);
		return true;
	}

	@Override
	public int performRangedAttack(CrossbowUseContext user, ItemStack stack, InteractionHand hand) {
		var mob = user.user();
		for (int i = 0; i < 3; i++) {
			Projectile shoot = new MerorBulletEntity(JerotesVillageEntityType.MEROR_BULLET.get(), mob.level());
			shoot.setOwner(mob);
			shoot.setPos(mob.getX(), mob.getEyeY() * 0.75 + mob.getY() * 0.25, mob.getZ());
			var pos = shoot.position();
			user.aim(pos, 4, 0, 0).shoot(shoot, 0);
			mob.level().addFreshEntity(shoot);
		}
		if (!mob.isSilent()) {
			mob.level().playSound(null, mob.getX(), mob.getY(), mob.getZ(), SoundEvents.GENERIC_EXPLODE, mob.getSoundSource(), 1.0F, 5.0F);
		}
		return 10;
	}

}
