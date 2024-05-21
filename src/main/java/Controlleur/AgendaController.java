/**
 * Sample Skeleton for 'Rendez-vous.fxml' Controller Class
 */
package Controlleur;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AgendaController  {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="agendaligne"
    private VBox agendaligne; // Value injected by FXMLLoader

    @FXML // fx:id="editprofile"
    private Button editprofile; // Value injected by FXMLLoader

    @FXML // fx:id="utilisateur1"
    private Label utilisateur1; // Value injected by FXMLLoader

    @FXML
    private void handleRouting(MouseEvent event) {

        Label label = (Label) event.getSource();
        String labelText = label.getText();


        String PageRouter = "/com/example/tp_poo/DefaultPage.fxml"; // Chemin par défaut
        boolean newPage = false;

        switch (labelText) {
            case "Patients":
                newPage = true;
                PageRouter = "/com/example/tp_poo/Patients.fxml";
                break;

            case "Agenda":
                newPage = true;
                PageRouter = "/com/example/tp_poo/Agenda.fxml";
                break;

            case "BO":
                newPage = true;
                PageRouter = "/com/example/tp_poo/BO.fxml";
                break;

            case "Fiche de suivi":
                newPage = true;
                PageRouter = "/com/example/tp_poo/FicheDeSuivi.fxml";
                break;

            case "Testes":
                newPage = true;
                PageRouter = "/com/example/tp_poo/Testes.fxml";
                break;

            case "Votre profile":
                newPage = true;
                PageRouter = "/com/example/tp_poo/Profile.fxml"; // Chemin vers la page de profil
                break;

            case "Se déconnecter":
                newPage = true;
                PageRouter = "/com/example/tp_poo/Logout.fxml";
                break;

            default:
                newPage = true;
                PageRouter = "/com/example/tp_poo/DefaultPage.fxml";
                break;
        }
        //  PageRouter = "/com/example/tp_poo/Login.fxml";

        if (newPage) {
            try {
                // Load the desired page
                Parent nextPage = FXMLLoader.load(getClass().getResource(PageRouter));
                Stage Scene = (Stage) ((Node)event.getSource()).getScene().getWindow();
                javafx.scene.Scene scene = new Scene(nextPage, 1000, 670);
                Scene.setScene(scene);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void page_atelier(ActionEvent event) {


    }

    @FXML
    void page_consultation(ActionEvent event) {
        try {
            // Load the FXML file for the signup page
            Parent signupRoot = FXMLLoader.load(getClass().getResource("/com/example/tp_poo/Consultation.fxml"));
            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Create a new scene with the signup root
            Scene scene = new Scene(signupRoot, 1000, 670);

            // Set the scene on the stage
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void page_suivi(ActionEvent event) {

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException, ClassNotFoundException {

        Set<Rendez_vous> rd = new TreeSet<> (rendezVous());

        for (Rendez_vous rendezVous : rd) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/tp_poo/Agendaligne.fxml"));
            try {
                HBox hBox = fxmlLoader.load();
                AgendaligneController cic = fxmlLoader.getController();
                cic.remplir_tableau(rendezVous);
                agendaligne.getChildren().add(hBox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private Set<Rendez_vous> rendezVous() throws IOException, ClassNotFoundException {
       Orthophoniste utilisateur = Orthophoniste.getcurrentuser();

        TreeMap<Integer, Dossier> dossiers = utilisateur.getMes_patients();

        TreeSet<Rendez_vous> futureRendezVous = new TreeSet<>();

        LocalDateTime now = LocalDateTime.now();

        for (Dossier dossier : dossiers.values()) {
            TreeSet<Rendez_vous> rendezVousDossier = dossier.getRendez_vous();
            futureRendezVous.addAll(rendezVousDossier.tailSet(new Rendez_vousStub(now)));
        }

        return futureRendezVous;
    }

    // Stub pour comparer les rendez-vous par date uniquement
    private static class Rendez_vousStub extends Rendez_vous
    {
        public Rendez_vousStub(LocalDateTime dateTime) {
            super(dateTime);
        }
    }
}