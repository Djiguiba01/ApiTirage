package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Models.Tirage;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TirageService {

    Tirage add(Tirage tirage);

    Tirage update(Long id_tirage, Tirage tirage);

    String delete(Long id_tirage);

    List<Tirage> lire();

    List<Postulants> creerTirage(Tirage tirage, List<Postulants> listATrier, int nbre);

    //List<Object> mesPersonnesPostulants(Long id_liste);





    List<Object> personnesTirer( Long tirages_id_tirage);





    /*
    // Les nouvelles modifications


    Tirage trouverTirageParListeLibelle(String libelleirage);

    int creer(Long idPostulant, Long idTirage);

    Iterable<Object[]> AfficherTousPostulants();
*/



}
