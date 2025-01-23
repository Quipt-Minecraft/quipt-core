package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.entity.QuiptPlayer;
import me.quickscythe.quipt.api.events.listeners.Listener;

public record QuiptPlayerLeaveEvent(QuiptPlayer player, String message) implements QuiptEvent {
    @Override
    public Class<? extends Listener> listener() {
        return Listener.QuiptPlayerLeaveListener.class;
    }
}
