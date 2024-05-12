package Model;

public class Epreuve_clinique {


    private String[] Observations_cliniques;
    private Test[] tests;

    public Epreuve_clinique(String[] observations_cliniques, Test[] tests) {
        Observations_cliniques = observations_cliniques;
        this.tests = tests;
    }

    public String[] getObservations_cliniques() {
        return Observations_cliniques;
    }

    public void setObservations_cliniques(String[] observations_cliniques) {
        Observations_cliniques = observations_cliniques;
    }

    public Test[] getTests() {
        return tests;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }
}
