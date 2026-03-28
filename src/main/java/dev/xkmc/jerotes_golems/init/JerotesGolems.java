package dev.xkmc.jerotes_golems.init;

import com.tterrag.registrate.providers.ProviderType;
import dev.xkmc.jerotes_golems.content.fraction.JGFactionRegistry;
import dev.xkmc.jerotes_golems.events.JGAttackListener;
import dev.xkmc.jerotes_golems.init.data.*;
import dev.xkmc.jerotes_golems.init.reg.JGEffects;
import dev.xkmc.jerotes_golems.init.reg.JGEntities;
import dev.xkmc.jerotes_golems.init.reg.JGItems;
import dev.xkmc.jerotes_golems.init.reg.JGModifiers;
import dev.xkmc.l2damagetracker.contents.attack.AttackEventHandler;
import dev.xkmc.l2library.base.L2Registrate;
import dev.xkmc.l2library.serial.config.PacketHandlerWithConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JerotesGolems.MODID)
@Mod.EventBusSubscriber(modid = JerotesGolems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JerotesGolems {

	public static final String MODID = "jerotes_village_golems";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final L2Registrate REGISTRATE = new L2Registrate(MODID);
	public static final IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();

	public static final PacketHandlerWithConfig HANDLER = new PacketHandlerWithConfig(
			new ResourceLocation(JerotesGolems.MODID, "main"), 1
	);

	public JerotesGolems() {
		JGItems.register();
		JGModifiers.register();
		JGEffects.register();
		JGEntities.register();
		JGConfig.init();
		AttackEventHandler.register(7901, new JGAttackListener());
	}

	@SubscribeEvent
	public static void modifyAttributes(EntityAttributeModificationEvent event) {
	}

	@SubscribeEvent
	public static void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			JGFactionRegistry.register();
		});
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void gatherData(GatherDataEvent event) {
		REGISTRATE.addDataGenerator(ProviderType.LANG, JGLang::genLang);
		REGISTRATE.addDataGenerator(ProviderType.RECIPE, JGRecipeGen::genRecipe);
		REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, JGTagGen::genItemTag);

		var gen = event.getGenerator();
		var output = gen.getPackOutput();
		var pvd = event.getLookupProvider();
		var helper = event.getExistingFileHelper();
		var server = event.includeServer();
		gen.addProvider(server, new JGConfigGen(gen));
		new JGDamageTypes(output, pvd, helper).generate(server, gen);
	}


	public static ResourceLocation loc(String id) {
		return new ResourceLocation(MODID, id);
	}

}
