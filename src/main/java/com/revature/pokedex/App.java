package com.revature.pokedex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {
        DexRepository dexRepository = new DexRepository("pokedex.csv");
        DexService dexService = new DexService(dexRepository);

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "dexServlet", dexService).addMapping("/");
        try {
            server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
