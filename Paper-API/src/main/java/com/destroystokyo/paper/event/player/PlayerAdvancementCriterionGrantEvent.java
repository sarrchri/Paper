package com.destroystokyo.paper.event.player;

import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called after a player is granted a criteria in an advancement.
 * If cancelled the criteria will be revoked.
 */
public class PlayerAdvancementCriterionGrantEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    @NotNull private final Advancement advancement;
    @NotNull private final String criterion;
    @NotNull private final AdvancementProgress advancementProgress;
    private boolean cancel = false;

    public PlayerAdvancementCriterionGrantEvent(@NotNull Player who, @NotNull Advancement advancement, @NotNull String criterion) {
        super(who);
        this.advancement = advancement;
        this.criterion = criterion;
        this.advancementProgress = who.getAdvancementProgress(advancement);
    }

    /**
     * Get the advancement which has been affected.
     *
     * @return affected advancement
     */
    @NotNull
    public Advancement getAdvancement() {
        return advancement;
    }

    /**
     * Get the criterion which has been granted.
     *
     * @return granted criterion
     */
    @NotNull
    public String getCriterion() {
        return criterion;
    }

    public boolean isCancelled() {
        return cancel;
    }

    /**
     * Gets the current AdvancementProgress.
     * See {@link PlayerAdvancementCriterionGrantEvent}
     *
     * @return advancement progress
     */
    @NotNull
    public AdvancementProgress getAdvancementProgress() {
        return advancementProgress;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
