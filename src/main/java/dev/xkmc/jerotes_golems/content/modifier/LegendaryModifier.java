package dev.xkmc.jerotes_golems.content.modifier;

import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.jerotes_golems.init.reg.JGEffects;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.StringUtil;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class LegendaryModifier extends GolemModifier {

	public LegendaryModifier(StatFilterType type, int maxLevel) {
		super(type, maxLevel);
	}

	@Override
	public void onAiStep(AbstractGolemEntity<?, ?> golem, int level) {
		if (golem.tickCount % 20 == 0 && !golem.level().isClientSide() && golem.isHostile()) {
			if (HasItemUtil.hasItem(golem, JGItems.ULTIMATE_ENERGY_REGIME.get())) {
				golem.addEffect(new MobEffectInstance(JGEffects.LEGENDARY.get(), 600, 0, false, false), golem);
			}
		}
	}

	@Override
	public InteractionResult interact(Player player, AbstractGolemEntity<?, ?> golem, InteractionHand hand, int level) {
		ItemStack stack = player.getItemInHand(hand);
		if (stack.is(JGItems.ULTIMATE_ENERGY_REGIME.get())) {
			if (player.level().isClientSide()) return InteractionResult.SUCCESS;
			var ins = golem.getEffect(JGEffects.LEGENDARY.get());
			int remain = ins == null ? 0 : ins.getDuration();
			int dur = JGConfig.COMMON.legendaryChargeDuration.get() << (level - 1);
			if (remain >= dur) return InteractionResult.PASS;
			golem.addEffect(new MobEffectInstance(JGEffects.LEGENDARY.get(), remain + dur, 0, false, false), player);
			if (!player.isCreative()) stack.shrink(1);
		}
		return super.interact(player, golem, hand, level);
	}

	@Override
	public List<MutableComponent> getDetail(int v) {
		int dur = JGConfig.COMMON.legendaryChargeDuration.get() << (v - 1);
		return List.of(Component.translatable(this.getDescriptionId() + ".desc",
				JGItems.ULTIMATE_ENERGY_REGIME.get().getDescription(),
				StringUtil.formatTickDuration(dur)
		).withStyle(ChatFormatting.GREEN));
	}

}
