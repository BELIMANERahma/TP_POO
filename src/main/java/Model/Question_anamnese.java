package Model;

public abstract class Question_anamnese {
private String enonce;

    public Question_anamnese(String enonce) {
        this.enonce = enonce;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }
}
