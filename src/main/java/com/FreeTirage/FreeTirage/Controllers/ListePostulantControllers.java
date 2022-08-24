package com.FreeTirage.FreeTirage.Controllers;


import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Service.ListePostulantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Les requetes possible sur ma table pays")
@RestController
@RequestMapping("/listepostulant")
@AllArgsConstructor

public class ListePostulantControllers {

    /* Permet de creer une entrée pour*/
    private final ListePostulantService listePostulantService;

    @ApiOperation(value = "Permet de creer une entrée pour un postulant")
    @PostMapping("/add")
    public ListePostulant add(@RequestBody ListePostulant listePostulant) {
        return listePostulantService.add(listePostulant);
    }

    /*Permet d'afficher la liste de toute les  postulants*/
    @GetMapping("/read")
    @ApiOperation(value = "Permet d'afficher la liste de toute les  postulants")
    public List<ListePostulant> lire() {
        return listePostulantService.lire();
    }

    /*Permet de modifier un postulants donné*/
    @PutMapping("/update/{id_postulant}")
    @ApiOperation(value = "Permet de modifier un postulant donné")
    public ListePostulant update(@PathVariable Long id_liste_postulant, @RequestBody ListePostulant listePostulant) {
        return listePostulantService.update(id_liste_postulant, listePostulant);
    }

    /*Permet de supprimer un postulant donnée*/
    @DeleteMapping("/delete/{id_postulant}")
    @ApiOperation(value = "Permet de supprimer un postulant donnée")
    public String supprimer(@PathVariable Long id_liste_postulant) {
        return listePostulantService.delete(id_liste_postulant);
    }



}
