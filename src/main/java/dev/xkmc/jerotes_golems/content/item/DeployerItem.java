package dev.xkmc.jerotes_golems.content.item;

import dev.xkmc.jerotes_golems.content.entity.TrialBannerEntity;
import dev.xkmc.jerotes_golems.init.reg.JGEntities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DeployerItem extends Item {

	private final ResourceLocation id;

	public DeployerItem(Properties prop, ResourceLocation id) {
		super(prop);
		this.id = id;
	}

	@Override
	public InteractionResult useOn(UseOnContext use) {
		var level = use.getLevel();
		var e = new TrialBannerEntity(JGEntities.BANNER.get(), level);
		if (!e.setTrial(id)) return InteractionResult.FAIL;
		if (level.isClientSide) return InteractionResult.SUCCESS;
		var dim = e.getDimensions(Pose.STANDING);
		var pos = use.getClickLocation();
		e.setPos(pos);
		Vec3 center = pos.add(0, dim.height / 2, 0);
		VoxelShape box = Shapes.create(AABB.ofSize(center, 2, 2, 2));
		level.findFreePosition(e, box, center, dim.width, dim.height, dim.width)
				.ifPresent(x -> e.setPos(x.add(0, -dim.height / 2, 0)));
		level.addFreshEntity(e);
		var pl = use.getPlayer();
		if (pl != null && !pl.isCreative())
			use.getItemInHand().shrink(1);
		return InteractionResult.SUCCESS;
	}

}
