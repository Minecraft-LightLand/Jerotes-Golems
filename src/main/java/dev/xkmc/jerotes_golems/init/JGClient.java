package dev.xkmc.jerotes_golems.init;

import com.jerotes.jerotes.util.EntityAndItemFind;
import dev.xkmc.jerotes_golems.content.client.*;
import dev.xkmc.jerotes_golems.content.entity.TrialBannerModelData;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.modulargolems.content.client.armor.GolemEquipmentModels;
import dev.xkmc.modulargolems.content.client.override.ModelOverride;
import dev.xkmc.modulargolems.content.client.override.ModelOverrides;
import net.minecraft.client.renderer.item.ItemProperties;
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
		event.enqueueWork(() -> {
			ModelOverrides.registerOverride(JerotesGolems.loc("refine_meror"), ModelOverride.texturePredicate(e ->
					EntityAndItemFind.isLegendary(e) ? "_charged" : ""));
			ItemProperties.register(JGItems.ULTIMATE_MEROR_SPEAR.get(), JerotesGolems.loc("charged"),
					(stack, level, user, index) -> user != null && EntityAndItemFind.isLegendary(user) ? 1 : 0);
		});
	}

	@SubscribeEvent
	public static void registerOverlays(RegisterGuiOverlaysEvent event) {
	}

	@SubscribeEvent
	public static void registerArmorLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(TrialBannerModelData.LAYER_LOCATION, TrialBannerModelData::createBodyLayer);

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
