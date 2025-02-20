package com.quiptmc.core.events.listeners;

import com.quiptmc.core.events.*;

/**
 * Represents a listener for Quipt events.
 */
public abstract class Listener<T extends QuiptEvent> {

    private final Class<T> type;

    public Listener(Class<T> type){
        this.type = type;
    }

    public Class<T> type(){
        return type;
    }

    public abstract static class QuiptPlayerLeaveListener extends Listener<QuiptPlayerLeaveEvent> {

        public QuiptPlayerLeaveListener(){
            super(QuiptPlayerLeaveEvent.class);
        }

        public abstract void onPlayerLeave(QuiptPlayerLeaveEvent event);
    }

    public abstract static class QuiptPlayerDeathEventListener extends Listener<QuiptPlayerDeathEvent> {

        public QuiptPlayerDeathEventListener(){
            super(QuiptPlayerDeathEvent.class);
        }

        public abstract void onPlayerDeath(QuiptPlayerDeathEvent event);
    }

    public abstract static class QuiptPlayerChatListener extends Listener<QuiptPlayerChatEvent> {

        public QuiptPlayerChatListener(){
            super(QuiptPlayerChatEvent.class);
        }

        public abstract void onPlayerChat(QuiptPlayerChatEvent event);
    }

    public abstract static class QuiptPlayerJoinListener extends Listener<QuiptPlayerJoinEvent> {

        public QuiptPlayerJoinListener(){
            super(QuiptPlayerJoinEvent.class);
        }

        public abstract void onPlayerJoin(QuiptPlayerJoinEvent event);
    }

}