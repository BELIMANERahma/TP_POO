package Model;

public class Test_exercice  extends Test{
private Exercice[] liste_excercice;


    public Test_exercice(String nom, int capacité, Exercice[] liste_excercice) {
        super(nom, capacité);
        this.liste_excercice = liste_excercice;
    }

    public Exercice[] getListe_excercice() {
        return liste_excercice;
    }

    public void setListe_excercice(Exercice[] liste_excercice) {
        this.liste_excercice = liste_excercice;
    }
}
