package dev.xkmc.jerotes_golems.mixin;

import com.jerotes.jerotes.item.Interface.ItemSpecialAttack;
import com.jerotes.jerotes.item.Tool.ItemToolBasePike;
import dev.xkmc.modulargolems.content.entity.common.SweepGolemEntity;
import dev.xkmc.modulargolems.content.entity.humanoid.HumanoidGolemEntity;
import dev.xkmc.modulargolems.content.entity.humanoid.weapon.GolemWeaponRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HumanoidGolemEntity.class)
public abstract class HumanoidGolemEntityMixin extends SweepGolemEntity {

	protected HumanoidGolemEntityMixin(GolemWeaponRegistry reg, EntityType type, Level level) {
		super(reg, type, level);
	}

	@Inject(method = "doHurtTarget", at = @At("HEAD"), cancellable = true)
	public void jerotesgolem$doHurtTarget(Entity target, CallbackInfoReturnable<Boolean> cir) {
		if (getMainHandItem().getItem() instanceof ItemSpecialAttack item) {
			if (item instanceof ItemToolBasePike) {
				return;
			}
			item.jerotesSpecialAttack(this, EquipmentSlot.MAINHAND);
			cir.setReturnValue(true);
		}
	}

}
