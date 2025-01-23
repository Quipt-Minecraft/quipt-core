/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.quickscythe.quipt.api;

import me.quickscythe.quipt.api.events.EventHandler;

import java.io.File;

/**
 * The main interface for the plugin
 */
public abstract class QuiptIntegration {

    private final EventHandler handler;

    public QuiptIntegration(){
        handler = new EventHandler(this);
    }

    public final EventHandler events(){
        return handler;
    }


    abstract void enable();

    /**
     * Log a message to the console
     *
     * @param quiptConfig The config that the message is from
     * @param s           The message to log
     */
    public abstract void log(String quiptConfig, String s);

    /**
     * Get the data folder for the plugin
     *
     * @return The data folder
     */
    public abstract File dataFolder();

    /**
     * Get the name of the plugin
     *
     * @return The name of the plugin
     */
    public abstract String name();
}
