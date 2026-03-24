package dev.xkmc.jerotes_golems.content.equipment;

import com.jerotes.jerotes.util.Main;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BrightLandBlade extends MetalGolemWeaponItem implements IDamageListenerWeapon {

	public BrightLandBlade(Properties properties, int attackDamage, double percentAttack, float range, float sweep) {
		super(properties, attackDamage, percentAttack, range, sweep);
	}

	@Override
	public void onHurt(AttackCache cache, DamageSource source, MetalGolemEntity e, ItemStack stack) {
		var target = cache.getAttackTarget();
		float bonus = Main.mobWidth(target) * 4 * Main.mobHeight(target);
		float baseDamage = (float) e.getAttributeValue(Attributes.ATTACK_DAMAGE);
		baseDamage = Math.max(2, baseDamage);
		bonus = Math.min(bonus, baseDamage * 10);
		cache.addHurtModifier(DamageModifier.multTotal(1 + bonus / baseDamage));
	}

	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		list.add(Component.translatable("item.jerotesvillage.bright_land_beast_horn.desc").withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, level, list, tooltipFlag);
	}

}
