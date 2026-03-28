package dev.xkmc.jerotes_golems.content.fraction;

import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.modulargolems.content.entity.hostile.HostileFaction;
import dev.xkmc.modulargolems.content.entity.hostile.HostileGolemRegistry;

public class JGFactionRegistry {

	public static final HostileFaction CARVED = HostileGolemRegistry.register(
			new CarvedFaction(JerotesGolems.loc("villager_metal")));

	public static final HostileFaction SERPON = HostileGolemRegistry.register(
			new SerponFaction(JerotesGolems.loc("serpon")));

	public static final HostileFaction QOAIKU = HostileGolemRegistry.register(
			new QoaikuFaction(JerotesGolems.loc("qoaiku")));

	public static final HostileFaction MEROR = HostileGolemRegistry.register(
			new MerorFaction(JerotesGolems.loc("meror")));

	public static void register() {

	}

}
