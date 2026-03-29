package dev.xkmc.jerotes_golems.content.ranged;

import com.jerotes.jerotesvillage.entity.Shoot.Other.MerorFireEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageEntityType;
import dev.xkmc.jerotes_golems.content.client.JGModelPaths;
import dev.xkmc.jerotes_golems.init.data.JGLang;
import dev.xkmc.modulargolems.content.client.armor.GolemModelPaths;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import dev.xkmc.modulargolems.content.item.ranged.CannonPoseUtil;
import dev.xkmc.modulargolems.content.item.ranged.IShoulderCannonAnimated;
import dev.xkmc.modulargolems.content.item.ranged.ShouldWeaponItem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MerorFlameThrowerItem extends ShouldWeaponItem implements IShoulderCannonAnimated {

	public MerorFlameThrowerItem(Properties p) {
		super(p);
	}

	@Override
	public void onTick(MetalGolemEntity e, ItemStack stack, InteractionHand hand) {
		if (e.tickCount % 4 != (hand == InteractionHand.MAIN_HAND ? 1 : 3)) return;
		if (CannonPoseUtil.BEACON.isOutOfRange(e, hand, 15)) return;
		var target = e.getTarget();
		if (target == null || !target.isAlive()) return;
		var pos = CannonPoseUtil.BEACON.getOrigin(e, hand);
		var dst = target.position().add(0, target.getBbHeight() / 2, 0);
		var dir = dst.subtract(pos).normalize();
		Projectile proj = new MerorFireEntity(JerotesVillageEntityType.MEROR_FIRE.get(), e.level());
		proj.setOwner(e);
		proj.setPos(pos);
		proj.setDeltaMovement(dir.scale(1.5));
		e.level().addFreshEntity(proj);
		e.level().playSound(null, e, SoundEvents.FIRE_AMBIENT, SoundSource.NEUTRAL, 1.0F, 1.0F);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		list.add(JGLang.FLAME_THROWER_DESC.get());
		super.appendHoverText(stack, level, list, flag);
	}

	@Override
	public @Nullable ResourceLocation getModelForHand(InteractionHand hand) {
		return hand == InteractionHand.MAIN_HAND ? JGModelPaths.FLAME_RIGHT : JGModelPaths.FLAME_LEFT;
	}

	@Override
	public @Nullable ResourceLocation getAnimBaseId(MetalGolemEntity user, ItemStack stack, InteractionHand hand) {
		return hand == InteractionHand.MAIN_HAND ? GolemModelPaths.BEACON_RIGHT : GolemModelPaths.BEACON_LEFT;
	}

	@Override
	public ResourceLocation getModelTexture(MetalGolemEntity entity, ItemStack stack, InteractionHand hand) {
		var id = ForgeRegistries.ITEMS.getKey(this);
		assert id != null;
		return id.withPath(e -> "textures/equipments/" + e + ".png");
	}

}
