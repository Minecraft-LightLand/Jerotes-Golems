package dev.xkmc.jerotes_golems.content.fraction;

import com.jerotes.jerotes.util.EntityFactionFind;
import com.jerotes.jerotesvillage.init.JerotesVillageTabs;
import dev.xkmc.golemdungeons.content.faction.DungeonFaction;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.Lazy;

public class CarvedFaction extends DungeonFaction {

	private static final Lazy<ItemStack> BANNER = Lazy.of(JerotesVillageTabs::CarvedBanner);

	public CarvedFaction(ResourceLocation id) {
		super(id);
	}

	@Override
	public ItemStack getBanner(AbstractGolemEntity<?, ?> e, int col) {
		return BANNER.get();
	}

	@Override
	public boolean hostileGolemAttacks(LivingEntity e) {
		if (super.hostileGolemAttacks(e)) return true;
		return e.getType().is(EntityTypeTags.RAIDERS) || e.getMobType() == MobType.ILLAGER || EntityFactionFind.isRaider(e);
	}

	@Override
	protected boolean isAlliedTo(Entity other) {
		return super.isAlliedTo(other) || EntityFactionFind.isCarved(other.getType());
	}

}
