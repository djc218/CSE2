/*
Daniel Colville
CSE 2
9/5/2014
This program is meant to simulate a bicycle cyclometer by recording data for
time elapsed and rotations of the front wheel. Given this data it should be
able to calculate the time, distance, and rotations for a given trip and the
combined distance of two trips if given two trips to calculate from.
*/
public class Cyclometer {
    //main method-required for Java program
    public static void main(String[] args) {
        //our input data used for calculations
        int secsTrip1=480;//The number of seconds on trip 1
        int secsTrip2=3220;//The number of seconds on trip 2
        int countsTrip1=1561;//Number of wheel rotations on trip 1
        int countsTrip2=9037;//Number of wheel rotations on trip 2
        //constants and variables used to do conversions
        double wheelDiameter=27.0,//Diameter of wheel(inches) to convert rotations to distance
        PI=3.14159,//value for pi used in distance conversions
        feetPerMile=5280,//constant to convert feet to miles
        inchesPerFoot=12,//constant to convert inches to feet
        secondsPerMinute=60;//used for converting seconds to minutes
        double distanceTrip1, distanceTrip2, totalDistance;//variables to store result of later calculations
        //calculates minutes in each trip, then prints out minutes and number of rotations for each trip
        System.out.println("Trip 1 took "+(secsTrip1/secondsPerMinute)+" minutes and had "+countsTrip1+" counts");
        System.out.println("Trip 2 took "+(secsTrip2/secondsPerMinute)+" minutes and had "+countsTrip2+" counts");
        distanceTrip1=countsTrip1*wheelDiameter*PI;
        //above uses calculates trip1 distance in inches using wheel diameter and number of rotations
        distanceTrip1/=inchesPerFoot*feetPerMile;//converts trip distance to feet, then miles
        distanceTrip2=countsTrip2*wheelDiameter*PI/inchesPerFoot/feetPerMile;
        totalDistance=distanceTrip1+distanceTrip2;
        //above calculates trip 2 distance from rotations and wheel diameter, then converts it to miles
        //print out distance of each trip and then total distance
        System.out.println("Trip 1 was "+distanceTrip1+" miles");
        System.out.println("Trip 2 was "+distanceTrip2+" miles");
        System.out.println("The total distance was "+totalDistance+" miles");
    }
}