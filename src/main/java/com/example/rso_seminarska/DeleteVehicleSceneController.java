package com.example.rso_seminarska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class DeleteVehicleSceneController implements Initializable {
    @FXML
    protected ChoiceBox<String> vehicleChoiceBox;
    protected int vehicleIndex;
    protected Parent root;
    protected Scene scene;
    protected Stage stage;
    // Metoda, ki icializira vrednosti v vehicleChoiceBox
    public void initialize(URL arg0, ResourceBundle arg1){
        for (int i = 0; i < PublicTransportApplication.BUS.size(); i++){
            vehicleChoiceBox.getItems().add("Tip vozila: Avtobus     Ime vozila: " + PublicTransportApplication.BUS.get(i).getVehicleName());
        }
        for (int i = 0; i < PublicTransportApplication.TRAIN.size(); i++) {
            vehicleChoiceBox.getItems().add("Tip vozila: Vlak     Ime vozila: " + PublicTransportApplication.TRAIN.get(i).getVehicleName());
        }
    }
    // Metoda, ki izbriše instanco razreda Bus ali Train in izbriše tekstovno datoteko, ki vsebuje podatke tega razreda. Metoda se sproži ob pritisku na gumb
    public void delete(ActionEvent event)throws IOException{
        if (vehicleChoiceBox.getValue().startsWith("Tip vozila: Avtobus")){
            for (int i = 0; i < PublicTransportApplication.BUS.size(); i++){
                if (vehicleChoiceBox.getValue().contains(PublicTransportApplication.BUS.get(i).getVehicleName()))
                    vehicleIndex = i;
            }
            PublicTransportApplication.BUS.remove(vehicleIndex);

            Path filePath = Paths.get("Bus" + vehicleIndex + ".txt");
            Files.delete(filePath);
            Bus.BUS_COUNTER --;
        }
        else if (vehicleChoiceBox.getValue().startsWith("Tip vozila: Vlak")){
            for (int i = 0; i < PublicTransportApplication.TRAIN.size(); i++){
                if (vehicleChoiceBox.getValue().contains(PublicTransportApplication.TRAIN.get(i).getVehicleName()))
                    vehicleIndex = i;
            }
            PublicTransportApplication.TRAIN.remove(vehicleIndex);

            Path filePath = Paths.get("Train" + vehicleIndex + ".txt");
            Files.delete(filePath);
            Train.TRAIN_COUNTER --;
        }
        vehicleChoiceBox.getItems().remove(vehicleChoiceBox.getValue());
        vehicleChoiceBox.getSelectionModel().clearSelection();
    }
    // Metoda, ki spremeni sceno iz trenutne scene na sceno AdministatorScene. Metoda se sproži ob pritisku na gumb
    public void switchToAdministratorScene(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}