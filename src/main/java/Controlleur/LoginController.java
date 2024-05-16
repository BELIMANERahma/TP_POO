package Controlleur;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {


    @FXML
    private Button create_account_btn;



    @FXML
    private Button login_btn;

    @FXML
    private PasswordField login_password;

    @FXML
    private CheckBox login_selectshow;

    @FXML
    private TextField login_show;

    @FXML
    private TextField login_username;

    @FXML
    private AnchorPane loginform;




    @FXML




    public void Signup(ActionEvent event) {
        try {
            // Load the FXML file for the signup page
            Parent signupRoot = FXMLLoader.load(getClass().getResource("/com/example/tp_poo/Signup.fxml"));

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


}