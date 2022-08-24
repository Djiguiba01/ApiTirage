package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TirageRepository extends JpaRepository<Tirage, Long> {

    @Query(value = "SELECT postulants.nom_postulant,postulants.prenom_postulant,postulants.email_postulant,\n" +
            "            postulants.numero_postulant,postulants.listepostulant_id_liste_postulant FROM postulants_tirages,postulants\n" +
            "             WHERE  postulants.id_postulant = postulants_tirages.postulants_id_postulant\n" +
            "            AND postulants_tirages.tirages_id_tirage =:tirages_id_tirage",nativeQuery = true)

    List<Object> lestires(@Param("tirages_id_tirage") Long tirages_id_tirage);
}
