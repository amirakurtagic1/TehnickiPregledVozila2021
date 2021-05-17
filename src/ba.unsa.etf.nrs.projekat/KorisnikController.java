package ba.unsa.etf.nrs.projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class KorisnikController {
    public ImageView imgView;
    public ComboBox cmbTipKorisnika;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldImeOca;
    public TextField fldJMBG;
    public DatePicker dateDatumPolaganjaIspita;
    public TextField fldMjestoPolaganjaIspita;
    public TextField fldBrojLicence;
    public DatePicker dateDatumVazenjaLicence;
    public Button btnOtkazi;
    public Button btnPotvrdi;

    private TehnickiPregledDAO dao;

    public void initialize(){
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgView.setImage(image);
        ObservableList<String> tipoviKorisnika = FXCollections.observableArrayList("Direktor", "Administrator", "Tehničar");
        cmbTipKorisnika.setItems(tipoviKorisnika);
       // cmbTipKorisnika.getSelectionModel().selectFirst();
        dao = TehnickiPregledDAO.getInstance();

        setDisableAllField();

        cmbTipKorisnika.valueProperty().addListener((options, oldValue, newValue) ->{
            if(newValue.equals("Direktor") || newValue.equals("Administrator")) {
                setEnableFields();
                fldBrojLicence.setDisable(true);
                fldMjestoPolaganjaIspita.setDisable(true);
                dateDatumPolaganjaIspita.setDisable(true);
                dateDatumVazenjaLicence.setDisable(true);
            }else{
                setEnableFields();
                fldBrojLicence.setDisable(false);
                fldMjestoPolaganjaIspita.setDisable(false);
                dateDatumPolaganjaIspita.setDisable(false);
                dateDatumVazenjaLicence.setDisable(false);
            }
        });


    }

    private void setEnableFields(){
        fldIme.setDisable(false);
        fldPrezime.setDisable(false);
        fldImeOca.setDisable(false);
        fldJMBG.setDisable(false);
    }

    private void setDisableAllField(){
        fldIme.setDisable(true);
        fldPrezime.setDisable(true);
        fldImeOca.setDisable(true);
        fldJMBG.setDisable(true);
        fldBrojLicence.setDisable(true);
        fldMjestoPolaganjaIspita.setDisable(true);
        dateDatumPolaganjaIspita.setDisable(true);
        dateDatumVazenjaLicence.setDisable(true);
    }
    public void onActionOtkazi(ActionEvent actionEvent) {
        ((Stage)imgView.getScene().getWindow()).close();
    }

    public void onActionPotvrdi(ActionEvent actionEvent) {
    }
}
