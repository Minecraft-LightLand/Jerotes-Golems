package dev.xkmc.jerotes_golems.content.modifier;

import com.jerotes.jerotes.forge.JerotesMerorDamageEvent;
import dev.xkmc.jerotes_golems.init.data.JGConfig;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.DamageModifier;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;

public class MerorDefenseModifier extends GolemModifier {

	public MerorDefenseModifier(int maxLevel) {
		super(StatFilterType.HEALTH, maxLevel);
	}

	@Override
	public void onDamaged(AttackCache cache, AbstractGolemEntity<?, ?> entity, int level) {
		var event = cache.getLivingHurtEvent();
		assert event != null;
		var source = event.getSource();
		if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) return;
		var pred = new JerotesMerorDamageEvent(source);
		MinecraftForge.EVENT_BUS.post(pred);
		if (!pred.isMerorDamage()) {
			double fac = Math.pow(1 - JGConfig.COMMON.merorDefenseDamageReduction.get(), level);
			cache.addDealtModifier(DamageModifier.multTotal((float) fac));
		}
	}

	@Override
	public List<MutableComponent> getDetail(int v) {
		int fac = Math.round(100 * (1 - (float) Math.pow(1 - JGConfig.COMMON.merorDefenseDamageReduction.get(), v)));
		return List.of(Component.translatable(this.getDescriptionId() + ".desc", fac).withStyle(ChatFormatting.GREEN));
	}

}
