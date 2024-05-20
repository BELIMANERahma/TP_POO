/**
 * Sample Skeleton for 'home.fxml' Controller Class
 */
package Controlleur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Orthophoniste;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Homecontroller implements Initializable {
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

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private Label utilisateur1;
    @FXML
    private void handleRouting(MouseEvent event)
    {

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
                // You need to set the new page in the current scene or open a new window
                // Example for setting the new page in the current scene:
                  Stage Scene = (Stage) ((Node)event.getSource()).getScene().getWindow();
                  Scene scene = new Scene(nextPage, 1000, 670);
                 Scene.setScene(scene);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void setusername(Orthophoniste utilisateur)
    {
        utilisateur1.setText(utilisateur.getCompte().getNom() + " " + utilisateur.getCompte().getPrenom());


    }





}