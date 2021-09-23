package com.company;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Bank {

    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCostumers;

    public Bank(){
        allAccounts = new ArrayList<BankAccount>();
        allCostumers = new ArrayList<Customer>();
    }

    public void doBanking(){
        var menuReader = new Scanner(System.in);
        while(true){
            printMenu();
            var userChoice = menuReader.nextInt();
            switch (userChoice){
                case 1:
                    System.exit(0);
                case 2:
                    addCustomer(menuReader);
                    break;
                case 3:
                    Optional<Customer> current = selectCustomer(menuReader);
                    if(current.isPresent())
                        doCustomerMenu(menuReader);
                    else
                        System.out.println("No customer with that ID found");
                    break;
                default:
                    System.out.println("Please choose one of the menu options");
            }
        }
    }

    private void doCustomerMenu(Scanner menuReader) {
        System.out.println("We will finish this next week");
    }

    private Optional<Customer> selectCustomer(Scanner reader) {
        System.out.print("Customer ID of customer to select:");
        var idToFind = reader.nextInt();
        for (var currentCustomer: allCostumers){
            if(currentCustomer.getID() == idToFind)
                return Optional.of(currentCustomer);
        }
        return Optional.empty();

    }

    private void addCustomer(Scanner inputReader) {
        inputReader.nextLine(); //eat the orphan newline from previous nextIn call
        System.out.print("What is the new Customer's name:");
        var customerName = inputReader.nextLine();
        System.out.print("What is the new Customer's Tax ID (SSN):");
        var taxID = inputReader.nextInt();
        var newCustomer = new Customer(customerName, taxID);
        allCostumers.add(newCustomer);
    }

    private void printMenu() {
        System.out.println("What would you like to do next (select the number):");
        System.out.println("   [1] Exit the program");
        System.out.println("   [2] Add a customer");
        System.out.println("   [3] Select customer by ID");
        System.out.print("Enter choice:");
    }
}
