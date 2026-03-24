package dev.xkmc.jerotes_golems.content.client;

import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.client.armor.GolemModelPath;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import java.util.List;

import static dev.xkmc.modulargolems.content.client.armor.GolemEquipmentModels.buildGolemBaseLayers;

public class RefineMerorArmors {

	public static final ModelLayerLocation HELMET_LAYER = new ModelLayerLocation(JerotesGolems.loc("refine_meror_helmet"), "main");
	public static final ModelLayerLocation CHESTPLATE_LAYER = new ModelLayerLocation(JerotesGolems.loc("refine_meror_chestplate"), "main");
	public static final ModelLayerLocation SHINGUARD_LAYER = new ModelLayerLocation(JerotesGolems.loc("refine_meror_shinguard"), "main");

	static {
		GolemModelPath.register(JGModelPaths.REFINE_MEROR_HELMETS,
				new GolemModelPath(HELMET_LAYER, List.of(
						List.of("head", "head1")
				)));

		GolemModelPath.register(JGModelPaths.REFINE_MEROR_CHESTPLATES,
				new GolemModelPath(CHESTPLATE_LAYER, List.of(
						List.of("body", "body1"),
						List.of("right_arm", "body2"),
						List.of("left_arm", "body3")
				)));

		GolemModelPath.register(JGModelPaths.REFINE_MEROR_LEGGINGS,
				new GolemModelPath(SHINGUARD_LAYER, List.of(
						List.of("body", "legs1"),
						List.of("right_leg", "legs2"),
						List.of("left_leg", "legs3")
				)));
	}

	public static LayerDefinition createHelmet() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition head = mesh.getRoot().getChild("head");

		PartDefinition bone4 = head.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(40, 25).addBox(-4.5F, -43.5F, -8.0F, 9.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(-5.0F, -40.0F, -8.5F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 2.0F));

		PartDefinition head3_r1 = bone4.addOrReplaceChild("head3_r1", CubeListBuilder.create().texOffs(62, 0).addBox(-8.0F, -4.0F, 0.7F, 16.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -43.0F, -9.0F, 0.0436F, 0.0F, 0.0F));

		return LayerDefinition.create(mesh, 128, 128);
	}

	public static LayerDefinition createChestplate() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition body = mesh.getRoot().getChild("body");
		PartDefinition right_arm = mesh.getRoot().getChild("right_arm");
		PartDefinition left_arm = mesh.getRoot().getChild("left_arm");

		PartDefinition bone = body.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.5F, -33.1F, -6.5F, 19.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition bone2 = right_arm.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(76, 74).addBox(-15.5F, -26.0F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(60, 55).addBox(-13.5F, -17.0F, -3.5F, 5.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(76, 25).addBox(-14.0F, -16.0F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition body17_r1 = bone2.addOrReplaceChild("body17_r1", CubeListBuilder.create().texOffs(28, 79).addBox(0.0F, -4.0F, -4.5F, 2.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition body7_r1 = bone2.addOrReplaceChild("body7_r1", CubeListBuilder.create().texOffs(24, 63).addBox(1.0F, -4.0F, -4.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -27.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition body6_r1 = bone2.addOrReplaceChild("body6_r1", CubeListBuilder.create().texOffs(0, 42).addBox(0.0F, -2.0F, -4.5F, 6.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -32.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition bone3 = left_arm.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 80).addBox(8.5F, -26.0F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 61).addBox(8.5F, -17.0F, -3.5F, 5.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(62, 11).addBox(8.0F, -16.0F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition body18_r1 = bone3.addOrReplaceChild("body18_r1", CubeListBuilder.create().texOffs(50, 90).addBox(-2.0F, -4.0F, -4.5F, 2.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition body15_r1 = bone3.addOrReplaceChild("body15_r1", CubeListBuilder.create().texOffs(30, 44).addBox(-6.0F, -2.0F, -4.5F, 6.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -32.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition body11_r1 = bone3.addOrReplaceChild("body11_r1", CubeListBuilder.create().texOffs(50, 74).addBox(-4.0F, -7.7F, -1.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -24.0F, -3.0F, 0.0F, 0.0F, 0.3491F));

        return LayerDefinition.create(mesh, 128, 128);
	}

	public static LayerDefinition createLeggings() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition body = mesh.getRoot().getChild("body");
		PartDefinition right_leg = mesh.getRoot().getChild("right_leg");
		PartDefinition left_leg = mesh.getRoot().getChild("left_leg");

		PartDefinition bone7 = body.addOrReplaceChild("legs1", CubeListBuilder.create().texOffs(60, 44).addBox(-5.5F, -19.5F, -4.0F, 11.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition bone5 = right_leg.addOrReplaceChild("legs2", CubeListBuilder.create().texOffs(84, 55).addBox(-8.0F, -15.0F, -3.5F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 13.0F, 0.0F));

		PartDefinition bone6 = left_leg.addOrReplaceChild("legs3", CubeListBuilder.create().texOffs(76, 86).addBox(1.0F, -15.0F, -3.5F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 13.0F, 0.0F));

		return LayerDefinition.create(mesh, 128, 128);
	}

}