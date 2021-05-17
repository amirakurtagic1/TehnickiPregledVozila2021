package ba.unsa.etf.nrs.projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Controller {
    public TextField fldUsername;
    public PasswordField fldPassword;
    public Label porukaLogin;
    public Button btnDalje;
    public ImageView imgView;

    public void initialize() {
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgView.setImage(image);
    }

    public void onActionDalje(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        if (validacija() == true) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/glavna.fxml"));
            Parent root = loader.load();
            myStage.setTitle("Tehnički pregled vozila");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
        }
    }

    private boolean validacija() {
        //System.out.println("Evo sta ispisuje" + fldPassword.getText());
        if (fldUsername.getText().equals("") || fldUsername.getText().equals(null)) {
            porukaLogin.setText("Neispravni podaci!");
            if (fldPassword.getText().equals("") || fldPassword.getText().equals(null)) {
                fldPassword.setStyle("-fx-background-color: lightpink");
            }
            fldUsername.setStyle("-fx-background-color: lightpink");
            return false;
        } else fldUsername.setStyle("-fx-background-color: lightgreen");
        if (fldPassword.getText().equals("") || fldPassword.getText().equals(null)) {
            porukaLogin.setText("Neispravni podaci!");
            fldPassword.setStyle("-fx-background-color: lightpink");
            return false;
        } else fldPassword.setStyle("-fx-background-color: lightgreen");
        porukaLogin.setText("");
        fldUsername.setStyle("-fx-background-color: lightgreen");
        fldPassword.setStyle("-fx-background-color: lightgreen");

        return true;
    }
}
