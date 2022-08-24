package com.FreeTirage.FreeTirage.Controllers;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Models.Tirage;
import com.FreeTirage.FreeTirage.Service.ListePostulantService;
import com.FreeTirage.FreeTirage.Service.PostulantService;
import com.FreeTirage.FreeTirage.Service.TirageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(value = "hello")
@RestController
@RequestMapping("/tirage")
@AllArgsConstructor
public class TirageControllers {

    /* Permet de creer une entrée pour*/
    private final TirageService tirageService;
    private final PostulantService postulantService;
    private  final ListePostulantService listePostulantService;

    /*Permet de modifier un postulants donné*/
    @PutMapping("/update/{id_tirage}")
    @ApiOperation(value = "Permet de modifier un postulant donné")
    public Tirage update(@PathVariable Long id_tirage, @RequestBody Tirage tirage) {
        return tirageService.update(id_tirage, tirage);
    }

    /*Permet de supprimer un postulant donnée*/
    @DeleteMapping("/delete/{id_tirage}")
    @ApiOperation(value = "Permet de supprimer un postulant donnée")
    public String supprimer(@PathVariable Long id_tirage) {
        return tirageService.delete(id_tirage);
    }

    //***********************************************Les nouvelles modifications

    @PostMapping("/nbretrier/{libelle}/{nombre}")
    public Object create(@PathVariable("libelle") String libelle, @PathVariable("nombre") int nbre)
    {
        ListePostulant listePostulant=listePostulantService.RetrouverParLibelle(libelle);
        if(listePostulant!=null){
            Tirage tirage=new Tirage();
            tirage.setNbre_postulant_tirer(nbre);
            tirage.setLibelle_tirage("Resultat"+libelle);
            tirage.setDate_tirage(new Date());


            return tirageService.creerTirage(tirage,postulantService.listePost(listePostulant),nbre);

        }else {
            return "Cette liste n'existe pas!!";
        }

    }

}
