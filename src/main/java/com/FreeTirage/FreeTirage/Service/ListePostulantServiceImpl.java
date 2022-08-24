package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Repository.ListePostulantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ListePostulantServiceImpl implements ListePostulantService{
    private final ListePostulantRepository listePostulantRepository;

    @Override
    public ListePostulant add(ListePostulant listePostulant) {
        return listePostulantRepository.save(listePostulant);
    }

    @Override
    public List<ListePostulant> lire() {
        return listePostulantRepository.findAll();
    }

    @Override
    public ListePostulant update(Long id_liste_postulant, ListePostulant listePostulant) {
        return listePostulantRepository.findById(id_liste_postulant)
                .map(listePostulant1 ->  {

                    listePostulant1.setLibelle(listePostulant.getLibelle());
                    listePostulant1.setDate(listePostulant.getDate());
                    return listePostulantRepository.save(listePostulant1);

                }).orElseThrow(() -> new RuntimeException("Liste Postulant non trouvée"));
    }

    @Override
    public String delete(Long id_liste_postulant) {
        listePostulantRepository.deleteById(id_liste_postulant);
        return "Liste de Postulant supprimée";
    }

    @Override
    public Optional<ListePostulant> lesPostulants(Long id_postulant) {
        return listePostulantRepository.findById(id_postulant);
    }

    @Override
    public ListePostulant RetrouverParLibelle(String libelle) {
        return listePostulantRepository.findByLibelle(libelle);
    }


}
