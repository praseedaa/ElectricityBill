Electricity Billing System (Java)
Project Overview:
This is a Java-based Electricity Billing System that calculates electricity bills based on slab rates.
It demonstrates control flow, arrays, loops, and role-based access, making it suitable for academic purposes.

Supports two user roles:

Administrator – Can modify unit caps and slab rates after password authentication.

Consumer – Can input units consumed and get the bill, based on default or admin-modified slabs.

Features:

Default slab rates when admin hasn’t modified them.

Admin login for secure access to slab modification.

Consumer mode for bill calculation.

Switch-case driven menu for clean control flow.

Bill Calculation Formula:
Total Bill = (First k units × Rate1) + (Next k units × Rate2) + ... + (Remaining units × RateN)

Execution Flow:

Program starts with a menu: Admin, Consumer, Exit.

Admin mode:

Enter password to access slab modification.

Option to modify slab caps and rates:

YES → Admin enters new caps and rates.

NO → Continue with default or existing slabs.

Consumer mode:

Enter total units consumed.

Program calculates bill slab by slab and displays total.

Program loops until Exit is selected.

Default Slabs and Rates:

Slab 1: 0 – 100 units → ₹5/unit
Slab 2: 101 – 200 units → ₹7/unit
Slab 3: 201+ units → ₹10/unit
(Admin can modify these at runtime.)

Sample Input-Output:
Admin Login & Slab Modification:

Enter your choice: 1
Enter Admin Password: admin123
Modify slabs? (Yes/No): Yes
Enter cap for slab 1: 120
Enter rate for slab 1: 6
Enter cap for slab 2: 250
Enter rate for slab 2: 8
Enter cap for slab 3: 0
Enter rate for slab 3: 12
Slabs updated successfully!

Consumer Bill Calculation:

Enter your choice: 2
Enter total units consumed: 180
Your total bill = Rs 1200

Exit:

Enter your choice: 3
Exiting... Thank you!

Future Scope:

Save admin-modified slab rates permanently in files or databases.

Multi-consumer login with bill history tracking.

Online payment integration.

GUI interface with JavaFX or Swing.

IoT integration for automatic unit reading.

Export bills as PDF/Excel.

How to Run:

Save as ElectricityBillSystem.java

Compile: javac ElectricityBillSystem.java

Run: java ElectricityBillSystem
