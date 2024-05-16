package Model;

public class Dossier {

    private int numero;
    private Rendez_vous rendez_vous[];
    private BO Bilans_orth[];
    private String fiches_suiv[];


    public Dossier(int numero, Rendez_vous[] rendez_vous, BO[] bilans_orth, String[] fiches_suiv) {
        this.numero = numero;
        this.rendez_vous = rendez_vous;
        Bilans_orth = bilans_orth;
        this.fiches_suiv = fiches_suiv;
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

    public String[] getFiches_suiv() {
        return fiches_suiv;
    }

    public void setFiches_suiv(String[] fiches_suiv) {
        this.fiches_suiv = fiches_suiv;
    }
}
