package dev.xkmc.jerotes_golems.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.xkmc.jerotes_golems.init.reg.JGEffects;
import dev.xkmc.modulargolems.content.item.ranged.MetalGolemBowItem;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = MetalGolemBowItem.class, remap = false)
public class GolemBowItemMixin {

	@ModifyReturnValue(method = "getPullTime", at = @At("RETURN"))
	private int jerotesGolem$netherite(int original, @Local(argsOnly = true) LivingEntity user) {
		if (user.hasEffect(JGEffects.NETHERITE_BOOST.get())) {
			return original / 2;
		}
		return original;
	}

}
