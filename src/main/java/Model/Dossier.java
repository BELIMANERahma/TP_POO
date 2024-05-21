package Model;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.TreeSet;

public class Dossier implements Serializable {
    private static int counter = 0;

    private int numero;
    private Patient patient ;
    private TreeSet<Rendez_vous>  rendez_vous;
    private BO Bilans_orth[];
    private  Fiche_suivi fiches_suivi[];


    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Fiche_suivi[] getFiches_suivi() {
        return fiches_suivi;
    }

    public void setFiches_suivi(Fiche_suivi[] fiches_suivi) {
        this.fiches_suivi = fiches_suivi;
    }

    public Dossier(Patient patient)
    {
        this.patient= patient;
        numero = counter+1;
        counter++;
        this.rendez_vous = new TreeSet<Rendez_vous>();

    }
    public Dossier()
    {
        numero = counter+1;
        counter++;
        this.rendez_vous = new TreeSet<Rendez_vous>();

    }


    public Dossier(TreeSet<Rendez_vous> rendezVous,BO[] bilans_orth, Fiche_suivi [] fiches_suivi ,Patient patient    ) {
        this.numero = counter+1;
        counter++;
        this.rendez_vous = new TreeSet<Rendez_vous>(rendezVous);
        Bilans_orth = bilans_orth;
        this.fiches_suivi = fiches_suivi;
        this.patient = patient;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TreeSet<Rendez_vous> getRendez_vous() {
        return rendez_vous;
    }

    public void setRendez_vous(TreeSet<Rendez_vous> rendez_vous) {
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
    public void add_rendez_vous(Rendez_vous rd){
        rendez_vous.add(rd);
    }
}
