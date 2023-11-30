package com.example.rso_seminarska;

import java.util.ArrayList;

public class Train extends Vehicle{
    public Train(String vehicleName, String driverName, ArrayList<String> station, ArrayList<String> daysOfDriving, ArrayList<Integer> timetableHours, ArrayList<Integer> timetableMinutes){

    }
    public Train(){

    }
    @Override
    public void allDataPrintout() {
        System.out.println("Ime vlaka: "+ vehicleName);
        System.out.println("Ime voznika: "+ driverName);
        String dd = "";
        for (int i=1; i<daysOfDriving.size(); i++){
            dd = dd + "   " + daysOfDriving.get(i);
        }
        System.out.println("Dnevi vožnje v tednu: "+ dd);
        for (int i=0; i<daysOfDriving.size(); i++){
            System.out.println("postaja: " + station.get(i) + ",   prihod: " + timetableHours.get(i) + "h" + timetableMinutes.get(i) + "min");
        }
        System.out.println();
    }
}
