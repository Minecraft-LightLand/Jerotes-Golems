package dev.xkmc.jerotes_golems.content.fraction;

import com.jerotes.jerotesvillage.init.JerotesVillageTabs;
import dev.xkmc.golemdungeons.content.faction.DungeonFaction;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BannerPatterns;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.util.Lazy;

public class SerponFaction extends DungeonFaction {


	private static final Lazy<ItemStack> BANNER = Lazy.of(JerotesVillageTabs::SerponCombatTeamBanner);

	public SerponFaction(ResourceLocation id) {
		super(id);
	}

	@Override
	public ItemStack getBanner(AbstractGolemEntity<?, ?> e, int col) {
		return BANNER.get();
	}

}
