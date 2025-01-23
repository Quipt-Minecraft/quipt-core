package me.quickscythe.quipt.api.events.listeners;

import me.quickscythe.quipt.api.events.*;

public interface Listener {

    void process(QuiptEvent event);

    interface QuiptPlayerLeaveListener extends Listener {

        default void process(QuiptEvent event){
            if(event instanceof QuiptPlayerLeaveEvent){
                onPlayerLeave((QuiptPlayerLeaveEvent) event);
            }
        }

        void onPlayerLeave(QuiptPlayerLeaveEvent event);

    }

    interface QuiptPlayerDeathEventListener extends Listener {

        default void process(QuiptEvent event){
            if(event instanceof QuiptPlayerDeathEvent){
                onPlayerDeath((QuiptPlayerDeathEvent) event);
            }
        }

        void onPlayerDeath(QuiptPlayerDeathEvent event);

    }

    interface QuiptPlayerChatListener extends Listener {

        default void process(QuiptEvent event){
            if(event instanceof QuiptPlayerChatEvent){
                onPlayerChat((QuiptPlayerChatEvent) event);
            }
        }

        void onPlayerChat(QuiptPlayerChatEvent event);

    }



    interface QuiptPlayerJoinListener extends Listener {

        default void process(QuiptEvent event){
            if(event instanceof QuiptPlayerJoinEvent){
                onPlayerJoin((QuiptPlayerJoinEvent) event);
            }
        }

        void onPlayerJoin(QuiptPlayerJoinEvent event);

    }
}
