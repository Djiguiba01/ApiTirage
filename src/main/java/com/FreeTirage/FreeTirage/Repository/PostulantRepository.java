package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostulantRepository extends JpaRepository<Postulants, Long> {

    @Query(value = "SELECT postulants.nom_postulant," +
            "postulants.prenom_postulant," +
            "postulants.email_postulant," +
            "postulants.numero_postulant,liste_postulant.libelle " +
            "FROM postulants,liste_postulant WHERE" +
            " postulants.listepostulant_id_liste_postulant = liste_postulant.id_liste_postulant;" +
            "\n",nativeQuery = true)

    Iterable<Object[]> listerPostulants();

    @Query(value = "SELECT postulants.id_postulant FROM postulants;",nativeQuery = true)
    Iterable<Object[]> laListeID();

    List<Postulants> findByListepostulant(ListePostulant listePostulant);


}
