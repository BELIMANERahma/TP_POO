package Model;

public class Agenda {
    private Rendez_vous[] Rendez_vous;
    private int nbr_rdv =0;

    public Agenda(Model.Rendez_vous[] rendez_vous) {
        Rendez_vous = rendez_vous;
    }

    public Model.Rendez_vous[] getRendez_vous() {
        return Rendez_vous;
    }

    public void setRendez_vous(Model.Rendez_vous[] rendez_vous) {
        Rendez_vous = rendez_vous;
    }

    public void add_rendez_vous(Rendez_vous rdv){
        nbr_rdv++;
        this.Rendez_vous[nbr_rdv] = rdv;

    }

}
