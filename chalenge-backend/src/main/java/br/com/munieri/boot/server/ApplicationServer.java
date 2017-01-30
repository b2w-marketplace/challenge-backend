package br.com.munieri.boot.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

public class ApplicationServer implements WebServer {

    private static final String CONFIG_LOCATION = "br.com.munieri.boot";
    public static final String RESOURCE_BASE = "src/main/webapp/";

    public static final int DEFAULT_PORT = 8080;
    public static final String CONTEXT_PATH = "/";

    public static final String MAPPING_URL = "/*";
    public static final String DEFAULT_PROFILE = "staging";

    public static final int IDLE_TIMEOUT = 30000;

    private Server server;
    private int jettyPort;

    public void start() throws Exception {
        start(DEFAULT_PORT);
    }

    public int portNUmber() {
        return jettyPort;
    }

    public void start(int port) throws Exception {
        ThreadPool threadPool = configThreadPool();
        configServer(port, threadPool);
        startServer();

        ServerConnector connector = (ServerConnector) server.getConnectors()[0];
        jettyPort = connector.getLocalPort();
    }

    private QueuedThreadPool configThreadPool() {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setMaxThreads(100);
        return threadPool;
    }

    private void startServer() throws Exception {
        server.start();
    }

    private void configServer(int port, ThreadPool threadPool) throws Exception {
        server = new Server(threadPool);
        server.setHandler(getServletContextHandler(getContext()));
        server.setConnectors(new Connector[]{getHttpConnector(port)});
    }

    public void stop() throws Exception {
        server.stop();
        server.destroy();
    }


    private Connector getHttpConnector(Integer port) {
        HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory();
        ServerConnector http = new ServerConnector(server, httpConnectionFactory);
        http.setPort(port);
        http.setIdleTimeout(IDLE_TIMEOUT);

        return http;
    }

    private WebAppContext getServletContextHandler(WebApplicationContext context) throws
            IOException {
        WebAppContext webApp = new WebAppContext();
        webApp.setContextPath(CONTEXT_PATH);
        webApp.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        webApp.addEventListener(new ContextLoaderListener(context));
        webApp.setResourceBase(RESOURCE_BASE);
        return webApp;
    }

    private WebApplicationContext getContext() throws IOException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        context.getEnvironment().setDefaultProfiles(DEFAULT_PROFILE);

        return context;
    }
}

