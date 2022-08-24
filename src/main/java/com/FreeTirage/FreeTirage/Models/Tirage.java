package com.FreeTirage.FreeTirage.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tirage")

    private Long id_tirage;

    private String libelle_tirage;

    private Date date_tirage;

    private int nbre_postulant_tirer;


}
