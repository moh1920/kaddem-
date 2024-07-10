package org.sayari.kaddem.services.interf;

import org.sayari.kaddem.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe (Equipe e);
    Equipe retrieveEquipe (Integer idEquipe);

}
