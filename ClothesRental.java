import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ClothesRental {

    static String getClothName(int choice, int clothChoice) {

        if (choice == 1) {
            if (clothChoice == 1) return "T-Shirt";
            if (clothChoice == 2) return "Jeans";
        }
        if (choice == 2) {
            if (clothChoice == 1) return "Shirt";
            if (clothChoice == 2) return "Formal Pant";
        }
        if (choice == 3) {
            if (clothChoice == 1) return "Kurta";
            if (clothChoice == 2) return "Sherwani";
        }
        if (choice == 4) {
            if (clothChoice == 1) return "Jacket";
            if (clothChoice == 2) return "Coat";
        }
        if (choice == 5) {
            if (clothChoice == 1) return "Party Wear";
            if (clothChoice == 2) return "Wedding Suit";
        }

        return "Unknown";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalCost = 0;
        int choice, clothChoice, days;
        int costPerDay = 0;

        boolean[] booked = new boolean[10];

        String[] rentedClothes = new String[20];
        int[] rentedCost = new int[20];
        int[] rentedIndices = new int[20];
        ArrayList<String> takeDates = new ArrayList<>();
        ArrayList<String> returnDates = new ArrayList<>();
        int count = 0;

        int option = 0;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("==========================================");
        System.out.println("  |        CLOTHES RENTAL SYSTEM           |");
        System.out.println("  ==========================================");
        System.out.println("          _________");
        System.out.println("         /         \\");
        System.out.println("        /  SHIRT    \\");
        System.out.println("       |             |");
        System.out.println("       |             |");
        System.out.println("       |_____________|");
        System.out.println();

        while (option != 5) {

            System.out.println("\n1. View Clothes");
            System.out.println("2. Rent Clothes");
            System.out.println("3. Return Clothes");
            System.out.println("4. View My Clothes");
            System.out.println("5. Exit");

            option = sc.nextInt();

            // ===== VIEW =====
            if (option == 1) {

                System.out.println("\n--- Casual Wear ---");
                System.out.println("1. T-Shirt (100/day) - Available: " + (booked[0] ? "No " : "Yes ✓"));
                System.out.println("2. Jeans (150/day) - Available: " + (booked[1] ? "No " : "Yes ✓"));

                System.out.println("\n--- Formal Wear ---");
                System.out.println("3. Shirt (120/day) - Available: " + (booked[2] ? "No " : "Yes ✓"));
                System.out.println("4. Formal Pant (140/day) - Available: " + (booked[3] ? "No " : "Yes ✓"));

                System.out.println("\n--- Traditional ---");
                System.out.println("5. Kurta (200/day) - Available: " + (booked[4] ? "No " : "Yes ✓"));
                System.out.println("6. Sherwani (500/day) - Available: " + (booked[5] ? "No " : "Yes ✓"));

                System.out.println("\n--- Winter Wear ---");
                System.out.println("7. Jacket (250/day) - Available: " + (booked[6] ? "No " : "Yes ✓"));
                System.out.println("8. Coat (400/day) - Available: " + (booked[7] ? "No " : "Yes ✓"));

                System.out.println("\n--- Special ---");
                System.out.println("9. Party Wear (300/day) - Available: " + (booked[8] ? "No " : "Yes ✓"));
                System.out.println("10. Wedding Suit (700/day) - Available: " + (booked[9] ? "No " : "Yes ✓"));
            }

            // ===== RENT =====
            else if (option == 2) {

                System.out.println("\nSelect Category:");
                System.out.println("1. Casual Wear");
                System.out.println("2. Formal Wear");
                System.out.println("3. Traditional");
                System.out.println("4. Winter Wear");
                System.out.println("5. Special");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("1. T-Shirt (100/day) " + (booked[0] ? " Not Available" : ""));
                        System.out.println("2. Jeans (150/day) " + (booked[1] ? " Not Available" : ""));
                        break;
                    case 2:
                        System.out.println("1. Shirt (120/day) " + (booked[2] ? " Not Available" : ""));
                        System.out.println("2. Formal Pant (140/day) " + (booked[3] ? " Not Available" : ""));
                        break;
                    case 3:
                        System.out.println("1. Kurta (200/day) " + (booked[4] ? " Not Available" : ""));
                        System.out.println("2. Sherwani (500/day) " + (booked[5] ? " Not Available" : ""));
                        break;
                    case 4:
                        System.out.println("1. Jacket (250/day) " + (booked[6] ? " Not Available" : ""));
                        System.out.println("2. Coat (400/day) " + (booked[7] ? " Not Available" : ""));
                        break;
                    case 5:
                        System.out.println("1. Party Wear (300/day) " + (booked[8] ? " Not Available" : ""));
                        System.out.println("2. Wedding Suit (700/day) " + (booked[9] ? " Not Available" : ""));
                        break;
                    default:
                        System.out.println("Invalid Category");
                        continue;
                }

                System.out.print("Enter Clothes Choice: ");
                clothChoice = sc.nextInt();

                int index = (choice - 1) * 2 + (clothChoice - 1);

                if (clothChoice < 1 || clothChoice > 2) {
                    System.out.println("Invalid Choice!");
                    continue;
                }

                if (booked[index]) {
                    System.out.println(" Not Available");
                    continue;
                }

                booked[index] = true;

                int[] priceArr = {100,150,120,140,200,500,250,400,300,700};
                costPerDay = priceArr[index];

                System.out.print("Enter Days: ");
                days = sc.nextInt();

                int cost = costPerDay * days;
                totalCost += cost;

                LocalDateTime takeDateTime = LocalDateTime.now();
                LocalDateTime returnDateTime = takeDateTime.plusDays(days);

                rentedClothes[count] = getClothName(choice, clothChoice);
                rentedCost[count] = cost;
                rentedIndices[count] = index;
                takeDates.add(takeDateTime.format(formatter));
                returnDates.add(returnDateTime.format(formatter));
                count++;

                System.out.println("\n✔ Clothes Booked Successfully!");
                System.out.println("➡ Cost: Rs." + cost);
                System.out.println("➡ Taken: " + takeDateTime.format(formatter));
                System.out.println("➡ Return Date: " + returnDateTime.format(formatter));
                System.out.println("➡ Total Bill So Far: Rs." + totalCost);
            }

            // ===== RETURN =====
            else if (option == 3) {

                System.out.print("Enter Clothes ID to Return (1-10): ");
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
                                rentedClothes[j] = rentedClothes[j + 1];
                                rentedCost[j] = rentedCost[j + 1];
                                rentedIndices[j] = rentedIndices[j + 1];
                                takeDates.set(j, takeDates.get(j + 1));
                                returnDates.set(j, returnDates.get(j + 1));
                            }
                            // Clear the last record
                            rentedClothes[count - 1] = null;
                            rentedCost[count - 1] = 0;
                            rentedIndices[count - 1] = -1;
                            takeDates.remove(count - 1);
                            returnDates.remove(count - 1);
                            count--;
                            break;
                        }
                    }
                    
                    booked[id] = false;
                    System.out.println("Clothes Returned Successfully!");
                }
            }

            // ===== VIEW BOOKINGS =====
            else if (option == 4) {

                BillReceipt.showBill("CLOTHES RENTAL", rentedClothes, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else if (option == 5) {
                BillReceipt.showBill("CLOTHES RENTAL - FINAL BILL", rentedClothes, rentedCost, count, totalCost, takeDates, returnDates);
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