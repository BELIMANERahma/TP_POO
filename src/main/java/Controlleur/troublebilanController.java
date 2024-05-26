/**
 * Sample Skeleton for 'troublebilan.fxml' Controller Class
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

public class troublebilanController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="edit_profile"
    private Button edit_profile; // Value injected by FXMLLoader

    @FXML // fx:id="enregistrer"
    private Button enregistrer; // Value injected by FXMLLoader

    @FXML // fx:id="listeobject"
    private VBox listtrouble; // Value injected by FXMLLoader

    @FXML // fx:id="retour"
    private Button retour; // Value injected by FXMLLoader

    @FXML // fx:id="utilisateur1"
    private Label utilisateur1; // Value injected by FXMLLoader

    private  Dossier dossier;
     private BO bilan;


    @FXML
    public void enregistrer(ActionEvent event) {

        VBox vbox = listtrouble;

        // Use ArrayList to temporarily store Objectif objects
        List<Trouble> TroubleList = new ArrayList<>();

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
    void handleRouting(MouseEvent event) {

    }
    @FXML
    void retour(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/tp_poo/ajouttrouble.fxml"));
            HBox hBox = fxmlLoader.load();
            ajoutertroubleController cic = fxmlLoader.getController();
            cic.setData(listtrouble);
            listtrouble.getChildren().add(hBox);

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        assert edit_profile != null : "fx:id=\"edit_profile\" was not injected: check your FXML file 'troublebilan.fxml'.";
        assert enregistrer != null : "fx:id=\"enregistrer\" was not injected: check your FXML file 'troublebilan.fxml'.";
        assert listtrouble != null : "fx:id=\"listeobject\" was not injected: check your FXML file 'troublebilan.fxml'.";
        assert retour != null : "fx:id=\"retour\" was not injected: check your FXML file 'troublebilan.fxml'.";
        assert utilisateur1 != null : "fx:id=\"utilisateur1\" was not injected: check your FXML file 'troublebilan.fxml'.";

    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public Dossier getDossier() {

        return dossier;
    }

    public BO getBilan() {
        return bilan;
    }

    public void setBilan(BO bilan) {
        this.bilan = bilan;
    }
}
