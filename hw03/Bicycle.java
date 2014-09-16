/*
Daniel Colville
CSE 2 9/14/2014
This program will prompt user to input of seconds on a bicycle trip and number 
of rotations(counts) and from these numbers it will calculate the distance of
the trip in miles, its length in minutes and the average number of miles per
hour on the trip.  
*/
//import Scanner so it can be used in program
import java.util.Scanner;
public class Bicycle {
    //main method for program
    public static void main(String[] args) {
        //declare and initialize scanner to take keyboard input
        Scanner myScanner = new Scanner(System.in);
        //prompts user to enter counts and stores result in variable tripCounts
        System.out.print("enter the number of counts:");
        int tripCounts=myScanner.nextInt();
        //asks user for number of seconds then stores result in a variable
        System.out.print("enter the number of seconds:");
        int tripSeconds=myScanner.nextInt();
        //constants used in calculations
        double wheelDiameter=27.0,
        PI=3.14159,
        inchesPerFoot=12,
        feetPerMile=5280,
        secondsPerMinute=60,
        minutesPerHour=60;
        //calculation of minutes in a trip
        double tripMinutes=tripSeconds/secondsPerMinute;
        //calculates trip distance in inches, then converts to miles through feet
        double tripDistance=tripCounts*PI*wheelDiameter/inchesPerFoot/feetPerMile;
        //calculates mph using distance in miles and seconds, which are converted to hours
        double milesPerHour=tripDistance/(tripSeconds/(secondsPerMinute*minutesPerHour));
        //cuts off more than two decimals for final result of distance and mph
        tripDistance=(int)(tripDistance*100)/100.0;
        milesPerHour=(int)(milesPerHour*100)/100.0;
        //prints out the distance in miles and trip length in minutes
        System.out.println("the distance was "+tripDistance + " miles and took "
        + tripMinutes+ " minutes");
        //prints out mph for trip
        System.out.println("the average mph was "+ milesPerHour);
        
    }
}