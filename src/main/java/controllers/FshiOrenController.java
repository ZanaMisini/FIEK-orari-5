package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.ConnectionUtil;
import service.Translate;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static service.PasswordUtil.showAlert;
import static service.PasswordUtil.showErrorAlert;

public class FshiOrenController {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int available;


    @FXML
    TextField indeksiField;

    @FXML
    Label writeIndexLabel;

    @FXML
    Button deleteButton;

    public static String selectedLanguageCode = "sq";
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTexts(); // Call updateTexts() during initialization
    }
    @FXML
    public void fshi(ActionEvent event){
        String indeksi = indeksiField.getText();

        if(indeksi.isEmpty()){
            showErrorAlert("Shkruani indeksin e ores!");
            return;
        }

        try{
            available = 0;
            Connection conn1 = ConnectionUtil.getConnection();
            PreparedStatement statement1 = conn1.prepareStatement("UPDATE class SET available = ? WHERE oid = ?");
            statement1.setInt(1, available);
            statement1.setString(2, indeksi);
            statement1.executeUpdate();
            showAlert("Ora u fshi me sukses!");



        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateTexts(){
        deleteButton.setText(Translate.get("deleteButton.text"));
        writeIndexLabel.setText(Translate.get("writeIndexLabel.text"));

    }

    public void setSelectedLanguageCode(String languageCode) {
        selectedLanguageCode = languageCode;
    }

}
