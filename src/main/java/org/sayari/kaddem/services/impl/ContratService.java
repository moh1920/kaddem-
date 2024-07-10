package org.sayari.kaddem.services.impl;

import org.sayari.kaddem.entity.Contrat;
import org.sayari.kaddem.entity.Etudiant;
import org.sayari.kaddem.repostries.ContratRepo;
import org.sayari.kaddem.repostries.EtudiantRepo;
import org.sayari.kaddem.services.interf.IcontratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContratService implements IcontratService {
@Autowired
private ContratRepo contratRepo ;
@Autowired
private EtudiantRepo etudiantRepo ;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepo.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        if (contratRepo.findById(ce.getIdContrat())==null){
            return contratRepo.save(ce);
        }
        return ce ;
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepo.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepo.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepo.deleteById(idContrat);
    }



    Contrat affectContratToEtudiant (Integer idContrat, String nomE,String prenomE){
        Contrat contrat = contratRepo.findById(idContrat).get();
        Etudiant etudiant =etudiantRepo.findByNomEAndPrenomE(nomE,prenomE);
        int sommeContrat = 0;
        Set<Contrat> listContrat = etudiant.getContrats();
        for(Contrat c : listContrat){
            if(c == contrat){
                sommeContrat ++;
            }
        }
        if(sommeContrat < 5){
            contrat.setEtudiant(etudiant);
            contratRepo.save(contrat);
        }
        return   contrat ;

    }
}
