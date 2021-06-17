package ba.unsa.etf.nrs.projekat.controller;

import ba.unsa.etf.nrs.projekat.model.Korisnik;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregled;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregledDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class izborZaposlenogController {
    public TextField fldPretragaPoImenuZaposlenog;
    public TableView tableView;
    public TableColumn columnIDZaposlenog;
    public TableColumn columnImeIPrezimeZaposlenog;
    public TableColumn columnTipKorisnika;
    public ImageView imgViewLogo;
    public TehnickiPregledDAO dao;

    public void initialize(){


        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);

        dao = TehnickiPregledDAO.getInstance();
        ObservableList<Korisnik> listaKorisnika  = FXCollections.observableArrayList(dao.getUsers());
        System.out.println(listaKorisnika);
        tableView.setItems(listaKorisnika);
        columnIDZaposlenog.setCellValueFactory(new PropertyValueFactory("id"));
        columnImeIPrezimeZaposlenog.setCellValueFactory(new PropertyValueFactory("ime"));
        columnTipKorisnika.setCellValueFactory(new PropertyValueFactory("tipKorisnika"));



    }
    public void onActionPretraga(ActionEvent actionEvent) {
    }

    public void btnOnActionCancelIzborZaposlenog(ActionEvent actionEvent) {
    }

    public void onActionOtvoriPregledeOdZaposlenog(ActionEvent actionEvent) {
    }

    public void btnOnActionPrikaziPodatkeOZaposlenom(ActionEvent actionEvent) {
    }
}
