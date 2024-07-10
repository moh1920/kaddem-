package org.sayari.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.util.Set;

@Entity
@Table(name = "etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Contrat> contrats ;
    @ManyToOne
    private Departement departement;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Equipe> equipe;

}
