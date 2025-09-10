import java.util.Scanner;
class ElectricityBillSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Default slabs (used unless admin modifies them)
        int[] slabCap = {100, 200, 500};     // unit caps
        double[] rate = {5.0, 7.0, 10.0};    // rates for each slab

        final String ADMIN_PASSWORD = "admin123"; // simple password
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- ELECTRICITY BILLING SYSTEM ---");
            System.out.println("1. Admin");
            System.out.println("2. Consumer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Admin
                    System.out.print("Enter Admin Password: ");
                    String pass = sc.next();

                    if (pass.equals(ADMIN_PASSWORD)) {
                        System.out.println("Login Successful! Current slabs are:");
                        for (int i = 0; i < slabCap.length; i++) {
                            System.out.println("Slab " + (i + 1) + ": up to " + slabCap[i] + " units @ Rs " + rate[i] + "/unit");
                        }

                        System.out.print("\nDo you want to modify slabs? (Yes/No): ");
                        String modify = sc.next();

                        if (modify.equalsIgnoreCase("Yes")) {
                            for (int i = 0; i < slabCap.length; i++) {
                                System.out.print("Enter new cap for slab " + (i + 1) + ": ");
                                slabCap[i] = sc.nextInt();

                                System.out.print("Enter new rate for slab " + (i + 1) + ": ");
                                rate[i] = sc.nextDouble();
                            }
                            System.out.println("Slabs updated successfully!");

                            // After updating, take units and calculate bill
                            System.out.print("\nEnter total units consumed: ");
                            int units = sc.nextInt();
                            double bill = calculateBill(units, slabCap, rate);
                            System.out.println("Your total bill = Rs " + bill);

                        } else {
                            System.out.println("No changes made. Using existing slabs.");
                            // Directly proceed to bill calculation
                            System.out.print("\nEnter total units consumed: ");
                            int units = sc.nextInt();
                            double bill = calculateBill(units, slabCap, rate);
                            System.out.println("Your total bill = Rs " + bill);
                        }
                    } else {
                        System.out.println("Incorrect password! Access denied.");
                    }
                    break;

                case 2: // Consumer
                    System.out.println("Using current slab rates (default if admin not logged in):");
                    for (int i = 0; i < slabCap.length; i++) {
                        System.out.println("Slab " + (i + 1) + ": up to " + slabCap[i] + " units @ Rs " + rate[i] + "/unit");
                    }

                    System.out.print("\nEnter total units consumed: ");
                    int units = sc.nextInt();

                    double bill = calculateBill(units, slabCap, rate);
                    System.out.println("Your total bill = Rs " + bill);
                    break;

                case 3: // Exit
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

    // Function to calculate bill using switch-case logic
    public static double calculateBill(int units, int[] slabCap, double[] rate) {
        double bill = 0;
        int caseNum = 0;

        // Find which case to apply
        for (int i = 0; i < slabCap.length; i++) {
            if (units <= slabCap[i]) {
                caseNum = i + 1;
                break;
            }
        }
        if (caseNum == 0) {
            caseNum = slabCap.length; // last case if units exceed all slabs
        }

        // Switch-case calculation
        switch (caseNum) {
            case 1:
                bill = units * rate[0];
                break;

            default:
                bill = (slabCap[0] * rate[0]); // first slab always fully used
                for (int i = 1; i < caseNum; i++) {
                    if (i == caseNum - 1) {
                        bill += (units - slabCap[i - 1]) * rate[i];
                    } else {
                        bill += (slabCap[i] - slabCap[i - 1]) * rate[i];
                    }
                }
        }
        return bill;
    }
}
