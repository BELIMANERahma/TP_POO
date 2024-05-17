package Controlleur;

import Model.Orthophoniste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginController {

    @FXML
    private TextField adresse;

    @FXML
    private Button create_account_btn;

    @FXML
    private TextField email;


    @FXML
    private TextField full_name;



    @FXML
    private Label PasswordErrorMessage;

    @FXML
    private Label usernameErrorMessage;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField login_password;

    @FXML
    private TextField login_show;

    @FXML
    private TextField login_username;

    @FXML
    private AnchorPane loginform;

    @FXML
    private TextField number;

    @FXML
    private TextField sign_upuname;

    @FXML
    private Button signup;

    @FXML
    private AnchorPane signupform;

    @FXML
    private PasswordField signuppassword;

    @FXML
    private TextField signupusername;

    @FXML
    private Button returntologin;

    @FXML


    void Signupform(ActionEvent event) {
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

    private void loadNextPage(Orthophoniste utilisateur) {

        String nextPage;

        nextPage = "Profile.fxml";


        try
        {

            //meriem hna beh tbdli l profile lezem nbe3tou des infos pour le mzomznt rahi byda bdliha kima 7biti
            Parent next = FXMLLoader.load(getClass().getResource("/com/example/tp_poo/Profile.fxml"));

            // Get the current scene
            Scene currentScene = create_account_btn.getScene();

            // Set the root of the current scene to the Step2 root
            currentScene.setRoot(next);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    @FXML
    public void SignIn()
    {
        String username = login_username.getText();
        String password = login_password.getText();

        // Perform login authentication and retrieve the Utilisateur object
        Orthophoniste user = authenticate(username, password);

        if (user != null)
        {

            // Load the next page
            loadNextPage(user);
        }
    }
    private Orthophoniste authenticate(String username, String password)
    {

        String pseudo = username.toLowerCase().replaceAll(" ", "");
        String filename = "./src/main/Userinformation/" + username + ".ser";

        File file = new File(filename);

        if (file.exists()) {
            Orthophoniste utilisateur = null;
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                utilisateur = (Orthophoniste) objectInputStream.readObject();
                String storedUsername = utilisateur.getCompte().getEmail();
                String storedPassword = utilisateur.getCompte().getMot_pass();

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return utilisateur;
                } else {
                    PasswordErrorMessage.setText("Invalid password");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Working Directory: " + System.getProperty("user.dir"));
            System.out.println("File Path: " + file.getAbsolutePath());
            usernameErrorMessage.setText("Username does not exist");
        }
        return null;
    }


}