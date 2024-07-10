package org.sayari.kaddem.services.impl;

import org.sayari.kaddem.entity.Departement;
import org.sayari.kaddem.entity.Universite;
import org.sayari.kaddem.repostries.DepartmentRepo;
import org.sayari.kaddem.repostries.UniversiteRepo;
import org.sayari.kaddem.services.interf.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UniversiteService implements IUniversiteService {
    @Autowired
    private UniversiteRepo universiteRepo ;
    @Autowired
    private DepartmentRepo departmentRepo ;


    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        Set<Departement> departementListt = u.getDepartementSet();
        for(Departement dep :departementListt){
         departmentRepo.save(dep);
         dep.setUniversite(u);
        }
        return universiteRepo.save(u);

    }

    @Override
    public Universite updateUniversite(Universite u) {
        Optional<Universite> universitexist = universiteRepo.findById(u.getIdDepart());
        if(universitexist.isPresent()){
            return universiteRepo.save(u);
        }
        return null;
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement){
        Universite u = universiteRepo.findById(idUniversite).get();
        Departement d = departmentRepo.findById(idDepartement).get();
        u.getDepartementSet().add(d);
        universiteRepo.save(u);

    }

}
