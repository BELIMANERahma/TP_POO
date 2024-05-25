/**
 * Sample Skeleton for 'Projettherapeutique.fxml' Controller Class
 */

package Controlleur;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Dossier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class Projet_therapeutiqueController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="enregistrer"
    private Button enregistrer; // Value injected by FXMLLoader

    @FXML // fx:id="projet_thérapeutique"
    private TextArea projet_thérapeutique; // Value injected by FXMLLoader

    @FXML // fx:id="retour"
    private Button retour; // Value injected by FXMLLoader

    @FXML // fx:id="username1"
    private Label username1; // Value injected by FXMLLoader

    private Dossier dossier;

    @FXML
    void enregistrer(ActionEvent event) {


    }

    @FXML
    void handleRouting(MouseEvent event) {


    }

    @FXML
    void profile(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert enregistrer != null : "fx:id=\"enregistrer\" was not injected: check your FXML file 'Projettherapeutique.fxml'.";
        assert projet_thérapeutique != null : "fx:id=\"projet_thérapeutique\" was not injected: check your FXML file 'Projettherapeutique.fxml'.";
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'Projettherapeutique.fxml'.";
        assert username1 != null : "fx:id=\"username1\" was not injected: check your FXML file 'Projettherapeutique.fxml'.";

    }

    public void setDossier(Dossier dossier) {

        this.dossier = dossier;

    }
}
