package ba.unsa.etf.nrs.projekat.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ucitajPregledController {

    public ImageView imgViewLogo;
    public Label lblTehnickiPregledSaId;
    public TextField fldDodijeljeniTehnicar;
    public TextField fldIDTehnicara;
    public TextField fldStatus;
    public TextField fldFinalniRezultat;
    public TextField fldUpozorenje;
    public TextField fldSlanjeObavijesti;


    public void initialize(){
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);
    }

    public void onActionDetaljniPrikazPregleda(ActionEvent actionEvent) {
    }

    public void onActionCancel(ActionEvent actionEvent) {
        ((Stage)fldDodijeljeniTehnicar.getScene().getWindow()).close();
    }
}
