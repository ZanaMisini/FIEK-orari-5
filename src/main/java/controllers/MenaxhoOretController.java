package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.User;
import service.ConnectionUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MenaxhoOretController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    ObservableList lista;

    @FXML
    private TableView<?> table_menaxhoOret;
    @FXML
    private TableColumn<?, ?> columnOra;
    @FXML
    private TableColumn<?, ?> columnDita;
    @FXML
    private TableColumn<?, ?> columnSalla;
    @FXML
    private TableColumn<?, ?> columnLenda;

    public void initialize(URL url, ResourceBundle resourceBundle){
        try{
            conn = ConnectionUtil.getConnection();
            lista = FXCollections.observableArrayList();
            setCellTable();
            loadFromDatabase();
        }catch(Exception e){

        }
    }

    public void setCellTable(){
        columnDita.setCellValueFactory(new PropertyValueFactory<>("day"));
        columnLenda.setCellValueFactory(new PropertyValueFactory<>("lenda"));
        columnOra.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        columnSalla.setCellValueFactory(new PropertyValueFactory<>("salla"));
    }

    public void loadFromDatabase(){
        try{
            System.out.println(UserController.loggedInUserId);
            ps = conn.prepareStatement("Select * from orarizgjedhur where idNumber = ? AND available!=0");
            ps.setString(1, UserController.loggedInUserId);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(new MenaxhoOretTable(rs.getString(7), rs.getString(6), rs.getString(4), rs.getString(5)));
            }
            table_menaxhoOret.setItems(lista);

        }catch(Exception e){

        }
    }

    @FXML
    public void fshiOren(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/fiekorari/fshiOren.fxml"));

        Stage addDialogStage = new Stage();
        addDialogStage.setTitle("Fshi oren");
        addDialogStage.initModality(Modality.WINDOW_MODAL);
        addDialogStage.initOwner(stage);
        scene = new Scene(root);
        addDialogStage.setScene(scene);
        addDialogStage.showAndWait();
    }

}
