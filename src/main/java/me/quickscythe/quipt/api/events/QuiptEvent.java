package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.events.listeners.Listener;

public interface QuiptEvent {

    Class<? extends Listener> listener();

}
