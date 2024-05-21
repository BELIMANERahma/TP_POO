package Model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Atelier extends Rendez_vous implements Serializable
{
    private String thematique;
    private Dossier[] liste_patients;
    private   String duree;

    public Atelier(LocalDateTime date, String heure, Type_rendez_vous type, String observation, String thematique, Dossier[] liste_patients, String duree) {
        super(date, heure, type, observation);
        this.thematique = thematique;
        this.liste_patients = liste_patients;
        this.duree = duree;
    }

    public Atelier(LocalDateTime date, String thematique, Dossier[] liste_patients, String duree) {
        super(date);
        this.thematique = thematique;
        this.liste_patients = liste_patients;
        this.duree = duree;
    }

    public Atelier(String thematique, Dossier[] liste_patients, String duree) {
        this.thematique = thematique;
        this.liste_patients = liste_patients;
        this.duree = duree;
    }

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public Dossier[] getListe_patients() {
        return liste_patients;
    }

    public void setListe_patients(Dossier[] liste_patients) {
        this.liste_patients = liste_patients;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}
