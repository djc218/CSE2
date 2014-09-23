/*
Daniel Colville
CSE 2 9/23/2014
This program should take the user input of the seconds that have passed during the day
and then display the time in conventional form.  The program uses a series of if statements 
to make sure that zeros are added to show time correctly when needed
*/
//import Scanner class to be used in program
import java.util.Scanner;
public class TimePadding {
    //main method used in every Java program
    public static void main(String[] args) {
        //declare and intialize a Scanner
        Scanner myScanner = new Scanner(System.in);
        //declares hours as a variable
        int hours;
        //user prompt for number of seconds
        System.out.print("Enter the time in seconds: ");
        //takes user input and stores it as an integer
        int secondsNumber= myScanner.nextInt();
        //first part of printing time
        System.out.print("The time is  ");
        //checks if there is an hour worth of seconds
        if(secondsNumber>=3600) {
            //finds number of hours as int
            hours=secondsNumber/3600;
            //print out hours
            System.out.print(hours+":");
        }
        //if there was not an hour of seconds, print out 0
        else { 
            System.out.print("0:");
        }
        //remove any full hours from second count
        secondsNumber=secondsNumber%3600;
        //finds number of minutes 
        int minutes=secondsNumber/60;
        //checks if first digit of minutes is zero and 2nd isn't
        if(minutes<10&&minutes>0) {
            //prints out a 0 and number of minutes
            System.out.print("0"+minutes+":");
        }
        //checks if number of minutes is equal to 0
        else if (minutes==0) {
            //prints out two 0's
            System.out.print("00:");
        }
        //prints out minutes if other statements weren't true
        else {
            System.out.print(minutes+":");
        }
        //takes full minutes from the count of seconds
        secondsNumber=secondsNumber%60;
        //check if first digit of seconds is 0 and 2nd isn't
        if(secondsNumber<10&&secondsNumber>0) {
            //prints 0 and the number of seconds
            System.out.println("0"+secondsNumber);
        }
        //checks if number of minutes is equal to 0
        else if(secondsNumber==0) {
            //prints out two 0's
            System.out.println("00.");
        }
        //prints out number of minutes if other statements weren't true
        else {
            System.out.println(secondsNumber);
        }
    }
}