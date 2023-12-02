package com.example.rso_seminarska;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewVehicleSceneController implements Initializable{
    @FXML
    protected ChoiceBox<String> vehicleTypeChoiceBox;
    @FXML
    protected TextField vehicleNameLabel;
    @FXML
    protected TextField driverNameLabel;
    @FXML
    protected ListView<String> daysOfDrivingListView;
    @FXML
    protected CheckBox ponedeljekCheckBox, torekCheckBox, sredaCheckBox, četrtekCheckBox, petekCheckBox, sobotaCheckBox, nedeljaCheckBox;
    @FXML
    protected TextField stationNameTextField;
    @FXML
    protected TextField arrivalHoursTextField;
    @FXML
    protected TextField arrivalMinutesTextField;
    @FXML
    protected Parent root;
    @FXML
    protected Scene scene;
    @FXML
    protected Stage stage;

    ArrayList<String> stationName = new ArrayList<>();

    ArrayList<Integer> arrivalHours = new ArrayList<>();
    ArrayList<Integer> arrivalMinutes = new ArrayList<>();
    public void initialize(URL arg0, ResourceBundle arg1){
        vehicleTypeChoiceBox.getItems().addAll("Avtobus", "Vlak");
    }
    public void create(ActionEvent event){

        if (vehicleTypeChoiceBox.getValue().equals("Avtobus")){
            Bus bus = new Bus();
            bus.setVehicleName(vehicleNameLabel.getText());

            ArrayList<String> daysOfDriving = getCheckBoxes();
            bus.setVehicleName(vehicleNameLabel.getText());
            bus.setDriverName(driverNameLabel.getText());

            bus.setDaysOfDriving(daysOfDriving);
            bus.setStation((ArrayList<String>)stationName.clone());
            bus.setTimetableHours((ArrayList<Integer>)arrivalHours.clone());
            bus.setTimetableMinutes((ArrayList<Integer>)arrivalHours.clone());

            PublicTransportApplication.BUS.add(bus);
            vehicleNameLabel.setText(null);
            driverNameLabel.setText(null);
            vehicleTypeChoiceBox.getSelectionModel().clearSelection();

            stationName.clear();
            arrivalHours.clear();
            arrivalMinutes.clear();
            disableCheckBoxes();
        }
        else if (vehicleTypeChoiceBox.getValue().equals("Vlak")) {
            Train train = new Train();
            train.setVehicleName(vehicleNameLabel.getText());

            ArrayList<String> daysOfDriving = getCheckBoxes();
            train.setVehicleName(vehicleNameLabel.getText());
            train.setDriverName(driverNameLabel.getText());

            train.setDaysOfDriving(daysOfDriving);
            train.setStation((ArrayList<String>)stationName.clone());
            train.setTimetableHours((ArrayList<Integer>)arrivalHours.clone());
            train.setTimetableMinutes((ArrayList<Integer>)arrivalHours.clone());

            PublicTransportApplication.TRAIN.add(train);
            vehicleNameLabel.setText(null);
            driverNameLabel.setText(null);
            vehicleTypeChoiceBox.getSelectionModel().clearSelection();

            stationName.clear();
            arrivalHours.clear();
            arrivalMinutes.clear();
            disableCheckBoxes();
        }

    }
    private void disableCheckBoxes(){
        ponedeljekCheckBox.setSelected(false);
        torekCheckBox.setSelected(false);
        sredaCheckBox.setSelected(false);
        četrtekCheckBox.setSelected(false);
        petekCheckBox.setSelected(false);
        sobotaCheckBox.setSelected(false);
        nedeljaCheckBox.setSelected(false);
    }
    private ArrayList<String> getCheckBoxes(){
        ArrayList<String> daysOfDriving = new ArrayList<>();

        if (ponedeljekCheckBox.isSelected())
            daysOfDriving.add("Ponedeljek");
        if (torekCheckBox.isSelected())
            daysOfDriving.add("Torek");
        if (sredaCheckBox.isSelected())
            daysOfDriving.add("Sreda");
        if (četrtekCheckBox.isSelected())
            daysOfDriving.add("Četrtek");
        if (petekCheckBox.isSelected())
            daysOfDriving.add("Petek");
        if (sobotaCheckBox.isSelected())
            daysOfDriving.add("Sobota");
        if (nedeljaCheckBox.isSelected())
            daysOfDriving.add("Nedelja");

        return daysOfDriving;
    }
    public void addStation(ActionEvent event)throws IOException{
        stationName.add(stationNameTextField.getText());
        arrivalHours.add(Integer.parseInt(arrivalHoursTextField.getText()));
        arrivalMinutes.add(Integer.parseInt(arrivalMinutesTextField.getText()));

        stationNameTextField.setText(null);
        arrivalHoursTextField.setText(null);
        arrivalMinutesTextField.setText(null);
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
