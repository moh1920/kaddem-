package org.sayari.kaddem.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "contrat")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;
    private Instant dateDebutContrat;
    private Instant dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private boolean archive ;
    private Integer montantContrat;
    @ManyToOne
    private Etudiant etudiant;


}
