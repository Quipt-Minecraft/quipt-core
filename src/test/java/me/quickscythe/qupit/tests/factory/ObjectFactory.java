package me.quickscythe.qupit.tests.factory;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.config.ConfigManager;
import me.quickscythe.qupit.tests.config.TestConfig;
import me.quickscythe.qupit.tests.config.TestNestedConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Optional;

public class ObjectFactory {


    public static QuiptIntegration createIntegration(){
        return createIntegration("TestIntegration", "test_data");
    }

    public static QuiptIntegration createIntegration(String name, String folderPath){
        return new QuiptIntegration() {

            final Logger logger = LoggerFactory.getLogger(this.getClass());
            File file = new File(folderPath);


            @Override
            public void enable() {

                if (!file.exists())
                    log("TestIntegration", "Data folder does not exist. Creating... " + (file.mkdirs() ? "Success" : "Failed"));

                TestConfig config = ConfigManager.registerConfig(this, TestConfig.class);
                config.testConfig = ConfigManager.getNestedConfig(config, TestNestedConfig.class, "testConfig");
                config.save();
                log("TestIntegration", "Enabled");

            }

            @Override
            public void log(String format, String args) {
                logger.info(format, args);
            }


            @Override
            public File dataFolder() {
                return file;
            }

            @Override
            public String name() {
                return name;
            }

        };
    }
}
