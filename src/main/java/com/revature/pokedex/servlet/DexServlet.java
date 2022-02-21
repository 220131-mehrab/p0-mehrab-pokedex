package com.revature.pokedex.servlet;

import com.revature.pokedex.domain.Pokemon;
import com.revature.pokedex.service.PokedexService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DexServlet extends HttpServlet {
    PokedexService service;

    public DexServlet(PokedexService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput = req.getParameter("searchName");
        resp.getWriter().println(service.searchForm());

        List<Pokemon> results = new ArrayList<>();
        if (userInput != null) {
            results.add(service.getPokemon(userInput));
        } else {
            results.addAll(service.getPokemon());
        }
        for (Pokemon p : results)
            resp.getWriter().println(p + "<br/>");
    }
}
