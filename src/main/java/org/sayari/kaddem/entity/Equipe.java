package org.sayari.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "equipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipe {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "equipe",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Etudiant> etudiantSet;
    @OneToOne
    private DetailEquipe detailEquipe ;

}
