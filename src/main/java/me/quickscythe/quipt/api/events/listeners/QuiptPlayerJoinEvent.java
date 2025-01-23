package me.quickscythe.quipt.api.events.listeners;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.entity.QuiptPlayer;
import me.quickscythe.quipt.api.events.QuiptEvent;

public class QuiptPlayerJoinEvent implements QuiptEvent {

    QuiptPlayer player;
    String message;

    public QuiptPlayerJoinEvent(QuiptPlayer player, String message) {
        this.player = player;
        this.message = message;
    }

    @Override
    public void process(QuiptIntegration integration) {
        System.out.println(player.name() + " joined the game with message: " + message);
    }
}
