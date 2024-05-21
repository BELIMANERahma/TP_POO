package Controlleur;

import Model.Fiche_suivi;
import Model.Objectif;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FicheelementController {

    @FXML
    private Label numfiche;

    @FXML
    private Label objectif;

    @FXML
    private Label typeobj;

    public void setData(Fiche_suivi fiche,Objectif obj)
    {
        numfiche.setText(String.valueOf(fiche.getNum()));
        objectif.setText(obj.getNom());
        typeobj.setText(String.valueOf(obj.getType()));

    }







}
