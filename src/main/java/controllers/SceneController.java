package controllers;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
import models.LocaleBundle;
import service.ConnectionUtil;
import service.PasswordUtil;
import service.Translate;

abstract class SceneController {
    public static String selectedLanguageCode = "sq";

    private Stage stage;
    private Scene scene;
    private  Parent root;

    @FXML
    public void switchToFillimi(ActionEvent event) throws IOException {
        ResourceBundle bundle = LocaleBundle.bundle(selectedLanguageCode);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fiekorari/fillimi.fxml"), bundle);
        root = loader.load();
        FillimiController fillimiController = loader.getController();
        fillimiController.setSelectedLanguageCode(selectedLanguageCode);
        fillimiController.updateTexts(); // Call updateTexts() in the SignupController
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Fillimi");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToMenaxhoOret(ActionEvent event) throws IOException {
        ResourceBundle bundle = LocaleBundle.bundle(selectedLanguageCode);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fiekorari/menaxhoOret.fxml"), bundle);
        root = loader.load();
        MenaxhoOretController menaxhoOretController = loader.getController();
        menaxhoOretController.setSelectedLanguageCode(selectedLanguageCode);
        menaxhoOretController.updateTexts(); // Call updateTexts() in the SignupController
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menaxho Oret");
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
        // Load the login screen FXML using the selected language bundle
        ResourceBundle bundle = LocaleBundle.bundle(selectedLanguageCode);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fiekorari/login.fxml"), bundle);
        root = loader.load();
        LoginController loginController = loader.getController();
        loginController.setSelectedLanguageCode(selectedLanguageCode);

        loginController.updateTexts(); // Call updateTexts() in the LoginController

        // Switch to the login screen
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void switchToNdihma(ActionEvent event) throws IOException {
        ResourceBundle bundle = LocaleBundle.bundle(selectedLanguageCode);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fiekorari/ndihma.fxml"), bundle);
        root = loader.load();
        NdihmaController ndihmaController = loader.getController();
        ndihmaController.setSelectedLanguageCode(selectedLanguageCode);
        ndihmaController.updateTexts(); // Call updateTexts() in the SignupController
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Ndihma");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void switchToOrari(ActionEvent event) throws IOException {
        ResourceBundle bundle = LocaleBundle.bundle(selectedLanguageCode);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fiekorari/orari.fxml"), bundle);
        root = loader.load();
        OrariFinalController orariController = loader.getController();
        orariController.setSelectedLanguageCode(selectedLanguageCode);
        orariController.updateTexts(); // Call updateTexts() in the SignupController
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Orari");
        stage.setScene(scene);
        stage.show();
    }

    }
