package com.FreeTirage.FreeTirage.Service;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Repository.PostulantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class PostulantServiceImpl implements PostulantService{
    private final PostulantRepository postulantRepository;

    @Override
    public Postulants add(Postulants postulants) {
        return postulantRepository.save(postulants);
    }

    @Override
    public List<Postulants> lire() {
        return postulantRepository.findAll();
    }

    @Override
    public List<Postulants> listePost(ListePostulant listePostulant) {
        return postulantRepository.findByListepostulant(listePostulant);
    }

    @Override
    public Postulants update(Long id_postulant, Postulants postulants) {
        return postulantRepository.findById(id_postulant)
                .map(postulants1 ->  {
                    postulants1.setNom_postulant(postulants.getNom_postulant());
                    postulants1.setPrenom_postulant(postulants.getPrenom_postulant());
                    postulants1.setEmail_postulant(postulants.getEmail_postulant());
                    postulants1.setNumero_postulant(postulants.getNumero_postulant());
                    postulants1.setListepostulant(postulants.getListepostulant());

                    return postulantRepository.save(postulants1);
                }).orElseThrow(() -> new RuntimeException("Postulant non trouvé"));
    }

    @Override
    public String delete(Long id_postulant) {
        postulantRepository.deleteById(id_postulant);
        return "Postulant supprimé";
    }


   }
