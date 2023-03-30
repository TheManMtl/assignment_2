/*
 * Ehsan KH. Motlagh
 * student ID: 2340457
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountDemo {
    public static void main(String[] args) {

        SavingsAccount ba = new SavingsAccount(500);

        //init files and paths
        String path = ".\\src\\data\\";
        File deposits = new File(path + "Deposits.txt");
        File withdrawals = new File(path + "Withdrawals.txt");

        //user provides the annual rate
        Scanner keyboard = new Scanner(System.in);

        try {
            System.out.print("Enter annual interest rate: ");
            ba.setAnnualInterest(keyboard.nextFloat());
        }catch (InputMismatchException ime){
            System.out.println("Wrong Input. Your Balance will be calculated without Interest!" +
                    " Please contact customer service for more info!");
        }

        Scanner fileReader;
        try {
            fileReader = new Scanner(deposits);// to read deposits file

        /*  reading Deposits from file and setting to SavingsAccount deposit field
            then adding to balance
        */
            while (fileReader.hasNext()) {
                ba.setDeposit(fileReader.nextFloat());
                ba.addDepositAmount();
            }
            fileReader.close(); // closing the file reader
        } catch (FileNotFoundException fnfe) {
            System.out.println("Provided File notFound! ( " + deposits.getName() + " )");
        }

        try {
            fileReader = new Scanner(withdrawals);// to read withdrawals file

         /*  reading withdrawals from file and setting to SavingsAccount withdrawals field
            then subtracting from balance
         */
            while (fileReader.hasNext()) {
                ba.setWithdrawal(fileReader.nextFloat());
                ba.subWithdrawalAmount();
            }
            fileReader.close();// closing the file reader

        } catch (FileNotFoundException fnfe) {
            System.out.println("Provided File notFound! ( " + withdrawals.getName() + " )");
        }

        ba.addMonthlyInterest();//adds monthly interest to balance, keeps monthly interest

        keyboard.close(); // closing input

        // Result
        System.out.println("Account info:");
        System.out.printf("Ending Balance: %.2f\n", ba.getBalance());
        System.out.printf("Total Deposit: %.2f\n", ba.getTotalDeposit());
        System.out.printf("Total Withdrawal: %.2f\n", ba.getTotalWithdrawal());
        System.out.printf("Total Interest: %.2f\n", ba.getTotalInterestAmount());


    }
}
