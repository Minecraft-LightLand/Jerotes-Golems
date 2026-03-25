package dev.xkmc.jerotes_golems.content.weapon;

import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.jerotes_golems.init.data.JGDamageTypes;
import dev.xkmc.jerotes_golems.init.data.JGLang;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import dev.xkmc.modulargolems.content.item.equipments.ExtraAttackGolemWeapon;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemWeaponItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class SerponChainBlade extends MetalGolemWeaponItem implements ExtraAttackGolemWeapon {

	public SerponChainBlade(Properties properties, int attackDamage, double percentAttack, float range, float sweep) {
		super(properties, attackDamage, percentAttack, range, sweep);
	}

	@Override
	public boolean repeatAttack(MetalGolemEntity e, Entity target, float dmg, boolean prev) {
		if (e.level() instanceof ServerLevel sl) {
			long time = sl.getGameTime();
			float damage = dmg * JGConfig.COMMON.serponChainBladeDamageFactor.get().floatValue();
			GeneralEventHandler.schedulePersistent(() -> {
				if (!e.isAlive()) return true;
				long diff = sl.getGameTime() - time;
				if (diff > 0 && diff % 3 == 0) {
					var source = e.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
							.getHolderOrThrow(JGDamageTypes.FIRE);
					target.hurt(new DamageSource(source, e), damage);
					return diff >= 9;
				}
				return false;
			});
		}
		return true;
	}

	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		int rate = Math.round(JGConfig.COMMON.serponChainBladeDamageFactor.get().floatValue() * 100);
		list.add(JGLang.SERPON_CHAIN_BLADE_DESC.get(rate).withStyle(ChatFormatting.GRAY));
		super.appendHoverText(itemStack, level, list, tooltipFlag);
	}

}
