package dev.xkmc.jerotes_golems.content.modifier;

import com.jerotes.jerotesvillage.spell.OtherSpellType;
import dev.xkmc.modulargolems.compat.materials.goety.multi.MultiTargetRangedGoal;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.function.BiConsumer;

public class MultiTargetSpellModifier extends GolemModifier {

	private final OtherSpellType spell;
	private final int level, range;

	public MultiTargetSpellModifier(StatFilterType type, int maxLevel, int range, int level, OtherSpellType spell) {
		super(type, maxLevel);
		this.range = range;
		this.spell = spell;
		this.level = level;
	}

	@Override
	public void onRegisterGoals(AbstractGolemEntity<?, ?> entity, int lv, BiConsumer<Integer, Goal> addGoal) {
		addGoal.accept(2, new SpellAttackGoal(entity, lv));
	}

	public class SpellAttackGoal extends MultiTargetRangedGoal {

		public SpellAttackGoal(AbstractGolemEntity<?, ?> golem, int lv) {
			super(100, 0, range, golem, lv);
		}

		@Override
		protected int searchRange() {
			return range;
		}

		@Override
		protected int getMaxTarget() {
			return lv;
		}

		@Override
		protected int cd() {
			return 10;
		}

		@Override
		protected void performAttackImpl(LivingEntity le) {
			spell.magicSpellGet(level, golem, le).spellUse();
		}

	}

}
