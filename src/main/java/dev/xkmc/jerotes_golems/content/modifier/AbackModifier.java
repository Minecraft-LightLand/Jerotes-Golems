package dev.xkmc.jerotes_golems.content.modifier;

import com.jerotes.jerotes.init.JerotesMobEffects;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.world.effect.MobEffectInstance;

public class AbackModifier extends GolemModifier {

	public AbackModifier(StatFilterType type, int maxLevel) {
		super(type, maxLevel);
	}

	@Override
	public void onAiStep(AbstractGolemEntity<?, ?> golem, int level) {
		if (golem.tickCount % 5 == 0) {
			var target = golem.getTarget();
			if (target == null) return;
			target.addEffect(new MobEffectInstance(JerotesMobEffects.ABACK.get(), 60, 0), golem);
		}
	}

}
