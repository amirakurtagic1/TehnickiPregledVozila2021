package ba.unsa.etf.nrs.projekat.controller;

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
    public void onActionPregledajStatistike(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pregledStatistike.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Pregled statistike");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void onActionKreirajKorisnika(ActionEvent actionEvent) throws IOException {
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/unosKorisnika.fxml"));
            Parent root = loader.load();
            myStage.setTitle("Tehnički pregled vozila");
            //myStage.initOwner(imgViewLogo.getScene().getWindow());
             myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.setResizable(false);
            myStage.showAndWait();
    }

    public void onActionKreirajIzvjestaj(ActionEvent actionEvent) {
    }

    public void onActionUvidPregleda(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/uvidUPreglede.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Uvid u preglede");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void onActionPokaziPostojeceKorisnike(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/postojeciKorisnici.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Postojeći korisnici");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void onActionKreirajPregled(ActionEvent actionEvent) {
    }

    public void onActionDodijeliPregled(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodjelaPregleda.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Dodjela pregleda");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void onActionIzlaz(ActionEvent actionEvent) {
        ((Stage)imgViewLogo.getScene().getWindow()).close();
    }
}
