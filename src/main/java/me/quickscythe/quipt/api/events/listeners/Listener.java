package me.quickscythe.quipt.api.events.listeners;

import me.quickscythe.quipt.api.events.*;

public interface Listener {


    interface QuiptPlayerLeaveListener extends Listener {

        void onPlayerLeave(QuiptPlayerLeaveEvent event);

    }

    interface QuiptPlayerDeathEventListener extends Listener {

        void onPlayerDeath(QuiptPlayerDeathEvent event);

    }

    interface QuiptPlayerChatListener extends Listener {

        void onPlayerChat(QuiptPlayerChatEvent event);

    }



    interface QuiptPlayerJoinListener extends Listener {

        void onPlayerJoin(QuiptPlayerJoinEvent event);

    }
}
