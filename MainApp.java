import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private ArrayList<User> users = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private User loggedInUser;

    public static void main(String[] args) {
        new MainApp().run();
    }

    private void run() {
        System.out.println("Welcome to the Rental Management System!");

        while (!authenticateUser()) {
            // keep prompting until login succeeds
        }

        showMainMenu();
    }

    private boolean authenticateUser() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Register New User");
        System.out.println("2. Login Existing User");
        System.out.println("3. Exit");
        System.out.print("Enter Choice: ");

        int option = readInteger();

        switch (option) {
            case 1:
                registerUser();
                return false;
            case 2:
                return loginUser();
            case 3:
                System.out.println("Exiting System...");
                System.exit(0);
                return false;
            default:
                System.out.println("Invalid Choice. Please try again.");
                return false;
        }
    }

    private void registerUser() {
        System.out.print("Enter new username: ");
        String username = sc.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        if (findUser(username) != null) {
            System.out.println("Username already exists. Please login or choose a different username.");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        users.add(new User(username, password));
        System.out.println("Registration successful. Please login with your new account.");
    }

    private boolean loginUser() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();
        User user = findUser(username);

        if (user == null) {
            System.out.println("User not found. Please register first.");
            return false;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (!user.checkPassword(password)) {
            System.out.println("Incorrect password. Please try again.");
            return false;
        }

        loggedInUser = user;
        System.out.println("Login successful. Welcome, " + loggedInUser.getUsername() + "!");
        return true;
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    private void showMainMenu() {
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n===== RENTAL SYSTEM =====");
            System.out.println("Logged in as: " + loggedInUser.getUsername());
            System.out.println("1. Books");
            System.out.println("2. Vehicles");
            System.out.println("3. Clothes");
            System.out.println("4. Electronics");
            System.out.println("5. Rooms");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = readInteger();

            switch (choice) {
                case 1:
                    new BookRental().start();
                    break;
                case 2:
                    new VehicleRental().start();
                    break;
                case 3:
                    new ClothesRental().start();
                    break;
                case 4:
                    new ElectronicsRental().start();
                    break;
                case 5:
                    new RoomsRental().start();
                    break;
                case 6:
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private int readInteger() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
