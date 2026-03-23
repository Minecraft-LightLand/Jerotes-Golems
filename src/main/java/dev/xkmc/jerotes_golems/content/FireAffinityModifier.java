package dev.xkmc.jerotes_golems.content;

import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import java.util.List;

public class FireAffinityModifier extends GolemModifier {

	public FireAffinityModifier(int maxLevel) {
		super(StatFilterType.MASS, maxLevel);
	}

	@Override
	public void onAttacked(AbstractGolemEntity<?, ?> entity, LivingAttackEvent event, int level) {
		if (event.getSource().is(DamageTypeTags.IS_FIRE)) {
			entity.getPersistentData().putLong("FireAffinityTime", entity.level().getGameTime() + 20);
			event.setCanceled(true);
		}
	}

	@Override
	public double onHealTick(double heal, AbstractGolemEntity<?, ?> entity, int level) {
		if (entity.getPersistentData().getLong("FireAffinityTime") > entity.level().getGameTime()) {
			heal += level * JGConfig.COMMON.fireAffinityHeal.get();
		}
		return super.onHealTick(heal, entity, level);
	}

	@Override
	public void modifyDamage(AttackCache cache, AbstractGolemEntity<?, ?> entity, int level) {
		if (entity.getPersistentData().getLong("FireAffinityTime") > entity.level().getGameTime()) {
			float factor = 1 + level * JGConfig.COMMON.fireAffinityDamageBonus.get().floatValue();
			cache.addHurtModifier(DamageModifier.multTotal(factor));
		}
	}

	@Override
	public List<MutableComponent> getDetail(int v) {
		double heal = JGConfig.COMMON.fireAffinityHeal.get().floatValue() * v;
		int rate = Math.round(JGConfig.COMMON.fireAffinityDamageBonus.get().floatValue() * v * 100);
		return List.of(Component.translatable(this.getDescriptionId() + ".desc", heal, rate).withStyle(ChatFormatting.GREEN));
	}

}
