package me.quickscythe.quipt.api.logger;

import me.quickscythe.quipt.api.QuiptPlugin;

import java.util.logging.Logger;

public class QuiptLogger {

    QuiptPlugin plugin;

    public QuiptLogger(QuiptPlugin plugin) {
        this.plugin = plugin;
    }

    public void log(String message) {
        Logger.getLogger(plugin.name()).info(message);
    }

    public void log(String message, Object... args) {
        Logger.getLogger(plugin.name()).info(message.formatted(args));
    }

    public void warn(String message) {
        Logger.getLogger(plugin.name()).warning(message);
    }

    public void warn(String message, Object... args) {
        Logger.getLogger(plugin.name()).warning(message.formatted(args));
    }

    public void error(String message) {
        Logger.getLogger(plugin.name()).severe(message);
    }

    public void error(String message, Object... args) {
        Logger.getLogger(plugin.name()).severe(message.formatted(args));
    }

    public void error(String message, Throwable throwable) {
        Logger.getLogger(plugin.name()).severe(message);
        throwable.printStackTrace();
    }

    public void error(String message, Throwable throwable, Object... args) {
        Logger.getLogger(plugin.name()).severe(message.formatted(args));
        throwable.printStackTrace();
    }

    public void debug(String message) {
        Logger.getLogger(plugin.name()).fine(message);
    }

    public void debug(String message, Object... args) {
        Logger.getLogger(plugin.name()).fine(message.formatted(args));
    }

    public void trace(String message) {
        Logger.getLogger(plugin.name()).finest(message);
    }

    public void trace(String message, Object... args) {
        Logger.getLogger(plugin.name()).finest(message.formatted(args));
    }




}
