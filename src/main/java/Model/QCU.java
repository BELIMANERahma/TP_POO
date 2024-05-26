package Model;

import java.io.Serializable;

public class QCU extends Question  implements Serializable {
    private  String choix[];
    private  int nbr_choix;
    private String  reponse;


    public QCU(String enonce,int note, String reponse, String[] choix) {

        super(enonce, note);
        this.choix = choix;
        this.nbr_choix = choix.length;
        this.reponse =reponse;

    }

    public String[] getChoix() {
        return choix;
    }

    public void setChoix(String[] choix) {
        this.choix = choix;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

}
