package com.example.rso_seminarska;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class PublicTransportApplication extends Application {
    static ArrayList<Bus> BUS = new ArrayList<>();
    static ArrayList<Train> TRAIN = new ArrayList<>();

    @Override
    @FXML
    // Metoda, ki zažene program
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MenuScene.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Javni prevoz");
        stage.setScene(scene);
        stage.show();
    }
    // Main metoda, ki kliče metode za ustvarjanje objektov tipa Bus in Train iz tekstovnih datotek in kliče metodo za zagon programa
    public static void main(String[] args) throws IOException {
        createBusFromTextFile();
        createTrainFromTextFile();
        launch();
    }
    // Metoda za ustvarjanje objekta tipa Bus iz tekstovne datoteke
    public static void createBusFromTextFile()throws IOException{
        BufferedReader br;
        boolean fileExistence = true;
        int i = 0;
        while (fileExistence){
            try {
                br = new BufferedReader(new FileReader("Bus" + i + ".txt"));
                BUS.add(new Bus());
                Bus.BUS_COUNTER ++;

                BUS.get(i).setVehicleName(br.readLine());
                BUS.get(i).setDriverName(br.readLine());
                BUS.get(i).setDaysOfDriving(new ArrayList<>(Arrays.asList(br.readLine().split(" "))));

                ArrayList<String> station = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
                for (int j = 0; j < station.size(); j++)
                    station.set(j, station.get(j).replace("#", " "));
                BUS.get(i).setStation(station);

                ArrayList<String> timetableHoursString = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
                ArrayList<Integer> timetableHoursInteger = new ArrayList<>();
                for (int j = 0; j < timetableHoursString.size(); j++)
                    timetableHoursInteger.add(Integer.parseInt(timetableHoursString.get(j)));
                BUS.get(i).setTimetableHours(timetableHoursInteger);

                ArrayList<String> timetableMinutesString = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
                ArrayList<Integer> timetableMinutesInteger = new ArrayList<>();
                for (int j = 0; j < timetableMinutesString.size(); j++)
                    timetableMinutesInteger.add(Integer.parseInt(timetableMinutesString.get(j)));
                BUS.get(i).setTimetableMinutes(timetableMinutesInteger);

                i++;
            }
            catch (FileNotFoundException e){
                fileExistence = false;
            }

        }
    }
    // Metoda za ustvarjanje objekta tipa Train iz tekstovne datoteke
    public static void createTrainFromTextFile()throws IOException{
        BufferedReader br;
        boolean fileExistence = true;
        int i = 0;
        while (fileExistence){
            try {
                br = new BufferedReader(new FileReader("Train" + i + ".txt"));
                TRAIN.add(new Train());
                Train.TRAIN_COUNTER++;

                TRAIN.get(i).setVehicleName(br.readLine());
                TRAIN.get(i).setDriverName(br.readLine());
                TRAIN.get(i).setDaysOfDriving(new ArrayList<>(Arrays.asList(br.readLine().split(" "))));

                ArrayList<String> station = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
                for (int j = 0; j < station.size(); j++)
                    station.set(j, station.get(j).replace("#", " "));
                TRAIN.get(i).setStation(station);

                ArrayList<String> timetableHoursString = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
                ArrayList<Integer> timetableHoursInteger = new ArrayList<>();
                for (int j = 0; j < timetableHoursString.size(); j++)
                    timetableHoursInteger.add(Integer.parseInt(timetableHoursString.get(j)));
                TRAIN.get(i).setTimetableHours(timetableHoursInteger);

                ArrayList<String> timetableMinutesString = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));
                ArrayList<Integer> timetableMinutesInteger = new ArrayList<>();
                for (int j = 0; j < timetableMinutesString.size(); j++)
                    timetableMinutesInteger.add(Integer.parseInt(timetableMinutesString.get(j)));
                TRAIN.get(i).setTimetableMinutes(timetableMinutesInteger);

                i++;
            }
            catch (FileNotFoundException e){
                fileExistence = false;
            }

        }
    }
}