package org.sayari.kaddem.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Entity
@Table(name = "Universite")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Universite extends Departement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUniv ;
    private String nomUniv;
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="universite")
    private Set<Departement> departementSet;

}
