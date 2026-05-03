import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class RoomsRental {

    static String getRoomName(int choice, int roomChoice) {

        if (choice == 1) {
            if (roomChoice == 1) return "1 BHK - Ameerpet";
            if (roomChoice == 2) return "1 BHK - Madhapur";
        }
        if (choice == 2) {
            if (roomChoice == 1) return "2 BHK - Kukatpally";
            if (roomChoice == 2) return "2 BHK - Gachibowli";
        }
        if (choice == 3) {
            if (roomChoice == 1) return "3 BHK - Banjara Hills";
            if (roomChoice == 2) return "3 BHK - Jubilee Hills";
        }
        if (choice == 4) {
            if (roomChoice == 1) return "Hostel Room";
            if (roomChoice == 2) return "PG Room";
        }
        if (choice == 5) {
            if (roomChoice == 1) return "Luxury Villa";
            if (roomChoice == 2) return "Penthouse";
        }

        return "Unknown";
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        int totalCost = 0;
        int choice, roomChoice, days;
        int costPerDay = 0;

        boolean[] booked = new boolean[10];

        String[] rentedRooms = new String[20];
        int[] rentedCost = new int[20];
        int[] rentedIndices = new int[20]; // Track which booked index each rental corresponds to
        ArrayList<String> takeDates = new ArrayList<>();
        ArrayList<String> returnDates = new ArrayList<>();
        int count = 0;

        int option = 0;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("===========================================");
        System.out.println("  |        ROOM RENTAL SYSTEM              |");
        System.out.println("  ==========================================");
        System.out.println("          /\\        /\\        /\\");
        System.out.println("         /  \\      /  \\      /  \\");
        System.out.println("        /____\\    /____\\    /____\\");
        System.out.println("        | [] |    | [] |    | [] |");
        System.out.println("        |____|    |____|    |____|");
        System.out.println();

        while (option != 5) {

            System.out.println("\n1. View Rooms");
            System.out.println("2. Rent Room");
            System.out.println("3. Return Room");
            System.out.println("4. View My Rooms");
            System.out.println("5. Exit");

            option = sc.nextInt();

            // ===== VIEW =====
            if (option == 1) {

                System.out.println("\n--- 1 BHK ---");
                System.out.println("1. Ameerpet (10000/month) - Available: " + (booked[0] ? "No " : "Yes ✓"));
                System.out.println("2. Madhapur (11000/month) - Available: " + (booked[1] ? "No " : "Yes ✓"));

                System.out.println("\n--- 2 BHK ---");
                System.out.println("3. Kukatpally (15000/month) - Available: " + (booked[2] ? "No " : "Yes ✓"));
                System.out.println("4. Gachibowli (17000/month) - Available: " + (booked[3] ? "No " : "Yes ✓"));

                System.out.println("\n--- 3 BHK ---");
                System.out.println("5. Banjara Hills (25000/month) - Available: " + (booked[4] ? "No " : "Yes ✓"));
                System.out.println("6. Jubilee Hills (27000/month) - Available: " + (booked[5] ? "No " : "Yes ✓"));

                System.out.println("\n--- Budget ---");
                System.out.println("7. Hostel Room (5000/month) - Available: " + (booked[6] ? "No " : "Yes ✓"));
                System.out.println("8. PG Room (7000/month) - Available: " + (booked[7] ? "No " : "Yes ✓"));

                System.out.println("\n--- Luxury ---");
                System.out.println("9. Luxury Villa (50000/month) - Available: " + (booked[8] ? "No " : "Yes ✓"));
                System.out.println("10. Penthouse (80000/month) - Available: " + (booked[9] ? "No " : "Yes ✓"));
            }

            // ===== RENT =====
            else if (option == 2) {

                System.out.println("\nSelect Category:");
                System.out.println("1. 1 BHK");
                System.out.println("2. 2 BHK");
                System.out.println("3. 3 BHK");
                System.out.println("4. Budget");
                System.out.println("5. Luxury");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("1. Ameerpet (10000/month) " + (booked[0] ? " Not Available" : ""));
                        System.out.println("2. Madhapur (11000/month) " + (booked[1] ? " Not Available" : ""));
                        break;
                    case 2:
                        System.out.println("1. Kukatpally (15000/month) " + (booked[2] ? " Not Available" : ""));
                        System.out.println("2. Gachibowli (17000/month) " + (booked[3] ? " Not Available" : ""));
                        break;
                    case 3:
                        System.out.println("1. Banjara Hills (25000/month) " + (booked[4] ? " Not Available" : ""));
                        System.out.println("2. Jubilee Hills (27000/month) " + (booked[5] ? " Not Available" : ""));
                        break;
                    case 4:
                        System.out.println("1. Hostel Room (5000/month) " + (booked[6] ? " Not Available" : ""));
                        System.out.println("2. PG Room (7000/month) " + (booked[7] ? " Not Available" : ""));
                        break;
                    case 5:
                        System.out.println("1. Luxury Villa (50000/month) " + (booked[8] ? " Not Available" : ""));
                        System.out.println("2. Penthouse (80000/month) " + (booked[9] ? " Not Available" : ""));
                        break;
                    default:
                        System.out.println("Invalid Category");
                        continue;
                }

                System.out.print("Enter Room Choice: ");
                roomChoice = sc.nextInt();

                int index = (choice - 1) * 2 + (roomChoice - 1);

                if (roomChoice < 1 || roomChoice > 2) {
                    System.out.println("Invalid Choice!");
                    continue;
                }

                if (booked[index]) {
                    System.out.println(" Room Not Available");
                    continue;
                }

                booked[index] = true;

                int[] priceArr = {10000,11000,15000,17000,25000,27000,5000,7000,50000,80000};
                costPerDay = priceArr[index];

                System.out.print("Enter Months: ");
                days = sc.nextInt();

                int cost = costPerDay * days;
                totalCost += cost;

                LocalDateTime takeDateTime = LocalDateTime.now();
                LocalDateTime returnDateTime = takeDateTime.plusDays(days);

                rentedRooms[count] = getRoomName(choice, roomChoice);
                rentedCost[count] = cost;
                rentedIndices[count] = index;
                takeDates.add(takeDateTime.format(formatter));
                returnDates.add(returnDateTime.format(formatter));
                count++;

                System.out.println("\n✔ Room Booked Successfully!");
                System.out.println("➡ Cost: Rs." + cost);
                System.out.println("➡ Taken: " + takeDateTime.format(formatter));
                System.out.println("➡ Return Date: " + returnDateTime.format(formatter));
                System.out.println("➡ Total Bill So Far: Rs." + totalCost);
            }

            // ===== RETURN =====
            else if (option == 3) {

                System.out.print("Enter Room ID to Return (1-10): ");
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
                            for (int j = i; j < count - 1; j++) {
                                rentedRooms[j] = rentedRooms[j + 1];
                                rentedCost[j] = rentedCost[j + 1];
                                rentedIndices[j] = rentedIndices[j + 1];
                                takeDates.set(j, takeDates.get(j + 1));
                                returnDates.set(j, returnDates.get(j + 1));
                            }
                            // Clear the last record
                            rentedRooms[count - 1] = null;
                            rentedCost[count - 1] = 0;
                            rentedIndices[count - 1] = -1;
                            takeDates.remove(count - 1);
                            returnDates.remove(count - 1);
                            count--;
                            break;
                        }
                    }
                    
                    booked[id] = false;
                    System.out.println("Room Returned Successfully!");
                }
            }

            // ===== VIEW BOOKINGS =====
            else if (option == 4) {

                BillReceipt.showBill("ROOMS RENTAL", rentedRooms, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else if (option == 5) {
                BillReceipt.showBill("ROOMS RENTAL - FINAL BILL", rentedRooms, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else {
                System.out.println("Invalid Option");
            }
        }
    }
}