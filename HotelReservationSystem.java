import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isBooked;
    String guestName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.guestName = "";
    }

    public void bookRoom(String guestName) {
        if (!isBooked) {
            this.isBooked = true;
            this.guestName = guestName;
            System.out.println("Room " + roomNumber + " booked successfully for " + guestName);
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    public void cancelBooking() {
        if (isBooked) {
            System.out.println("Booking for room " + roomNumber + " cancelled.");
            this.isBooked = false;
            this.guestName = "";
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }
}

public class HotelReservationSystem {
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize rooms
        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room(i));
        }

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    bookRoom(roomNumber, guestName);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel booking: ");
                    int cancelRoom = scanner.nextInt();
                    cancelBooking(cancelRoom);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void viewRooms() {
        for (Room room : rooms) {
            String status = room.isBooked ? "Booked by " + room.guestName : "Available";
            System.out.println("Room " + room.roomNumber + ": " + status);
        }
    }

    public static void bookRoom(int roomNumber, String guestName) {
        if (roomNumber >= 1 && roomNumber <= rooms.size()) {
            rooms.get(roomNumber - 1).bookRoom(guestName);
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public static void cancelBooking(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= rooms.size()) {
            rooms.get(roomNumber - 1).cancelBooking();
        } else {
            System.out.println("Invalid room number.");
        }
    }
}
