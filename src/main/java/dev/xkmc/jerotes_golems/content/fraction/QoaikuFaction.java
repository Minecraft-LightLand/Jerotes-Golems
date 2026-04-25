package dev.xkmc.jerotes_golems.content.fraction;

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

public class QoaikuFaction extends DungeonFaction {

	private static final Lazy<ItemStack> BANNER = Lazy.of(() -> {
		ItemStack stack = new ItemStack(Items.LIGHT_BLUE_BANNER);
		CompoundTag tag = new CompoundTag();
		ListTag list = new BannerPattern.Builder()
				.addPattern(BannerPatterns.CURLY_BORDER, DyeColor.BLUE)
				.addPattern(BannerPatterns.STRIPE_SMALL, DyeColor.CYAN)
				.addPattern(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.WHITE)
				.addPattern(BannerPatterns.TRIANGLES_TOP, DyeColor.WHITE)
				.addPattern(BannerPatterns.STRIPE_CENTER, DyeColor.LIGHT_BLUE)
				.addPattern(BannerPatterns.FLOWER, DyeColor.BLUE)
				.addPattern(BannerPatterns.STRAIGHT_CROSS, DyeColor.LIGHT_BLUE)
				.toListTag();
		tag.put("Patterns", list);
		BlockItem.setBlockEntityData(stack, BlockEntityType.BANNER, tag);
		stack.hideTooltipPart(ItemStack.TooltipPart.ADDITIONAL);

		return stack;
	});

	public QoaikuFaction(ResourceLocation id) {
		super(id);
	}

	@Override
	public ItemStack getBanner(AbstractGolemEntity<?, ?> e, int col) {
		return BANNER.get();
	}

	@Override
	protected boolean isAlliedTo(Entity other) {
		return super.isAlliedTo(other) || OtherEntityFactionFind.isQoaiku(other.getType());
	}

}
