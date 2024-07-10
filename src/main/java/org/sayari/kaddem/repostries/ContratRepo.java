package org.sayari.kaddem.repostries;

import org.sayari.kaddem.entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ContratRepo extends JpaRepository<Contrat,Integer> {
}
