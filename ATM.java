import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    double checkBalance() {
        return balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(10000);

        int choice = 0;

        while (choice != 4) {
            System.out.println("\n===== ATM INTERFACE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Balance: Rs. %.2f%n",
                            account.checkBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");

                    if (sc.hasNextDouble()) {
                        account.deposit(sc.nextDouble());
                        System.out.printf("Balance: Rs. %.2f%n",
                                account.checkBalance());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");

                    if (sc.hasNextDouble()) {
                        account.withdraw(sc.nextDouble());
                        System.out.printf("Balance: Rs. %.2f%n",
                                account.checkBalance());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1 to 4.");
            }
        }

        sc.close();
    }
}
