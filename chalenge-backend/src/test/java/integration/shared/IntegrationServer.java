package integration.shared;

import br.com.munieri.boot.server.ApplicationServer;
import br.com.munieri.boot.server.WebServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class IntegrationServer {

    WebServer server;
    protected int jettyPort;

    @BeforeMethod(alwaysRun = true)
    public void init() throws Exception {
        server = new ApplicationServer();
        server.start();
        jettyPort = server.portNUmber();
    }

    @AfterMethod(alwaysRun = true)
    public void destroy() throws Exception {
        server.stop();
    }
}