import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class BookRental {

    static String getBookName(int choice, int bookChoice) {

        if (choice == 1) {
            if (bookChoice == 1) return "Ghost House";
            if (bookChoice == 2) return "Dark Night";
        }
        if (choice == 2) {
            if (bookChoice == 1) return "Love Forever";
            if (bookChoice == 2) return "Heart Beats";
        }
        if (choice == 3) {
            if (bookChoice == 1) return "Mystery Night";
            if (bookChoice == 2) return "Secret Case";
        }
        if (choice == 4) {
            if (bookChoice == 1) return "Java Basics";
            if (bookChoice == 2) return "Data Structures";
        }
        if (choice == 5) {
            if (bookChoice == 1) return "Tom & Jerry";
            if (bookChoice == 2) return "Doraemon";
        }

        return "Unknown";
    }
    public void start() {

        Scanner sc = new Scanner(System.in);

        int totalCost = 0;
        int choice, bookChoice, days;
        int costPerDay = 0;

        boolean[] booked = new boolean[10];

        String[] rentedBooks = new String[20];
        int[] rentedCost = new int[20];
        int[] rentedIndices = new int[20]; 
        ArrayList<String> takeDates = new ArrayList<>();
        ArrayList<String> returnDates = new ArrayList<>();
        int count = 0;

        int option = 0;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        while (option != 5) {

            System.out.println(ColorUtils.header("=========================================="));
            System.out.println(ColorUtils.header("  |          BOOK RENTAL SYSTEM            |"));
            System.out.println(ColorUtils.header("  =========================================="));
            System.out.println(ColorUtils.BRIGHT_MAGENTA + "       _______   _______   _______");
            System.out.println("      |       | |       | |       |");
            System.out.println("      | BOOK  | | BOOK  | | BOOK  |");
            System.out.println("      |_______| |_______| |_______|" + ColorUtils.RESET);
            System.out.println();
            System.out.println(ColorUtils.BRIGHT_BLUE + "1." + ColorUtils.RESET + " View Books");
            System.out.println(ColorUtils.BRIGHT_BLUE + "2." + ColorUtils.RESET + " Rent Book");
            System.out.println(ColorUtils.BRIGHT_BLUE + "3." + ColorUtils.RESET + " Return Book");
            System.out.println(ColorUtils.BRIGHT_BLUE + "4." + ColorUtils.RESET + " View My Books");
            System.out.println(ColorUtils.BRIGHT_BLUE + "5." + ColorUtils.RESET + " Exit");

            System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter Choice: " + ColorUtils.RESET);
            option = sc.nextInt();

            //===== VIEW =====
            if (option == 1) {

                System.out.println(ColorUtils.header("\n--- Horror ---"));
                System.out.println(ColorUtils.BRIGHT_BLUE + "1." + ColorUtils.RESET + " Ghost House (10/day) - Available: " + (booked[0] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));
                System.out.println(ColorUtils.BRIGHT_BLUE + "2." + ColorUtils.RESET + " Dark Night (12/day) - Available: " + (booked[1] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));

                System.out.println(ColorUtils.header("\n--- Love Stories ---"));
                System.out.println(ColorUtils.BRIGHT_BLUE + "3." + ColorUtils.RESET + " Love Forever (8/day) - Available: " + (booked[2] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));
                System.out.println(ColorUtils.BRIGHT_BLUE + "4." + ColorUtils.RESET + " Heart Beats (9/day) - Available: " + (booked[3] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));

                System.out.println(ColorUtils.header("\n--- Thriller ---"));
                System.out.println(ColorUtils.BRIGHT_BLUE + "5." + ColorUtils.RESET + " Mystery Night (12/day) - Available: " + (booked[4] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));
                System.out.println(ColorUtils.BRIGHT_BLUE + "6." + ColorUtils.RESET + " Secret Case (15/day) - Available: " + (booked[5] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));

                System.out.println(ColorUtils.header("\n--- Educational ---"));
                System.out.println(ColorUtils.BRIGHT_BLUE + "7." + ColorUtils.RESET + " Java Basics (7/day) - Available: " + (booked[6] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));
                System.out.println(ColorUtils.BRIGHT_BLUE + "8." + ColorUtils.RESET + " Data Structures (10/day) - Available: " + (booked[7] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));

                System.out.println(ColorUtils.header("\n--- Cartoon ---"));
                System.out.println(ColorUtils.BRIGHT_BLUE + "9." + ColorUtils.RESET + " Tom & Jerry (5/day) - Available: " + (booked[8] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));
                System.out.println(ColorUtils.BRIGHT_BLUE + "10." + ColorUtils.RESET + " Doraemon (6/day) - Available: " + (booked[9] ? ColorUtils.error("No ❌") : ColorUtils.success("Yes ✓")));
            }

            // ===== RENT =====
            else if (option == 2) {

                System.out.println(ColorUtils.info("\nSelect Category:"));
                System.out.println(ColorUtils.BRIGHT_BLUE + "1." + ColorUtils.RESET + " Horror");
                System.out.println(ColorUtils.BRIGHT_BLUE + "2." + ColorUtils.RESET + " Love Stories");
                System.out.println(ColorUtils.BRIGHT_BLUE + "3." + ColorUtils.RESET + " Thriller");
                System.out.println(ColorUtils.BRIGHT_BLUE + "4." + ColorUtils.RESET + " Educational");
                System.out.println(ColorUtils.BRIGHT_BLUE + "5." + ColorUtils.RESET + " Cartoon");

                System.out.print(ColorUtils.BRIGHT_YELLOW + "Enter Category: " + ColorUtils.RESET);
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("1. Ghost House (10/day) " + (booked[0] ? " Not Available" : ""));
                        System.out.println("2. Dark Night (12/day) " + (booked[1] ? " Not Available" : ""));
                        break;
                    case 2:
                        System.out.println("1. Love Forever (8/day) " + (booked[2] ? " Not Available" : ""));
                        System.out.println("2. Heart Beats (9/day) " + (booked[3] ? " Not Available" : ""));
                        break;
                    case 3:
                        System.out.println("1. Mystery Night (12/day) " + (booked[4] ? " Not Available" : ""));
                        System.out.println("2. Secret Case (15/day) " + (booked[5] ? " Not Available" : ""));
                        break;
                    case 4:
                        System.out.println("1. Java Basics (7/day) " + (booked[6] ? " Not Available" : ""));
                        System.out.println("2. Data Structures (10/day) " + (booked[7] ? " Not Available" : ""));
                        break;
                    case 5:
                        System.out.println("1. Tom & Jerry (5/day) " + (booked[8] ? "  Not Available" : ""));
                        System.out.println("2. Doraemon (6/day) " + (booked[9] ? "  Not Available" : ""));
                        break;
                    default:
                        System.out.println("Invalid Category");
                        continue;
                }

                System.out.print("Enter Book Choice: ");
                bookChoice = sc.nextInt();

                int index = (choice - 1) * 2 + (bookChoice - 1);

                if (bookChoice < 1 || bookChoice > 2) {
                    System.out.println("Invalid Book!");
                    continue;
                }

                if (booked[index]) {
                    System.out.println("Book Not Available");
                    continue;
                }

                booked[index] = true;

                int[] priceArr = {10,12,8,9,12,15,7,10,5,6};
                costPerDay = priceArr[index];

                System.out.print("Enter Days: ");
                days = sc.nextInt();

                int cost = costPerDay * days;
                totalCost += cost;

                LocalDateTime takeDateTime = LocalDateTime.now();
                LocalDateTime returnDateTime = takeDateTime.plusDays(days);

                rentedBooks[count] = getBookName(choice, bookChoice);
                rentedCost[count] = cost;
                rentedIndices[count] = index;
                takeDates.add(takeDateTime.format(formatter));
                returnDates.add(returnDateTime.format(formatter));
                count++;

                System.out.println(ColorUtils.success("\n✔ Booked Successfully!"));
                System.out.println("➡ Book Cost: Rs." + cost);
                System.out.println("➡ Taken: " + takeDateTime.format(formatter));
                System.out.println("➡ Return Date: " + returnDateTime.format(formatter));
                System.out.println("➡ Total Bill So Far: Rs." + totalCost);
            }

            // ===== RETURN =====
            else if (option == 3) {

                System.out.print("Enter Book ID to Return (1-10): ");
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
                                rentedBooks[j] = rentedBooks[j + 1];
                                rentedCost[j] = rentedCost[j + 1];
                                rentedIndices[j] = rentedIndices[j + 1];
                                takeDates.set(j, takeDates.get(j + 1));
                                returnDates.set(j, returnDates.get(j + 1));
                            }
                            rentedBooks[count - 1] = null;
                            rentedCost[count - 1] = 0;
                            rentedIndices[count - 1] = -1;
                            takeDates.remove(count - 1);
                            returnDates.remove(count - 1);
                            count--;
                            break;
                        }
                    }
                    
                    booked[id] = false;
                    System.out.println(ColorUtils.success("Book Returned Successfully!"));
                }
            }

            // ===== VIEW =====
            else if (option == 4) {

                BillReceipt.showBill("BOOK RENTAL", rentedBooks, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else if (option == 5) {
                BillReceipt.showBill("BOOK RENTAL - FINAL BILL", rentedBooks, rentedCost, count, totalCost, takeDates, returnDates);
            }

            else {
                System.out.println("Invalid Option");
            }
        }
    }
}