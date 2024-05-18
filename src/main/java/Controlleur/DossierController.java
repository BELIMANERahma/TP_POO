package Controlleur;

import Model.Dossier;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DossierController {

    @FXML
    private TextField dossierNumber;

    @FXML
    void handleRouting(MouseEvent event) {

    }


    public void setDossierData(Dossier dossier) {
        dossierNumber.setText(String.valueOf(dossier.getNumero()));

    }
}
