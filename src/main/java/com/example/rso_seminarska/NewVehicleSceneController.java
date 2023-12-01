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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewVehicleSceneController implements Initializable {
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

    ArrayList<String> daysOfDriving = new ArrayList<>();
    ArrayList<String> stationName = new ArrayList<>();
    ArrayList<Integer> arrivalHours = new ArrayList<>();
    ArrayList<Integer> arrivalMinutes = new ArrayList<>();

    public void initialize(URL arg0, ResourceBundle arg1){
        vehicleTypeChoiceBox.getItems().addAll("Avtobus", "Vlak");
    }
    public void create(ActionEvent event){

        if (vehicleTypeChoiceBox.getValue().equals("Avtobus")){
            PublicTransportApplication.BUS.add(new Bus());
            PublicTransportApplication.BUS.getLast().setVehicleName(vehicleNameLabel.getText());
            PublicTransportApplication.BUS.getLast().setDriverName(driverNameLabel.getText());

            if (ponedeljekCheckBox.isSelected())
                daysOfDriving.add(ponedeljekCheckBox.getText());
            if (torekCheckBox.isSelected())
                daysOfDriving.add(torekCheckBox.getText());
            if (sredaCheckBox.isSelected())
                daysOfDriving.add(sredaCheckBox.getText());
            if (četrtekCheckBox.isSelected())
                daysOfDriving.add(četrtekCheckBox.getText());
            if (petekCheckBox.isSelected())
                daysOfDriving.add(petekCheckBox.getText());
            if (sobotaCheckBox.isSelected())
                daysOfDriving.add(sobotaCheckBox.getText());
            if (nedeljaCheckBox.isSelected())
                daysOfDriving.add(nedeljaCheckBox.getText());

            PublicTransportApplication.BUS.getLast().setDaysOfDriving(daysOfDriving);
            PublicTransportApplication.BUS.getLast().setStation(stationName);
            PublicTransportApplication.BUS.getLast().setTimetableHours(arrivalHours);
            PublicTransportApplication.BUS.getLast().setTimetableMinutes(arrivalMinutes);

            vehicleNameLabel.setText(null);
            driverNameLabel.setText(null);
            vehicleTypeChoiceBox.getSelectionModel().clearSelection();

            ponedeljekCheckBox.setSelected(false);
            torekCheckBox.setSelected(false);
            sredaCheckBox.setSelected(false);
            četrtekCheckBox.setSelected(false);
            petekCheckBox.setSelected(false);
            sobotaCheckBox.setSelected(false);
            nedeljaCheckBox.setSelected(false);

        }
        else if (vehicleTypeChoiceBox.getValue().equals("Vlak")) {
            PublicTransportApplication.TRAIN.add(new Train());
            PublicTransportApplication.TRAIN.getLast().setVehicleName(vehicleNameLabel.getText());
            PublicTransportApplication.TRAIN.getLast().setDriverName(driverNameLabel.getText());

            if (ponedeljekCheckBox.isSelected())
                daysOfDriving.add(ponedeljekCheckBox.getText());
            if (torekCheckBox.isSelected())
                daysOfDriving.add(torekCheckBox.getText());
            if (sredaCheckBox.isSelected())
                daysOfDriving.add(sredaCheckBox.getText());
            if (četrtekCheckBox.isSelected())
                daysOfDriving.add(četrtekCheckBox.getText());
            if (petekCheckBox.isSelected())
                daysOfDriving.add(petekCheckBox.getText());
            if (sobotaCheckBox.isSelected())
                daysOfDriving.add(sobotaCheckBox.getText());
            if (nedeljaCheckBox.isSelected())
                daysOfDriving.add(nedeljaCheckBox.getText());

            PublicTransportApplication.TRAIN.getLast().setDaysOfDriving(daysOfDriving);
            PublicTransportApplication.TRAIN.getLast().setStation(stationName);
            PublicTransportApplication.TRAIN.getLast().setTimetableHours(arrivalHours);
            PublicTransportApplication.TRAIN.getLast().setTimetableMinutes(arrivalMinutes);

            vehicleNameLabel.setText(null);
            driverNameLabel.setText(null);
            vehicleTypeChoiceBox.getSelectionModel().clearSelection();

            ponedeljekCheckBox.setSelected(false);
            torekCheckBox.setSelected(false);
            sredaCheckBox.setSelected(false);
            četrtekCheckBox.setSelected(false);
            petekCheckBox.setSelected(false);
            sobotaCheckBox.setSelected(false);
            nedeljaCheckBox.setSelected(false);

        }

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
