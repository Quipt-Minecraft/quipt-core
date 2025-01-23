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
                if(event.listener().equals(Listener.QuiptPlayerJoinListener.class)) ((Listener.QuiptPlayerJoinListener) listener).onPlayerJoin((QuiptPlayerJoinEvent) event);
                if(event.listener().equals(Listener.QuiptPlayerLeaveListener.class)) ((Listener.QuiptPlayerLeaveListener) listener).onPlayerLeave((QuiptPlayerLeaveEvent) event);
                if(event.listener().equals(Listener.QuiptPlayerDeathEventListener.class)) ((Listener.QuiptPlayerDeathEventListener) listener).onPlayerDeath((QuiptPlayerDeathEvent) event);
                if(event.listener().equals(Listener.QuiptPlayerChatListener.class)) ((Listener.QuiptPlayerChatListener) listener).onPlayerChat((QuiptPlayerChatEvent) event);
            }
        }
    }
}
