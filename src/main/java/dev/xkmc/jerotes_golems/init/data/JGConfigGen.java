package dev.xkmc.jerotes_golems.init.data;

import dev.xkmc.l2library.serial.config.ConfigDataProvider;
import net.minecraft.data.DataGenerator;

public class JGConfigGen extends ConfigDataProvider {

	public JGConfigGen(DataGenerator generator) {
		super(generator, "Jerotes Golem Config");
	}

	public void add(ConfigDataProvider.Collector map) {
	}

}
