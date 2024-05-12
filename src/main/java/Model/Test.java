package Model;

public  abstract class Test {
    private String nom;
    private int capacité;
    private String compte_rendu;

    public Test(String nom, int capacité) {
        this.nom = nom;
        this.capacité = capacité;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacité() {
        return capacité;
    }

    public String getCompte_rendu() {
        return compte_rendu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public void setCompte_rendu(String compte_rendu) {
        this.compte_rendu = compte_rendu;
    }

}
