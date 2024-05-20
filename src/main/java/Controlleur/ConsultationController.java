/**
 * Sample Skeleton for 'Consultation.fxml' Controller Class
 */

package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;

import Model.Adulte;
import Model.Enfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ConsultationController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Age"
    private TextField Age; // Value injected by FXMLLoader

    @FXML // fx:id="duree"
    private TextField duree; // Value injected by FXMLLoader

    @FXML // fx:id="enregistrer"
    private Button enregistrer; // Value injected by FXMLLoader

    @FXML // fx:id="heure_consult"
    private DatePicker heure_consult; // Value injected by FXMLLoader

    @FXML // fx:id="jour_consult"
    private DatePicker jour_consult; // Value injected by FXMLLoader

    @FXML // fx:id="nom"
    private TextField nom; // Value injected by FXMLLoader

    @FXML // fx:id="prenom"
    private TextField prenom; // Value injected by FXMLLoader

    @FXML // fx:id="profile"
    private Button profile; // Value injected by FXMLLoader

    @FXML // fx:id="retour"
    private Button retour; // Value injected by FXMLLoader

    @FXML
    void enregistrer(ActionEvent event) {
        String Nom = nom.getText();
        String Prenom= prenom.getText();
        DatePicker date= jour_consult;
        DatePicker heure= jour_consult;
        int age = Integer.parseInt(Age.getText());
        if(age>=18){
            Adulte  patient= new Adulte(Nom,Prenom);
        }else{
            Enfant patient= new Enfant(Nom,Prenom);

        }

    }

    @FXML
    void handleRouting(MouseEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert Age != null : "fx:id=\"Age\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert duree != null : "fx:id=\"duree\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert enregistrer != null : "fx:id=\"enregistrer\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert heure_consult != null : "fx:id=\"heure_consult\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert jour_consult != null : "fx:id=\"jour_consult\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert nom != null : "fx:id=\"nom\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert prenom != null : "fx:id=\"prenom\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert profile != null : "fx:id=\"profile\" was not injected: check your FXML file 'Consultation.fxml'.";
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'Consultation.fxml'.";

    }

}
