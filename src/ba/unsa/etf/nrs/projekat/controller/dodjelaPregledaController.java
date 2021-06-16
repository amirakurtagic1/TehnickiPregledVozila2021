package ba.unsa.etf.nrs.projekat.controller;

import ba.unsa.etf.nrs.projekat.model.TehnickiPregled;
import ba.unsa.etf.nrs.projekat.model.TehnickiPregledDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class dodjelaPregledaController {
    public ImageView imgViewLogo;
    public TextField fldPretragaPoIdPregleda;
    public TextField fldPretragaPoPodnosiocuZahtjava;
    public TextField fldPretragaPoDatumu;
    public TableView tableView;
    public TableColumn columnIDPregleda;
    public TableColumn columnPodnosiocZahtjeva;
    public TableColumn columnDatum;
    public TehnickiPregledDAO dao;

    public void initialize(){
        dao = TehnickiPregledDAO.getInstance();
        ObservableList<TehnickiPregled> tehPregled  = FXCollections.observableArrayList(dao.getExams());
        Image image = new Image(getClass().getResource("/img/resizeimage.jpg").toString());
        imgViewLogo.setImage(image);

        tableView.setItems(FXCollections.observableArrayList(tehPregled));
        columnIDPregleda.setCellValueFactory(new PropertyValueFactory("id"));
        columnPodnosiocZahtjeva.setCellValueFactory(new PropertyValueFactory("ownerId"));
        columnDatum.setCellValueFactory(new PropertyValueFactory("datumKreiranja"));


    }

    public void onActionDodijeliPregled(ActionEvent actionEvent) throws IOException {
        TehnickiPregled tehnickiPregled = (TehnickiPregled) tableView.getSelectionModel().getSelectedItem();
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodijeliPregledPoID.fxml"));
        dodjelaPregledaPoIDController dodjelaPregledaPoIDController = new dodjelaPregledaPoIDController(tehnickiPregled);
        loader.setController(dodjelaPregledaPoIDController);
        Parent root = loader.load();
        myStage.setTitle("Dodjela pregleda");
        //myStage.initOwner(imgViewLogo.getScene().getWindow());
        myStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.showAndWait();
    }

    public void onActionCancel(ActionEvent actionEvent) {
        ((Stage)fldPretragaPoDatumu.getScene().getWindow()).close();
    }
}
