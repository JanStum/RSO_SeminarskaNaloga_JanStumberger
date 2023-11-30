package com.example.rso_seminarska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteVehicleSceneController implements Initializable {
    @FXML
    protected ChoiceBox<String> vehicleChoiceBox;
    protected String vehicleTypeChoice;
    protected int vehicleIndex;
    @FXML
    protected Parent root;
    @FXML
    protected Scene scene;
    @FXML
    protected Stage stage;
    public void initialize(URL arg0, ResourceBundle arg1){
        for (int i = 0; i < PublicTransportApplication.BUS.size(); i++){
            vehicleChoiceBox.getItems().add("Tip vozila: avtobus     Ime vozila: " + PublicTransportApplication.BUS.get(i).getVehicleName());
        }
        for (int i = 0; i < PublicTransportApplication.TRAIN.size(); i++) {
            vehicleChoiceBox.getItems().add("Tip vozila: vlak     Ime vozila: " + PublicTransportApplication.TRAIN.get(i).getVehicleName());
        }
    }
    public void delete(ActionEvent event)throws IOException{
        if (vehicleChoiceBox.getValue().startsWith("Tip vozila: avtobus")){
            PublicTransportApplication.BUS.remove(vehicleIndex);
        }
        else if (vehicleChoiceBox.getValue().startsWith("Tip vozila: vlak")){
            PublicTransportApplication.TRAIN.remove(vehicleIndex);
        }
        vehicleChoiceBox.getItems().remove(vehicleChoiceBox.getValue());
        vehicleChoiceBox.getSelectionModel().clearSelection();
         // Zakaj da fak se ne izbriše selekcija. Z nekega razloga ne morem hkrati zbrisati selekcije in zbrisati elementa iz ChoiceBoxa, lahko pa vsako posebej
    }
    public void switchToAdministratorScene(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
