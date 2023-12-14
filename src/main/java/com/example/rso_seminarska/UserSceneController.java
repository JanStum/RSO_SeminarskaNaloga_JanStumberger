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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSceneController implements Initializable {
    @FXML
    protected ChoiceBox<String> vehicleTypeChoiceBox, weekdayChoiceBox;
    @FXML
    protected TextField entryStationTextField, exitStationTextField;
    @FXML
    protected Label timetableLabel;
    protected Parent root;
    protected Stage stage;
    protected Scene scene;
    protected String vehicleType, weekday, entryStation, exitStation;

    // Metoda, ki inicializira vrednost za vehicleChoiceBox in weekdayChoiceBox
    public void initialize(URL arg0, ResourceBundle arg1){
        vehicleTypeChoiceBox.getItems().addAll("Avtobus", "Vlak");
        weekdayChoiceBox.getItems().addAll("Ponedeljek", "Torek", "Sreda", "Četrtek", "Petek", "Sobota", "Nedelja");
    }
    // Metoda, ki uporabniku v timetableLabel zapiše celoten spored vožnje vlaka ali avtobusa in čas vožnje glede na izbrane postaje. Metoda se sproži ob pritisku na gumb
    public void showTimetable(ActionEvent event) {
        vehicleType = vehicleTypeChoiceBox.getValue();
        entryStation = entryStationTextField.getText();
        exitStation = exitStationTextField.getText();
        weekday = weekdayChoiceBox.getValue();

        vehicleTypeChoiceBox.getSelectionModel().clearSelection();
        entryStationTextField.setText(null);
        exitStationTextField.setText(null);
        weekdayChoiceBox.getSelectionModel().clearSelection();

        Bus bus;
        Train train;
        if (vehicleType.equals("Avtobus")){
            bus = findBus();
            bus.timetablePrintout(entryStation, exitStation, timetableLabel);
            timetableLabel.setText(timetableLabel.getText() + "\nČas vožnje: " + bus.travelTime(entryStation, exitStation));
        }
        else if (vehicleType.equals("Vlak")){
            train = findTrain();
            train.timetablePrintout(entryStation, exitStation, timetableLabel);
            timetableLabel.setText(timetableLabel.getText() + "\nČas vožnje: " + train.travelTime(entryStation, exitStation));
        }
    }
    // Metoda, ki iz trenutne scene zamenja sceno na MenuScene. Metoda se sproži ob pritisku na gumb
    public void switchToMenuScene(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Metoda, ki poišče objekt tipa Bus, ki se ujema po podatkih, ki smo jih vnesli (vhodni postaji, izhodni postaji in dnevu v tednu) in ga vrne. Metoda se sproži ob pritisku na gumb
    public Bus findBus(){
        for (int i = 0; i < PublicTransportApplication.BUS.size(); i++){
            Bus bus = PublicTransportApplication.BUS.get(i);
            if (bus.compareStation(entryStation) && bus.compareStation(exitStation) && bus.compareDaysOfDriving(weekday)){
                return bus;
            }
        }
        return new Bus();
    }
    // Metoda, ki poišče objekt tipa Train, ki se ujema po podatkih, ki smo jih vnesli (vhodni postaji, izhodni postaji in dnevu v tednu) in ga vrne. Metoda se sproži ob pritisku na gumb
    public Train findTrain(){
        for (int i = 0; i < PublicTransportApplication.TRAIN.size(); i++){
            Train train = PublicTransportApplication.TRAIN.get(i);
            if (train.compareStation(entryStation) && train.compareStation(exitStation) && train.compareDaysOfDriving(weekday)){
                return train;
            }
        }
        return new Train();
    }
}