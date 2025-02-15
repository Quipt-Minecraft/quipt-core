package me.quickscythe.qupit.tests.config;

import com.quiptmc.core.QuiptIntegration;
import com.quiptmc.core.config.ConfigTemplate;

import java.io.File;

@ConfigTemplate(name = "test_config", ext = ConfigTemplate.Extension.XML)
public class TestConfigXml extends TestConfig{
    /**
     * Creates a new config file
     *
     * @param file        The file to save to
     * @param name        The name of the config
     * @param extension   The extension of the config
     * @param integration The plugin that owns this config
     */
    public TestConfigXml(File file, String name, ConfigTemplate.Extension extension, QuiptIntegration integration) {
        super(file, name, extension, integration);
    }
}
