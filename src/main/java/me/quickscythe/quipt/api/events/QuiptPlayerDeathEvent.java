package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.entity.QuiptPlayer;
import me.quickscythe.quipt.api.events.listeners.Listener;
import org.eclipse.jgit.annotations.Nullable;

public record QuiptPlayerDeathEvent(QuiptPlayer player, @Nullable QuiptPlayer killer, String message) implements QuiptEvent {
    @Override
    public Class<? extends Listener> listener() {
        return Listener.QuiptPlayerDeathEventListener.class;
    }
}
