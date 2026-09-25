package dev.xkmc.jerotes_golems.mixin;

import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
	public void jerotesGolem$addEffect(MobEffectInstance ins, Entity source, CallbackInfoReturnable<Boolean> cir) {
		LivingEntity self = (LivingEntity) (Object) this;
		LivingEntity user = null;
		if (source instanceof TraceableEntity tr) source = tr.getOwner();
		if (source instanceof LivingEntity le) user = le;
		if (user instanceof AbstractGolemEntity<?, ?> golem && ins.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
			if (golem.isAlliedTo(self)) {
				cir.setReturnValue(false);
			}
		}
	}

}
