package com.example.rso_seminarska;

import javafx.scene.control.Label;
import java.util.ArrayList;

public abstract class Vehicle {
    protected String vehicleName;
    protected String driverName;
    protected ArrayList<String> station = new ArrayList<>();
    protected ArrayList<String> daysOfDriving = new ArrayList<>();
    protected ArrayList<Integer> timetableHours = new ArrayList<>();
    protected ArrayList<Integer> timetableMinutes = new ArrayList<>();

    public String getVehicleName() {
        return vehicleName;
    }

    public String getDriverName() {
        return driverName;
    }

    public ArrayList<String> getStation() {
        return station;
    }

    public ArrayList<String> getDaysOfDriving() {
        return daysOfDriving;
    }

    public ArrayList<Integer> getTimetableHours() {
        return timetableHours;
    }

    public ArrayList<Integer> getTimetableMinutes() {
        return timetableMinutes;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setStation(ArrayList<String> station) {
        this.station = station;
    }

    public void setDaysOfDriving(ArrayList<String> daysOfDriving) {
        this.daysOfDriving = daysOfDriving;
    }

    public void setTimetableHours(ArrayList<Integer> timetableHours) {
        this.timetableHours = timetableHours;
    }

    public void setTimetableMinutes(ArrayList<Integer> timetableMinutes) {
        this.timetableMinutes = timetableMinutes;
    }

    public boolean compareStation(String compare){
        boolean comparison = true;
        for (int i=0; i<station.size(); i++){
            if (comparison == station.get(i).equals(compare))
                return true;
        }
        return false;
    }

    // Metoda, ki primerja, če vpisani dan vožnje enak kot ta, ki ga je zapisal uporabnik
    public boolean compareDaysOfDriving(String dd){
        for (int i=0; i<daysOfDriving.size(); i++){
            if (daysOfDriving.get(i).equals(dd))
                return true;
        }
        return false;
    }
    // Metoda za izpis voznega reda avtobusa
    public void timetablePrintout(String entryStation, String exitStation, Label timetableLabel){
        String text = "";
        for (int i=0; i< station.size(); i++){
            if (station.get(i).equals(entryStation) || station.get(i).equals(exitStation))
                text += "     Postaja:     " + station.get(i) + ",     Prihod:     " + timetableHours.get(i) + "h" + timetableMinutes.get(i) + "min\n";
            else
                text += "Postaja:     " + station.get(i) +  ",     Prihod:     " + timetableHours.get(i) + "h" + timetableMinutes.get(i) + "min\n";
        }
        timetableLabel.setText(text);
    }
    // Metoda za izračun časa vožnje, glede na uporabnikov vpis vstopne in izstopne postaje
    public String travelTime(String entryStation, String exitStation){
        int minuend = 0; int subtrahend = 0;
        int difference, hourDifference, minuteDifference;
        for (int i=0; i<station.size(); i++){
            if (station.get(i).equals(entryStation)){
                subtrahend = timetableHours.get(i)*60 + timetableMinutes.get(i);
                break;
            }
        }
        for (int i=0; i<station.size(); i++){
            if (station.get(i).equals(exitStation)){
                minuend = timetableHours.get(i)*60 + timetableMinutes.get(i);
                break;
            }
        }
        difference = minuend - subtrahend;
        hourDifference = difference/60;
        minuteDifference = difference - hourDifference*60;
        return hourDifference + "h" + minuteDifference + "min";
    }
    // Metoda za izpis vseh podatkov vozila
    public abstract void allDataPrintout(Label vehicleDataLabel);
}