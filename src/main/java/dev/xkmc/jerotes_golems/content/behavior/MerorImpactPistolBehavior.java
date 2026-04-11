package dev.xkmc.jerotes_golems.content.behavior;

import com.jerotes.jerotesvillage.entity.Shoot.Other.MerorShockWaveEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageEntityType;
import com.jerotes.jerotesvillage.item.MerorImpactPistol;
import dev.xkmc.mob_weapon_api.api.projectile.ProjectileWeaponUser;
import dev.xkmc.mob_weapon_api.api.simple.IInstantWeaponBehavior;
import dev.xkmc.mob_weapon_api.util.ShootUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;

public class MerorImpactPistolBehavior implements IInstantWeaponBehavior {

	@Override
	public double range(ProjectileWeaponUser projectileWeaponUser, ItemStack itemStack) {
		return 20;
	}

	@Override
	public int trigger(ProjectileWeaponUser user, ItemStack stack, LivingEntity target) {
		var mob = user.user();
		Projectile shoot = new MerorShockWaveEntity(JerotesVillageEntityType.MEROR_SHOCK_WAVE.get(), mob.level());
		shoot.setOwner(mob);
		shoot.setPos(mob.getX(), mob.getEyeY() * 0.75 + mob.getY() * 0.25, mob.getZ());
		var pos = shoot.position();
		ShootUtils.getShootVector(target, pos, 3, 0, 0).shoot(shoot, 0);
		mob.level().addFreshEntity(shoot);
		if (!user.bypassAllConsumption()) {
			stack.hurtAndBreak(1, mob, e -> e.broadcastBreakEvent(user.user().getUsedItemHand()));
		}
		if (!mob.isSilent()) {
			mob.level().playSound(null, mob.getX(), mob.getY(), mob.getZ(), SoundEvents.GENERIC_EXPLODE, mob.getSoundSource(), 1.0F, 5.0F);
		}
		int bullet = MerorImpactPistol.getBullet(stack);
		if (bullet > 1) {
			MerorImpactPistol.setBullet(stack, bullet - 1);
		} else {
			MerorImpactPistol.setBullet(stack, bullet + 5);
			setCD(mob, stack, 80);
		}
		return 5;
	}

}
