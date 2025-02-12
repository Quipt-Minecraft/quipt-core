package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.events.listeners.Listener;

/**
 * Represents a Quipt event.
 */
public interface QuiptEvent {

    /**
     * Returns the listener class associated with this event.
     *
     * @return the listener class associated with this event
     */
    Class<? extends Listener> listener();

}