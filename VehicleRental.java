import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class VehicleRental {

    static String getVehicleName(int choice, int vehicleChoice) {

        if (choice == 1) {
            if (vehicleChoice == 1) return "Scooty";
            if (vehicleChoice == 2) return "Bike";
        }
        if (choice == 2) {
            if (vehicleChoice == 1) return "Sedan";
            if (vehicleChoice == 2) return "SUV";
        }
        if (choice == 3) {
            if (vehicleChoice == 1) return "Mini Truck";
            if (vehicleChoice == 2) return "Pickup Van";
        }
        if (choice == 4) {
            if (vehicleChoice == 1) return "Electric Scooter";
            if (vehicleChoice == 2) return "Electric Car";
        }
        if (choice == 5) {
            if (vehicleChoice == 1) return "Bicycle";
            if (vehicleChoice == 2) return "Sports Bike";
        }

        return "Unknown";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalCost = 0;
        int choice, vehicleChoice, days;
        int costPerDay = 0;

        boolean[] booked = new boolean[10];

        String[] rentedVehicles = new String[20];
        int[] rentedCost = new int[20];
        int[] rentedIndices = new int[20]; // Track which booked index each rental corresponds to
        ArrayList<String> takeDates = new ArrayList<>();
        ArrayList<String> returnDates = new ArrayList<>();
        int count = 0;

        int option = 0;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("==========================================");
        System.out.println("  |        VEHICLE RENTAL SYSTEM           |");
        System.out.println("  ==========================================");
        System.out.println("        ______");
        System.out.println("       /|_||_\\`.__");
        System.out.println("      (   _    _ _\\");
        System.out.println("      =`-(_)--(_)-'\n");

        while (option != 5) {

            System.out.println("\n1. View Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. View My Vehicles");
            System.out.println("5. Exit");

            option = sc.nextInt();

            // ===== VIEW =====
            if (option == 1) {

                System.out.println("\n--- Two Wheelers ---");
                System.out.println("1. Scooty (200/day) - Available: " + (booked[0] ? "No ❌" : "Yes ✓"));
                System.out.println("2. Bike (300/day) - Available: " + (booked[1] ? "No ❌" : "Yes ✓"));

                System.out.println("\n--- Cars ---");
                System.out.println("3. Sedan (1000/day) - Available: " + (booked[2] ? "No ❌" : "Yes ✓"));
                System.out.println("4. SUV (1500/day) - Available: " + (booked[3] ? "No ❌" : "Yes ✓"));

                System.out.println("\n--- Commercial ---");
                System.out.println("5. Mini Truck (2000/day) - Available: " + (booked[4] ? "No ❌" : "Yes ✓"));
                System.out.println("6. Pickup Van (1800/day) - Available: " + (booked[5] ? "No ❌" : "Yes ✓"));

                System.out.println("\n--- Electric ---");
                System.out.println("7. Electric Scooter (250/day) - Available: " + (booked[6] ? "No ❌" : "Yes ✓"));
                System.out.println("8. Electric Car (1200/day) - Available: " + (booked[7] ? "No ❌" : "Yes ✓"));

                System.out.println("\n--- Special ---");
                System.out.println("9. Bicycle (100/day) - Available: " + (booked[8] ? "No ❌" : "Yes ✓"));
                System.out.println("10. Sports Bike (2000/day) - Available: " + (booked[9] ? "No ❌" : "Yes ✓"));
            }

            // ===== RENT =====
            else if (option == 2) {

                System.out.println("\nSelect Category:");
                System.out.println("1. Two Wheelers");
                System.out.println("2. Cars");
                System.out.println("3. Commercial");
                System.out.println("4. Electric");
                System.out.println("5. Special");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("1. Scooty (200/day) " + (booked[0] ? "❌ Not Available" : ""));
                        System.out.println("2. Bike (300/day) " + (booked[1] ? "❌ Not Available" : ""));
                        break;
                    case 2:
                        System.out.println("1. Sedan (1000/day) " + (booked[2] ? "❌ Not Available" : ""));
                        System.out.println("2. SUV (1500/day) " + (booked[3] ? "❌ Not Available" : ""));
                        break;
                    case 3:
                        System.out.println("1. Mini Truck (2000/day) " + (booked[4] ? "❌ Not Available" : ""));
                        System.out.println("2. Pickup Van (1800/day) " + (booked[5] ? "❌ Not Available" : ""));
                        break;
                    case 4:
                        System.out.println("1. Electric Scooter (250/day) " + (booked[6] ? "❌ Not Available" : ""));
                        System.out.println("2. Electric Car (1200/day) " + (booked[7] ? "❌ Not Available" : ""));
                        break;
                    case 5:
                        System.out.println("1. Bicycle (100/day) " + (booked[8] ? "❌ Not Available" : ""));
                        System.out.println("2. Sports Bike (2000/day) " + (booked[9] ? "❌ Not Available" : ""));
                        break;
                    default:
                        System.out.println("Invalid Category");
                        continue;
                }

                System.out.print("Enter Vehicle Choice: ");
                vehicleChoice = sc.nextInt();

                int index = (choice - 1) * 2 + (vehicleChoice - 1);

                if (vehicleChoice < 1 || vehicleChoice > 2) {
                    System.out.println("Invalid Vehicle!");
                    continue;
                }

                if (booked[index]) {
                    System.out.println("❌ Vehicle Not Available");
                    continue;
                }

                booked[index] = true;

                int[] priceArr = {200,300,1000,1500,2000,1800,250,1200,100,2000};
                costPerDay = priceArr[index];

                System.out.print("Enter Days: ");
                days = sc.nextInt();

                int cost = costPerDay * days;
                totalCost += cost;

                LocalDateTime takeDateTime = LocalDateTime.now();
                LocalDateTime returnDateTime = takeDateTime.plusDays(days);

                rentedVehicles[count] = getVehicleName(choice, vehicleChoice);
                rentedCost[count] = cost;
                rentedIndices[count] = index;
                takeDates.add(takeDateTime.format(formatter));
                returnDates.add(returnDateTime.format(formatter));
                count++;

                System.out.println("\n✔ Vehicle Booked Successfully!");
                System.out.println("➡ Vehicle Cost: Rs." + cost);
                System.out.println("➡ Taken: " + takeDateTime.format(formatter));
                System.out.println("➡ Return Date: " + returnDateTime.format(formatter));
                System.out.println("➡ Total Bill So Far: Rs." + totalCost);
            }

            // ===== RETURN =====
            else if (option == 3) {

                System.out.print("Enter Vehicle ID to Return (1-10): ");
                int id = sc.nextInt() - 1;

                if (id < 0 || id >= 10) {
                    System.out.println("Invalid ID");
                }
                else if (!booked[id]) {
                    System.out.println("Already Available");
                }
                else {
                    // Find and remove the rental record
                    for (int i = 0; i < count; i++) {
                        if (rentedIndices[i] == id) {
                            // Remove this rental record by shifting all subsequent records
                            for (int j = i; j < count - 1; j++) {
                                rentedVehicles[j] = rentedVehicles[j + 1];
                                rentedCost[j] = rentedCost[j + 1];
                                rentedIndices[j] = rentedIndices[j + 1];
                                takeDates.set(j, takeDates.get(j + 1));
                                returnDates.set(j, returnDates.get(j + 1));
                            }
                            // Clear the last record
                            rentedVehicles[count - 1] = null;
                            rentedCost[count - 1] = 0;
                            rentedIndices[count - 1] = -1;
                            takeDates.remove(count - 1);
                            returnDates.remove(count - 1);
                            count--;
                            break;
                        }
                    }
                    
                    booked[id] = false;
                    System.out.println("Vehicle Returned Successfully!");
                }
            }

            // ===== VIEW BOOKINGS =====
            else if (option == 4) {

                BillReceipt.showBill("VEHICLE RENTAL", rentedVehicles, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else if (option == 5) {
                BillReceipt.showBill("VEHICLE RENTAL - FINAL BILL", rentedVehicles, rentedCost, count, totalCost, takeDates, returnDates);
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