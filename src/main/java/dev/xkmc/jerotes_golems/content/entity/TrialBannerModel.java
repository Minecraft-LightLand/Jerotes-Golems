package dev.xkmc.jerotes_golems.content.entity;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;

public class TrialBannerModel extends HierarchicalModel<TrialBannerEntity> {

	private final ModelPart root;

	protected TrialBannerModel(ModelPart root) {
		this.root = root;
	}

	@Override
	public ModelPart root() {
		return root;
	}

	@Override
	public void setupAnim(TrialBannerEntity e, float v, float v1, float v2, float v3, float v4) {
	}

	public void animate(TrialBannerEntity e, float pt) {
		root().getAllParts().forEach(ModelPart::resetPose);
		e.idle.startIfStopped(e.tickCount);
		if (e.deathTick > 0) {
			e.death.startIfStopped(e.tickCount);
			animate(e.death, TrialBannerModelData.DEATH, e.tickCount + pt);
		} else {
			animate(e.idle, TrialBannerModelData.IDLE, e.tickCount + pt);
		}
	}
}
