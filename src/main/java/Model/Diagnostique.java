package Model;

public class Diagnostique {

    private Trouble[] trouble;

    public Diagnostique(Trouble[] trouble)
    {
        this.trouble = trouble;
    }

    public Trouble[] getTrouble() {
        return trouble;
    }

    public void setTrouble(Trouble[] trouble) {
        this.trouble = trouble;
    }
}
