/**
 * Sample Skeleton for 'home.fxml' Controller Class
 */
package Controlleur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Homecontroller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    void handleRouting(MouseEvent event) {
        String PageRouter;
        boolean newPage;
        label53:
        {
            Label label = (Label) event.getSource();
            newPage = false;

            PageRouter = "Profile/Profile.fxml";
        }

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }



}