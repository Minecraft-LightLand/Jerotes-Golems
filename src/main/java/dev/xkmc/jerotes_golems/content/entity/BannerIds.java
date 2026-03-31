package dev.xkmc.jerotes_golems.content.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class BannerIds {

	public static final Map<UUID, Integer> MAP = new LinkedHashMap<>();

	public static synchronized void update(UUID uuid, int uid) {
		MAP.put(uuid, uid);
	}

	public static synchronized int get(UUID id) {
		return MAP.getOrDefault(id, -1);
	}
}
