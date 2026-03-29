package dev.xkmc.jerotes_golems.mixin;

import com.jerotes.jerotes.util.EntityAndItemFind;
import dev.xkmc.jerotes_golems.init.reg.JGEffects;
import dev.xkmc.l2library.base.effects.ClientEffectCap;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityAndItemFind.class, remap = false)
public class EntityAndItemFindMixin {

	@Inject(method = "isLegendary", at = @At("HEAD"), cancellable = true)
	private static void jerotesgolesm$legendary(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		if (entity instanceof AbstractGolemEntity<?, ?> e) {
			if (e.hasEffect(JGEffects.LEGENDARY.get()) || e.level().isClientSide() &&
					ClientEffectCap.HOLDER.get(e).map.containsKey(JGEffects.LEGENDARY.get())) {
				cir.setReturnValue(true);
			}
		}
	}

}
