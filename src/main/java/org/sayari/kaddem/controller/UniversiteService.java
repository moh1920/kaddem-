package org.sayari.kaddem.controller;

import org.sayari.kaddem.entity.Universite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/universite")
public class UniversiteService {
    @Autowired
    private UniversiteService universiteService;

    @GetMapping("/getAll")
    public List<Universite> retrieveAllUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    @PostMapping("/create")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @PostMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u) {
        return universiteService.updateUniversite(u);
    }

    @GetMapping("/getById")
    public Universite retrieveUniversite(@RequestParam Integer idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }


}
