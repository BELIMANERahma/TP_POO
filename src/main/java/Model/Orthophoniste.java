package Model;

public class Orthophoniste {


    private Compte compte;
    private Agenda agnenda;
    private Patient[] Mes_patients;

    public Orthophoniste(Compte compte ) {
        this.compte = compte;

    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Agenda getAgnenda() {
        return agnenda;
    }

    public void setAgnenda(Agenda agnenda) {
        this.agnenda = agnenda;
    }

    public Patient[] getMes_patients() {
        return Mes_patients;
    }

    public void setMes_patients(Patient[] mes_patients) {
        Mes_patients = mes_patients;
    }
}
