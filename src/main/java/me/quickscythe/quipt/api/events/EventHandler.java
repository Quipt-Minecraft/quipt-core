package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.QuiptIntegration;

public class EventHandler {

    QuiptIntegration integration;

    public EventHandler(QuiptIntegration integration){
        this.integration = integration;
    }

    public void handle(QuiptEvent event){
        event.process(integration);
    }
}
