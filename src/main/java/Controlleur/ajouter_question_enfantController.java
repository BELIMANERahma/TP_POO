/**
 * Sample Skeleton for 'ajouter_enfant_anam.fxml' Controller Class
 */

package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ajouter_question_enfantController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="edit_profile"
    private Button edit_profile; // Value injected by FXMLLoader

    @FXML // fx:id="enregistrer"
    private Button enregistrer; // Value injected by FXMLLoader

    @FXML // fx:id="listquestions"
    private VBox listquestions; // Value injected by FXMLLoader

    @FXML // fx:id="retour"
    private Button retour; // Value injected by FXMLLoader

    @FXML // fx:id="utilisateur1"
    private Label utilisateur1; // Value injected by FXMLLoader

//hadi wmb3d nbedelha

    @FXML
    public void enregistrer(ActionEvent event) {
        VBox vbox = listquestions;

        // Use ArrayList to temporarily store Objectif objects
        List<Question_enfant> TroubleList = new ArrayList<>();

        for (Node node : vbox.getChildren()) {
            if (node instanceof HBox) {
                HBox hbox = (HBox) node;
                AnchorPane anchorPane = (AnchorPane) hbox.getChildren().get(0);

                TextField nomtroubleField = null;
                ComboBox<String> typetroubleComboBox = null;

                // Find TextField and ComboBox within the AnchorPane
                for (Node child : anchorPane.getChildren()) {
                    if (child instanceof TextField) {
                        nomtroubleField = (TextField) child;
                    } else if (child instanceof ComboBox) {
                        typetroubleComboBox = (ComboBox<String>) child;
                    }
                }

                if (nomtroubleField != null && typetroubleComboBox != null) {
                    String nomtrouble = nomtroubleField.getText().trim();
                    String typetrouble = typetroubleComboBox.getValue();

                    System.out.println(nomtrouble);
                    System.out.println(typetrouble);

                    if (!nomtrouble.isEmpty() && typetrouble != null) {
                        Categorie_trouble type = null;

                        try {

                            type = Categorie_trouble.valueOf(typetrouble.replace(" ", "_"));

                        } catch (IllegalArgumentException e) {
                            // Handle unexpected type values (optional)
                            e.printStackTrace();
                        }

                        if (type != null) {

                            Trouble trouble = new Trouble(nomtrouble,type);
                            TroubleList.add(trouble);
                        }
                    }
                }
            }
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
                PageRouter = "/com/example/tp_poo/Bilan.fxml";
                break;

            case "Fiche de suivi":
                newPage = true;
                PageRouter = "/com/example/tp_poo/CreerFichesuivi.fxml";
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
                String username =user.getCompte().getEmail();
                String filepath="./src/main/Userinformation/" + username + ".ser";
                Orthophoniste.serialize(filepath,user);
                newPage = true;
                PageRouter = "/com/example/tp_poo/Login.fxml";
                break;

            default:
                newPage = true;
                PageRouter = "/com/example/tp_poo/DefaultPage.fxml";
                break;
        }

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
    void retour(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/tp_poo/anam_enfant_elemnt.fxml"));
            HBox hBox = fxmlLoader.load();
           anam_enfant_elemntController cic = fxmlLoader.getController();
            cic.setData(listquestions);
            listquestions.getChildren().add(hBox);

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        assert edit_profile != null : "fx:id=\"edit_profile\" was not injected: check your FXML file 'ajouter_enfant_anam.fxml'.";
        assert enregistrer != null : "fx:id=\"enregistrer\" was not injected: check your FXML file 'ajouter_enfant_anam.fxml'.";
        assert listquestions != null : "fx:id=\"listquestions\" was not injected: check your FXML file 'ajouter_enfant_anam.fxml'.";
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'ajouter_enfant_anam.fxml'.";
        assert utilisateur1 != null : "fx:id=\"utilisateur1\" was not injected: check your FXML file 'ajouter_enfant_anam.fxml'.";

    }

}
