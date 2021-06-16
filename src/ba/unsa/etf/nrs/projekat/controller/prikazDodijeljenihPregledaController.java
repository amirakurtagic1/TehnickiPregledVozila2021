package ba.unsa.etf.nrs.projekat.controller;

import ba.unsa.etf.nrs.projekat.model.Korisnik;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregled;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregledDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class prikazDodijeljenihPregledaController {

    public ImageView imgViewLogo;
    public ListView lstListaDodijeljenihPregleda;
    public TextField fldPretrazi;
    public DatePicker dtPickerDatum;
    public ChoiceBox choiceBoxFiltriranjePoMjesecu;
    public ChoiceBox choiceBoxFiltriranjePoGodini;
    private Korisnik korisnik;
    private TehnickiPregledDAO dao;

    public prikazDodijeljenihPregledaController() {
    }
    public prikazDodijeljenihPregledaController(Korisnik korisnik) {
        this.korisnik = korisnik;
    }


    public void initialize(){



        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);
        choiceBoxFiltriranjePoMjesecu.setItems(FXCollections.observableArrayList("Januar", "Februar", "Mart", "April","Maj", "Juni", "Juli", "August", "Septembar", "Oktobar", "Novembar", "Decembar"));
        choiceBoxFiltriranjePoGodini.setItems(FXCollections.observableArrayList("2021", "2020","2019", "2018"));

        dao = TehnickiPregledDAO.getInstance();
        ObservableList<TehnickiPregled> tehnickiPregledi = FXCollections.observableArrayList(dao.getExams());
        ArrayList<TehnickiPregled> tehnickiPregledOdKorisnika = new ArrayList<>();
        for(int i = 0; i < tehnickiPregledi.size(); i++){
            if(tehnickiPregledi.get(i).getTechnician_id() != null && tehnickiPregledi.get(i).getTechnician_id().equals(korisnik.getId())) tehnickiPregledOdKorisnika.add(tehnickiPregledi.get(i));
        }
        lstListaDodijeljenihPregleda.setItems(FXCollections.observableArrayList(tehnickiPregledOdKorisnika));

    }

    public void onActionPretrazi(ActionEvent actionEvent) {

    }

    public void onActionDetaljiOPregledu(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/uvidUPreglede.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Tehnički pregled");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void onActionCancel(ActionEvent actionEvent) {
        ((Stage)fldPretrazi.getScene().getWindow()).close();
    }
}
