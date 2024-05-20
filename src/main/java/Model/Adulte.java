package Model;

public class Adulte extends Patient
{

    private String Dimplome;
    private String profession;
    private long numero_personnel;

    public Adulte(String nom, String prenom, String date_naissance, String lieu_naissance, String adresse, String dimplome, String profession, int numero_personnel) {
        super(nom, prenom, date_naissance, lieu_naissance, adresse);
        Dimplome = dimplome;
        this.profession = profession;
        this.numero_personnel = numero_personnel;
    }
    public Adulte(String nom, String prenom) {
        super(nom, prenom);

    }


    public Adulte() {

    }

    public String getDimplome() {
        return Dimplome;
    }

    public void setDimplome(String dimplome) {
        Dimplome = dimplome;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public long getNumero_personnel() {
        return numero_personnel;
    }

    public void setNumero_personnel(int numero_personnel) {
        this.numero_personnel = numero_personnel;
    }
}
