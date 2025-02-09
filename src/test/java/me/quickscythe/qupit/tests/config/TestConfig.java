package me.quickscythe.qupit.tests.config;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.config.Config;
import me.quickscythe.quipt.api.config.ConfigTemplate;
import me.quickscythe.quipt.api.config.ConfigValue;
import org.json.JSONArray;

import java.io.File;

@ConfigTemplate(name = "test_config", ext = ConfigTemplate.Extension.QPT)
public class TestConfig extends Config {

    @ConfigValue
    public String testValue = "me/quickscythe/quipt/test";

    @ConfigValue
    public int testInt = 1;

    @ConfigValue
    public boolean testBool = true;

    @ConfigValue
    public double testDouble = 1.0;

    @ConfigValue
    public float testFloat = 1.0f;

    @ConfigValue
    public long testLong = 1L;


    @ConfigValue
    public JSONArray testArray = new JSONArray().put(1).put("me/quickscythe/quipt/test");

    @ConfigValue
    public TestNestedConfig<?> testConfig = null;

    /**
     * Creates a new config file
     *
     * @param file        The file to save to
     * @param name        The name of the config
     * @param extension   The extension of the config
     * @param integration The plugin that owns this config
     */
    public TestConfig(File file, String name, ConfigTemplate.Extension extension, QuiptIntegration integration) {
        super(file, name, extension, integration);
    }

    /**
     * Creates a new config file
     *
     * @param file        The file to save to
     * @param name        The name of the config
     * @param integration The plugin that owns this config
     */
}
