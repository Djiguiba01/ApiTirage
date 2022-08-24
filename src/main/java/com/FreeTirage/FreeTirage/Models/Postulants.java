package com.FreeTirage.FreeTirage.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Postulants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulant")

    private Long id_postulant;

    private String nom_postulant;

    private String prenom_postulant;

    private String numero_postulant;

    private String email_postulant;


    @ManyToOne
    private ListePostulant listepostulant;

    //
    @ManyToMany
    // La class postulant a une
    private List<Tirage> tirages;


}