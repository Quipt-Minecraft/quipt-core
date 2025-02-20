package com.quiptmc.core.events;

import com.quiptmc.core.QuiptIntegration;
import com.quiptmc.core.events.listeners.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the registration and dispatching of Quipt events to their respective listeners.
 */
public class EventHandler {

    private final QuiptIntegration integration;
    private final List<Listener<? extends QuiptEvent>> listeners = new ArrayList<>();

    /**
     * Constructs an EventHandler with the specified QuiptIntegration.
     *
     * @param integration the QuiptIntegration instance
     */
    public EventHandler(QuiptIntegration integration) {
        this.integration = integration;
    }

    /**
     * Registers a listener to receive events.
     *
     * @param listener the listener to register
     */
    public void register(Listener<? extends QuiptEvent> listener) {
        listeners.add(listener);
    }

    /**
     * Handles the specified event by dispatching it to the appropriate listener.
     *
     * @param event the event to handle
     */
    public void handle(QuiptEvent event) {
        System.out.println("Handling event: " + event);
        for (Listener<? extends QuiptEvent> listener : listeners) {
            System.out.println("Checking listener: " + listener);
            if (listener.type().isAssignableFrom(event.getClass())) {
                System.out.println("Dispatching event to listener: " + listener);
                handleEvent(event, listener);
            }
        }
    }

    /**
     * Dispatches the specified event to the appropriate listener.
     *
     * @param event the event to dispatch
     * @param listener the listener to dispatch the event to
     */
    private void handleEvent(QuiptEvent event, Listener listener) {
        if (listener instanceof Listener.QuiptPlayerJoinListener joinListener) {
            joinListener.onPlayerJoin((QuiptPlayerJoinEvent) event);
        } else if (listener instanceof Listener.QuiptPlayerLeaveListener leaveListener) {
            leaveListener.onPlayerLeave((QuiptPlayerLeaveEvent) event);
        } else if (listener instanceof Listener.QuiptPlayerDeathEventListener deathListener) {
            deathListener.onPlayerDeath((QuiptPlayerDeathEvent) event);
        } else if (listener instanceof Listener.QuiptPlayerChatListener chatListener) {
            chatListener.onPlayerChat((QuiptPlayerChatEvent) event);
        }
    }
}