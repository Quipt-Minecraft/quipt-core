package me.quickscythe.quipt.api.events.listeners;

import me.quickscythe.quipt.api.events.QuiptEvent;

public interface Listener {

    void process(QuiptEvent event);
}
