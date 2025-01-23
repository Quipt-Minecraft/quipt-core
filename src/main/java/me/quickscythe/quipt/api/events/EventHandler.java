package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.events.listeners.Listener;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {

    private final QuiptIntegration integration;
    private final List<Listener> listeners = new ArrayList<>();

    public EventHandler(QuiptIntegration integration){
        this.integration = integration;
    }

    public void register(Listener listener){
        listeners.add(listener);
    }

    public void handle(QuiptEvent event){
        for(Listener listener : listeners){
            if(event.listener().isAssignableFrom(listener.getClass())){
                if(listener instanceof Listener.QuiptPlayerJoinListener joinListener) joinListener.onPlayerJoin((QuiptPlayerJoinEvent) event);
                if(listener instanceof Listener.QuiptPlayerLeaveListener leaveListener) leaveListener.onPlayerLeave((QuiptPlayerLeaveEvent) event);
                if(listener instanceof Listener.QuiptPlayerDeathEventListener deathListener) deathListener.onPlayerDeath((QuiptPlayerDeathEvent) event);
                if(listener instanceof Listener.QuiptPlayerChatListener chatListener) chatListener.onPlayerChat((QuiptPlayerChatEvent) event);
            }
        }
    }
}
