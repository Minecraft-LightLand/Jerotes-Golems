package dev.xkmc.jerotes_golems.content.modifier;

import com.jerotes.jerotes.init.JerotesMobEffects;
import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;

public class PurpleSandModifier extends GolemModifier {

	public PurpleSandModifier(StatFilterType type, int maxLevel) {
		super(type, maxLevel);
	}

	@Override
	public void onDamaged(AttackCache cache, AbstractGolemEntity<?, ?> entity, int level) {
		var event = cache.getLivingDamageEvent();
		var attacker = cache.getAttacker();
		if (event == null || attacker == null) return;
		var source = event.getSource();
		if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || source.is(DamageTypeTags.BYPASSES_EFFECTS))
			return;
		if (source.is(L2DamageTypes.MAGIC)) {
			cache.addDealtModifier(DamageModifier.multTotal((1 - JGConfig.COMMON.purpleSandReduction.get().floatValue())));
			entity.addEffect(new MobEffectInstance(JerotesMobEffects.MAGIC_ABSORPTION.get(), 0, 1200), entity);
		}
	}

	@Override
	public List<MutableComponent> getDetail(int v) {
		int fac = (int) Math.round(100 * (1 - JGConfig.COMMON.purpleSandReduction.get()));
		return List.of(Component.translatable(this.getDescriptionId() + ".desc", fac).withStyle(ChatFormatting.GREEN));
	}

}
