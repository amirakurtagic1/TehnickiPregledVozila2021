package ba.unsa.etf.nrs.projekat.controller;

import ba.unsa.etf.nrs.projekat.model.Korisnik;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregledDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class postojeciKorisniciController {

    public ListView lstListaKorisnika;
    public TextField fldPretraga;
    public ImageView imgViewLogo;
    public TehnickiPregledDAO dao;


    public void initialize(){

        dao = TehnickiPregledDAO.getInstance();
        ArrayList<Korisnik> korisnici = dao.getUsers();

        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);
        lstListaKorisnika.setItems(FXCollections.observableArrayList(korisnici));
        
    }
    public void onActionUrediPodatkeOKorisniku(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/unosKorisnika.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Uredi podatke o korisniku");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();

    }

    public void onActionPrikaziDetaljeOKorisniku(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/unosKorisnika.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Detalji o korisniku");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void onActionPrikaziDodijeljenePreglede(ActionEvent actionEvent) throws IOException {
        Korisnik korisnik = (Korisnik) lstListaKorisnika.getSelectionModel().getSelectedItem();
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/prikazDodijeljenihPregleda.fxml"));
        prikazDodijeljenihPregledaController prikazDodijeljenihPregledaController = new prikazDodijeljenihPregledaController(korisnik);
        loader.setController(prikazDodijeljenihPregledaController);
        Parent root = loader.load();
        myStage.setTitle("Dodijeljeni pregledi");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();

    }

    public void onActionCancel(ActionEvent actionEvent) {
        ((Stage)fldPretraga.getScene().getWindow()).close();
    }

    public void onActionPretraziKorisnike(ActionEvent actionEvent) {
    }
}
