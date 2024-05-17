package Controlleur;

import Model.Patient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    void handleRouting(MouseEvent event)
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
        patient.setDossier(null);
        ls.add(patient);

        patient = new Patient();

        patient.setNom("ddddddn") ;
        patient.setPrenom("ddd") ;
        patient.setDate_naissance("20041324") ;
        patient.setDossier(null);
        ls.add(patient);

         patient = new Patient();

        patient.setNom("dddddds") ;
        patient.setPrenom("ddd") ;
        patient.setDate_naissance("20041324") ;
        patient.setDossier(null);
        ls.add(patient);

        patient = new Patient();

        patient.setNom("ddddddq") ;
        patient.setPrenom("ddd") ;
        patient.setDate_naissance("20041324") ;
        patient.setDossier(null);
        ls.add(patient);
        patient = new Patient();

        patient.setNom("ddddddq") ;
        patient.setPrenom("ddd") ;
        patient.setDate_naissance("20041324") ;
        patient.setDossier(null);
        ls.add(patient);
        patient = new Patient();

        patient.setNom("ddddddq") ;
        patient.setPrenom("ddd") ;
        patient.setDate_naissance("20041324") ;
        patient.setDossier(null);
        ls.add(patient);
        patient = new Patient();

        patient.setNom("ddddddq") ;
        patient.setPrenom("ddd") ;
        patient.setDate_naissance("20041324") ;
        patient.setDossier(null);
        ls.add(patient);



        return ls;
    }


}
