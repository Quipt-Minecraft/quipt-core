package me.quickscythe.qupit.tests;

import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.config.ConfigManager;
import me.quickscythe.qupit.tests.config.TestConfigYaml;
import me.quickscythe.qupit.tests.config.TestNestedConfig;
import me.quickscythe.qupit.tests.factory.ObjectFactory;

public class Main {

    public static void main(String[] args) {
        QuiptIntegration testIntegration = ObjectFactory.createIntegration();
//        QuiptServer server = new QuiptServer(testIntegration, new QuiptServer.ServerConfig(QuiptServer.ServerProtocol.HTTP, "127.0.0.1", 8765));
//
//        server.handler().handle("test", new QuiptServlet(server) {
//            @Override
//            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                System.out.println("HANDLE?!");
//                resp.getWriter().write("Hello, World!");
//            }
//        }, "test");
//
//        server.start();

        TestConfigYaml yaml = ConfigManager.registerConfig(testIntegration, TestConfigYaml.class);
        yaml.testConfig = ConfigManager.getNestedConfig(yaml, TestNestedConfig.class, "testConfig");
        yaml.save();




    }
}
