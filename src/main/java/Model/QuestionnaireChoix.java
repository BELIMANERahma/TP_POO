package Model;

public class QuestionnaireChoix {
    private String titre;
    private Question[] questions;
    private int nbr_qiuetions ;
    private int capacite;

    public QuestionnaireChoix(String titre, Question[] questions, int capacite) {

        this.titre = titre;
        this.questions = questions;
        this.capacite = capacite;

    }


}
