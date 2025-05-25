package dao;

import model.Train;
import java.io.*;
import java.util.*;

public class TrainDAO {

    private static final String TRAIN_FILE = "trains.txt";
    private static final String BOOKING_FILE = "bookings.txt";

    public void addTrain(Train train) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TRAIN_FILE, true))) {
            bw.write(train.toString());
            bw.newLine();
        }
    }

    public List<Train> getAllTrains() throws IOException {
        List<Train> trains = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TRAIN_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Train train = Train.fromString(line);
                if (train != null) trains.add(train);
            }
        }
        return trains;
    }

    public void updateTrain(String id, Train updatedTrain) throws IOException {
        List<Train> trains = getAllTrains();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TRAIN_FILE))) {
            for (Train t : trains) {
                if (t.getId().equals(id)) {
                    bw.write(updatedTrain.toString());
                } else {
                    bw.write(t.toString());
                }
                bw.newLine();
            }
        }
    }

    public void deleteTrain(String id) throws IOException {
        List<Train> trains = getAllTrains();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TRAIN_FILE))) {
            for (Train t : trains) {
                if (!t.getId().equals(id)) {
                    bw.write(t.toString());
                    bw.newLine();
                }
            }
        }
    }

    public void bookTrain(String trainId, String passengerName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKING_FILE, true))) {
            bw.write(trainId + "," + passengerName);
            bw.newLine();
        }
    }

    public void cancelBooking(String trainId, String passengerName) throws IOException {
        List<String> bookings = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKING_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(trainId + "," + passengerName)) {
                    bookings.add(line);
                }
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKING_FILE))) {
            for (String b : bookings) {
                bw.write(b);
                bw.newLine();
            }
        }
    }

    public void viewBookings() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKING_FILE))) {
            String line;
            System.out.println("Bookings:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    System.out.println("Train ID: " + parts[0] + ", Passenger: " + parts[1]);
                }
            }
        }
    }
}