package com.example.rso_seminarska;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Train extends Vehicle{
    static int TRAIN_COUNTER = 0;
    public Train(String vehicleName, String driverName, ArrayList<String> station, ArrayList<String> daysOfDriving, ArrayList<Integer> timetableHours, ArrayList<Integer> timetableMinutes){

    }
    public Train(){

    }
    @Override
    public void allDataPrintout(Label vehicleDataLabel) {
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
        vehicleDataLabel.setText(text);
    }
    public void createTextFileFromTrain()throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Train" + TRAIN_COUNTER + ".txt"));
        TRAIN_COUNTER ++;

        bw.write(getVehicleName() + "\n");
        bw.write(getDriverName() + "\n");
        for (int i = 0; i < daysOfDriving.size(); i++)
            bw.write(daysOfDriving.get(i) + " ");
        bw.write("\n");
        for (int i = 0; i < station.size(); i++){
            bw.write(station.get(i).replace(" ", "#") + " ");
        }
        bw.write("\n");
        for (int i = 0; i < timetableHours.size(); i++)
            bw.write(timetableHours.get(i) + " ");
        bw.write("\n");
        for (int i = 0; i < timetableMinutes.size(); i++)
            bw.write(timetableMinutes.get(i) + " ");
        bw.write("\n");
        bw.close();
    }
}