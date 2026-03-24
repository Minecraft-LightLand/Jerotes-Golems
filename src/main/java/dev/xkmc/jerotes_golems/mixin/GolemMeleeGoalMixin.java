package dev.xkmc.jerotes_golems.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.xkmc.jerotes_golems.init.reg.JGEffects;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.entity.goals.GolemMeleeGoal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = GolemMeleeGoal.class, remap = false)
public class GolemMeleeGoalMixin {

	@Shadow
	@Final
	private AbstractGolemEntity<?, ?> golem;

	@ModifyReturnValue(method = "getMeleeInterval", at = @At("RETURN"))
	public int jerotesgolems$fasterAttack(int original) {
		if (golem.hasEffect(JGEffects.NETHERITE_BOOST.get())) {
			return original / 2;
		}
		return original;
	}

}
