package me.quickscythe.quipt.api.events;

import me.quickscythe.quipt.api.QuiptIntegration;

public interface QuiptEvent {

    void process(QuiptIntegration integration);
}
