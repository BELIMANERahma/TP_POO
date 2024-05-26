package Model;

public class question_libre extends Question{
    private String reponse;



    public question_libre(String enonce, int note, String reponse) {
        super(enonce, note);
        this.reponse = reponse;
    }


    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }


}
