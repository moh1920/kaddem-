package org.sayari.kaddem.services.interf;

import org.sayari.kaddem.entity.Contrat;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IcontratService {
    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat (Contrat ce);
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);

}
