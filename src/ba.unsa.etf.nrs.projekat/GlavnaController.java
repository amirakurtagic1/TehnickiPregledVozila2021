package ba.unsa.etf.nrs.projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class GlavnaController {


    public ImageView imgViewLogo;
    public Button btnPregledajStatistike;

    public void initialize(){
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);

    }
    public void onActionPregledajStatistike(ActionEvent actionEvent) {
    }

    public void onActionKreirajKorisnika(ActionEvent actionEvent) throws IOException {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/unosKorisnika.fxml"));
            Parent root = loader.load();
            myStage.setTitle("Tehnički pregled vozila");
            myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
    }

    public void onActionKreirajIzvjestaj(ActionEvent actionEvent) {
    }

    public void onActionUvidPregleda(ActionEvent actionEvent) {
    }

    public void onActionPokaziPostojeceKorisnike(ActionEvent actionEvent) {
    }

    public void onActionKreirajPregled(ActionEvent actionEvent) {
    }

    public void onActionDodijeliPregled(ActionEvent actionEvent) {
    }

    public void onActionIzlaz(ActionEvent actionEvent) {
        ((Stage)imgViewLogo.getScene().getWindow()).close();
    }
}
