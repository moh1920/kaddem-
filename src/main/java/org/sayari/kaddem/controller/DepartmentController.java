package org.sayari.kaddem.controller;

import org.sayari.kaddem.entity.Departement;
import org.sayari.kaddem.services.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService ;

    @GetMapping("getAll")
    public List<Departement> retrieveAllDepartements() {
        return departmentService.retrieveAllDepartements() ;
    }

    @PostMapping("/create")
    public Departement addDepartement(@RequestBody  Departement d) {
        return departmentService.addDepartement(d);
    }


    @PostMapping("/update")
    public Departement updateDepartement(@RequestBody Departement d) {;
        return departmentService.updateDepartement(d);
    }

    @GetMapping("/getById")
    public Departement retrieveDepartement(Integer idDepart) {
        return departmentService.retrieveDepartement(idDepart);
    }


}
