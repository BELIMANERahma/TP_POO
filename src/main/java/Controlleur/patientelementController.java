package Controlleur;

import Model.Objectif;
import Model.Patient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class patientelementController implements Initializable {

    @FXML
    private Label date;

    @FXML
    private Button dossier;

    @FXML
    private Label nom;

    @FXML
    private Label num_dossier;

    @FXML
    private Label prenom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }


    public void setData(Patient patient)
    {
      // String tryit= String.valueOf(patient.getDossier().getNumero());
        num_dossier.setText("1");
        nom.setText(patient.getNom());
        prenom.setText(patient.getPrenom());
        date.setText(patient.getDate_naissance());
        //dossier.setOnAction(gyn);

    }


}
