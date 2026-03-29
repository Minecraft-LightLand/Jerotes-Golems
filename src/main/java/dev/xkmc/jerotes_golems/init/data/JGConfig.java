package dev.xkmc.jerotes_golems.init.data;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class JGConfig {

	public static class Client {

		Client(ForgeConfigSpec.Builder builder) {
		}

	}

	public static class Common {

		public final ForgeConfigSpec.IntValue villagerBonusDuration;
		public final ForgeConfigSpec.DoubleValue merorDefenseDamageReduction;
		public final ForgeConfigSpec.DoubleValue fireAffinityHeal;
		public final ForgeConfigSpec.DoubleValue fireAffinityDamageBonus;
		public final ForgeConfigSpec.DoubleValue qoaikuAttackDamageBonus;
		public final ForgeConfigSpec.DoubleValue serponChainBladeDamageFactor;
		public final ForgeConfigSpec.IntValue legendaryChargeDuration;

		Common(ForgeConfigSpec.Builder builder) {
			builder.push("modifiers");
			villagerBonusDuration = builder.comment("VillagerMetal: bonus effect duration per level")
					.defineInRange("villagerBonusDuration", 1200, 200, 6000);
			merorDefenseDamageReduction = builder.comment("MerorDefense: Damage reduction per level")
					.defineInRange("merorDefenseDamageReduction", 0.2, 0, 1);
			fireAffinityHeal = builder.comment("FireAffinity: Healing bonus per level")
					.defineInRange("fireAffinityHeal", 0.5, 0, 10);
			fireAffinityDamageBonus = builder.comment("FireAffinity: Damage bonus per level")
					.defineInRange("fireAffinityDamageBonus", 0.1, 0, 10);
			qoaikuAttackDamageBonus = builder.comment("QoaikuAttack: Damage bonus per level")
					.defineInRange("qoaikuAttackDamageBonus", 0.1, 0, 1);
			legendaryChargeDuration = builder.comment("Legendary: Charge duration")
					.defineInRange("legendaryChargeDuration", 1200, 100, 24000);
			builder.pop();
			builder.push("weapons");
			serponChainBladeDamageFactor = builder.comment("Serpon Chain Blade: follow up damage factor")
					.defineInRange("serponChainBladeDamageFactor", 0.2, 0, 1);
			builder.pop();

		}

	}

	public static final ForgeConfigSpec CLIENT_SPEC;
	public static final Client CLIENT;

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Client, ForgeConfigSpec> client = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENT_SPEC = client.getRight();
		CLIENT = client.getLeft();

		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	public static void init() {
		register(ModConfig.Type.CLIENT, CLIENT_SPEC);
		register(ModConfig.Type.COMMON, COMMON_SPEC);
	}

	private static void register(ModConfig.Type type, IConfigSpec<?> spec) {
		var mod = ModLoadingContext.get().getActiveContainer();
		String path = "l2_configs/" + mod.getModId() + "-" + type.extension() + ".toml";
		ModLoadingContext.get().registerConfig(type, spec, path);
	}


}
