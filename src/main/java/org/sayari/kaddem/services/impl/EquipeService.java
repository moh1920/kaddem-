package org.sayari.kaddem.services.impl;

import org.sayari.kaddem.entity.Equipe;
import org.sayari.kaddem.repostries.EquipeRepo;
import org.sayari.kaddem.services.interf.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EquipeService implements IEquipeService {
    @Autowired
    private EquipeRepo equipeRepo;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepo.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepo.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        Optional<Equipe> equipeexist = equipeRepo.findById(e.getIdEquipe());
        if(equipeexist.isPresent()) {
            return equipeRepo.save(e);
        }
        return null;
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepo.findById(idEquipe).orElse(null);
    }
}
