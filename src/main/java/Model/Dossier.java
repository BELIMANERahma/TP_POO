package Model;

public class Dossier {

    private int numero;
    private Rendez_vous rendez_vous[];
    private BO Bilans_orth[];
    private  Fiche_suivi fiches_suivi[];


    public Dossier(int numero, Rendez_vous[] rendez_vous, BO[] bilans_orth,  Fiche_suivi [] fiches_suivi) {
        this.numero = numero;
        this.rendez_vous = rendez_vous;
        Bilans_orth = bilans_orth;
        this.fiches_suivi = fiches_suivi;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Rendez_vous[] getRendez_vous() {
        return rendez_vous;
    }

    public void setRendez_vous(Rendez_vous[] rendez_vous) {
        this.rendez_vous = rendez_vous;
    }

    public BO[] getBilans_orth() {
        return Bilans_orth;
    }

    public void setBilans_orth(BO[] bilans_orth) {
        Bilans_orth = bilans_orth;
    }

    public  Fiche_suivi[]  getFiches_suiv() {
        return fiches_suivi;
    }

    public void setFiches_suiv( Fiche_suivi [] fiches_suivi) {
        this.fiches_suivi = fiches_suivi;
    }
}
