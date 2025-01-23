package me.quickscythe.quipt.api.events.listeners;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.config.Config;
import me.quickscythe.quipt.api.config.ConfigManager;
import me.quickscythe.quipt.api.entity.QuiptPlayer;
import me.quickscythe.quipt.api.events.QuiptEvent;
import me.quickscythe.quipt.api.events.QuiptPlayerJoinEvent;
import org.json.JSONObject;

public interface QuiptPlayerJoinListener extends Listener {

    default void process(QuiptEvent event){
        if(event instanceof QuiptPlayerJoinEvent){
            onPlayerJoin((QuiptPlayerJoinEvent) event);
        }
    }

    void onPlayerJoin(QuiptPlayerJoinEvent event);

}
