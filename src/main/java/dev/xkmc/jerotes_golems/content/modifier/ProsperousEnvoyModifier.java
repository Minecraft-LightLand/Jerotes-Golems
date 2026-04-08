package dev.xkmc.jerotes_golems.content.modifier;

import com.jerotes.jerotes.init.JerotesMobEffects;
import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;

public class ProsperousEnvoyModifier extends GolemModifier {

	public ProsperousEnvoyModifier(StatFilterType type, int maxLevel) {
		super(type, maxLevel);
	}

	@Override
	public void finalizeHurtTarget(AttackCache cache, AbstractGolemEntity<?, ?> golem, int value) {
		int perLevel = value * 20 * JGConfig.COMMON.prosperousEnvoyDuration.get();
		int time = (int) Mth.clamp(cache.getPreDamage() * perLevel, perLevel, 1e9);
		var target = cache.getAttackTarget();
		var ins = target.getEffect(JerotesMobEffects.ANESTHETIZED.get());
		if (ins != null) {
			time += ins.getDuration();
		}
		target.addEffect(new MobEffectInstance(JerotesMobEffects.ANESTHETIZED.get(), time, 0, false, false), golem);
	}


	@Override
	public List<MutableComponent> getDetail(int v) {
		int fac = JGConfig.COMMON.prosperousEnvoyDuration.get() * v;
		return List.of(Component.translatable(this.getDescriptionId() + ".desc", fac).withStyle(ChatFormatting.GREEN));
	}

}
