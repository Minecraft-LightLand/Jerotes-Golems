package dev.xkmc.jerotes_golems.init.reg;

import com.tterrag.registrate.util.entry.EntityEntry;
import dev.xkmc.jerotes_golems.content.entity.TrialBannerEntity;
import dev.xkmc.jerotes_golems.content.entity.TrialBannerRenderer;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import net.minecraft.world.entity.MobCategory;

public class JGEntities {

	public static final EntityEntry<TrialBannerEntity> BANNER = JerotesGolems.REGISTRATE
			.entity("trial_banner", TrialBannerEntity::new, MobCategory.MISC)
			.properties(p -> p.sized(2, 6).fireImmune())
			.renderer(() -> TrialBannerRenderer::new)
			.defaultLang()
			.register();

	public static void register() {

	}

}
