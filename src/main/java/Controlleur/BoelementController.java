package Controlleur;

import Model.BO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BoelementController {


    @FXML
    private HBox hbox;
    @FXML
    private Label testes;

    @FXML
    private Label thera;

    @FXML
    private Label troubles;

    @FXML
    private Label ana;

    @FXML
    private Label anamnese;



    public  void setData(BO bo)
    {

        ana.setVisible(false);
        anamnese.setVisible(false);
        hbox.setVisible(false);
        thera.setText(bo.getProjet().getDescription());

        testes.setOnMouseClicked(event ->
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tp_poo/teste.fxml"));
                Parent root = loader.load();
                EpreuveController fiche = loader.getController();
                fiche.setficheData(bo.getEpreuves_cliniques());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 1000, 670);
                stage.setScene(scene);

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        troubles.setOnMouseClicked(event ->
        {
            try
            {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tp_poo/Troubles.fxml"));
                Parent root = loader.load();
                TroublesController fiche = loader.getController();
                fiche.setficheData(bo.getDiagnostique().getTrouble());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 1000, 670);
                stage.setScene(scene);

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });



    }



}
