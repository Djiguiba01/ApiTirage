package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Models.Tirage;
import com.FreeTirage.FreeTirage.Repository.PostulantRepository;
import com.FreeTirage.FreeTirage.Repository.TirageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class TirageServiceImpl implements TirageService {

    private final TirageRepository tirageRepository;

    private final PostulantRepository postulantRepository;

    @Override
    public Tirage add(Tirage tirage) {
        return tirageRepository.save(tirage);
    }

    @Override
    public List<Tirage> lire() {
        return tirageRepository.findAll();
    }

// Les nouvelle modifications ****************************************************************

    @Override
    public List<Postulants> creerTirage(Tirage tirage, List<Postulants> listATrier, int nbre) {
        Random random =  new Random();
        List<Postulants> list = new ArrayList<>();
        for (int i = 0; i < nbre;i++)
        {
            Integer idAct =  random.nextInt(listATrier.size());

            list.add(listATrier.get(idAct));

            listATrier.remove(listATrier.get(idAct));
        }
        Tirage t=tirageRepository.save(tirage);
        for (Postulants p:list){
            p.getTirages().add(t);
            postulantRepository.save(p);
        }
        tirageRepository.save(tirage);
        return list;
    }




    @Override
    public Tirage update(Long id_tirage, Tirage tirage) {
        return tirageRepository.findById(id_tirage)
                .map(tirage1 -> {
                    tirage1.setDate_tirage(tirage.getDate_tirage());
                    tirage1.setLibelle_tirage(tirage.getLibelle_tirage());
                    tirage1.setNbre_postulant_tirer(tirage.getNbre_postulant_tirer());

                    return tirageRepository.save(tirage1);
                }).orElseThrow(() -> new RuntimeException("Postulant non trouvé"));
    }

    @Override
    public String delete(Long id_tirage) {
       tirageRepository.deleteById(id_tirage);
        return "Tirage supprimé";
    }
/*
    @Override
    public Tirage trouverTirageParListeLibelle(String libelleirage) {
        return tirageRepository.findByLibelleTirage(libelleirage);
    }

    @Override
    public int creer(Long idPostulant, Long idTirage) {
        return tirageRepository.InserePostulantTrier(idPostulant,idTirage);
    }

    @Override
    public Iterable<Object[]> AfficherTousPostulants() {
        return tirageRepository.RecupererationAfficher();
    }

 */

}
