package me.quickscythe.quipt.api.server;


import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class QuiptHandler extends ServletContextHandler {

    QuiptServer server;

    public QuiptHandler(QuiptServer server) {
        super(SESSIONS);
        this.server = server;
        server.setHandler(this);
    }

    public QuiptServer server() {
        return server;
    }

    public void handle(String name, QuiptServlet servlet, String path) {
        path = path.startsWith("/") ? path.substring(1) : path;
        String url = server.config().address();
        addServlet(new ServletHolder(name, servlet), "/" + path);
        server.integration().logger().log("Added servlet %s at: %s/%s", name, url, path);
    }

}
