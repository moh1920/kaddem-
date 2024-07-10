package org.sayari.kaddem.repostries;

import org.sayari.kaddem.entity.Etudiant;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepo  extends JpaRepository<Etudiant,Integer> {
    Etudiant findByNomEAndPrenomE(String nomE,String prenomE) ;

}
