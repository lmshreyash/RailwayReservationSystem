package main;

import dao.TrainDAO;
import model.Train;
import util.FileHelper;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileHelper.ensureFiles();
        TrainDAO dao = new TrainDAO();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n--- Railway Reservation System ---");
            System.out.println("1. Add Train");
            System.out.println("2. View All Trains");
            System.out.println("3. Modify Train");
            System.out.println("4. Delete Train");
            System.out.println("5. Book Train");
            System.out.println("6. Cancel Booking");
            System.out.println("7. View Bookings");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Train ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Train Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Source: ");
                        String source = sc.nextLine();
                        System.out.print("Enter Destination: ");
                        String dest = sc.nextLine();
                        dao.addTrain(new Train(id, name, source, dest));
                        System.out.println("✅ Train added successfully!");
                        break;

                    case 2:
                        List<Train> trains = dao.getAllTrains();
                        if (trains.isEmpty()) {
                            System.out.println("⚠️ No trains found.");
                        } else {
                            System.out.println("📋 List of Trains:");
                            for (Train t : trains) {
                                System.out.println(t);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter Train ID to modify: ");
                        String modId = sc.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new Source: ");
                        String newSource = sc.nextLine();
                        System.out.print("Enter new Destination: ");
                        String newDest = sc.nextLine();
                        dao.updateTrain(modId, new Train(modId, newName, newSource, newDest));
                        System.out.println("✅ Train updated successfully!");
                        break;

                    case 4:
                        System.out.print("Enter Train ID to delete: ");
                        String delId = sc.nextLine();
                        dao.deleteTrain(delId);
                        System.out.println("🗑️ Train deleted successfully!");
                        break;

                    case 5:
                        System.out.print("Enter Train ID to book: ");
                        String bookId = sc.nextLine();
                        System.out.print("Enter Passenger Name: ");
                        String passenger = sc.nextLine();
                        dao.bookTrain(bookId, passenger);
                        System.out.println("✅ Booking successful!");
                        break;

                    case 6:
                        System.out.print("Enter Train ID to cancel: ");
                        String cancelId = sc.nextLine();
                        System.out.print("Enter Passenger Name: ");
                        String cancelName = sc.nextLine();
                        dao.cancelBooking(cancelId, cancelName);
                        System.out.println("❌ Booking cancelled successfully!");
                        break;

                    case 7:
                        System.out.println("📖 Viewing All Bookings:");
                        dao.viewBookings();
                        break;

                    case 8:
                        System.out.println("👋 Thank you for using the system.");
                        running = false;
                        break;

                    default:
                        System.out.println("⚠️ Invalid choice. Please select between 1 and 8.");
                }
            } catch (IOException e) {
                System.out.println("❌ An error occurred: " + e.getMessage());
            }
        }

        sc.close();
    }
}
