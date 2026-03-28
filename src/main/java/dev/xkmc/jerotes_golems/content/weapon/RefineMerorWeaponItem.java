package dev.xkmc.jerotes_golems.content.weapon;

import com.jerotes.jerotes.init.JerotesMobEffects;
import dev.xkmc.jerotes_golems.init.data.JGLang;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RefineMerorWeaponItem extends MetalGolemWeaponItem implements IDamageListenerWeapon {

	public RefineMerorWeaponItem(Properties properties, int attackDamage, double percentAttack, float range, float sweep) {
		super(properties, attackDamage, percentAttack, range, sweep);
	}

	@Override
	public void onHurt(AttackCache cache, DamageSource source, MetalGolemEntity e, ItemStack stack) {
		var target = cache.getAttackTarget();
		var eff = JerotesMobEffects.BLEEDING.get();
		var old = target.getEffect(eff);
		if (old == null) {
			target.addEffect(new MobEffectInstance(eff, 60, 0, false, false), e);
			return;
		}
		int level = old.getAmplifier() + 1;
		int time = old.getDuration();
		int levelAdd = level;
		int timeAdd = time + 20;
		if (timeAdd > 120) {
			if (level < 5) {
				levelAdd = level + 1;
				timeAdd = 60;
			} else timeAdd = 120;
		}
		target.addEffect(new MobEffectInstance(eff, timeAdd, levelAdd, false, false), e);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		list.add(JGLang.REFINE_MEROR_WEAPON.get());
		super.appendHoverText(stack, level, list, flag);
	}

}
