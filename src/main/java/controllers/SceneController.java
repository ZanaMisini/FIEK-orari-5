package controllers;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ConnectionUtil;
import service.PasswordUtil;

abstract class SceneController {

    private Stage stage;
    private Scene scene;
    private  Parent root;

    @FXML
    public void switchToFillimi(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("/com/example/fiekorari/fillimi.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Fillimi");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToMenaxhoOret(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/fiekorari/menaxhoOret.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menaxho Orët");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToProfili(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/fiekorari/profili.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Profili");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/fiekorari/logIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Kyçu");
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void switchToNdihma(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/fiekorari/ndihma.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Ndihma");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void switchToOrari(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/example/fiekorari/orari.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Orari");
        stage.setScene(scene);
        stage.show();
    }
    }