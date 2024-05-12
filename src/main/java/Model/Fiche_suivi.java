package Model;

public class Fiche_suivi {
    private Objectif[] objectifs;

    public Fiche_suivi(Objectif[] objectifs) {
        this.objectifs = objectifs;
    }

    public void setObjectifs(Objectif[] objectifs) {
        this.objectifs = objectifs;
    }

    public Objectif[] getObjectifs() {
        return objectifs;
    }
}
