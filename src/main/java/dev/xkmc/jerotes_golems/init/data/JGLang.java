package dev.xkmc.jerotes_golems.init.data;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.init.ModularGolems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.util.Locale;

public enum JGLang {
	BITTER_COLD_AXE_DESC("tooltip.bitter_cold_axe", "Inflict Frozen and Corrosion effect", 0, ChatFormatting.GRAY),
	SEDIMENT_SWORD_DESC("tooltip.sediment_sword", "Inflict Slowness", 0, ChatFormatting.GRAY),
	WONDERLAND_BLADE_DESC("tooltip.wonderland_blade", "Inflict Aback and Quake effect, then gain Rampant effect", 0, ChatFormatting.GRAY),
	SERPON_CHAIN_BLADE_DESC("tooltip.serpon_chain_blade", "Deal 3 follow up fire damage at %s%% of original damage", 1, ChatFormatting.GRAY),
	FLAME_THROWER_DESC("tooltip.flame_thrower", "Shoots Meror Flame", 0, ChatFormatting.GRAY),
	MACHINE_GUN_DESC("tooltip.machine_gun", "Shoots Meror Bullets. Support Infinity Enchantment", 0, ChatFormatting.GRAY),
	REFINE_MEROR_WEAPON("tooltip.refine_meror", "Stack Bleeding effect on target, up to level VI", 0, ChatFormatting.GRAY);

	private final String key, def;
	private final int arg;
	private final ChatFormatting format;

	JGLang(String key, String def, int arg, @Nullable ChatFormatting format) {
		this.key = JerotesGolems.MODID + "." + key;
		this.def = def;
		this.arg = arg;
		this.format = format;
	}

	public static String asId(String name) {
		return name.toLowerCase(Locale.ROOT);
	}

	public static MutableComponent getTranslate(String s) {
		return Component.translatable(ModularGolems.MODID + "." + s);
	}

	public static MutableComponent fromTrial(ResourceLocation id) {
		return Component.translatable(Util.makeDescriptionId("trial", id));
	}

	public MutableComponent get(Object... args) {
		if (args.length != arg)
			throw new IllegalArgumentException("for " + name() + ": expect " + arg + " parameters, got " + args.length);
		MutableComponent ans = Component.translatable(key, args);
		if (format != null) {
			return ans.withStyle(format);
		}
		return ans;
	}

	public static void genLang(RegistrateLangProvider pvd) {
		pvd.add("golem_material." + JerotesGolems.MODID + ".villager_metal", "Villager Metal");
		pvd.add("golem_material." + JerotesGolems.MODID + ".qoaiku", "Qoaiku Metal");
		pvd.add("golem_material." + JerotesGolems.MODID + ".serpon_alloy", "Serpon Alloy");
		pvd.add("golem_material." + JerotesGolems.MODID + ".meror", "Meror Metal");
		pvd.add("golem_material." + JerotesGolems.MODID + ".refine_meror", "Refined Meror Metal");
	}

}
