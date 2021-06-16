package ba.unsa.etf.nrs.projekat.controller;

import ba.unsa.etf.nrs.projekat.model.Korisnik;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregled;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregledDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class dodjelaPregledaPoIDController {
    public ImageView imgViewLogo;
    public TextField fldIDPregleda;
    public TextField fldPodnosiocZahtjeva;
    public TextField fldDodijeljeniTehnicar;
    public TextField fldPretraga;
    public ListView listListaTehnicara;
    public TehnickiPregled tehnickiPregled;
    public TehnickiPregledDAO dao;
    public dodjelaPregledaPoIDController() {
    }
    public dodjelaPregledaPoIDController(TehnickiPregled tehnickiPregled) {
        this.tehnickiPregled = tehnickiPregled;
    }


    public void initialize(){
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);

        dao = TehnickiPregledDAO.getInstance();
        ObservableList<Korisnik> korisnici = FXCollections.observableArrayList(dao.getUsers());
        listListaTehnicara.setItems(korisnici);
        fldIDPregleda.setText(tehnickiPregled.getId());
        fldDodijeljeniTehnicar.setText(tehnickiPregled.getTechnician_id());
        fldPodnosiocZahtjeva.setText(tehnickiPregled.getOwnerId());


    }

    public void onActionPretrazTehnicara(ActionEvent actionEvent) {
    }

    public void onActionDodijeliTehnicara(ActionEvent actionEvent) {
    }

    public void onActionCancel(ActionEvent actionEvent) {
        ((Stage)fldPretraga.getScene().getWindow()).close();
    }
}
