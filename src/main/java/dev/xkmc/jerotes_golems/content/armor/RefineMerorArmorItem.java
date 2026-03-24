package dev.xkmc.jerotes_golems.content.armor;

import com.google.common.collect.ImmutableMultimap;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.l2damagetracker.init.L2DamageTracker;
import dev.xkmc.modulargolems.compat.materials.twilightforest.TFDispatch;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.item.equipments.IGolemModifierItem;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemArmorItem;
import dev.xkmc.modulargolems.content.modifier.base.ModifierInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class RefineMerorArmorItem extends MetalGolemArmorItem implements IGolemModifierItem {

	public RefineMerorArmorItem(Properties properties, ArmorItem.Type type, int defense, float toughness, ResourceLocation model) {
		super(properties, type, defense, toughness, model);
	}

	@Override
	public List<ModifierInstance> getModifier(ItemStack stack, @Nullable AbstractGolemEntity<?, ?> golem) {
		return List.of(new ModifierInstance(JGModifiers.MEROR_DEF.get(), 1));
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		appendModifierText(stack, list);
	}

	@Override
	protected void addExtraModifiers(ImmutableMultimap.Builder<Attribute, AttributeModifier> builder) {
		super.addExtraModifiers(builder);
		UUID uuid = UUID.get(getSlot());

		builder.put(L2DamageTracker.REDUCTION.get(), new AttributeModifier(uuid,
				"Refine Meror Armor", -0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));

	}

	@Override
	public ResourceLocation getModelTexture(LivingEntity user) {
		return JerotesGolems.loc("textures/equipments/refine_meror.png");
	}

}
