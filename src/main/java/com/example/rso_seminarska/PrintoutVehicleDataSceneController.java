package com.example.rso_seminarska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrintoutVehicleDataSceneController implements Initializable {
    @FXML
    protected ChoiceBox<String> vehicleChoiceBox;
    @FXML
    protected Label vehicleDataLabel;
    protected Parent root;
    protected Scene scene;
    protected Stage stage;
    // Metoda, ki inicializira vrednosti vehicleChoiceBox
    public void initialize(URL arg0, ResourceBundle arg1){
        for (int i = 0; i < PublicTransportApplication.BUS.size(); i++){
            vehicleChoiceBox.getItems().add("Tip vozila: Avtobus     Ime vozila: " + PublicTransportApplication.BUS.get(i).getVehicleName());
        }
        for (int i = 0; i < PublicTransportApplication.TRAIN.size(); i++) {
            vehicleChoiceBox.getItems().add("Tip vozila: Vlak     Ime vozila: " + PublicTransportApplication.TRAIN.get(i).getVehicleName());
        }
    }
    // Metoda, ki izpiše vse podatke objekta tipa Train ali Bus, glede na kateri objekt izberemo. Metoda se sproži ob pritisku na gumb
    public void printoutVehicleData(ActionEvent event)throws IOException{
        if (vehicleChoiceBox.getValue().startsWith("Tip vozila: Avtobus")){
            for (int i = 0; i < PublicTransportApplication.BUS.size(); i++){
                if (vehicleChoiceBox.getValue().endsWith(PublicTransportApplication.BUS.get(i).getVehicleName())){
                    PublicTransportApplication.BUS.get(i).allDataPrintout(vehicleDataLabel);
                }
            }
        }
        else if (vehicleChoiceBox.getValue().startsWith("Tip vozila: Vlak")){
            for (int i = 0; i < PublicTransportApplication.TRAIN.size(); i++){
                if (vehicleChoiceBox.getValue().endsWith(PublicTransportApplication.TRAIN.get(i).getVehicleName())){
                    PublicTransportApplication.TRAIN.get(i).allDataPrintout(vehicleDataLabel);
                }
            }
        }
    }
    // Metoda, ki spremeni sceno iz trenutne scene na AdmininstratorScene. Metoda se sproži ob pritisku na gumb
    public void switchToAdministratorScene(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
