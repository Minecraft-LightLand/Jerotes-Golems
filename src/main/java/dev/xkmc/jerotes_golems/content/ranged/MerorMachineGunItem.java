package dev.xkmc.jerotes_golems.content.ranged;

import com.jerotes.jerotesvillage.entity.Shoot.Other.MerorBulletEntity;
import com.jerotes.jerotesvillage.init.JerotesVillageEntityType;
import com.jerotes.jerotesvillage.init.JerotesVillageItems;
import dev.xkmc.jerotes_golems.content.client.JGModelPaths;
import dev.xkmc.jerotes_golems.init.data.JGLang;
import dev.xkmc.modulargolems.content.client.armor.GolemModelPaths;
import dev.xkmc.modulargolems.content.client.weapon.ShoulderAnimData;
import dev.xkmc.modulargolems.content.entity.metalgolem.MetalGolemEntity;
import dev.xkmc.modulargolems.content.item.ranged.CannonPoseUtil;
import dev.xkmc.modulargolems.content.item.ranged.IShoulderCannonAnimated;
import dev.xkmc.modulargolems.init.data.MGLangData;
import dev.xkmc.modulargolems.init.registrate.GolemTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MerorMachineGunItem extends ProjectileWeaponItem implements IShoulderCannonAnimated {

	public MerorMachineGunItem(Properties p) {
		super(p);
	}

	@Override
	public void onTick(MetalGolemEntity e, ItemStack stack, InteractionHand hand) {
		if (e.tickCount % 4 != (hand == InteractionHand.MAIN_HAND ? 1 : 3)) return;
		if (CannonPoseUtil.BEACON.isOutOfRange(e, hand, 15)) return;
		var target = e.getTarget();
		if (target == null || !target.isAlive()) return;
		var ammo = e.getProjectile(stack);
		var inf = e.isHostile() || stack.getEnchantmentLevel(Enchantments.INFINITY_ARROWS) > 0;
		if (!inf && ammo.isEmpty()) return;
		var pos = CannonPoseUtil.BEACON.getOrigin(e, hand);
		var dst = target.position().add(0, target.getBbHeight() / 2, 0);
		var dir = dst.subtract(pos).normalize();
		for (int i = 0; i < 3; i++) {
			Projectile proj = new MerorBulletEntity(JerotesVillageEntityType.MEROR_BULLET.get(), e.level());
			proj.setOwner(e);
			proj.setPos(pos);
			proj.setDeltaMovement(dir.scale(4));
			e.level().addFreshEntity(proj);
		}
		if (!e.isSilent()) {
			e.level().playSound(null, e.getX(), e.getY(), e.getZ(), SoundEvents.GENERIC_EXPLODE, e.getSoundSource(), 1.0F, 5.0F);
		}
		if (!inf) ammo.shrink(1);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		list.add(JGLang.MACHINE_GUN_DESC.get());
		list.add(MGLangData.GOLEM_EQUIPMENT.get(GolemTypes.ENTITY_GOLEM.get().getDescription().copy().withStyle(ChatFormatting.GOLD))
				.withStyle(ChatFormatting.UNDERLINE));
		list.add(MGLangData.SHOULDER_WEAPON.get());
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment == Enchantments.INFINITY_ARROWS;
	}

	private static boolean supports(ItemStack stack) {
		return stack.is(JerotesVillageItems.MEROR_BULLET.get());
	}

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return MerorMachineGunItem::supports;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 15;
	}

	@Override
	public List<ShoulderAnimData> getAnimationData(MetalGolemEntity user, ItemStack stack, InteractionHand hand) {
		var ans = new ArrayList<>(IShoulderCannonAnimated.super.getAnimationData(user, stack, hand));
		int starting = user.animState.getStartingAnim();
		int ending = user.animState.getEndingAnim();
		if (starting >= 0 && starting <= 5 || ending >= 0 && ending <= 5) return ans;
		ans.add(new ShoulderAnimData(getModelForHand(hand), 1, user.tickCount));
		return ans;
	}

	@Override
	public ResourceLocation getModelForHand(InteractionHand hand) {
		return hand == InteractionHand.MAIN_HAND ? JGModelPaths.GUN_RIGHT : JGModelPaths.GUN_LEFT;
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
