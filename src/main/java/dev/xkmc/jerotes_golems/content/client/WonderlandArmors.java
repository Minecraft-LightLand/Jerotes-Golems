package dev.xkmc.jerotes_golems.content.client;

import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.client.armor.GolemModelPath;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import java.util.List;

import static dev.xkmc.modulargolems.content.client.armor.GolemEquipmentModels.buildGolemBaseLayers;

public class WonderlandArmors {

	public static final ModelLayerLocation HELMET_LAYER = new ModelLayerLocation(JerotesGolems.loc("wonderland_helmet"), "main");
	public static final ModelLayerLocation CHESTPLATE_LAYER = new ModelLayerLocation(JerotesGolems.loc("wonderland_chestplate"), "main");
	public static final ModelLayerLocation SHINGUARD_LAYER = new ModelLayerLocation(JerotesGolems.loc("wonderland_shinguard"), "main");

	static {
		GolemModelPath.register(JGModelPaths.WONDERLAND_HELMETS,
				new GolemModelPath(HELMET_LAYER, List.of(
						List.of("head", "head1")
				)));

		GolemModelPath.register(JGModelPaths.WONDERLAND_CHESTPLATES,
				new GolemModelPath(CHESTPLATE_LAYER, List.of(
						List.of("body", "body1"),
						List.of("right_arm", "body2"),
						List.of("left_arm", "body3")
				)));

		GolemModelPath.register(JGModelPaths.WONDERLAND_LEGGINGS,
				new GolemModelPath(SHINGUARD_LAYER, List.of(
						List.of("body", "legs1"),
						List.of("right_leg", "legs2"),
						List.of("left_leg", "legs3")
				)));
	}

	public static LayerDefinition createHelmet() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition head = mesh.getRoot().getChild("head");

        PartDefinition bone4 = head.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 57).addBox(-4.5F, -43.5F, -8.0F, 9.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(52, 76).addBox(-1.0F, -46.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(68, 19).addBox(0.0F, -51.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(94, 50).addBox(-2.0F, -51.0F, -4.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 2.0F));

        PartDefinition head3_r1 = bone4.addOrReplaceChild("head3_r1", CubeListBuilder.create().texOffs(22, 98).addBox(-5.0F, -5.0F, -1.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -41.0F, -4.0F, 0.0F, 1.0036F, 0.0F));

        PartDefinition head2_r1 = bone4.addOrReplaceChild("head2_r1", CubeListBuilder.create().texOffs(10, 98).addBox(-1.0F, -6.0F, -1.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -40.0F, -4.0F, 0.0F, -1.0036F, 0.0F));

		return LayerDefinition.create(mesh, 128, 128);
	}

	public static LayerDefinition createChestplate() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition body = mesh.getRoot().getChild("body");
		PartDefinition right_arm = mesh.getRoot().getChild("right_arm");
		PartDefinition left_arm = mesh.getRoot().getChild("left_arm");

        PartDefinition bone = body.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.5F, -33.1F, -6.5F, 19.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

        PartDefinition body5_r1 = bone.addOrReplaceChild("body5_r1", CubeListBuilder.create().texOffs(34, 25).addBox(-1.0F, -7.0F, -6.0F, 0.0F, 15.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -41.0F, 15.0F, -0.2427F, -0.0992F, -0.3806F));

        PartDefinition body4_r1 = bone.addOrReplaceChild("body4_r1", CubeListBuilder.create().texOffs(0, 25).addBox(1.0F, -7.0F, -6.0F, 0.0F, 15.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -41.0F, 15.0F, -0.2427F, 0.0992F, 0.3806F));

        PartDefinition body3_r1 = bone.addOrReplaceChild("body3_r1", CubeListBuilder.create().texOffs(94, 25).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -42.0F, 8.0F, -0.2427F, -0.0992F, -0.3806F));

        PartDefinition body2_r1 = bone.addOrReplaceChild("body2_r1", CubeListBuilder.create().texOffs(92, 0).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -42.0F, 8.0F, -0.2427F, 0.0992F, 0.3806F));


        PartDefinition bone2 = right_arm.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 89).addBox(-13.5F, -23.0F, -3.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(52, 84).addBox(-13.5F, -16.0F, -3.5F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(92, 68).addBox(-18.0F, -21.0F, 0.0F, 5.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

        PartDefinition body7_r1 = bone2.addOrReplaceChild("body7_r1", CubeListBuilder.create().texOffs(68, 39).addBox(1.0F, -4.0F, -4.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -27.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition body6_r1 = bone2.addOrReplaceChild("body6_r1", CubeListBuilder.create().texOffs(36, 57).addBox(0.0F, -2.0F, -4.5F, 6.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -33.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition bone3 = left_arm.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(24, 89).addBox(8.5F, -23.0F, -3.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(76, 84).addBox(8.5F, -16.0F, -3.5F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 98).addBox(13.0F, -21.0F, 0.0F, 5.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

        PartDefinition body15_r1 = bone3.addOrReplaceChild("body15_r1", CubeListBuilder.create().texOffs(62, 0).addBox(-6.0F, -2.0F, -4.5F, 6.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -33.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition body11_r1 = bone3.addOrReplaceChild("body11_r1", CubeListBuilder.create().texOffs(66, 68).addBox(-4.0F, -6.7F, -1.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -25.0F, -3.0F, 0.0F, 0.0F, 0.3491F));

        return LayerDefinition.create(mesh, 128, 128);
	}

	public static LayerDefinition createLeggings() {
		MeshDefinition mesh = buildGolemBaseLayers();
		PartDefinition body = mesh.getRoot().getChild("body");
		PartDefinition right_leg = mesh.getRoot().getChild("right_leg");
		PartDefinition left_leg = mesh.getRoot().getChild("left_leg");

        PartDefinition bone7 = body.addOrReplaceChild("legs1", CubeListBuilder.create().texOffs(66, 57).addBox(-5.5F, -19.5F, -4.0F, 11.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 0.0F));

        PartDefinition bone5 = right_leg.addOrReplaceChild("legs2", CubeListBuilder.create().texOffs(0, 76).addBox(-8.0F, -15.0F, -3.5F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 13.0F, 0.0F));

        PartDefinition bone6 = left_leg.addOrReplaceChild("legs3", CubeListBuilder.create().texOffs(26, 76).addBox(1.0F, -15.0F, -3.5F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 13.0F, 0.0F));

		return LayerDefinition.create(mesh, 128, 128);
	}

}