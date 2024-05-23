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
import java.time.LocalDate;
import java.time.LocalTime;
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

        Orthophoniste user=OrthophonisteSessionManager.getCurrentOrthophonisteName();
        username1.setText(user.getCompte().getNom() + " " + user.getCompte().getPrenom());

        List<Patient> patients = null;
        try {
            patients = new ArrayList<>(patientt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
      //  List<Patient> patients = null;
       // patients = new ArrayList<>(   user.getPatientsList());

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

        Orthophoniste user=OrthophonisteSessionManager.getCurrentOrthophonisteName();
        username1.setText(user.getCompte().getNom() + " " + user.getCompte().getPrenom());

        List<Patient> ls = new ArrayList<>();
        Enfant patient = new Enfant();
        Adulte patient1=new Adulte();
        patient.setNum_dossier(1);
        patient.setNom("Belimane") ;
        patient.setPrenom("Rahma") ;
        LocalDate now = LocalDate.now();

        patient.setDate_naissance(now) ;
        patient.setAdresse("Constantine");
        patient.setLieu_naissance("Constantine");
        patient.setClass_etude("1 CP");


        TreeSet<Rendez_vous> rendez_vous = new TreeSet<>();
        LocalTime heure =LocalTime.now();
        String observation ="ya pas d observation ";
        Objectif[] objectifs = new Objectif[3];

        // Initialize the array with Objectif objects
        objectifs[0] = new Objectif("Stay alive until the end", Type_objectif.COURT_TERME);
        objectifs[1] = new Objectif("Complete the project", Type_objectif.MOYEN_TERME);
        objectifs[2] = new Objectif("Achieve career goals", Type_objectif.LONG_TERME);


        Rendez_vous r1 =new Consultation(now,heure,Type_rendez_vous.CONSULTATION,observation,"1h");
        rendez_vous.add(r1);


        List<Fiche_suivi> ficheSuivis =new ArrayList<Fiche_suivi>();
        Objectif[] objectif = new Objectif[3];

        // Initialize the array with Objectif objects
        objectif[0] = new Objectif("Stay alive until the end", Type_objectif.COURT_TERME);
        objectif[1] = new Objectif("Complete the project", Type_objectif.MOYEN_TERME);
        objectif[2] = new Objectif("Achieve career goals", Type_objectif.LONG_TERME);


        Fiche_suivi f = new Fiche_suivi(objectifs)  ;
        ficheSuivis.add(f);



        Projet_therapeu po =new Projet_therapeu("description du projet dorthophoniste ");
        String[] observations = {
                "Patient is experiencing mild headaches.",
                "No signs of fever.",
                "Blood pressure is within normal range."
        };

        // Create some example questions for the written test
        Question[] questions = new Question[]{
                new Question("What is the capital of France?", "Paris"),
                new Question("Explain the process of photosynthesis.", "Photosynthesis is the process by which green plants and some other organisms use sunlight to synthesize foods with the help of chlorophyll."),
                new Question("What is the chemical symbol for water?", "H2O")
        };
        Exercice[] exercices = new Exercice[]{
                new Exercice("Do 10 push-ups.", new String[]{"Mat", "Water bottle"}),
                new Exercice("Run for 5 minutes.", new String[]{"Running shoes"})
        };
        // Create a written test with these questions
        Test_questions writtenTest = new Test_questions("General Knowledge Test", 100, questions);
        exercices[0].setNbr_repeter(3);  // Repeat 3 times
        exercices[1].setNbr_repeter(1);  // Repeat 1 time

        // Create an exercise test with these exercises
        Test_exercice exerciseTest = new Test_exercice("Physical Fitness Test", 50, exercices);

        // Create an array of tests (in this case, just one written test)
        Test[] tests = new Test[]{writtenTest,writtenTest,exerciseTest,writtenTest,writtenTest,writtenTest,writtenTest,writtenTest};

        // Create the Epreuve_clinique instance with the observations and the test
        Epreuve_clinique epreuve = new Epreuve_clinique(observations, tests);
        Epreuve_clinique[] s = new Epreuve_clinique[]{epreuve,epreuve};


        Trouble dysphagie = new Trouble("Dysphagie", Categorie_trouble.Deglutition);
        Trouble troubleDuSpectreAutistique = new Trouble("Trouble du spectre autistique", Categorie_trouble.Neuro_developpementaux);
        Trouble troubleDuDeficitDeLAttention = new Trouble("Trouble du déficit de l'attention", Categorie_trouble.Cognitifs);

        // Creating an array of troubles
        Trouble[] troubles = {dysphagie, troubleDuSpectreAutistique, troubleDuDeficitDeLAttention};

        // Creating a Diagnostique instance
        Diagnostique diagnostique = new Diagnostique(troubles);

        List<BO> bos=new ArrayList<BO>();


        BO b =new BO(s,diagnostique,po);
        bos.add(b);
        bos.add(b);


        Dossier dossier = new Dossier(rendez_vous,bos, (ArrayList<Fiche_suivi>) ficheSuivis,patient);
        user.add_patient(dossier);
        ls.add(patient);


        patient1.setNum_dossier(2);
        patient1.setNom("Belimane") ;
        patient1.setPrenom("Rahma") ;
        patient1.setDate_naissance(now) ;
        patient1.setAdresse("Constantine");
        patient1.setLieu_naissance("Constantine");
        patient1.setDimplome("1 CP");
        patient1.setProfession("NAWM");
        patient1.setNumero_personnel(794157061);

        Dossier dossier2 =  new Dossier(rendez_vous,bos, (ArrayList<Fiche_suivi>) ficheSuivis,patient1);
        user.add_patient(dossier2);
        ls.add(patient1);
        //   String email = user.getCompte().getEmail().toLowerCase().replace(" ", "");
        //  serialize("./src/main/Userinformation/" + email + ".ser",user);


        return ls;
    }
    private static void serialize(String filepath,Orthophoniste user)
    {
        try {
            if (user != null)
            {
                FileOutputStream fileOut = new FileOutputStream(filepath);
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
