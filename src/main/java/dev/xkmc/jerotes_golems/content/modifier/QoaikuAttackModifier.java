package dev.xkmc.jerotes_golems.content.modifier;

import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import java.util.List;

public class QoaikuAttackModifier extends GolemModifier {

	private static int looping = 0;

	public QoaikuAttackModifier(int maxLevel) {
		super(StatFilterType.ATTACK, maxLevel);
	}

	@Override
	public void onAttackTarget(AbstractGolemEntity<?, ?> entity, LivingAttackEvent event, int level) {
		if (looping > 0) return;
		if (event.getSource().is(L2DamageTypes.DIRECT)) {
			GeneralEventHandler.schedule(() -> {
				var type = entity.level().registryAccess()
						.lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(DamageTypes.DROWN);
				var source = new DamageSource(type, entity);
				looping++;
				if (!event.getEntity().hurt(source, event.getAmount())) {
					event.getEntity().hurt(event.getSource(), event.getAmount());
				}
				looping--;
			});
			event.setCanceled(true);
		}
	}

	@Override
	public void modifyDamage(AttackCache cache, AbstractGolemEntity<?, ?> entity, int level) {
		if (cache.getAttackTarget().isSensitiveToWater()) {
			float factor = 1 + level * JGConfig.COMMON.qoaikuAttackDamageBonus.get().floatValue();
			cache.addHurtModifier(DamageModifier.multTotal(factor));
		}
	}

	@Override
	public List<MutableComponent> getDetail(int v) {
		int rate = Math.round(JGConfig.COMMON.qoaikuAttackDamageBonus.get().floatValue() * v * 100);
		return List.of(Component.translatable(this.getDescriptionId() + ".desc", rate).withStyle(ChatFormatting.GREEN));
	}

}
