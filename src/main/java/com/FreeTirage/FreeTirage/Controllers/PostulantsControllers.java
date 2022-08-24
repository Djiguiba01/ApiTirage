package com.FreeTirage.FreeTirage.Controllers;

import com.FreeTirage.FreeTirage.Models.ListePostulant;
import com.FreeTirage.FreeTirage.Models.Postulants;
import com.FreeTirage.FreeTirage.Repository.PostulantRepository;
import com.FreeTirage.FreeTirage.Service.ListePostulantService;
import com.FreeTirage.FreeTirage.Service.PostulantService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Api(value = "hello")
    @RestController
    @RequestMapping("/postulant/")
    @AllArgsConstructor

    public class PostulantsControllers {

        /* Permet de creer une entrée pour */
        private final PostulantService postulantService;
        private final  ListePostulantService lpservice;


    // Insertion des données depuis un fichiers CSV
        @Autowired
        PostulantRepository service;
        @PostMapping("/upload/{libelle}")
        public String uploadData(@RequestParam("file") MultipartFile file, ListePostulant listeP ) throws IOException {

            try
            {
            listeP.setDate(new Date());
            ListePostulant pliste= lpservice.add(listeP);

            List<Postulants> listePostulants = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            CsvParserSettings setting = new CsvParserSettings();
            setting.setHeaderExtractionEnabled(true);
            CsvParser parser = new  CsvParser(setting);
            List<Record> passerAllRecord = parser.parseAllRecords(inputStream);

               passerAllRecord.forEach(record -> {
                   Postulants postulants = new Postulants();
                   postulants.setNom_postulant(record.getString("nom_postulant"));
                   postulants.setPrenom_postulant(record.getString("prenom_postulant"));
                   postulants.setEmail_postulant(record.getString("email_postulant"));
                   postulants.setNumero_postulant(record.getString("numero_postulant"));
                   postulants.setListepostulant(pliste);
                   listePostulants.add(postulants);
                });

                service.saveAll(listePostulants);

                return " Importer avec succes";
            }
            catch (Exception exception)
            {
                return "Fichier non importer";
            }

        }
        //Lister les postulants avec les listes possiblesS

        @GetMapping("/lire")
        @ApiOperation(value = "Permet d'afficher la liste de toute les  pays")
        public List<Postulants> lire() {
            return postulantService.lire();
        }

        /*Permet de modifier un postulants donné*/
        @PutMapping("/update/{id_postulant}")
        @ApiOperation(value = "Permet de modifier un postulant donné")
        public Postulants update(@PathVariable Long id_postulant, @RequestBody Postulants postulants) {
            return postulantService.update(id_postulant, postulants);
        }

        /*Permet de supprimer un postulant donnée*/
        @DeleteMapping("/delete/{id_postulant}")
        @ApiOperation(value = "Permet de supprimer un postulant donnée")
        public String supprimer(@PathVariable Long id_postulant) {
            return postulantService.delete(id_postulant);
        }


        @PostMapping("/ajouter")
        @ApiOperation(value = "Permet de creer une entrée pour un postulant")
        public Postulants add(@RequestBody Postulants postulants) {
            return this.postulantService.add(postulants);
        }

    public String Afficher(@PathVariable Long id_postulant) {
        return postulantService.delete(id_postulant);
    }




}
