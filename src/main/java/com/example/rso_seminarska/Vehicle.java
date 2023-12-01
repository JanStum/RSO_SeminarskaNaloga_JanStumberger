package com.example.rso_seminarska;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    // Metoda sprejme parameter, ki določa dan vožnje in je tipa String
    // Metoda vrne true, če je parameter enak enemu od dni vožne na keterega avtobus vozi in false, če ni
    public boolean compareDaysOfDriving(String dd){
        for (int i=0; i<daysOfDriving.size(); i++){
            if (daysOfDriving.get(i).equals(dd))
                return true;
        }
        return false;
    }
    // Metoda za izpis voznega reda avtobusa
    // Vhodna podatka sta vstopna in izstopna postaja tipa String
    // Metoda ne vrne vračane vrednosti
    public void timetablePrintout(String entryStation, String exitStation){
        for (int i=0; i< station.size(); i++){
            if (station.get(i).equals(entryStation) || station.get(i).equals(exitStation))
                System.out.println("    Postaja: " + station.get(i) + ",   prihod: " + timetableHours.get(i) + "h" + timetableMinutes.get(i) + "min");
            else
                System.out.println("Postaja: " + station.get(i) +  ",   prihod: " + timetableHours.get(i) + "h" + timetableMinutes.get(i) + "min");
        }
    }
    // Metoda za izračun časa vožnje, glede na uporabnikov vpis vstopne in izstopne postaje
    // Vhodna podatka sta vstopna in izstopna postaja
    // Izhodni podatek je čas vožnje tipa String
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
        return Integer.toString(hourDifference)+"h"+Integer.toString(minuteDifference)+"min";
    }
    // Metoda za izpis vseh podatkov vozila
    // Metoda nima vhodnih ali izhodnih podatkov
    public abstract void allDataPrintout(TextArea vehicleDataTextArea);
}
