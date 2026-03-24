package dev.xkmc.jerotes_golems.content.equipment;

import dev.xkmc.jerotes_golems.init.data.JGLang;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class SedimentSword extends MetalGolemWeaponItem implements IDamageListenerWeapon {

	public SedimentSword(Properties properties, int attackDamage, double percentAttack, float range, float sweep) {
		super(properties, attackDamage, percentAttack, range, sweep);
	}

	@Override
	public void onHurt(AttackCache cache, DamageSource source, MetalGolemEntity e, ItemStack stack) {
		var target = cache.getAttackTarget();
		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 5));
	}

	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		list.add(JGLang.SEDIMENT_SWORD_DESC.get().withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, level, list, tooltipFlag);
	}

}
