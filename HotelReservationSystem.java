import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private boolean isBooked;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        isBooked = true;
    }

    public void cancelBooking() {
        isBooked = false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", category='" + category + '\'' +
                ", isBooked=" + isBooked +
                '}';
    }
}

class Booking {
    private Room room;
    private String customerName;
    private String paymentStatus;

    public Booking(Room room, String customerName) {
        this.room = room;
        this.customerName = customerName;
        this.paymentStatus = "Pending";
    }

    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void completePayment() {
        paymentStatus = "Completed";
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", customerName='" + customerName + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}

public class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        int choice;
        
            System.out.println("Hotel Reservation System");
            System.out.println("1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            do{
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
         // Consume newline

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Single"));
        rooms.add(new Room(105, "Double"));
    }

    private static void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation() {
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Room room = getRoomByNumber(roomNumber);

        if (room == null || room.isBooked()) {
            System.out.println("Room is not available.");
        } else {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            room.bookRoom();
            Booking booking = new Booking(room, customerName);
            bookings.add(booking);
            System.out.println("Reservation made successfully.");
            processPayment(booking);
        }
    }

    private static void processPayment(Booking booking) {
        System.out.println("Processing payment for booking: " + booking);
        booking.completePayment();
        System.out.println("Payment completed.");
    }

    private static void viewBookingDetails() {
        System.out.print("Enter room number to view booking details: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber) {
                System.out.println(booking);
                return;
            }
        }
        System.out.println("No booking found for the given room number.");
    }

    private static Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
