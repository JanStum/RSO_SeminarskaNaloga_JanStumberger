package com.example.rso_seminarska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministratorSceneController {
    @FXML
    protected PasswordField newPasswordField;
    @FXML
    protected Button confirmNewPasswordButton;
    static String PASSWORD = "1234";
    protected Parent root;
    protected Stage stage;
    protected Scene scene;
    public void createNewVehicle(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewVehicleScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void removeVehicle(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteVehicleScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changePassword(ActionEvent event) throws IOException{
        newPasswordField.setVisible(true);
        confirmNewPasswordButton.setVisible(true);
    }
    public void confirmNewPassword(ActionEvent event) throws IOException{
        PASSWORD = newPasswordField.getText();
        newPasswordField.setText(null);
        newPasswordField.setVisible(false);
        confirmNewPasswordButton.setVisible(false);
    }
    public void printoutVehicleData(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PrintoutVehicleDataScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMenuScene(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
