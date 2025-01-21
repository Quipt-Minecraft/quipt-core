/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package me.quickscythe.quipt.api.config;

import me.quickscythe.quipt.api.QuiptPlugin;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Represents a config file
 */
public abstract class Config {

    private final File file;
    private final String name;
    private final QuiptPlugin plugin;

    /**
     * Version of the config
     */
    @ConfigValue(override = true)
    public Number version = 1;

    /**
     * Creates a new config file
     *
     * @param file   The file to save to
     * @param name   The name of the config
     * @param plugin The plugin that owns this config
     */
    public Config(File file, String name, QuiptPlugin plugin) {
        this.file = file;
        this.name = name;
        this.plugin = plugin;
    }

    /**
     * File this config is saved to
     * @return The file this config is saved to
     */
    public File file() {
        return file;
    }

    /**
     * Name of this config
     * @return The name of this config
     */
    public String name() {
        return name;
    }

    /**
     * Saves the config
     */
    public void save() {
        ConfigManager.saveConfig(this);
    }

    /**
     * Gets the fields annotated with @ConfigValue
     * @return The fields annotated with @ConfigValue
     */
    Field[] getContentValues() {
        return Arrays.stream(this.getClass().getFields()).filter(f -> f.isAnnotationPresent(ConfigValue.class)).toArray(Field[]::new);
    }

    /**
     * Converts this config to a JSON object
     * @return a new JSON object
     */
    public JSONObject json() {
        JSONObject data = new JSONObject();
        for (Field field : getContentValues()) {
            try {
                data.put(field.getName(), field.get(this));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return data;
    }

    /**
     * Plugin that owns this config
     * @return The plugin that owns this config
     */
    public QuiptPlugin plugin() {
        return plugin;
    }
}
