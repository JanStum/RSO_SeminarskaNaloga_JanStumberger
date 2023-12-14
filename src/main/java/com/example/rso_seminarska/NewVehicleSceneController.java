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

public class NewVehicleSceneController implements Initializable{
    @FXML
    protected ChoiceBox<String> vehicleTypeChoiceBox;
    @FXML
    protected TextField vehicleNameLabel;
    @FXML
    protected TextField driverNameLabel;
    @FXML
    protected CheckBox ponedeljekCheckBox, torekCheckBox, sredaCheckBox, četrtekCheckBox, petekCheckBox, sobotaCheckBox, nedeljaCheckBox;
    @FXML
    protected TextField stationNameTextField, arrivalHoursTextField, arrivalMinutesTextField;
    @FXML
    protected Label addStationErrorLabel, createErrorLabel;
    protected Parent root;
    protected Scene scene;
    protected Stage stage;
    ArrayList<String> stationName = new ArrayList<>();
    ArrayList<Integer> arrivalHours = new ArrayList<>();
    ArrayList<Integer> arrivalMinutes = new ArrayList<>();
    // Metoda, ki inicalizira vrednosti vehicleTypeChoiceBox
    public void initialize(URL arg0, ResourceBundle arg1){
        vehicleTypeChoiceBox.getItems().addAll("Avtobus", "Vlak");
    }
    // Metoda, ki ustvari novo istanco razreda Bus ali Train, ji določi vse potrebne lastnosti in jo da v ArrayList. Metoda se sproži ob pritisku na gumb
    public void create(ActionEvent event) throws IOException {
        try {
            if (vehicleTypeChoiceBox.getValue().equals("Avtobus")){
                createErrorLabel.setText(null);
                Bus bus = new Bus();
                bus.setVehicleName(vehicleNameLabel.getText());

                ArrayList<String> daysOfDriving = getCheckBoxes();
                bus.setVehicleName(vehicleNameLabel.getText());
                bus.setDriverName(driverNameLabel.getText());

                bus.setDaysOfDriving(daysOfDriving);
                bus.setStation((ArrayList<String>)stationName.clone());
                bus.setTimetableHours((ArrayList<Integer>)arrivalHours.clone());
                bus.setTimetableMinutes((ArrayList<Integer>)arrivalMinutes.clone());

                PublicTransportApplication.BUS.add(bus);
                bus.createTextFileFromBus();
                vehicleNameLabel.setText(null);
                driverNameLabel.setText(null);
                vehicleTypeChoiceBox.getSelectionModel().clearSelection();

                stationName.clear();
                arrivalHours.clear();
                arrivalMinutes.clear();
                disableCheckBoxes();
            }
            else if (vehicleTypeChoiceBox.getValue().equals("Vlak")) {
                createErrorLabel.setText(null);
                Train train = new Train();
                train.setVehicleName(vehicleNameLabel.getText());

                ArrayList<String> daysOfDriving = getCheckBoxes();
                train.setVehicleName(vehicleNameLabel.getText());
                train.setDriverName(driverNameLabel.getText());

                train.setDaysOfDriving(daysOfDriving);
                train.setStation((ArrayList<String>)stationName.clone());
                train.setTimetableHours((ArrayList<Integer>)arrivalHours.clone());
                train.setTimetableMinutes((ArrayList<Integer>)arrivalMinutes.clone());

                PublicTransportApplication.TRAIN.add(train);
                train.createTextFileFromTrain();
                vehicleNameLabel.setText(null);
                driverNameLabel.setText(null);
                vehicleTypeChoiceBox.getSelectionModel().clearSelection();

                stationName.clear();
                arrivalHours.clear();
                arrivalMinutes.clear();
                disableCheckBoxes();
            }
        }
        catch (NullPointerException e) {
            createErrorLabel.setText("Določiti je treba vrsto vozila!");
        }
    }
    // Metoda, ki odkljuka vsa potrditvena polja
    private void disableCheckBoxes(){
        ponedeljekCheckBox.setSelected(false);
        torekCheckBox.setSelected(false);
        sredaCheckBox.setSelected(false);
        četrtekCheckBox.setSelected(false);
        petekCheckBox.setSelected(false);
        sobotaCheckBox.setSelected(false);
        nedeljaCheckBox.setSelected(false);
    }
    // Metoda, ki vrne ArrayList z vsemi vrednostmi vseh obkljukanih potrditvenih polj
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
    // Metoda, ki ŠE NE NAREJENEMU objektu tipa Train ali Bus doda postaje in čase prihoda do teh postaj. Metoda se sproži ob pritisku na gumb
    public void addStation(ActionEvent event){
        if (!stationNameTextField.getText().isEmpty() && !arrivalHoursTextField.getText().isEmpty() && !arrivalMinutesTextField.getText().isEmpty()){
            try{
                Integer.parseInt(arrivalHoursTextField.getText());
                Integer.parseInt(arrivalMinutesTextField.getText());

                arrivalHours.add(Integer.parseInt(arrivalHoursTextField.getText()));
                arrivalMinutes.add(Integer.parseInt(arrivalMinutesTextField.getText()));
                stationName.add(stationNameTextField.getText());
                stationNameTextField.setText(null);
                arrivalHoursTextField.setText(null);
                arrivalMinutesTextField.setText(null);
                addStationErrorLabel.setText(null);
            }
            catch (NumberFormatException e){
                addStationErrorLabel.setText("V čas prihoda lahko vpišeš le števila!");
            }
        }
        else {
            addStationErrorLabel.setText("Zapolni vse pogoje pred ustvarjanjem postaje!");
        }
    }
    // Metoda, ki iz trenutne scene spremeni sceno na AdministratorScene. Metoda se sproži ob pritisku na gumb
    public void switchToAdministratorScene(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorScene.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
