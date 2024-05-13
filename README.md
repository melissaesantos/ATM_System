# ATM System

This repository contains a simple ATM (Automated Teller Machine) system implemented in Java. The system allows users to perform basic banking operations such as checking balance, depositing funds, and withdrawing funds by taking in their input and handling specific cases to prevent exception errors.
## Files Included
### 1. ATM.java
This file contains the main implementation of the ATM system. Here's a brief overview of its functionalities:

Display Menu: Displays the main menu options for the user to choose from.

Input Handling: Handles user inputs for account name, account number, and menu choices.

Account Validation: Validates the existence of the user's account based on the provided name and account number.

Balance Inquiry: Allows users to check their account balance.

Deposit: Allows users to deposit funds into their account.

Withdrawal: Allows users to withdraw funds from their account, with validations to ensure they don't withdraw more than their balance or input negative amounts.

Exit: Allows users to exit the ATM system.
### 2. BankDatabase.java
This file contains the implementation of the bank database, which stores account information and balances. Here's an overview:

Account Storage: Stores account information (account number and associated name) in a HashMap.

Balance Management: Manages account balances, allowing for balance inquiries, deposits, and withdrawals.

Account Existence Check: Provides a method to check if an account exists based on the provided account number and name.

## Usage
To use this ATM system, follow these steps:

Compile both ATM.java and BankDatabase.java.
Run the compiled ATM class.
Follow the on-screen prompts to interact with the ATM system.
