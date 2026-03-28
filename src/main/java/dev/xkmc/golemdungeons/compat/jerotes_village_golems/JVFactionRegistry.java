package dev.xkmc.golemdungeons.compat.jerotes_village_golems;

import dev.xkmc.golemdungeons.compat.jerotes_village_golems.CarvedFaction;
import dev.xkmc.golemdungeons.compat.jerotes_village_golems.SerponFaction;
import dev.xkmc.golemdungeons.compat.jerotes_village_golems.QoaikuFaction;
import dev.xkmc.golemdungeons.compat.jerotes_village_golems.MerorFaction;
import dev.xkmc.golemdungeons.init.GolemDungeons;
import dev.xkmc.modulargolems.content.entity.hostile.HostileFaction;
import dev.xkmc.modulargolems.content.entity.hostile.HostileGolemRegistry;

public class JVFactionRegistry {

	public static final HostileFaction CARVED = HostileGolemRegistry.register(
			new CarvedFaction(GolemDungeons.loc("carved_")));

	public static final HostileFaction SERPON = HostileGolemRegistry.register(
			new SerponFaction(GolemDungeons.loc("serpon_")));

	public static final HostileFaction QOAIKU = HostileGolemRegistry.register(
			new QoaikuFaction(GolemDungeons.loc("_")));

	public static final HostileFaction MEROR = HostileGolemRegistry.register(
			new MerorFaction(GolemDungeons.loc("meror_")));

	public static void register() {

	}

}
