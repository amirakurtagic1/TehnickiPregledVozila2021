package ba.unsa.etf.nrs.projekat;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class StatistikaController {

    public TextField fldPretragaPoId;
    public TextField fldPretragaPoPodnosiocuZahtjeva;
    public TextField fldPretragaPoDatumu;
    public TableColumn columnIdIzvjestaja;
    public TableColumn columnPodnosilacZahtjeva;
    public TableColumn columnDatum;
    public Button btnIzborZaposlenika;
    public Button btnUcitajPregled;
    public Button btnDetaljniPrikazStatistike;
    public TextArea fldStatistikaOKreiranimIzvjestajima;
    public TextArea fldStatistikaOObradjenimIzvjestajima;
    public TextArea flsStatistika;
    public TextArea fldStatistika;
    public ImageView imgViewLogo;

    public void initialize(){
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);

    }

    public void btnOnActionOtvoriIzborZaposlenika(ActionEvent actionEvent) {
    }

    public void btnOnActionUcitajPregled(ActionEvent actionEvent) {
    }

    public void btnOnActionDetaljniPregledStatistike(ActionEvent actionEvent) {
    }

    public void btnOnActionCancel(ActionEvent actionEvent) {
        ((Stage)btnUcitajPregled.getScene().getWindow()).close();
    }
}
