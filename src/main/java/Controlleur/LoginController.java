package Controlleur;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;


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

    public void switchForm (ActionEvent event)
    {
// THE REGISTRATION FORM WILL BE VISIBLE
        if (event.getSource () == login_btn)
        {
            loginform.setVisible (true);
            signupform.setVisible(false);

        }
        else if (event.getSource()==create_account_btn)
        {
            signupform.setVisible(true);

            loginform.setVisible(false);

        }
    }

}