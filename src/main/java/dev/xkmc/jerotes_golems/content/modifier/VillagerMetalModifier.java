package dev.xkmc.jerotes_golems.content.modifier;

import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.jerotes_golems.init.reg.JGEffects;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class VillagerMetalModifier extends GolemModifier {

	public VillagerMetalModifier(StatFilterType type, int maxLevel) {
		super(type, maxLevel);
	}

	@Override
	public InteractionResult interact(Player player, AbstractGolemEntity<?, ?> golem, InteractionHand hand, int level) {
		ItemStack stack = player.getItemInHand(hand);
		int time = JGConfig.COMMON.villagerBonusDuration.get() * level;
		if (stack.is(Items.EMERALD_BLOCK)) {
			golem.repairWithItem();
			golem.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, time, 1));
			golem.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, time, 0));
			golem.addEffect(new MobEffectInstance(MobEffects.REGENERATION, time / 4, 1));
			if (!player.isCreative()) stack.shrink(1);
			return InteractionResult.SUCCESS;
		} else if (stack.is(Items.NETHERITE_BLOCK)) {
			golem.repairWithItem();
			golem.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, time, 4));
			golem.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, time, 2));
			golem.addEffect(new MobEffectInstance(MobEffects.REGENERATION, time, 1));
			golem.addEffect(new MobEffectInstance(JGEffects.NETHERITE_BOOST.get(), time, 0));
			int[] states = new int[]{0, golem.tickCount + 10};
			GeneralEventHandler.schedulePersistent(() -> {
				if (golem.isRemoved() || !golem.isAlive())
					return true;
				if (golem.tickCount >= states[1]) {
					states[1] = golem.tickCount + 10;
					states[0]++;
					golem.repairWithItem();
				}
				return states[0] >= 3;
			});
			if (!player.isCreative()) stack.shrink(1);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
