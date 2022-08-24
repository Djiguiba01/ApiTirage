package com.FreeTirage.FreeTirage.Repository;

import com.FreeTirage.FreeTirage.Models.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TirageRepository extends JpaRepository<Tirage, Long> {



}
