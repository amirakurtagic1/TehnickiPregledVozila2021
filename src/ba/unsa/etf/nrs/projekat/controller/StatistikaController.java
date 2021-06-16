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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

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
    public TextField fldPretragaPoImenuZaposlenog;
    public TableColumn columnIDZaposlenog;
    public TableColumn columnImeIPrezimeZaposlenog;
    public TableColumn columnTipKorisnika;
    public TableView<Korisnik> tableView;
    public TehnickiPregledDAO dao;

    public void initialize(){


            Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
            imgViewLogo.setImage(image);

            dao = TehnickiPregledDAO.getInstance();
        ObservableList<Korisnik> listOfKorisnika  = FXCollections.observableArrayList(dao.getUsers());
        System.out.println(listOfKorisnika);
     /*  tableView.setItems(listOfKorisnika);
        columnIDZaposlenog.setCellValueFactory(new PropertyValueFactory("id"));
        columnImeIPrezimeZaposlenog.setCellValueFactory(new PropertyValueFactory("ime"));
        columnTipKorisnika.setCellValueFactory(new PropertyValueFactory("tipKorisnika"));
*/


    }

    public void btnOnActionOtvoriIzborZaposlenika(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/izborZaposlenika.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Izbor zaposlenika");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void btnOnActionUcitajPregled(ActionEvent actionEvent) {
    }

    public void btnOnActionDetaljniPregledStatistike(ActionEvent actionEvent) {
    }

    public void btnOnActionCancel(ActionEvent actionEvent) {
       if((btnUcitajPregled.getScene().getWindow().isShowing())) ((Stage)btnUcitajPregled.getScene().getWindow()).close();

    }

    public void onActionPretraga(ActionEvent actionEvent) {
    }

    public void onActionOtvoriPregledeOdZaposlenog(ActionEvent actionEvent) {
    }

    public void btnOnActionPrikaziPodatkeOZaposlenom(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/unosKorisnika.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Detalji o korisniku");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void btnOnActionCancelIzborZaposlenog(ActionEvent actionEvent) {
        ((Stage)fldPretragaPoImenuZaposlenog.getScene().getWindow()).close();
    }
}
