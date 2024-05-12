package Model;

public class Suivi extends Rendez_vous {
    private int numero_dossier;
    private Deroulement_seance type;
    private Objectif[] objectif_seance;
    private String duree;

    public Suivi(String date, String heure, Type_rendez_vous type, String observation, int numero_dossier, Deroulement_seance type1, Objectif[] objectif_seance, String duree) {
        super(date, heure, type, observation);
        this.numero_dossier = numero_dossier;
        this.type = type1;
        this.objectif_seance = objectif_seance;
        this.duree = duree;
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

}
