package Model;

public class Anamnese {
    private Question_anamnese[] question;

    public Anamnese(Question_anamnese[] question) {
        this.question = question;
    }

    public Question_anamnese[] getQuestion() {
        return question;
    }

    public void setQuestion(Question_anamnese[] question) {
        this.question = question;
    }
}
