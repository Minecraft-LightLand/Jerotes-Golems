package dev.xkmc.jerotes_golems.init.reg;

import com.jerotes.jerotesvillage.init.JerotesVillageMobEffects;
import com.jerotes.jerotesvillage.spell.OtherSpellType;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import dev.xkmc.jerotes_golems.content.modifier.*;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.l2library.base.L2Registrate;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.item.upgrade.SimpleUpgradeItem;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import dev.xkmc.modulargolems.content.modifier.base.PotionDefenseModifier;
import dev.xkmc.modulargolems.init.ModularGolems;
import dev.xkmc.modulargolems.init.data.MGTagGen;
import dev.xkmc.modulargolems.init.registrate.GolemItems;
import dev.xkmc.modulargolems.init.registrate.GolemTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class JGModifiers {

	public static final RegistryEntry<VillagerMetalModifier> GREEDY;
	public static final RegistryEntry<MerorAttackModifier> MEROR_ATK;
	public static final RegistryEntry<MerorDefenseModifier> MEROR_DEF;
	public static final RegistryEntry<FireAffinityModifier> FIRE_AFFINITY;
	public static final RegistryEntry<QoaikuAttackModifier> QOAIKU_ATK;
	public static final RegistryEntry<AbackModifier> ABACK;
	public static final RegistryEntry<LegendaryModifier> LEGENDARY;
	public static final RegistryEntry<SedimentLordModifier> SEDIMENT;
	public static final RegistryEntry<PurpleSandModifier> PURPLE_SAND;
	public static final RegistryEntry<ProsperousEnvoyModifier> PROSPEROUS_ENVOY;
	public static final RegistryEntry<PotionDefenseModifier> RAMPANT;

	public static final RegistryEntry<SpellModifier> CORROSIVER, MALIGNASAUR, SERPON, WILL;

	public static final ItemEntry<SimpleUpgradeItem> ITEM_VILLAGE, ITEM_ABACK, ITEM_RAMPANT,
			ITEM_SEDIMENT, ITEM_PURPLE_SAND, ITEM_PROSPEROUS_ENVOY,
			ITEM_CORROSIVER, ITEM_MALIGNASAUR, ITEM_SERPON, ITEM_WILL;

	static {
		GREEDY = reg("greedy", () -> new VillagerMetalModifier(StatFilterType.HEALTH, 2), "Golem repairs and gets bonus when using emerald block or netherite block on it");
		MEROR_ATK = reg("meror_attack", () -> new MerorAttackModifier(1), "Golem deal Meror damage");
		MEROR_DEF = reg("meror_defense", () -> new MerorDefenseModifier(5), "Reduce Non-Meror damage by %s%%");
		FIRE_AFFINITY = reg("fire_affinity", () -> new FireAffinityModifier(5), "Absorb fire damage then get +%s natural healing and +%s%% damage bonus");
		QOAIKU_ATK = reg("qoaiku_attack", () -> new QoaikuAttackModifier(5), "Golem deal Drown damage if possible. Deal %s%% extra damage against mobs sensitive to water.");
		ABACK = reg("aback", () -> new AbackModifier(StatFilterType.MASS, 1), "Golem inflict Aback effect to target");
		LEGENDARY = reg("legendary", () -> new LegendaryModifier(StatFilterType.MASS, 4), "Consume [%s] to gain %s of legendary status");
		SEDIMENT = reg("sediment_lord", () -> new SedimentLordModifier(StatFilterType.MASS, 1), "Reduce damage from undead by %s%%. Immune to wither effect damage");
		PURPLE_SAND = reg("purple_sand", () -> new PurpleSandModifier(StatFilterType.MASS, 1), "When taking magic damage, gain Magic Absorption and reduce damage by %s%%");
		PROSPEROUS_ENVOY = reg("prosperous_envoy", () -> new ProsperousEnvoyModifier(StatFilterType.MASS, 3), "On attack, stack %s seconds of Anesthetized effect per point of damage on target");
		RAMPANT = reg("rampant", () -> new PotionDefenseModifier(1, () -> JerotesVillageMobEffects.RAMPANT.get()), null);

		CORROSIVER = reg("corrosive_breath", () -> new SpellModifier(StatFilterType.MASS, 3, 25, OtherSpellType.JEROTESVILLAGE_CORROSIVE_BREATH, lv -> lv + 2), "Unleash corrosive breath");
		MALIGNASAUR = reg("ocean_current_breath", () -> new SpellModifier(StatFilterType.MASS, 3, 25, OtherSpellType.JEROTESVILLAGE_OCEAN_CURRENT_BREATH, lv -> lv + 2), "Unleash ocean current breath");
		SERPON = reg("serpon_sirocco", () -> new SpellModifier(StatFilterType.MASS, 4, 15, OtherSpellType.JEROTESVILLAGE_SERPON_SIROCCO, lv -> lv), "Unleash Serpon Sirocco");
		WILL = reg("indomitable_will", () -> new SpellModifier(StatFilterType.MASS, 1, 15, OtherSpellType.JEROTESVILLAGE_INDOMITABLE_WILL, lv -> lv + 3), "Unleash Indomitable Will");

		ITEM_VILLAGE = regUpgradeImpl("greedy", () -> GREEDY, 1, false, JerotesGolems.MODID).lang("Jerotes Upgrade: Carved Nature").register();
		ITEM_ABACK = regUpgradeImpl("aback", () -> ABACK, 1, false, JerotesGolems.MODID).lang("Jerotes Upgrade: Shock Sight ").register();
		ITEM_RAMPANT = regUpgradeImpl("rampant", () -> RAMPANT, 1, false, JerotesGolems.MODID).lang("Jerotes Upgrade: Rampant").register();
		ITEM_SEDIMENT = regUpgradeImpl("sediment_lord", () -> SEDIMENT, 1, false, JerotesGolems.MODID).lang("Jerotes Upgrade: Sediment Lord").register();
		ITEM_PURPLE_SAND = regUpgradeImpl("purple_sand", () -> PURPLE_SAND, 1, false, JerotesGolems.MODID).lang("Jerotes Upgrade: Purple Sand").register();
		ITEM_PROSPEROUS_ENVOY = regUpgradeImpl("prosperous_envoy", () -> PROSPEROUS_ENVOY, 1, false, JerotesGolems.MODID).lang("Potion Upgrade: Prosperous Envoy").tag(MGTagGen.POTION_UPGRADES).register();

		ITEM_CORROSIVER = regUpgradeImpl("corrosiver", () -> CORROSIVER, 1, false, JerotesGolems.MODID).lang("Jerotes Spell Upgrade: Corrosive Breath").register();
		ITEM_MALIGNASAUR = regUpgradeImpl("gemstone_malignasaur", () -> MALIGNASAUR, 1, false, JerotesGolems.MODID).lang("Jerotes Spell Upgrade: Ocean Current Breath").register();
		ITEM_SERPON = regUpgradeImpl("serpon", () -> SERPON, 1, false, JerotesGolems.MODID).lang("Jerotes Spell Upgrade: Serpon Sirocco").register();
		ITEM_WILL = regUpgradeImpl("mountain_realm", () -> WILL, 1, false, JerotesGolems.MODID).lang("Jerotes Spell Upgrade: Indomitable Will").register();

	}

	public static <T extends GolemModifier> RegistryEntry<T> reg(String id, NonNullSupplier<T> sup, @Nullable String def) {
		Mutable<RegistryEntry<T>> holder = new MutableObject<>();
		L2Registrate.GenericBuilder<GolemModifier, T> ans = JerotesGolems.REGISTRATE.generic(GolemTypes.MODIFIERS, id, sup).defaultLang();
		if (def != null) {
			ans.addMiscData(ProviderType.LANG, (pvd) -> pvd.add(holder.getValue().get().getDescriptionId() + ".desc", def));
		}
		RegistryEntry<T> result = ans.register();
		holder.setValue(result);
		return result;
	}

	public static ItemBuilder<SimpleUpgradeItem, L2Registrate> regUpgradeImpl(String id, Supplier<RegistryEntry<? extends GolemModifier>> mod, int level, boolean foil, String modid) {
		return JerotesGolems.REGISTRATE.item(id, (p) -> new SimpleUpgradeItem(p, mod.get()::get, level, foil))
				.model((ctx, pvd) -> pvd.generated(ctx, new ResourceLocation(modid, "item/upgrades/" + id))
						.override().predicate(new ResourceLocation(ModularGolems.MODID, "blue_arrow"), 0.5f)
						.model(pvd.getBuilder(pvd.name(ctx) + "_purple")
								.parent(new ModelFile.UncheckedModelFile("item/generated"))
								.texture("layer0", new ResourceLocation(modid, "item/upgrades/" + id))
								.texture("layer1", new ResourceLocation(ModularGolems.MODID, "item/purple_arrow")))
						.end().override().predicate(new ResourceLocation(ModularGolems.MODID, "blue_arrow"), 1)
						.model(pvd.getBuilder(pvd.name(ctx) + "_blue")
								.parent(new ModelFile.UncheckedModelFile("item/generated"))
								.texture("layer0", new ResourceLocation(modid, "item/upgrades/" + id))
								.texture("layer1", new ResourceLocation(ModularGolems.MODID, "item/blue_arrow")))
						.end())
				.tab(GolemItems.UPGRADES.getKey());
	}

	public static void register() {

	}

}
