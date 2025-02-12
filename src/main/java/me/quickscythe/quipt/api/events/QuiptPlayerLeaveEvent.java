package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.entity.QuiptPlayer;
import me.quickscythe.quipt.api.events.listeners.Listener;

/**
 * Event triggered when a player leaves the Quipt system.
 *
 * @param player the player who is leaving
 * @param message the message associated with the player's departure
 */
public record QuiptPlayerLeaveEvent(QuiptPlayer player, String message) implements QuiptEvent {

    /**
     * Returns the listener class associated with this event.
     *
     * @return the listener class associated with this event
     */
    @Override
    public Class<? extends Listener> listener() {
        return Listener.QuiptPlayerLeaveListener.class;
    }
}