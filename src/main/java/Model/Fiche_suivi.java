package Model;

import java.io.Serializable;

public class Fiche_suivi implements Serializable {
    private Objectif[] objectifs;

    public Fiche_suivi()
    {
    }

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
