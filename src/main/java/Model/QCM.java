package Model;

public class QCM extends Question{
    private  String choix[];
    private  int nbr_choix;
    private String [] reponse;
    int nbr_reponce;



    public QCM (String enonce, int note, String [] reponse, String[] choix) {
        super(enonce, note);
        this.choix = choix;
        this.nbr_choix = choix.length;
        this.reponse =reponse;
        this.nbr_reponce= reponse.length;

    }

    public String[] getChoix() {
        return choix;
    }

    public void setChoix(String[] choix) {
        this.choix = choix;
    }

    public String[] getReponse() {
        return reponse;
    }

    public void setReponse(String[] reponse) {
        this.reponse = reponse;
    }
}
