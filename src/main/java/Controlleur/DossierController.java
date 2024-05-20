package Controlleur;

import Model.Dossier;
import Model.Enfant;
import Model.Orthophoniste;
import Model.Patient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class DossierController implements Initializable {


    @FXML
    private AnchorPane Infopersonnelle;

    @FXML
    private Label dossierusername;

    @FXML
    private AnchorPane patientbo;

    @FXML
    private AnchorPane patientfiche;

    @FXML
    private AnchorPane patientrendezvous;

    @FXML
    private Label utilisateur1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            Orthophoniste user = LoginController.getcurrentuser();
            utilisateur1.setText(user.getCompte().getNom() + " " + user.getCompte().getPrenom());
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

    }




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




    public void setDossierData(int num_dossier) throws IOException, ClassNotFoundException
    {

        Orthophoniste user = LoginController.getcurrentuser();
        Dossier dossier = user.rechercher_patient(num_dossier);

        if (dossier != null)
        {

            Patient patient = dossier.getPatient();


                Infopersonnelle.setOnMouseClicked(event ->
                {
                    try
                    {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tp_poo/Infopersonnelle.fxml"));
                        Parent root = loader.load();

                     //   InfopersonnelleController InfoController = loader.getController();
                        //InfoController.setInfoData(patient.getNum_dossier());

                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root, 1000, 670);
                        stage.setScene(scene);

                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                });

        }
    }



}
