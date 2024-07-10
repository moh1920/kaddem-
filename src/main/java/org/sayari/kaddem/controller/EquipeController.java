package org.sayari.kaddem.controller;

import org.sayari.kaddem.entity.Equipe;
import org.sayari.kaddem.services.impl.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    private EquipeService equipeService ;
    @GetMapping("/getAll")
    public List<Equipe> retrieveAllEquipes() {
        return equipeService.retrieveAllEquipes();
    }

    @PostMapping("/create")
    public Equipe addEquipe(Equipe e) {
        return equipeService.addEquipe(e);
    }

    @PostMapping("/update")
    public Equipe updateEquipe(Equipe e) {
        return equipeService.updateEquipe(e);
    }

    @GetMapping("/getById")
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeService.retrieveEquipe(idEquipe);
    }
}
