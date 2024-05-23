package Model;

import java.io.Serializable;

public class Question implements Serializable {
    private String enonce;
    private String reponse;

    public Question(String enonce, String reponse) {
        this.enonce = enonce;
        this.reponse = reponse;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
