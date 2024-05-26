package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Testes implements Serializable
{
    private ArrayList<QuestionnaireChoix> questionnaires;
    private ArrayList<QuestionnaireLibre> questionnaireLibre;
    private ArrayList<Test_exercice> serieExercices;

    public void Tests(ArrayList<QuestionnaireChoix> questionnaires, ArrayList<QuestionnaireLibre> questionnaireLibre, ArrayList<Test_exercice> serieExercices) {
        this.questionnaires = questionnaires;
        this.questionnaireLibre = questionnaireLibre;
        this.serieExercices = serieExercices;
    }





    public ArrayList<QuestionnaireChoix> getQuestionnaires() {
        return questionnaires;
    }

    public ArrayList<QuestionnaireLibre> getQuestionnaireLibre() {
        return questionnaireLibre;
    }

    public ArrayList<Test_exercice> getSerieExercices() {
        return serieExercices;
    }

    public void setQuestionnaires(ArrayList<QuestionnaireChoix> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public void setQuestionnaireLibre(ArrayList<QuestionnaireLibre> questionnaireLibre) {
        this.questionnaireLibre = questionnaireLibre;
    }

    public void setSerieExercices(ArrayList<Test_exercice> serieExercices) {
        this.serieExercices = serieExercices;
    }
}
