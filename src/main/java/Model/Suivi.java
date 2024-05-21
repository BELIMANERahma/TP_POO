package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Suivi extends Rendez_vous {
    private int numero_dossier;
    private Deroulement_seance type;
    private Objectif[] objectif_seance;
    private final String duree = "1:00";


    public Suivi(LocalDate date, String heure, Type_rendez_vous type, int numero_dossier, Deroulement_seance type1,  String duree) {
        super(date, heure, type);
        this.numero_dossier = numero_dossier;
        this.type = type1;
        this.objectif_seance = objectif_seance;
    }
    public Suivi(LocalDate date) {
        super(date) ;
    }
    public Suivi() {

    }

    public Suivi(LocalDate now1, String heure, Type_rendez_vous typeRendezVous, String observation, int i, Deroulement_seance deroulementSeance, Objectif[] objectifs, String s) {
    }

    public int getNumero_dossier() {
        return numero_dossier;
    }

    public Deroulement_seance getType_suivi() {
        return type;
    }

    public Objectif[] getObjectif_seance() {
        return objectif_seance;
    }

    public String getDuree() {
        return duree;
    }

    public  String getPatientName(){
       return "nom";
    }

}
