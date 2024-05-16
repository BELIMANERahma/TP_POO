package Controlleur;
import Model.*;

import Model.Compte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField adresse;

    @FXML
    private TextField email;

    @FXML
    private TextField full_name;

    @FXML
    private Button login_btn;

    @FXML
    private TextField number;

    @FXML
    private TextField sign_upname;

    @FXML
    private Button signup;

    @FXML
    private AnchorPane signupform;

    @FXML
    private PasswordField signuppassword;

    @FXML
    private TextField signupusername;

    @FXML
    public void Loginform(ActionEvent event)
    {
        try {
            // Load the FXML file for the signup page
            Parent signupRoot = FXMLLoader.load(getClass().getResource("/com/example/tp_poo/Login.fxml"));

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Create a new scene with the signup root
            Scene scene = new Scene(signupRoot, 1000, 600);

            // Set the scene on the stage
            stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    @FXML
//    public void Signp(ActionEvent event) {
//        String nom = sign_upname.getText();
//        String password = signuppassword.getText();
//        String emailfield = email.getText();
//        int telephone = Integer.parseInt(number.getText());
//        String username = signupusername.getText();
//        String prenom= full_name.getText();
//        String adress = adresse.getText();
//
//        Compte compte=  new Compte(nom, username, prenom,telephone,  emailfield, password, adress) ;
//
//
//
//            // SERIALIZED AUTOMATICALLY IN THE CLASS UTILISATEUR
//        Orthophoniste orthophoniste=new Orthophoniste(compte);
//        // ROUTING TO THE PAGE SIGNIN
//
//    }

}
