package dev.xkmc.jerotes_golems.content.fraction;

import com.jerotes.jerotes.util.EntityFactionFind;
import com.jerotes.jerotesvillage.util.OtherEntityFactionFind;
import dev.xkmc.golemdungeons.content.faction.DungeonFaction;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatterns;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.util.Lazy;

public class MerorFaction extends DungeonFaction {

	private static final Lazy<ItemStack> BANNER = Lazy.of(() -> {
		ItemStack stack = new ItemStack(Items.PINK_BANNER);
		CompoundTag tag = new CompoundTag();
		ListTag list = new BannerPattern.Builder()
				.addPattern(BannerPatterns.RHOMBUS_MIDDLE, DyeColor.GREEN)
				.addPattern(BannerPatterns.STRIPE_BOTTOM, DyeColor.RED)
				.addPattern(BannerPatterns.HALF_HORIZONTAL, DyeColor.BROWN)
				.addPattern(BannerPatterns.STRAIGHT_CROSS, DyeColor.PINK)
				.addPattern(BannerPatterns.STRIPE_CENTER, DyeColor.BROWN)
				.addPattern(BannerPatterns.BORDER, DyeColor.WHITE)
				.addPattern(BannerPatterns.STRIPE_MIDDLE, DyeColor.BLACK)
				.addPattern(BannerPatterns.HALF_HORIZONTAL, DyeColor.RED)
				.addPattern(BannerPatterns.BORDER, DyeColor.WHITE)
				.addPattern(BannerPatterns.TRIANGLES_TOP, DyeColor.PINK)
				.toListTag();
		tag.put("Patterns", list);
		BlockItem.setBlockEntityData(stack, BlockEntityType.BANNER, tag);
		stack.hideTooltipPart(ItemStack.TooltipPart.ADDITIONAL);
		return stack;
	});

	public MerorFaction(ResourceLocation id) {
		super(id);
	}

	@Override
	public ItemStack getBanner(AbstractGolemEntity<?, ?> e, int col) {
		return BANNER.get();
	}

	@Override
	protected boolean isAlliedTo(Entity other) {
		return super.isAlliedTo(other) || OtherEntityFactionFind.isMeror(other.getType());
	}

}
