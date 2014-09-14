/*
Daniel Colville
9/12/2014 CSE 2
The program should calculate the cost of buying Big Macs. By using the java Scanner 
class, it will get the number of Big Macs, cost per Big Macs, and state tax rate
which it will use to calculate the cost
*/
//import Scanner so we can use it in program
import java.util.Scanner;
public class BigMac {
    //main method required in Java program
    public static void main(String[] args) {
        Scanner myScanner;//declare a scanner
        //initialize scanner to take keyboard input
        myScanner = new Scanner( System.in );
        //prompt user to enter integer
        System.out.print("Enter the number of Big Macs(intger>0): ");
        //reads user input and stores int in nBigMacs
        int nBigMacs= myScanner.nextInt();
        //user prompt for Big Mac cost
        System.out.print("enter the cost per Big Mac as"+
        "a double (in the form xx.xx):");
        //reads user inputed cost and sets it equal to variable
        double bigMac$ = myScanner.nextDouble();
        //prompts user to enter tax rate
        System.out.print("Enter the percent tax rate as a whole number (xx) : ");
        //sets variable equal to user input
        double taxRate=myScanner.nextDouble();
        //converts take rate to proportion
        taxRate/=100;
        //declare variable for cost calculation
        double cost$;
        //variables to hold values to left of decimal(dollars),1st decimal place
        //to right(dimes) and 2nd to right of decimal(pennies)
        int dollars, dimes, pennies;
        //calculates cost
        cost$=nBigMacs*bigMac$*(1+taxRate);
        //splits dollar amount from cost
        dollars= (int) cost$;
        //finds number of dimes using remainder operation
        //for example (int)$5.11*10=51  51%10=1
        dimes= (int) (cost$*10) %10;
        //extracts number of pennies from cost using multiplcation then remainder
        pennies= (int) (cost$*100) %10;
        //prints out number of Big Macs,cost per Big Mac,tax rate,and final cost
        System.out.println("The total cost of " +nBigMacs + " Big Macs, at $"
        + bigMac$ + " per bigMac, with a"+ " sales tax of " 
        + (int) (taxRate*100) + "% is $" + dollars+ '.'+ dimes+pennies);
    }
}