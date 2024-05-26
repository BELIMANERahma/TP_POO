/**
 * Sample Skeleton for 'anam_enfant_elemnt.fxml' Controller Class
 */

package Controlleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class anam_enfant_elemntController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ajouterquestion"
    private Button ajouterquestion; // Value injected by FXMLLoader

    @FXML // fx:id="categorie"
    private ComboBox<?> categorie; // Value injected by FXMLLoader

    @FXML // fx:id="categorieerror"
    private Label categorieerror; // Value injected by FXMLLoader

    @FXML // fx:id="question"
    private TextField question; // Value injected by FXMLLoader

    @FXML // fx:id="questionerror"
    private Label questionerror; // Value injected by FXMLLoader

    @FXML
    void ajouterobjectif(ActionEvent event) {


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ajouterquestion != null : "fx:id=\"ajouterquestion\" was not injected: check your FXML file 'anam_enfant_elemnt.fxml'.";
        assert categorie != null : "fx:id=\"categorie\" was not injected: check your FXML file 'anam_enfant_elemnt.fxml'.";
        assert categorieerror != null : "fx:id=\"categorieerror\" was not injected: check your FXML file 'anam_enfant_elemnt.fxml'.";
        assert question != null : "fx:id=\"question\" was not injected: check your FXML file 'anam_enfant_elemnt.fxml'.";
        assert questionerror != null : "fx:id=\"questionerror\" was not injected: check your FXML file 'anam_enfant_elemnt.fxml'.";

    }

}
