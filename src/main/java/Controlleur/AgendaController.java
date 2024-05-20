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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AgendaController {

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
    void handleRouting(MouseEvent event) {


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
    void initialize() {

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

    private Set<Rendez_vous> rendezVous() {
        Set<Rendez_vous> ls = new TreeSet<>();

        // Create some dates for example purposes
        LocalDateTime date1 = LocalDateTime.of(2024, 5, 19, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2024, 6, 19, 14, 0);
        LocalDateTime date3 = LocalDateTime.of(2024, 7, 19, 9, 0);


        Rendez_vous R = new Consultation(date1);
        Rendez_vous R2 = new Consultation(date2);
        Rendez_vous R3 = new Consultation(date3);

        Rendez_vous R4 = new Suivi(date1);
        Rendez_vous R5 = new Suivi(date2);
        Rendez_vous R6 = new Suivi(date3);

        ls.add(R);
        ls.add(R2);
        ls.add(R3);
        ls.add(R4);
        ls.add(R5);
        ls.add(R6);

        return ls;
    }
}
