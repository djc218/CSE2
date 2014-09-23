/*
This program will take the income of a user in thousands of dollars through a Scanner, 
find the tax rate for their income bracket, then calculate the income tax they pay
*/
//import scanner so it can be used in program
import java.util.Scanner;
public class IncomeTax {
    //main method is required in every Java program
    public static void main(String[] args) {
        //declare a scanner and have it look for keyboard input
        Scanner myScanner=new Scanner(System.in);
        //declare tax rate and user income as variables outside if statements
        double taxRate;
        int userIncome;
        //user prompt to enter income
        System.out.print("Enter an int giving income in thousands of dollars: ");
        //if user entered an int, store in user income variable
        if(myScanner.hasNextInt()) {
        userIncome=myScanner.nextInt();
        }
        //if user didn't enter int, tell them they didn't and end program
        else {
            System.out.println("you did not enter an int");
            return;
        }
        //checks if int user entered is greater than 0, if so proceeds with finding income tax
        if(userIncome>0) {
            
        //case for user income less than $20000
        if(userIncome<20) {
            taxRate=.05; //sets tax rate to 5%
        }
        //case for incomes between greater than or equal to $20000 and less than $40000
        //previous statement already got values less than $20000, so only need to check upper value
        else if(userIncome<40) {
            taxRate=.07; //set tax rate to 7%
        }
        //checks for incomes between $40000 and $78000
        else if(userIncome<78) {
            taxRate=.12; //sets tax rate to 12%
        }
        //any incomes at or above $78000
        else {
            taxRate=.14; //sets tax rate to 14%
        }
        userIncome*=1000; //converts income into thousands
        //multiplies income by tax rate to find total income tax
        double incomeTax=taxRate*userIncome;
        //prevents excessive digits from being printed if rouding errors occured
        //in calculation.  Also converts tax rate to percent form
        incomeTax=(int)(incomeTax*100)/100.0;
        taxRate=(int)(taxRate*100);
        //print out income, tax rate, and income tax
        System.out.println("The tax rate on $"+userIncome+ " is "+ 
        taxRate+ "%, and the tax is $"+ incomeTax );
        }
        //if int user entered was not greater than 0, tell them of error and end program
        else {
            System.out.println("you did not enter a positive int");
            return;
        }
    }
}