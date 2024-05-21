/**
 * Sample Skeleton for 'agendaligne.fxml' Controller Class
 */

package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Patient;
import Model.Rendez_vous;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AgendaligneController
{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="duree"
    private Label duree; // Value injected by FXMLLoader

    @FXML // fx:id="jour"
    private Label jour; // Value injected by FXMLLoader

    @FXML // fx:id="num_dossier"
    private Label num_dossier; // Value injected by FXMLLoader

    @FXML // fx:id="patient"
    private Label patient; // Value injected by FXMLLoader

    @FXML
    private Label heure;

    @FXML // fx:id="type"
    private Label type; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert duree != null : "fx:id=\"duree\" was not injected: check your FXML file 'agendaligne.fxml'.";
        assert jour != null : "fx:id=\"jour\" was not injected: check your FXML file 'agendaligne.fxml'.";
        assert num_dossier != null : "fx:id=\"num_dossier\" was not injected: check your FXML file 'agendaligne.fxml'.";
        assert patient != null : "fx:id=\"patient\" was not injected: check your FXML file 'agendaligne.fxml'.";
        assert type != null : "fx:id=\"type\" was not injected: check your FXML file 'agendaligne.fxml'.";

    }
    public void remplir_tableau(Rendez_vous rd)
    {
        duree.setText("20:00");
        heure.setText("fygghg");
        type.setText("DFDF");
        patient.setText("frfrf");
        jour.setText("12/30/44");

    }

}
