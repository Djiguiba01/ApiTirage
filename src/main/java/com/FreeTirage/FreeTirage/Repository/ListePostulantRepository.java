package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListePostulantRepository extends JpaRepository<ListePostulant, Long> {

    ListePostulant findByLibelle(String libelle);




}
