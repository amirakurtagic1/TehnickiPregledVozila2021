package ba.unsa.etf.nrs.projekat.controller;

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
import java.lang.reflect.Array;
import java.util.ArrayList;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class uvidUPregledeController {


    public ImageView imgViewLogo;
    public TableColumn columnIDPregleda;
    public TableColumn columnNositelZahtjeva;
    public TableColumn columnTehnicarZaduzenZaPregled;
    public TableColumn columnDatumPregleda;
    public TextField fldPretragaPoID;
    public TextField fldPretragaAbecedaPoNositeljPotvrde;
    public TextField fldPretragaPoImenuTehnicara;
    public DatePicker dtPickerPretraga;
    public TehnickiPregledDAO dao;
    public TableView<TehnickiPregled> tableViewTehnickiPregledi;

    public void initialize(){
        dao = TehnickiPregledDAO.getInstance();
        //ArrayList<TehnickiPregled> tehnickiPregledi = dao.getExams();
        System.out.println("Ovdje sam " + dao.getExams());
        ObservableList<TehnickiPregled> tehPregled  = FXCollections.observableArrayList(dao.getExams());
        //System.out.println(tehnickiPregledi.size());
        tableViewTehnickiPregledi.setItems(FXCollections.observableArrayList(tehPregled));
        columnIDPregleda.setCellValueFactory(new PropertyValueFactory("id"));
        columnTehnicarZaduzenZaPregled.setCellValueFactory(new PropertyValueFactory("technician_id"));
        columnDatumPregleda.setCellValueFactory(new PropertyValueFactory("datumKreiranja"));
        columnNositelZahtjeva.setCellValueFactory(new PropertyValueFactory("ownerId"));



        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);

    }

    public void btnOnActionUcitajPregled(ActionEvent actionEvent) throws IOException {
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ucitajPregled.fxml"));
        Parent root = loader.load();
        myStage.setTitle("Tehnički pregled");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void btnPodaciOKorisniku(ActionEvent actionEvent) {
    }

    public void btnOnActionCancel(ActionEvent actionEvent) {
        ((Stage) imgViewLogo.getScene().getWindow()).close();
    }
}
