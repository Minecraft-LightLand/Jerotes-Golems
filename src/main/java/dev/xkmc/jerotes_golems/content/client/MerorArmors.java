package dev.xkmc.jerotes_golems.content.client;

import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.client.armor.GolemModelPath;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import java.util.List;

import static dev.xkmc.modulargolems.content.client.armor.GolemEquipmentModels.buildGolemBaseLayers;

public class MerorArmors {

	public static final ModelLayerLocation HELMET_LAYER = new ModelLayerLocation(JerotesGolems.loc("meror_helmet"), "main");
	public static final ModelLayerLocation CHESTPLATE_LAYER = new ModelLayerLocation(JerotesGolems.loc("meror_chestplate"), "main");
	public static final ModelLayerLocation SHINGUARD_LAYER = new ModelLayerLocation(JerotesGolems.loc("meror_shinguard"), "main");

	static {
		GolemModelPath.register(JGModelPaths.MEROR_HELMETS,
				new GolemModelPath(HELMET_LAYER, List.of(
						List.of("head", "head1")
				)));

		GolemModelPath.register(JGModelPaths.MEROR_CHESTPLATES,
				new GolemModelPath(CHESTPLATE_LAYER, List.of(
						List.of("body", "body1"),
						List.of("right_arm", "body2"),
						List.of("left_arm", "body3")
				)));

		GolemModelPath.register(JGModelPaths.MEROR_LEGGINGS,
				new GolemModelPath(SHINGUARD_LAYER, List.of(
						List.of("body", "legs1"),
						List.of("right_leg", "legs2"),
						List.of("left_leg", "legs3")
				)));
	}

	public static LayerDefinition createHelmet() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition head = mesh.getRoot().getChild("head");

		PartDefinition head1 = head.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 25).addBox(-4.5F, -43.2F, -8.0F, 9.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 44).addBox(-5.0F, -39.0F, -7.5F, 10.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 71).addBox(-1.0F, -44.5F, -8.7F, 2.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(62, 0).addBox(-3.0F, -43.5F, -8.5F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(64, 81).addBox(-4.5F, -39.0F, -9.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(64, 83).addBox(-4.5F, -37.0F, -9.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(30, 71).addBox(3.5F, -38.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(34, 71).addBox(-4.5F, -38.0F, -9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 2.0F));

		PartDefinition bone_r1 = head1.addOrReplaceChild("bone_r1", CubeListBuilder.create().texOffs(24, 71).addBox(-2.1F, -2.0F, 8.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.0F, -17.0F, 0.0F, 0.0F, 0.829F));

		return LayerDefinition.create(mesh, 128, 128);
	}

	public static LayerDefinition createChestplate() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition body = mesh.getRoot().getChild("body");
		PartDefinition right_arm = mesh.getRoot().getChild("right_arm");
		PartDefinition left_arm = mesh.getRoot().getChild("left_arm");

		PartDefinition body1 = body.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.5F, -33.5F, -6.5F, 19.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition body2 = right_arm.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(62, 12).addBox(-14.0F, -26.0F, -4.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(38, 63).addBox(-13.5F, -18.0F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition bone3_r1 = body2.addOrReplaceChild("bone3_r1", CubeListBuilder.create().texOffs(24, 81).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -17.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition bone3_r2 = body2.addOrReplaceChild("bone3_r2", CubeListBuilder.create().texOffs(38, 44).addBox(-4.0F, -8.0F, -5.0F, 7.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -26.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition body3 = left_arm.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(62, 63).addBox(8.5F, -18.0F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(70, 25).addBox(9.0F, -26.0F, -4.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition bone4_r1 = body3.addOrReplaceChild("bone4_r1", CubeListBuilder.create().texOffs(44, 81).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -17.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition bone4_r2 = body3.addOrReplaceChild("bone4_r2", CubeListBuilder.create().texOffs(36, 25).addBox(-3.0F, -8.0F, -5.0F, 7.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -26.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        return LayerDefinition.create(mesh, 128, 128);
	}

	public static LayerDefinition createLeggings() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition body = mesh.getRoot().getChild("body");
		PartDefinition right_leg = mesh.getRoot().getChild("right_leg");
		PartDefinition left_leg = mesh.getRoot().getChild("left_leg");

		PartDefinition legs1 = body.addOrReplaceChild("legs1", CubeListBuilder.create().texOffs(0, 59).addBox(-23.5F, 0.0F, 9.0F, 11.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, 11.0F, -13.0F));

		PartDefinition legs2 = right_leg.addOrReplaceChild("legs2", CubeListBuilder.create().texOffs(72, 38).addBox(-4.0F, -2.0F, -3.5F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs3 = left_leg.addOrReplaceChild("legs3", CubeListBuilder.create().texOffs(72, 50).addBox(1.0F, -15.0F, -3.5F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 13.0F, 0.0F));

		return LayerDefinition.create(mesh, 128, 128);
	}

}