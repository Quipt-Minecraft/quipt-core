package me.quickscythe.quipt.api.server;

import me.quickscythe.quipt.api.QuiptIntegration;
import org.eclipse.jetty.server.Server;

public class QuiptServer extends Server {

    private final QuiptIntegration integration;
    private final QuiptHandler handler;
    private final ServerConfig config;

    public QuiptServer(QuiptIntegration integration, ServerConfig config) {
        super(config.port());
        this.integration = integration;
        this.handler = new QuiptHandler(this);
        this.config = config;
        handle(handler);
    }

    public QuiptHandler handler(){
        return handler;
    }

    public QuiptIntegration integration(){
        return integration;
    }

    private void handle(QuiptHandler handler) {
        setHandler(handler);
    }

    public ServerConfig config() {
        return config;
    }

    public record ServerConfig(ServerProtocol protocol, String host, int port) {

        public String address(){
            return protocol().prefix() + host() + ":" + port();
        }

    }
    
    public enum ServerProtocol {
        HTTP("http://"), HTTPS("https://");

        final String prefix;

        ServerProtocol(String prefix) {
            this.prefix = prefix;
        }

        public String prefix() {
            return prefix;
        }
    }
}
