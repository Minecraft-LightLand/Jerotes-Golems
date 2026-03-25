package dev.xkmc.jerotes_golems.content.entity;

import dev.xkmc.golemdungeons.content.config.TrialConfig;
import dev.xkmc.golemdungeons.content.item.HostileSummonWand;
import dev.xkmc.golemdungeons.content.spawner.TrialData;
import dev.xkmc.golemdungeons.content.spawner.TrialTicker;
import dev.xkmc.golemdungeons.init.GolemDungeons;
import dev.xkmc.golemdungeons.init.reg.GDItems;
import dev.xkmc.jerotes_golems.init.JerotesGolems;
import dev.xkmc.l2library.base.BaseEntity;
import dev.xkmc.l2serial.serialization.SerialClass;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.bossevents.CustomBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

@SerialClass
public class TrialBannerEntity extends BaseEntity implements TrialTicker {

	private static final EntityDataAccessor<String> TRIAL = SynchedEntityData.defineId(TrialBannerEntity.class, EntityDataSerializers.STRING);

	@SerialClass.SerialField
	private final TrialData data = new TrialData();

	@Nullable
	private ResourceLocation trial;

	private final CustomBossEvent bar = new CustomBossEvent(JerotesGolems.loc("banner"), Component.empty());

	@SerialClass.SerialField
	public final UUID bannerId = bar.getId();

	AnimationState idle = new AnimationState();
	AnimationState death = new AnimationState();

	@SerialClass.SerialField
	public int deathTick = 0;

	public TrialBannerEntity(EntityType<?> type, Level world) {
		super(type, world);
		bar.setVisible(false);
	}

	@Override
	protected void defineSynchedData() {
		entityData.define(TRIAL, "");
	}

	@Override
	public boolean isPickable() {
		return true;
	}

	@Nullable
	public ResourceLocation getTexture() {
		var id = entityData.get(TRIAL);
		if (id.isEmpty()) return null;
		var trial = new ResourceLocation(id);
		return trial.withPath(e -> "textures/entity/trial_banner/" + e + ".png");
	}

	@Nullable
	public ResourceLocation getBannerTexture() {
		var id = entityData.get(TRIAL);
		if (id.isEmpty()) return null;
		var trial = new ResourceLocation(id);
		return trial.withPrefix("textures/gui/sprites/boss_bar/");
	}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (player.isCreative()) {
			if (stack.is(GDItems.SUMMON.get())) {
				var id = HostileSummonWand.getId(stack);
				var entry = GolemDungeons.SPAWN.getEntry(id);
				if (entry.targetTrial != null) {
					var config = GolemDungeons.TRIAL.getEntry(entry.targetTrial);
					if (config != null) {
						if (level() instanceof ServerLevel sl) {
							data.stop(sl, this);
							trial = entry.targetTrial;
							data.start(this, sl.getGameTime(), trial, config);
							bar.setVisible(true);
							entityData.set(TRIAL, trial.toString());
						}
						return InteractionResult.SUCCESS;
					}
				}
			}
		}
		return super.interact(player, hand);
	}

	@Override
	public void tick() {
		super.tick();
		if (level() instanceof ServerLevel sl && trial != null) {
			long time = sl.getGameTime();
			data.tickTrial(this, sl, time);
			data.updateBar(bar, sl, time);
		} else {
			BannerIds.update(this);
		}
	}

	@Override
	public void addCost(int i, long l) {
	}

	@Override
	public void stop() {
		if (level() instanceof ServerLevel sl) {
			if (trial != null) {
				data.stop(sl, this);
				bar.setVisible(false);
				trial = null;
			}
			if (!isRemoved()) {
				kill();
			}
			if (deathTick > 0) {
				deathTick++;
				if (deathTick > 20) {
					kill();
				}
			}
		}
	}

	@Override
	public void configureEntity(LivingEntity e, int i) {
		e.setPos(position());
	}

	@Override
	public boolean isValidTracked(Entity e) {
		return e.isAlive() && e.level() == level() && e.distanceToSqr(position()) < 48 * 48;
	}

	@Override
	public void complete(ServerLevel level, TrialConfig config, long l) {
		if (deathTick > 0) return;
		deathTick++;
		if (config.reward == null) return;
		var loot = level.getServer().getLootData().getLootTable(config.reward);
		var params = new LootParams.Builder(level)
				.withParameter(LootContextParams.ORIGIN, position())
				.create(LootContextParamSets.CHEST);
		List<ItemStack> list = loot.getRandomItems(params);
		for (var stack : list)
			spawnAtLocation(stack);
		level.broadcastEntityEvent(this, EntityEvent.DEATH);
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == EntityEvent.DEATH) {
			deathTick++;
		}
		super.handleEntityEvent(id);
	}

	@Override
	public boolean isOnGoing() {
		return trial != null && isAlive();
	}

	@Override
	public void configureGolem(AbstractGolemEntity<?, ?> e, int i) {
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void remove(RemovalReason reason) {
		super.remove(reason);
		if (reason.shouldDestroy())
			stop();
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		bar.setVisible(trial != null);
		entityData.set(TRIAL, trial == null ? "" : trial.toString());
	}

	public void startSeenByPlayer(ServerPlayer p_31483_) {
		super.startSeenByPlayer(p_31483_);
		this.bar.addPlayer(p_31483_);
	}

	public void stopSeenByPlayer(ServerPlayer p_31488_) {
		super.stopSeenByPlayer(p_31488_);
		this.bar.removePlayer(p_31488_);
	}

	@Override
	public AABB getBoundingBoxForCulling() {
		return getBoundingBox().inflate(6, 0, 6);
	}

}
