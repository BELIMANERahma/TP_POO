package Controlleur;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;


public class PatientController implements Initializable {

    @FXML
    private VBox patientslay;
    @FXML
    private Label username1;


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
        //  PageRouter = "/com/example/tp_poo/Login.fxml";


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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try {
            Orthophoniste user = LoginController.getcurrentuser();
            username1.setText(user.getCompte().getNom() + " " + user.getCompte().getPrenom());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }


        List<Patient> patients = null;
        try {
            patients = new ArrayList<>(patientt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        for(int i=0;i<patients.size();i++)
        {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/tp_poo/elemntpatient.fxml"));
            try {
                HBox hBox=fxmlLoader.load();
                patientelementController cic = fxmlLoader.getController();
                cic.setData(patients.get(i));
                patientslay.getChildren().add(hBox);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private List<Patient> patientt() throws IOException, ClassNotFoundException {

        Orthophoniste user =LoginController.getcurrentuser();

        List<Patient> ls = new ArrayList<>();
        Enfant patient = new Enfant();
        Adulte patient1=new Adulte();
        patient.setNum_dossier(1);
        patient.setNom("Belimane") ;
        patient.setPrenom("Rahma") ;
        patient.setDate_naissance("20042903") ;
        patient.setAdresse("Constantine");
        patient.setLieu_naissance("Constantine");
        patient.setClass_etude("1 CP");



        TreeSet<Rendez_vous> rendez_vous = new TreeSet<>();
        Fiche_suivi[] ficheSuivis= new Fiche_suivi[]{new Fiche_suivi()};
        BO[] bos=new BO[]{new BO()};
        Dossier dossier = new Dossier(rendez_vous,bos,ficheSuivis,patient);

        user.add_patient(dossier);
        ls.add(patient);


        patient1.setNum_dossier(2);
        patient1.setNom("Belimane") ;
        patient1.setPrenom("Rahma") ;
        patient1.setDate_naissance("20042903") ;
        patient1.setAdresse("Constantine");
        patient1.setLieu_naissance("Constantine");
        patient1.setDimplome("1 CP");
        patient1.setProfession("NAWM");
        patient1.setNumero_personnel(794157061);

        Dossier dossier2 = new Dossier(rendez_vous,bos,ficheSuivis,patient1);
        user.add_patient(dossier2);
        ls.add(patient1);



        String filename = "./src/main/Userinformation/current.ser";

        serialize(filename,user);


        return ls;
    }
    private static void serialize(String filepath,Orthophoniste user)
    {
        try {
            if (user != null)
            {
                String filename = "./src/main/Userinformation/current.ser";
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(user);

            }
        }

        catch
        (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
