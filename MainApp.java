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
        System.out.println(ColorUtils.header("==========================================="));
        System.out.println(ColorUtils.header("  |        RENTAL MANAGEMENT SYSTEM        |"));
        System.out.println(ColorUtils.header("  =========================================="));
        System.out.println(ColorUtils.success("Welcome to the Rental Management System!"));
        System.out.println();

        while (!authenticateUser()) {
            // keep prompting until login succeeds
        }

        showMainMenu();
    }

    private boolean authenticateUser() {
        System.out.println(ColorUtils.info("\nPlease select an option:"));
        System.out.println(ColorUtils.BRIGHT_BLUE + "1." + ColorUtils.RESET + " Register New User");
        System.out.println(ColorUtils.BRIGHT_BLUE + "2." + ColorUtils.RESET + " Login Existing User");
        System.out.println(ColorUtils.BRIGHT_BLUE + "3." + ColorUtils.RESET + " Exit");
        System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter Choice: " + ColorUtils.RESET);

        int option = readInteger();

        switch (option) {
            case 1:
                registerUser();
                return false;
            case 2:
                return loginUser();
            case 3:
                System.out.println(ColorUtils.warning("Exiting System..."));
                System.exit(0);
                return false;
            default:
                System.out.println(ColorUtils.error("Invalid Choice. Please try again."));
                return false;
        }
    }

    private void registerUser() {
        System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter new username: " + ColorUtils.RESET);
        String username = sc.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println(ColorUtils.error("Username cannot be empty."));
            return;
        }

        if (findUser(username) != null) {
            System.out.println(ColorUtils.error("Username already exists. Please login or choose a different username."));
            return;
        }

        System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter password: " + ColorUtils.RESET);
        String password = sc.nextLine();

        users.add(new User(username, password));
        System.out.println(ColorUtils.success("Registration successful. Please login with your new account."));
    }

    private boolean loginUser() {
        System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter username: " + ColorUtils.RESET);
        String username = sc.nextLine().trim();
        User user = findUser(username);

        if (user == null) {
            System.out.println(ColorUtils.error("User not found. Please register first."));
            return false;
        }

        System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter password: " + ColorUtils.RESET);
        String password = sc.nextLine();

        if (!user.checkPassword(password)) {
            System.out.println(ColorUtils.error("Incorrect password. Please try again."));
            return false;
        }

        loggedInUser = user;
        System.out.println(ColorUtils.success("Login successful. Welcome, " + loggedInUser.getUsername() + "!"));
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
            System.out.println(ColorUtils.header("\n===== RENTAL SYSTEM ====="));
            System.out.println(ColorUtils.info("Logged in as: ") + ColorUtils.highlight(loggedInUser.getUsername()));
            System.out.println(ColorUtils.BRIGHT_BLUE + "1." + ColorUtils.RESET + " Books");
            System.out.println(ColorUtils.BRIGHT_BLUE + "2." + ColorUtils.RESET + " Vehicles");
            System.out.println(ColorUtils.BRIGHT_BLUE + "3." + ColorUtils.RESET + " Clothes");
            System.out.println(ColorUtils.BRIGHT_BLUE + "4." + ColorUtils.RESET + " Electronics");
            System.out.println(ColorUtils.BRIGHT_BLUE + "5." + ColorUtils.RESET + " Rooms");
            System.out.println(ColorUtils.BRIGHT_BLUE + "6." + ColorUtils.RESET + " Exit");

            System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter Choice: " + ColorUtils.RESET);
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
                    System.out.println(ColorUtils.warning("Exiting System..."));
                    break;
                default:
                    System.out.println(ColorUtils.error("Invalid Choice"));
            }
        }
    }

    private int readInteger() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print(ColorUtils.error("Invalid input. Please enter a number: "));
            }
        }
    }
}
