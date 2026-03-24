package dev.xkmc.jerotes_golems.content.armor;

import com.google.common.collect.ImmutableMultimap;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.item.equipments.IGolemModifierItem;
import dev.xkmc.modulargolems.content.item.equipments.MetalGolemArmorItem;
import dev.xkmc.modulargolems.content.modifier.base.ModifierInstance;
import dev.xkmc.modulargolems.init.registrate.GolemModifiers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class WonderlandArmorItem extends MetalGolemArmorItem implements IGolemModifierItem {

	public WonderlandArmorItem(Properties properties, ArmorItem.Type type, int defense, float toughness, ResourceLocation model) {
		super(properties, type, defense, toughness, model);
	}

	@Override
	public List<ModifierInstance> getModifier(ItemStack stack, @Nullable AbstractGolemEntity<?, ?> golem) {
		var ins = switch (getSlot()) {
			case HEAD -> new ModifierInstance(JGModifiers.ABACK.get(), 1);
			case LEGS -> new ModifierInstance(GolemModifiers.WEAK.get(), 2);
			default -> null;
		};
		return ins == null ? List.of() : List.of(ins);
	}

	@Override
	protected void addExtraModifiers(ImmutableMultimap.Builder<Attribute, AttributeModifier> builder) {
		super.addExtraModifiers(builder);
		UUID uuid = UUID.get(getSlot());
		if (getSlot() == EquipmentSlot.CHEST) {
			builder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(uuid,
					"Wonderland Chestplate", 1, AttributeModifier.Operation.ADDITION));
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		appendModifierText(stack, list);
	}

	@Override
	public ResourceLocation getModelTexture(LivingEntity user) {
		return JerotesGolems.loc("textures/equipments/wonderland.png");
	}

}
