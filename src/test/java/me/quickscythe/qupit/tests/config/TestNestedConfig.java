package me.quickscythe.qupit.tests.config;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.config.Config;
import me.quickscythe.quipt.api.config.ConfigTemplate;
import me.quickscythe.quipt.api.config.ConfigValue;
import me.quickscythe.quipt.api.config.NestedConfig;
import org.json.JSONArray;

@ConfigTemplate(name = "nested")
public class TestNestedConfig<T extends Config> extends NestedConfig<T> {

    @ConfigValue
    public String nestedValue = "nestedValue";

    @ConfigValue
    public int nestedInt = 1;

    @ConfigValue
    public JSONArray nestedTestArray = new JSONArray().put(1).put("me/quickscythe/quipt/test");


    /**
     * Creates a new config file
     *
     * @param parent      The Config instance that holds this nested config.
     * @param name        The name of the config
     * @param integration The plugin that owns this config
     */
    public TestNestedConfig(T parent, String name, QuiptIntegration integration) {
        super(parent, name, integration);
    }
}
