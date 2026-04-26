package dev.xkmc.jerotes_golems.content.modifier;

import com.jerotes.jerotesvillage.spell.OtherSpellType;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import dev.xkmc.modulargolems.content.modifier.special.BaseRangedAttackGoal;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.function.BiConsumer;

public class SpellModifier extends GolemModifier {

	private final OtherSpellType spell;
	private final Int2IntFunction levelMap;
	private final int range;

	public SpellModifier(StatFilterType type, int maxLevel, int range, OtherSpellType spell, Int2IntFunction levelMap) {
		super(type, maxLevel);
		this.range = range;
		this.spell = spell;
		this.levelMap = levelMap;
	}

	@Override
	public void onRegisterGoals(AbstractGolemEntity<?, ?> entity, int lv, BiConsumer<Integer, Goal> addGoal) {
		addGoal.accept(2, new SpellAttackGoal(entity, lv));
	}

	public class SpellAttackGoal extends BaseRangedAttackGoal {

		public SpellAttackGoal(AbstractGolemEntity<?, ?> golem, int lv) {
			super(100, 0, range, golem, lv);
		}

		@Override
		protected boolean performAttack(LivingEntity le) {
			return spell.magicSpellGet(levelMap.get(lv), golem, le).spellUse();
		}

	}

}
