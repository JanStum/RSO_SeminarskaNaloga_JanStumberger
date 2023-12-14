package com.example.rso_seminarska;
import javafx.scene.control.Label;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Bus extends Vehicle{
    static int BUS_COUNTER = 0;
    @Override
    // Metoda za izpis vseh podatkov avtobusa v vehicleDataLabel
    public void allDataPrintout(Label vehicleDataLabel) {
        String text = "Tip vozila:     Avtobus\n";
        text += "Ime avtobusa:     " + vehicleName + "\n";
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
    // Metoda, ki iz instance razreda Bus naredi novo .txt datoteko, ki vsebuje vse lastnosti tega vozila, da jo lahko ob ponovnem zagonu programa pretvorimo nazaj v objekt
    public void createTextFileFromBus()throws IOException {
         BufferedWriter bw = new BufferedWriter(new FileWriter("Bus" + BUS_COUNTER + ".txt"));
         BUS_COUNTER ++;

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