package com.example.rso_seminarska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuSceneController {
    @FXML
    protected PasswordField administratorPassword;
    protected Label wrongPasswordLabel;
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
    public void userButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void administratorButton(ActionEvent event) throws IOException{
        if (administratorPassword.getText().equals("1234")){
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AdministratorMenuScene.fxml")));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}