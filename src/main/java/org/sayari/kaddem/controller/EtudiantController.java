package org.sayari.kaddem.controller;

import org.sayari.kaddem.entity.Etudiant;
import org.sayari.kaddem.services.impl.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/saveEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }
    @GetMapping("/getById")
    public Optional<Etudiant> retrieveEtudiant(@RequestParam Integer id) {
        return etudiantService.getEtudiantById(id);
    }
    @GetMapping("/getAll")
    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantService.retrieveAllEtudiants();
    }
    @PostMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody  Etudiant etudiant){
        return etudiantService.updateEtudiant(etudiant);
    }
    @DeleteMapping("/deleteEtudiant")
    void deleteEtudiant( @RequestParam Integer id){
        etudiantService.removeEtudiant(id);
    }


}

