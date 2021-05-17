package ba.unsa.etf.nrs.projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Locale;

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

        dateDatumPolaganjaIspita.setValue(LocalDate.now());
        dateDatumVazenjaLicence.setValue(LocalDate.now());

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

    private boolean validacija(){

        if(cmbTipKorisnika.getSelectionModel().getSelectedItem().equals("Tehničar") && (fldIme.getText().equals("") || fldPrezime.getText().equals("") || fldImeOca.equals("") || fldJMBG.getText().equals("") || fldMjestoPolaganjaIspita.getText().equals("") || fldBrojLicence.getText().equals("") ||
                dateDatumVazenjaLicence.getValue().isAfter(LocalDate.now()) || dateDatumPolaganjaIspita.getValue().isAfter(LocalDate.now()))){
            validacijaNonTehnicar();
            validacijaTehnicar();
            return false;
        }
        else{
            if(fldIme.getText().equals("") || fldPrezime.getText().equals("") || fldImeOca.equals("") || fldJMBG.getText().equals("")) {
                validacijaNonTehnicar();
                return false;
            }
        }
        return true;
    }

    private void validacijaTehnicar(){
        if(fldBrojLicence.getText().equals("")){
            fldBrojLicence.getStyleClass().remove("ispravno");
            fldBrojLicence.getStyleClass().add("neispravno");
        } else {
            fldBrojLicence.getStyleClass().remove("neispravno");
            fldBrojLicence.getStyleClass().add("ispravno");
        }
        if(fldMjestoPolaganjaIspita.getText().equals("")){
            fldMjestoPolaganjaIspita.getStyleClass().remove("ispravno");
            fldMjestoPolaganjaIspita.getStyleClass().add("neispravno");
        }else{
            fldMjestoPolaganjaIspita.getStyleClass().remove("neispravno");
            fldMjestoPolaganjaIspita.getStyleClass().add("ispravno");
        }
        if(dateDatumPolaganjaIspita.getValue().isAfter(LocalDate.now().minusDays(1))){
            dateDatumPolaganjaIspita.getStyleClass().remove("ispravno");
            dateDatumPolaganjaIspita.getStyleClass().add("neispravno");
        }else{
            dateDatumPolaganjaIspita.getStyleClass().remove("neispravno");
            dateDatumPolaganjaIspita.getStyleClass().add("ispravno");
        }
        if(dateDatumVazenjaLicence.getValue().isAfter(LocalDate.now().minusDays(1))){
            dateDatumVazenjaLicence.getStyleClass().remove("ispravno");
            dateDatumVazenjaLicence.getStyleClass().add("neispravno");
        }else{
            dateDatumVazenjaLicence.getStyleClass().remove("neispravno");
            dateDatumVazenjaLicence.getStyleClass().add("ispravno");
        }
    }
    private void validacijaNonTehnicar(){
        if(fldIme.getText().equals("")){
            fldIme.getStyleClass().remove("ispravno");
            fldIme.getStyleClass().add("neispravno");

        } else{
            fldIme.getStyleClass().remove("neispravno");
            fldIme.getStyleClass().add("ispravno");
        }
        if(fldPrezime.getText().equals("")){
            fldPrezime.getStyleClass().remove("ispravno");
            fldPrezime.getStyleClass().add("neispravno");

        } else{
            fldPrezime.getStyleClass().remove("neispravno");
            fldPrezime.getStyleClass().add("ispravno");
        }
        if(fldImeOca.getText().equals("")){
            fldImeOca.getStyleClass().remove("ispravno");
            fldImeOca.getStyleClass().add("neispravno");

        } else{
            fldImeOca.getStyleClass().remove("neispravno");
            fldImeOca.getStyleClass().add("ispravno");
        }
        if(fldJMBG.getText().equals("")){
            fldJMBG.getStyleClass().remove("ispravno");
            fldJMBG.getStyleClass().add("neispravno");

        } else{
            fldJMBG.getStyleClass().remove("neispravno");
            fldJMBG.getStyleClass().add("ispravno");
        }
    }
    public void onActionOtkazi(ActionEvent actionEvent) {
        ((Stage)imgView.getScene().getWindow()).close();
    }

    public void onActionPotvrdi(ActionEvent actionEvent) {
        if(validacija() == true) ((Stage)imgView.getScene().getWindow()).close();
    }
}
