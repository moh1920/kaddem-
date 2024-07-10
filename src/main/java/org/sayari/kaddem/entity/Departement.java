package org.sayari.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Departement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepart ;
    private String nomDepart ;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "departement",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Etudiant> etudiantSet;
    @ManyToOne
    private Universite universite ;





}
