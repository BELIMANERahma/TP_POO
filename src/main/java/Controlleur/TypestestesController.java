/**
 * Sample Skeleton for 'anamnese.fxml' Controller Class
 */

package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TypestestesController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="AnamneseAdulte"
    private Label AnamneseAdulte; // Value injected by FXMLLoader

    @FXML // fx:id="AnamneseEnfant"
    private Label AnamneseEnfant; // Value injected by FXMLLoader

    @FXML // fx:id="QCM_QCU"
    private Label QCM_QCU; // Value injected by FXMLLoader

    @FXML // fx:id="Rep_libre"
    private Label Rep_libre; // Value injected by FXMLLoader

    @FXML // fx:id="SerieExercice"
    private Label SerieExercice; // Value injected by FXMLLoader

    @FXML // fx:id="username1"
    private Label username1; // Value injected by FXMLLoader

    @FXML
    void handleRouting(MouseEvent event) {

    }

    @FXML
    public void handleRouting2(MouseEvent event) {

        Label label = (Label) event.getSource();
        String labelText = label.getText();


        String PageRouter = "Testes-view.fxml"; // Chemin par défaut
        boolean newPage = false;

        switch (labelText) {
            case "Sujet Anamnèse pour les adultes":
                newPage = true;
                PageRouter = "CreerAnamneseAdulte.fxml";
                break;

            case "Sujet Anamnèse pour les enfants":
                newPage = true;
                PageRouter = "CreerAnamneseEnfant.fxml";
                break;

            case "QCM,QCU":
                newPage = true;
                PageRouter = "CreerQuestionnaire.fxml";
                break;

            case "Serie d'exercices":
                newPage = true;
                PageRouter = "CreerExercice.fxml";
                break;

            case "Questionnaire á reponses libres":
                newPage = true;
                PageRouter = "CreerRepLibres.fxml";
                break;

            default:
                newPage = true;
                PageRouter = "CreerRepLibres.fxml";
                break;
        }
        //  PageRouter = "/com/example/tp_poo/Login.fxml";

        if (newPage) {
            try {
                // Load the desired page
                System.out.println("hehehehehe");
                Parent nextPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(PageRouter)));
                Stage Scene = (Stage) ((Node)event.getSource()).getScene().getWindow();
                javafx.scene.Scene scene = new Scene(nextPage, 1000, 670);
                Scene.setScene(scene);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void profile(ActionEvent event){

        try {
            String PageRouter = "/com/example/tp_poo/Profile.fxml";
            Parent nextPage = FXMLLoader.load(getClass().getResource(PageRouter));
            Stage Scene = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(nextPage, 1000, 670);
            Scene.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert AnamneseAdulte != null : "fx:id=\"AnamneseAdulte\" was not injected: check your FXML file 'anamnese.fxml'.";
        assert AnamneseEnfant != null : "fx:id=\"AnamneseEnfant\" was not injected: check your FXML file 'anamnese.fxml'.";
        assert QCM_QCU != null : "fx:id=\"QCM_QCU\" was not injected: check your FXML file 'anamnese.fxml'.";
        assert Rep_libre != null : "fx:id=\"Rep_libre\" was not injected: check your FXML file 'anamnese.fxml'.";
        assert SerieExercice != null : "fx:id=\"SerieExercice\" was not injected: check your FXML file 'anamnese.fxml'.";
        assert username1 != null : "fx:id=\"username1\" was not injected: check your FXML file 'anamnese.fxml'.";

    }

}
