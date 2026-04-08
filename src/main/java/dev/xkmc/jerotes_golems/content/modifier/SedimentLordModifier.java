package dev.xkmc.jerotes_golems.content.modifier;

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
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.MobType;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import java.util.List;

public class SedimentLordModifier extends GolemModifier {

	public SedimentLordModifier(StatFilterType type, int maxLevel) {
		super(type, maxLevel);
	}

	@Override
	public void onAttacked(AbstractGolemEntity<?, ?> entity, LivingAttackEvent event, int level) {
		if (event.getSource().is(DamageTypes.WITHER))
			event.setCanceled(true);
	}

	@Override
	public void onDamaged(AttackCache cache, AbstractGolemEntity<?, ?> entity, int level) {
		var event = cache.getLivingDamageEvent();
		var attacker = cache.getAttacker();
		if (event == null || attacker == null) return;
		var source = event.getSource();
		if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || source.is(DamageTypeTags.BYPASSES_EFFECTS))
			return;
		if (attacker.getMobType() == MobType.UNDEAD) {
			cache.addDealtModifier(DamageModifier.multTotal((1 - JGConfig.COMMON.sedimentLordDamageReduction.get().floatValue())));
		}
	}


	@Override
	public List<MutableComponent> getDetail(int v) {
		int fac = (int) Math.round(100 * (1 - JGConfig.COMMON.sedimentLordDamageReduction.get()));
		return List.of(Component.translatable(this.getDescriptionId() + ".desc", fac).withStyle(ChatFormatting.GREEN));
	}

}
