import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ElectronicsRental {

    static String getItemName(int choice, int itemChoice) {

        if (choice == 1) {
            if (itemChoice == 1) return "Laptop";
            if (itemChoice == 2) return "Desktop";
        }
        if (choice == 2) {
            if (itemChoice == 1) return "Smartphone";
            if (itemChoice == 2) return "Tablet";
        }
        if (choice == 3) {
            if (itemChoice == 1) return "Television";
            if (itemChoice == 2) return "Speaker";
        }
        if (choice == 4) {
            if (itemChoice == 1) return "Camera";
            if (itemChoice == 2) return "Drone";
        }
        if (choice == 5) {
            if (itemChoice == 1) return "Printer";
            if (itemChoice == 2) return "Projector";
        }

        return "Unknown";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalCost = 0;
        int choice, itemChoice, days;
        int costPerDay = 0;

        boolean[] booked = new boolean[10];

        String[] rentedItems = new String[20];
        int[] rentedCost = new int[20];
        int[] rentedIndices = new int[20]; 
        ArrayList<String> takeDates = new ArrayList<>();
        ArrayList<String> returnDates = new ArrayList<>();
        int count = 0;

        int option = 0;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("===========================================");
        System.out.println("  |   ELECTRIC APPLIANCE RENTAL SYSTEM     |");
        System.out.println("  ==========================================");
        System.out.println("      _______     _______     _______");
        System.out.println("     |       |   |       |   |       |");
        System.out.println("     |  TV   |   | FRIDGE|   | WASH  |");
        System.out.println("     |_______|   |_______|   |_______|");
        System.out.println();

        while (option != 5) {

            System.out.println("\n1. View Electronics");
            System.out.println("2. Rent Electronics");
            System.out.println("3. Return Electronics");
            System.out.println("4. View My Electronics");
            System.out.println("5. Exit");

            option = sc.nextInt();

            // ===== VIEW =====
            if (option == 1) {

                System.out.println("\n--- Computers ---");
                System.out.println("1. Laptop (800/day) - Available: " + (booked[0] ? "No " : "Yes ✓"));
                System.out.println("2. Desktop (700/day) - Available: " + (booked[1] ? "No " : "Yes ✓"));

                System.out.println("\n--- Mobile Devices ---");
                System.out.println("3. Smartphone (500/day) - Available: " + (booked[2] ? "No " : "Yes ✓"));
                System.out.println("4. Tablet (400/day) - Available: " + (booked[3] ? "No " : "Yes ✓"));

                System.out.println("\n--- Entertainment ---");
                System.out.println("5. Television (1000/day) - Available: " + (booked[4] ? "No " : "Yes ✓"));
                System.out.println("6. Speaker (300/day) - Available: " + (booked[5] ? "No " : "Yes ✓"));

                System.out.println("\n--- Photography ---");
                System.out.println("7. Camera (900/day) - Available: " + (booked[6] ? "No " : "Yes ✓"));
                System.out.println("8. Drone (1500/day) - Available: " + (booked[7] ? "No " : "Yes ✓"));

                System.out.println("\n--- Office Equipment ---");
                System.out.println("9. Printer (350/day) - Available: " + (booked[8] ? "No " : "Yes ✓"));
                System.out.println("10. Projector (1200/day) - Available: " + (booked[9] ? "No " : "Yes ✓"));
            }

            // ===== RENT =====
            else if (option == 2) {

                System.out.println("\nSelect Category:");
                System.out.println("1. Computers");
                System.out.println("2. Mobile Devices");
                System.out.println("3. Entertainment");
                System.out.println("4. Photography");
                System.out.println("5. Office Equipment");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("1. Laptop (800/day) " + (booked[0] ? " Not Available" : ""));
                        System.out.println("2. Desktop (700/day) " + (booked[1] ? " Not Available" : ""));
                        break;
                    case 2:
                        System.out.println("1. Smartphone (500/day) " + (booked[2] ? " Not Available" : ""));
                        System.out.println("2. Tablet (400/day) " + (booked[3] ? " Not Available" : ""));
                        break;
                    case 3:
                        System.out.println("1. Television (1000/day) " + (booked[4] ? " Not Available" : ""));
                        System.out.println("2. Speaker (300/day) " + (booked[5] ? " Not Available" : ""));
                        break;
                    case 4:
                        System.out.println("1. Camera (900/day) " + (booked[6] ? " Not Available" : ""));
                        System.out.println("2. Drone (1500/day) " + (booked[7] ? " Not Available" : ""));
                        break;
                    case 5:
                        System.out.println("1. Printer (350/day) " + (booked[8] ? " Not Available" : ""));
                        System.out.println("2. Projector (1200/day) " + (booked[9] ? " Not Available" : ""));
                        break;
                    default:
                        System.out.println("Invalid Category");
                        continue;
                }

                System.out.print("Enter Item Choice: ");
                itemChoice = sc.nextInt();

                int index = (choice - 1) * 2 + (itemChoice - 1);

                if (itemChoice < 1 || itemChoice > 2) {
                    System.out.println("Invalid Choice!");
                    continue;
                }

                if (booked[index]) {
                    System.out.println(" Not Available");
                    continue;
                }

                booked[index] = true;

                int[] priceArr = {800,700,500,400,1000,300,900,1500,350,1200};
                costPerDay = priceArr[index];

                System.out.print("Enter Days: ");
                days = sc.nextInt();

                int cost = costPerDay * days;
                totalCost += cost;

                LocalDateTime takeDateTime = LocalDateTime.now();
                LocalDateTime returnDateTime = takeDateTime.plusDays(days);

                rentedItems[count] = getItemName(choice, itemChoice);
                rentedCost[count] = cost;
                rentedIndices[count] = index;
                takeDates.add(takeDateTime.format(formatter));
                returnDates.add(returnDateTime.format(formatter));
                count++;

                System.out.println("\n✔ Item Booked Successfully!");
                System.out.println("➡ Cost: Rs." + cost);
                System.out.println("➡ Taken: " + takeDateTime.format(formatter));
                System.out.println("➡ Return Date: " + returnDateTime.format(formatter));
                System.out.println("➡ Total Bill So Far: Rs." + totalCost);
            }

            // ===== RETURN =====
            else if (option == 3) {

                System.out.print("Enter Item ID to Return (1-10): ");
                int id = sc.nextInt() - 1;

                if (id < 0 || id >= 10) {
                    System.out.println("Invalid ID");
                }
                else if (!booked[id]) {
                    System.out.println("Already Available");
                }
                else {
                    for (int i = 0; i < count; i++) {
                        if (rentedIndices[i] == id) {
                            for (int j = i; j < count - 1; j++) {
                                rentedItems[j] = rentedItems[j + 1];
                                rentedCost[j] = rentedCost[j + 1];
                                rentedIndices[j] = rentedIndices[j + 1];
                                takeDates.set(j, takeDates.get(j + 1));
                                returnDates.set(j, returnDates.get(j + 1));
                            }
                            // Clear the last record
                            rentedItems[count - 1] = null;
                            rentedCost[count - 1] = 0;
                            rentedIndices[count - 1] = -1;
                            takeDates.remove(count - 1);
                            returnDates.remove(count - 1);
                            count--;
                            break;
                        }
                    }
                    
                    booked[id] = false;
                    System.out.println("Item Returned Successfully!");
                }
            }

            // ===== VIEW BOOKINGS =====
            else if (option == 4) {

                BillReceipt.showBill("ELECTRONICS RENTAL", rentedItems, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else if (option == 5) {
                BillReceipt.showBill("ELECTRONICS RENTAL - FINAL BILL", rentedItems, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else {
                System.out.println("Invalid Option");
            }
        }
    }

    public void start() {
        main(new String[0]);
    }
}
