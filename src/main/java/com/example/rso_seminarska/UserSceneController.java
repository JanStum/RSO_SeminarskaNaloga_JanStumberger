package com.example.rso_seminarska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class UserSceneController {
    @FXML
    protected ChoiceBox<String> vehicleTypeChoiceBox, entryStationChoiceBox, exitStationChoiceBox, weekdayChoiceBox;
    @FXML
    protected TextArea timetableTextArea;
    protected Parent root;
    protected Stage stage;
    protected Scene scene;
    public void confirmVehicleType(ActionEvent event)throws IOException {

    }
    public void confirmEntryStation(ActionEvent event)throws IOException {

    }
    public void confirmExitStation(ActionEvent event)throws IOException {

    }
    public void showTimetable(ActionEvent event)throws IOException {
        vehicleTypeChoiceBox.getSelectionModel().clearSelection();
        entryStationChoiceBox.getSelectionModel().clearSelection();
        exitStationChoiceBox.getSelectionModel().clearSelection();
        weekdayChoiceBox.getSelectionModel().clearSelection();
    }
    public void switchToMenuScene(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
