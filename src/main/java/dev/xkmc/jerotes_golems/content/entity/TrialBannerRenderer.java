package dev.xkmc.jerotes_golems.content.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class TrialBannerRenderer extends EntityRenderer<TrialBannerEntity> {

	private final TrialBannerModel model;

	public TrialBannerRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new TrialBannerModel(context.bakeLayer(TrialBannerModelData.LAYER_LOCATION));
	}

	@Override
	public void render(TrialBannerEntity e, float yr, float pt, PoseStack pose, MultiBufferSource buffer, int light) {
		pose.pushPose();
		pose.scale(-1.0F, -1.0F, 1.0F);
		pose.translate(0.0F, -1.501F, 0.0F);
		model.animate(e, pt);
		var vc = buffer.getBuffer(RenderType.entityCutoutNoCull(getTextureLocation(e)));
		model.renderToBuffer(pose, vc, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		pose.popPose();
		super.render(e, yr, pt, pose, buffer, light);
	}

	@Override
	public ResourceLocation getTextureLocation(TrialBannerEntity e) {
		return e.getTexture();
	}

}
