package org.sayari.kaddem.services.impl;

import org.sayari.kaddem.entity.Contrat;
import org.sayari.kaddem.entity.Departement;
import org.sayari.kaddem.entity.Equipe;
import org.sayari.kaddem.entity.Etudiant;
import org.sayari.kaddem.repostries.ContratRepo;
import org.sayari.kaddem.repostries.DepartmentRepo;
import org.sayari.kaddem.repostries.EquipeRepo;
import org.sayari.kaddem.repostries.EtudiantRepo;
import org.sayari.kaddem.services.interf.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService  implements IEtudiantService {

    @Autowired
    private EtudiantRepo etudiantRepo ;
    @Autowired
    private DepartmentRepo departmentRepo ;
    @Autowired
    private ContratRepo contratRepo;
    @Autowired
    private EquipeRepo equipeRepo ;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
       List<Etudiant> etudiants = new ArrayList<Etudiant>();
       etudiantRepo.findAll().forEach(etudiants::add);
       return etudiants ;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
       return etudiantRepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }
    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) {
        Etudiant etudiant = etudiantRepo.findById(etudiantId).orElse(null);
        Departement departement = departmentRepo.findById(departementId).orElse(null);
        if (etudiant!=null && departement!=null) {
            etudiant.setDepartement(departement);
            etudiantRepo.save(etudiant);
        }

    }
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
        Contrat contrat = contratRepo.findById(idContrat).get();
        Equipe equipe = equipeRepo.findById(idEquipe).get();
        e.getContrats().add(contrat);
        e.getEquipe().add(equipe);
        etudiantRepo.save(e);
        return e;
    }

}
