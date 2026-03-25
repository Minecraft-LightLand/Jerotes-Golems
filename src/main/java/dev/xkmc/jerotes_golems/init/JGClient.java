package dev.xkmc.jerotes_golems.init;

import dev.xkmc.jerotes_golems.content.client.*;
import dev.xkmc.modulargolems.content.client.armor.GolemEquipmentModels;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = JerotesGolems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JGClient {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public static void registerOverlays(RegisterGuiOverlaysEvent event) {
	}

	@SubscribeEvent
	public static void registerArmorLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
		GolemEquipmentModels.regAndAdd(event, WonderlandArmors.HELMET_LAYER, WonderlandArmors::createHelmet);
		GolemEquipmentModels.regAndAdd(event, WonderlandArmors.CHESTPLATE_LAYER, WonderlandArmors::createChestplate);
		GolemEquipmentModels.regAndAdd(event, WonderlandArmors.SHINGUARD_LAYER, WonderlandArmors::createLeggings);
		GolemEquipmentModels.regAndAdd(event, MerorArmors.HELMET_LAYER, MerorArmors::createHelmet);
		GolemEquipmentModels.regAndAdd(event, MerorArmors.CHESTPLATE_LAYER, MerorArmors::createChestplate);
		GolemEquipmentModels.regAndAdd(event, MerorArmors.SHINGUARD_LAYER, MerorArmors::createLeggings);
		GolemEquipmentModels.regAndAdd(event, RefineMerorArmors.HELMET_LAYER, RefineMerorArmors::createHelmet);
		GolemEquipmentModels.regAndAdd(event, RefineMerorArmors.CHESTPLATE_LAYER, RefineMerorArmors::createChestplate);
		GolemEquipmentModels.regAndAdd(event, RefineMerorArmors.SHINGUARD_LAYER, RefineMerorArmors::createLeggings);

		GolemEquipmentModels.regAndAdd(event, MerorFlameThrowerModel.FLAME_RIGHT, MerorFlameThrowerModel::rightLayer);
		GolemEquipmentModels.regAndAdd(event, MerorFlameThrowerModel.FLAME_LEFT, MerorFlameThrowerModel::leftLayer);
		GolemEquipmentModels.regAndAdd(event, MerorMachineGunModel.FLAME_RIGHT, MerorMachineGunModel::rightLayer);
		GolemEquipmentModels.regAndAdd(event, MerorMachineGunModel.FLAME_LEFT, MerorMachineGunModel::leftLayer);
	}


}
