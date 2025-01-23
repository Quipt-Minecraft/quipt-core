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
            System.out.println("Checking listener: " + listener.getClass().getName() + " for event: " + event.listener().getName());
            if(event.listener().equals(listener.getClass())){
                System.out.println("Processing event: " + event.getClass().getName() + " with listener: " + listener.getClass().getName());
                listener.process(event);
            }
        }
    }
}
