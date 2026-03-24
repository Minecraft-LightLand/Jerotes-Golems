package dev.xkmc.jerotes_golems.init.reg;

import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import dev.xkmc.jerotes_golems.content.modifier.*;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.l2library.base.L2Registrate;
import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.item.upgrade.SimpleUpgradeItem;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import dev.xkmc.modulargolems.init.ModularGolems;
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

	static {
		GREEDY = reg("greedy", () -> new VillagerMetalModifier(StatFilterType.HEALTH, 2), "Golem repairs and gets bonus when using emerald block or netherite block on it");
		MEROR_ATK = reg("meror_attack", () -> new MerorAttackModifier(1), "Golem deal Meror damage");
		MEROR_DEF = reg("meror_defense", () -> new MerorDefenseModifier(5), "Reduce Non-Meror damage by %s%%");
		FIRE_AFFINITY = reg("fire_affinity", () -> new FireAffinityModifier(5), "Absorb fire damage then get +%s natural healing and +%s%% damage bonus");
		QOAIKU_ATK = reg("qoaiku_attack", () -> new QoaikuAttackModifier(5), "Golem deal Drown damage if possible. Deal %s%% extra damage against mobs sensitive to water.");
		ABACK = reg("aback", () -> new AbackModifier(StatFilterType.MASS,1), "Golem inflict Aback effect to target");

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
