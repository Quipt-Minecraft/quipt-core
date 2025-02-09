package me.quickscythe.qupit.tests;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.quickscythe.quipt.api.QuiptIntegration;
import me.quickscythe.quipt.api.messages.Message;
import me.quickscythe.quipt.api.registries.Registries;
import me.quickscythe.quipt.api.registries.Registry;
import me.quickscythe.quipt.api.server.QuiptHandler;
import me.quickscythe.quipt.api.server.QuiptServer;
import me.quickscythe.quipt.api.server.QuiptServlet;
import me.quickscythe.qupit.tests.factory.ObjectFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
//        QuiptIntegration testIntegration = ObjectFactory.createIntegration();
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


        Registry<Message> messages = Registries.add("messages", new Registry<>());
        messages.register("test", new Message("Hello, World!"));

        messages.get("test").send();



    }
}
