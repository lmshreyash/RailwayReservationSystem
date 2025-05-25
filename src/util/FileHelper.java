package util;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    public static void ensureFiles() {
        try {
            File trainFile = new File("trains.txt");
            if (!trainFile.exists()) trainFile.createNewFile();

            File bookingFile = new File("bookings.txt");
            if (!bookingFile.exists()) bookingFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Error initializing files.");
        }
    }
}