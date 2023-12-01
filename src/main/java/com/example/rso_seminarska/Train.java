package com.example.rso_seminarska;

import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Train extends Vehicle{
    public Train(String vehicleName, String driverName, ArrayList<String> station, ArrayList<String> daysOfDriving, ArrayList<Integer> timetableHours, ArrayList<Integer> timetableMinutes){

    }
    public Train(){

    }
    @Override
    public void allDataPrintout(TextArea vehicleDataTextArea) {
        String text = "Tip vozila:     Vlak\n";
        text += "Ime vlaka:     " + vehicleName + "\n";
        text += "Ime voznika:     " + driverName + "\n";
        String drivingDays = daysOfDriving.get(0);
        for (int i=1; i<daysOfDriving.size(); i++){
            drivingDays += "     " + daysOfDriving.get(i);
        }
        text += "Dnevi vožnje v tednu:     " + drivingDays + "\n\n";
        for (int i=0; i<station.size(); i++){
            text += "Postaja:     " + station.get(i) + ",     Prihod:     " + timetableHours.get(i) + "h" + timetableMinutes.get(i) + "min\n";
        }
        vehicleDataTextArea.setText(text);
    }
}
