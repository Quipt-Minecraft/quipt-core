package me.quickscythe.quipt.api.logger;

import me.quickscythe.quipt.api.QuiptPlugin;

import java.util.logging.Logger;


/**
 * Represents a logger
 */
public class QuiptLogger {

    QuiptPlugin plugin;

    /**
     * Creates a new logger
     *
     * @param plugin The plugin that owns this logger
     */
    public QuiptLogger(QuiptPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Logs a message
     *
     * @param message The message to log
     */
    public void log(String message) {
        Logger.getLogger(plugin.name()).info(message);
    }

    /**
     * Logs a message with arguments
     *
     * @param message The message to log
     * @param args    The arguments to format the message with
     */
    public void log(String message, Object... args) {
        Logger.getLogger(plugin.name()).info(message.formatted(args));
    }

    /**
     * Logs a warning
     *
     * @param message The warning to log
     */
    public void warn(String message) {
        Logger.getLogger(plugin.name()).warning(message);
    }

    /**
     * Logs a warning with arguments
     *
     * @param message The warning to log
     * @param args    The arguments to format the warning with
     */
    public void warn(String message, Object... args) {
        Logger.getLogger(plugin.name()).warning(message.formatted(args));
    }

    /**
     * Logs an error
     *
     * @param message The error to log
     */
    public void error(String message) {
        Logger.getLogger(plugin.name()).severe(message);
    }

    /**
     * Logs an error with arguments
     *
     * @param message The error to log
     * @param args    The arguments to format the error with
     */
    public void error(String message, Object... args) {
        Logger.getLogger(plugin.name()).severe(message.formatted(args));
    }

    /**
     * Logs an error with a throwable
     *
     * @param message   The error to log
     * @param throwable The throwable to log
     */
    public void error(String message, Throwable throwable) {
        Logger.getLogger(plugin.name()).severe(message);
        throwable.printStackTrace();
    }

    /**
     * Logs an error with a throwable and arguments
     *
     * @param message   The error to log
     * @param throwable The throwable to log
     * @param args      The arguments to format the error with
     */
    public void error(String message, Throwable throwable, Object... args) {
        Logger.getLogger(plugin.name()).severe(message.formatted(args));
        throwable.printStackTrace();
    }

    /**
     * Logs a debug message
     *
     * @param message The debug message to log
     */
    public void debug(String message) {
        Logger.getLogger(plugin.name()).fine(message);
    }

    /**
     * Logs a debug message with arguments
     *
     * @param message The debug message to log
     * @param args    The arguments to format the debug message with
     */
    public void debug(String message, Object... args) {
        Logger.getLogger(plugin.name()).fine(message.formatted(args));
    }

    /**
     * Logs a trace message
     *
     * @param message The trace message to
     */
    public void trace(String message) {
        Logger.getLogger(plugin.name()).finest(message);
    }

    /**
     * Logs a trace message with arguments
     *
     * @param message The trace message to log
     * @param args    The arguments to format the trace message with
     */
    public void trace(String message, Object... args) {
        Logger.getLogger(plugin.name()).finest(message.formatted(args));
    }


}
