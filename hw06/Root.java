/*
Daniel Colville
CSE 2 10/14/2014
This program takes a user inputed double and estimates its square root using the midpoint
method.  The program checks that the input is a double and greater than 0.  A loop 
will ensure that the method is run enough times until the difference between low and high is 
less than or equal to 0.0000001
*/
//import Scanner so it can be used in program
import java.util.Scanner;
public class Root {
    //main method for every Java program
    public static void main(String[] args) {
        //declare and initialize a scanner
        Scanner myScanner= new Scanner(System.in);
        //variable for user input; default is outside valid range
        double userInput=-1;
        //user prompt to enter double above 0
        System.out.print("Please enter a double greater than zero to have square root taken: ");
        //check if user entered a double
        if(myScanner.hasNextDouble()) {
            userInput=myScanner.nextDouble();//sets variable to user input
        }
        //if user didn't enter a double, tell them they didn't
        else {
            System.out.println("you did not enter a double");
            return;
        }
        //if user input is greater than 0
        if(userInput>0) {
            //sets low to 0
            double low=0;
            //sets high to 1 plus user entered value
            double high=1+userInput;
            //sets middle to high divided by 2
            double middle=(high/2);
            //while loop conditioned on difference between high and being above certain threshold
            while((high-low)>0.0000001) {
                //if middle squared is greater than user input, set high=middle
                if((middle*middle)>=userInput) {
                    high=middle;
                }
                //if not true, set low=middle
                else {
                    low=middle;
                }
                //reset middle to midpoint between new low and high
                middle=(low+high)/2;
            }
            //prints out square root estimate
            System.out.println("The square root estimate is: "+ middle);
        }
        //if user didn't enter a number greater than 0
        else {
            //tells user the error and exit program
            System.out.println("you did not enter a number greater than 0");
            return;
        }
    }
}