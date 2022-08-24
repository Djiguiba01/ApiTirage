package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;

import java.util.List;

public interface PostulantService {

    Postulants add(Postulants postulants);

// Permettre à l'utlisateur de modifier les Postulants

    Postulants update(Long id_postulant, Postulants postulants);

    String delete(Long id_postulant);

    // Permettre à lutlisateur de lire les Postulants
    List<Postulants> lire();

    // Permettre à l'utlisateur d'avoir la liste importée
    List<Postulants> listePost(ListePostulant listePostulant);

    }
