package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.entity.QuiptPlayer;
import me.quickscythe.quipt.api.events.listeners.Listener;
import me.quickscythe.quipt.api.events.listeners.QuiptPlayerJoinListener;

public class QuiptPlayerJoinEvent implements QuiptEvent {

    QuiptPlayer player;
    String message;
    Class<? extends Listener> listenerClass = QuiptPlayerJoinListener.class;

    public QuiptPlayerJoinEvent(QuiptPlayer player, String message) {
        this.player = player;
        this.message = message;
    }


    @Override
    public Class<? extends Listener> listener() {
        return listenerClass;
    }
}
