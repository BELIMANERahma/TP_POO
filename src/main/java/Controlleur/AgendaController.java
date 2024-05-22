/**
 * Sample Skeleton for 'Rendez-vous.fxml' Controller Class
 */
package Controlleur;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
                Orthophoniste user= OrthophonisteSessionManager.getCurrentOrthophonisteName();
                user.getMes_patients().get(1).getPatient();
                user.getMes_patients().get(1).getRendez_vous();
                user.getMes_patients().get(1).getFiches_suivi();


                String username =user.getCompte().getEmail();
                String filepath="./src/main/Userinformation/" + username + ".ser";
                Orthophoniste.serialize(filepath,user);
                Orthophoniste user1=OrthophonisteSessionManager.getCurrentOrthophonisteName();

                newPage = true;
                PageRouter = "/com/example/tp_poo/Login.fxml";
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
        try {
            // Load the FXML file for the signup page
            Parent signupRoot = FXMLLoader.load(getClass().getResource("/com/example/tp_poo/Suivi.fxml"));
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
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException, ClassNotFoundException {

        Orthophoniste user=OrthophonisteSessionManager.getCurrentOrthophonisteName();
        utilisateur1.setText(user.getCompte().getNom() + " " + user.getCompte().getPrenom());

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
        Orthophoniste users =OrthophonisteSessionManager.getCurrentOrthophonisteName();

        TreeMap<Integer, Dossier> dossiers = users.getMes_patients();


        LocalDate now = LocalDate.now();

        Set<Rendez_vous> futureRendezVous = new RendezVousManager().getFutureRendezVous(dossiers, now);


        return futureRendezVous;
    }

    // Stub pour comparer les rendez-vous par date uniquement
    public class RendezVousManager {

        public Set<Rendez_vous> getFutureRendezVous(TreeMap<Integer, Dossier> dossiers, LocalDate now) {
            return dossiers.values().stream()
                    .flatMap(dossier -> dossier.getRendez_vous().stream())
                    .filter(rv -> !rv.getDate().isBefore(now))
                    .collect(Collectors.toCollection(TreeSet::new));
        }
    }
}