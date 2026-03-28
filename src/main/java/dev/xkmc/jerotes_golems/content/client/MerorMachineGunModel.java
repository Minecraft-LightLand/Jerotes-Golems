package dev.xkmc.jerotes_golems.content.client;

import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.client.armor.GolemEquipmentModels;
import dev.xkmc.modulargolems.content.client.armor.GolemModelPath;
import dev.xkmc.modulargolems.content.client.armor.GolemModelPaths;
import dev.xkmc.modulargolems.content.client.pose.BeaconConnonPose;
import dev.xkmc.modulargolems.content.client.pose.GolemShoulderPose;
import dev.xkmc.modulargolems.content.client.weapon.GolemModelAnimations;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import java.util.List;

public class MerorMachineGunModel {

	public static final ModelLayerLocation FLAME_RIGHT = new ModelLayerLocation(JerotesGolems.loc("meror_machine_gun"), "right");
	public static final ModelLayerLocation FLAME_LEFT = new ModelLayerLocation(JerotesGolems.loc("meror_machine_gun"), "left");

	public static final AnimationDefinition ANIM;

	static {
		ANIM = AnimationDefinition.Builder.withLength(0.1667F).looping()
				.addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 90.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
				))
				.addAnimation("bone2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
						new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
						new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, -90.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
				))
				.build();
	}

	static {
		GolemModelPath.register(JGModelPaths.GUN_RIGHT,
				new GolemModelPath(FLAME_RIGHT, List.of(List.of("body", "flamethrower"))));

		GolemModelPath.register(JGModelPaths.GUN_LEFT,
				new GolemModelPath(FLAME_LEFT, List.of(List.of("body", "flamethrower2"))));

		GolemModelAnimations.register(JGModelPaths.GUN_RIGHT, ANIM);
		GolemModelAnimations.register(JGModelPaths.GUN_LEFT, ANIM);

		GolemShoulderPose.register(JGModelPaths.GUN_RIGHT, new BeaconConnonPose("flamethrower", -1, 0, 0));
		GolemShoulderPose.register(JGModelPaths.GUN_LEFT, new BeaconConnonPose("flamethrower2", 1, 0, 0));

	}


	public static LayerDefinition leftLayer() {
		MeshDefinition meshdefinition = GolemEquipmentModels.buildGolemBaseLayers();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.getChild("body");

		PartDefinition Gatling2 = body.addOrReplaceChild("flamethrower2", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0002F, -4.9954F, 2.053F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(24, 19).addBox(-3.0002F, -4.9954F, 0.053F, 4.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.5002F, 0.0046F, 2.053F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 5.0F, 4.0F));

		PartDefinition cube_r7 = Gatling2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(24, 9).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0002F, -2.4954F, 8.553F, -0.7854F, 0.0F, 0.0F));

		PartDefinition bone2 = Gatling2.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -16.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 32).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 32).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0002F, -6.9954F, 5.053F));

		PartDefinition cube_r8 = bone2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -5.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r9 = bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -5.0F, 1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r10 = bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, 1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r11 = bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(22, 0).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition rightLayer() {
		MeshDefinition meshdefinition = GolemEquipmentModels.buildGolemBaseLayers();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.getChild("body");

		PartDefinition Gatling = body.addOrReplaceChild("flamethrower", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -5.0F, 2.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(24, 19).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.5F, 0.0F, 2.0F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 5.0F, 4.0F));

		PartDefinition cube_r1 = Gatling.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 9).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 8.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition bone = Gatling.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -16.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 32).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 32).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 5.0F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -5.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -5.0F, 1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, 1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(22, 0).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

}
