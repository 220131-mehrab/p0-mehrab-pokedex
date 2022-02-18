package com.revature.pokedex;

import com.revature.pokedex.repository.DexRepository;
import com.revature.pokedex.repository.SQLDexRepository;
import com.revature.pokedex.servlet.DefaultServlet;
import com.revature.pokedex.servlet.DexServlet;
import com.revature.pokedex.service.PokedexService;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) {
        // Setting contextpath, URL paths are less complex with a blank name
        String webAppName = "";

        // Creating a object graph with dependency injections
        DexRepository dexRepository;
        //dexRepository = new CSVDexRepository("pokedex.csv");
        //dexRepository = new InMemoryDexRepository();
        dexRepository = new SQLDexRepository();
        PokedexService pokedexService = new PokedexService(dexRepository);

        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(0);
        server.getConnector();
        server.addContext(webAppName, null);

        server.addServlet(webAppName, "defaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webAppName, "dexServlet", new DexServlet(pokedexService)).addMapping("/pokemon");

        try {
            server.start();
            System.out.println("Server running on http://localhost:" + server.getConnector().getLocalPort());
            server.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
