/*
Daniel Colville 
CSE 2 11/4/2014
This program is designed to print out a block of numbers and dashes based on an integer 
which the user entered that is between 1 and 9.  The program prompts the user until they enter 
an int between 1 and 9.  Each number should be printed on a number of rows equal to that number
and the amount of numbers printed on each row is equal to one less than two times that number
There should be a line of dahes on the row between different numbers(e.g. between 2's and 3's)
that has a number of dashes equal to the amount of numbers above it.  The program is designed
modularly by implementing different methods to break down the task into components.  
*/
//import scanner so we can use it in class
import java.util.Scanner;
public class BlockedAgain{
    //main method for all Java programs
    public static void main(String []s){
    //declare an int m that will store value later
    int m;
    //declare and initialize a scanner
    Scanner myScanner=new Scanner(System.in);
    //prompt user to enter an int
    System.out.print("Enter an int- ");
    //set m equal to call of getInt method with scanner as input
    m = getInt(myScanner); 
    //call allBlocks method to print out a block with appropriate specifications
    allBlocks(m);
    }
    //method which returns int and has input of scanner
    public static int getInt(Scanner myScanner) {
        //calls checkInt method
        int userInteger=checkInt(myScanner);
        //calls checkRange method
        userInteger=checkRange(userInteger, myScanner);
        //returns integer user entered which was in proper range
        return userInteger;
    }
    //checkInt method-returns int and input scanner
    public static int checkInt(Scanner myScanner) {
        //sets a default value for userInput to guarantee something is returned
        int userInput=0;
        //if user has not entered an integer, prompt them to enter int
        while(!myScanner.hasNextInt()) {
            //clears what user entered
            myScanner.next();
            //prompts user to try again
            System.out.print("You did not enter an int; Try again- ");
        }
            //if user entered int, set that value to userInput
            userInput=myScanner.nextInt();
        //return userInput
        return userInput;
    }
    //returns int and takes an integer and scanner as input
    public static int checkRange(int userInteger, Scanner myScanner) {
        //sets default value for return
        int userInput=0;
        //if user input is not between 1 and 9, prompt user and return them to checkInt method
        while(userInteger<1||userInteger>9) {
            System.out.print("You did not enter an int between 1 and 9; try again- ");
            userInteger=checkInt(myScanner);
        }
        //return user input
        return userInteger;
    }
    
    public static void allBlocks(int blockingNumber) {
        //integer counting row length so it can be used as input for block method
        int rowLength=0;
        //calls block once for each number from 1 to the number the user entered
        for(int j=1;j<=blockingNumber;j++) {
            //increment row length
            rowLength++;
            //call block method
            block(blockingNumber,rowLength);
        }
    }
    public static void block(int blockingNumber, int rowLength) {
        //call space printing method
        line(blockingNumber, rowLength);
        //this loop ensures that new lines are started and spaces are printed
        for(int h=0;h<rowLength;h++) {
            //ensures that proper amount of numbers are printed
            for(int k=0;k<(rowLength*2)-1;k++) {
                //prints out current number on the line
                System.out.print(rowLength);
            }
            //starts new line
            System.out.println();
            //calls space printing method
            line(blockingNumber, rowLength);
        }
        //ensures that proper number of dashes are printed on a line
        for(int i=1;i<=(rowLength*2)-1;i++) {
            //print a dash for each time through loop
            System.out.print("-");
        }
        System.out.println();
    }
    //method ensures correct number of spaces are printed on line
    public static void line(int blockingNumber, int rowLength) {
             //determines how many spaces should be printed
             for(int l=0;l<=blockingNumber-rowLength;l++) {
                //prints a space each time through loop
                System.out.print(" ");
            }
    }
}
