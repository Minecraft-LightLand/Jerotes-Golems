package dev.xkmc.jerotes_golems.content.equipment;

import com.jerotes.jerotes.item.Interface.ItemAnesthetized;
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

public class AnestheticSpear extends MetalGolemWeaponItem implements IDamageListenerWeapon, ItemAnesthetized {

	public AnestheticSpear(Properties properties, int attackDamage, double percentAttack, float range, float sweep) {
		super(properties, attackDamage, percentAttack, range, sweep);
	}

	@Override
	public void onHurt(AttackCache cache, DamageSource source, MetalGolemEntity e, ItemStack stack) {
		var target = cache.getAttackTarget();
		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 440, 4));
		target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 440, 2));
	}

	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		list.add(Component.translatable("item.jerotes.anesthetized_only_melee", this.getAnesthetized()).withStyle(ChatFormatting.YELLOW));
		list.add(Component.translatable("item.jerotes.anesthetic_javelin.desc").withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, level, list, tooltipFlag);
	}

	@Override
	public int getAnesthetized() {
		return 330;
	}

	@Override
	public boolean onlyPlayer() {
		return false;
	}

	@Override
	public boolean onlyThrowing() {
		return false;
	}

}
