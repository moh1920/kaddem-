package org.sayari.kaddem.services.interf;

import org.sayari.kaddem.entity.Departement;

import java.util.List;

public interface IDepartmentService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement (Departement d);
    Departement updateDepartement (Departement d);
    Departement retrieveDepartement (Integer idDepart);
}
