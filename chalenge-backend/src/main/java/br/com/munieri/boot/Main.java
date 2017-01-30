package br.com.munieri.boot;

import br.com.munieri.boot.server.ApplicationServer;
import br.com.munieri.boot.server.WebServer;

public class Main {

    public static void main(String... args) throws Exception {

        WebServer server = new ApplicationServer();
        server.start();
    }
}
