package Controlleur;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class PatientController implements Initializable {

    @FXML
    private VBox patientslay;


    @FXML
    private void handleRouting(MouseEvent event)
    {



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        List<Patient> patients = new ArrayList<>(patientt());
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
    private List<Patient> patientt()
    {
        List<Patient> ls = new ArrayList<>();
        Patient patient = new Patient();

        patient.setNom("dddddds") ;
        patient.setPrenom("ddd") ;
        patient.setDate_naissance("20041324") ;
        Rendez_vous[] rendez_vous = new Consultation[]{new Consultation()};
        Fiche_suivi[] ficheSuivis= new Fiche_suivi[]{new Fiche_suivi()};
        BO[] bos=new BO[]{new BO()};
        Dossier dossier = new Dossier(1,rendez_vous,bos,ficheSuivis);
        patient.setDossier(dossier);

        ls.add(patient);

        Patient patient1 = new Patient();


        patient1.setNom("dddddds") ;
        patient1.setPrenom("ddd") ;
        patient1.setDate_naissance("20041324") ;

        Dossier dossier2 = new Dossier(2,rendez_vous,bos,ficheSuivis);
        patient1.setDossier(dossier2);

        ls.add(patient1);

         patient1 = new Patient();


        patient1.setNom("dddddds") ;
        patient1.setPrenom("ddd") ;
        patient1.setDate_naissance("20041324") ;

        dossier2 = new Dossier(3,rendez_vous,bos,ficheSuivis);
        patient1.setDossier(dossier2);

        ls.add(patient1);


        patient1 = new Patient();


        patient1.setNom("dddddds") ;
        patient1.setPrenom("ddd") ;
        patient1.setDate_naissance("20041324") ;

        dossier2 = new Dossier(4,rendez_vous,bos,ficheSuivis);
        patient1.setDossier(dossier2);

        ls.add(patient1);






        return ls;
    }


}
