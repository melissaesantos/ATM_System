import java.util.Scanner;
import java.util.InputMismatchException;

public class ATM {
    private Scanner scanner;
    private BankDatabase bankDatabase;


    // Constructor to initialize the scanner and bankDatabase
    public ATM() {
        scanner = new Scanner(System.in);
        bankDatabase = new BankDatabase(); // Assuming BankDatabase class is implemented elsewhere
        
    }

    // Method to display the main menu for the user
    public void displayName() {
        System.out.println("What would you like to do?");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit :) ");
       
        System.out.print("Enter your choice: \n");
    }

    public static void main(String[] args) {
        int choice;
        int deposit;
        boolean AccountExists = false;
        ATM atm = new ATM();
        System.out.println("******************************************");
        System.out.println("Welcome to Melissa's ATM!");
        System.out.println("******************************************\n");
        boolean tryAgain = true;
        while(tryAgain ==true){
            String name = "";
            boolean validName = false;
            while (!validName) {
                try {
                    System.out.println("Enter your account name:");
                    name = atm.scanner.nextLine();
                    validName = true;
                
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter characters.");
                    atm.scanner.nextLine(); // Clear the scanner's buffer
                }
            }

        // Loop until a valid account number is entered
            int accountNum = 0;
            boolean validNum = false;
            while (!validNum) {
                try {
                    System.out.println("Enter your account number:");
                    accountNum = atm.scanner.nextInt();
                    validNum = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    atm.scanner.nextLine(); // Clear the scanner's buffer
                }
            }

            if (atm.bankDatabase.accountExists(accountNum, name)) {
            //intchoice;
                AccountExists = true;
                System.out.println("******************************************");
                System.out.println("Account Exists");
                System.out.println("****************************************** \n");

            if(AccountExists = true){
                do {
                
                    atm.displayName();
                    // Implement further functionality based on user's choice
                    choice =0;
                    try {
                        choice = atm.scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("****************************************** \n");
                        System.out.println("Invalid input. Please enter a number.");
                        System.out.println("****************************************** \n");
                        atm.scanner.nextLine(); // Clear the scanner's buffer

                        continue; // 
                    }    
                    switch (choice) {
                        case 1:
                            System.out.println("Your current Balance is:\n" + "$" + atm.bankDatabase.getBalance(accountNum) +"\n");
                            System.out.println("****************************************** \n");

                            break;
                        case 2:
                            System.out.println("You have chosen to deposit");
                            System.out.println("Enter amount to deposit: ");
                            try {
                                deposit = atm.scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("****************************************** \n");
                                System.out.println("Invalid input. Please enter a number.");
                                System.out.println("****************************************** \n");
                                
                                
                                atm.scanner.nextLine(); // Clear the scanner's buffer
        
                                continue; // 
                            }   
                            while(deposit<0){
                                System.out.println("****************************************** \n");
                                System.out.println("Invalid! You can not deposit a negative amount");
                                System.out.println("****************************************** \n");
                                System.out.println("Enter a positive amount to deposit: ");
                                try {
                                    deposit = atm.scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("****************************************** \n");
                                    System.out.println("Invalid input. Please enter a number.");
                                    System.out.println("****************************************** \n");
                                    atm.scanner.nextLine(); // Clear the scanner's buffer
            
                                    continue; // 
                                }    
                            } 
                            atm.bankDatabase.addBalance(accountNum, deposit);
                            System.out.println("Your new Balance is:\n" + "$" + atm.bankDatabase.getBalance(accountNum)+"\n");
                            System.out.println("****************************************** \n");

                            break;
                        case 3:
                            System.out.println("You have chosen to withdraw");
                            System.out.println("Enter amount to withdraw: ");
                            int withdrawAmount = 0;
                            try {
                                withdrawAmount = atm.scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("****************************************** \n");
                                System.out.println("Invalid input. Please enter a number.");
                                System.out.println("****************************************** \n");
                                atm.scanner.nextLine(); // Clear the scanner's buffer
        
                                continue; // 
                            }    
                            if(withdrawAmount > atm.bankDatabase.getBalance(accountNum)){
                                System.out.println("try again. withdrawal to high");
                                try {
                                    withdrawAmount = atm.scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("****************************************** \n");
                                    System.out.println("Invalid input. Please enter a number.");
                                    System.out.println("****************************************** \n");
                                    atm.scanner.nextLine(); // Clear the scanner's buffer
            
                                    continue; // 
                                }    
                            }
                            if(withdrawAmount <0){
                                System.out.println("try again. withdrawal is in the negatives");
                                try {
                                    withdrawAmount = atm.scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("****************************************** \n");
                                    System.out.println("Invalid input. Please enter a positive number.");
                                    System.out.println("****************************************** \n");
                                    atm.scanner.nextLine(); // Clear the scanner's buffer
            
                                    continue; // 
                                }    
                            }
                            
                            atm.bankDatabase.wdBalance(accountNum, withdrawAmount);
                            //add a checker to make sure they cant withdraw more than their current balance
                            System.out.println("Your new Balance is:\n" + "$" + atm.bankDatabase.getBalance(accountNum)+"\n");
                            System.out.println("****************************************** \n");
                            break;
                        case 4:
                            System.out.println("Thank you for using my ATM :)");
                            System.out.println("****************************************** \n");
                            tryAgain = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    atm.scanner.nextLine(); // Clear the scanner's buffer
                } while (choice != 4); // Loop until the user chooses to exit
            }
            
            } else {
                System.out.println("******************************************");
                System.out.println("Account does not exist");
                System.out.println("******************************************");
                System.out.println("How do you want to proceed?\n");
                System.out.println("1. Exit ");
                System.out.println("2. Try again");
                // Handle user's choice to make an account or try again
                //how would i make it so tht it could keep looping? should i just make another
                //switch statement
                choice =0;
                try {
                    choice = atm.scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("****************************************** \n");
                    System.out.println("Invalid input. Please enter a number.");
                    System.out.println("****************************************** \n");
                    atm.scanner.nextLine(); // Clear the scanner's buffer

                    continue; // 
                }    
                
                switch(choice){
                    case 1: 
                        tryAgain = false;
                        break;
                    case 2: 
                        tryAgain =true;
                    default:
                    System.out.println("Invalid choice. Please try again.");
                }


            }
            atm.scanner.nextLine(); // Clear the scanner's buffer
        }
        atm.scanner.close();
    }
}

  

