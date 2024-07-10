package org.sayari.kaddem.services.impl;

import org.sayari.kaddem.entity.Departement;
import org.sayari.kaddem.repostries.DepartmentRepo;
import org.sayari.kaddem.services.interf.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {


    @Autowired
    private DepartmentRepo departmentRepo ;
    @Override
    public List<Departement> retrieveAllDepartements() {
        return departmentRepo.findAll() ;
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departmentRepo.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        Optional<Departement> depatmentexist = departmentRepo.findById(d.getIdDepart());
        if(depatmentexist.isPresent()){
            return departmentRepo.save(d);
        }
        return null;
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
             return departmentRepo.findById(idDepart).orElse(null);
    }
}
