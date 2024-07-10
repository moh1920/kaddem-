package org.sayari.kaddem.controller;

import org.sayari.kaddem.entity.Contrat;
import org.sayari.kaddem.services.impl.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    public ContratService contratService;
    @GetMapping("getAll")
    public List<Contrat> retrieveAllContrats(){
        return contratService.retrieveAllContrats();
    }
    @PostMapping("/update")
    public Contrat updateContrat (@RequestBody Contrat ce){
        return contratService.updateContrat(ce);
    }   
    @PostMapping("/addcontrat")
    public Contrat addContrat (@RequestBody Contrat ce){
        return contratService.addContrat(ce);
    }
    @GetMapping("/getById")
    public Contrat retrieveContrat (@RequestParam Integer idContrat){
        return contratService.retrieveContrat(idContrat);
    }
    @DeleteMapping("/delete")
    void removeContrat(@RequestParam Integer idContrat){
        contratService.removeContrat(idContrat);
    }



}
