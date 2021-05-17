package ba.unsa.etf.nrs.projekat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GlavnaController {


    public ImageView imgViewLogo;
    public Button btnPregledajStatistike;

    public void initialize(){
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);
    }
    public void onActionPregledajStatistike(ActionEvent actionEvent) {
    }

    public void onActionKreirajKorisnika(ActionEvent actionEvent) {
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
