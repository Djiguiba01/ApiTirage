package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;

import java.util.List;

public interface PostulantService {

    Postulants add(Postulants postulants);

    Postulants update(Long id_postulant, Postulants postulants);

    String delete(Long id_postulant);


    List<Postulants> lire();

    List<Postulants> listePost(ListePostulant listePostulant);

    }
