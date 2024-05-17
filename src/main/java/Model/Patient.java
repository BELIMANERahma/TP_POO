package Model;

public class Patient {


    private String nom;
    private String prenom;
    private String date_naissance;
    private String lieu_naissance;
    private String Adresse;
    private Dossier dossier;

    public Patient(String nom, String prenom, String date_naissance, String lieu_naissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.lieu_naissance = lieu_naissance;
        this.Adresse = adresse;
        dossier= new Dossier();
    }

    public Patient() {

    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }
}
