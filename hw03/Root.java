/*
Daniel Colville
CSE 2 9/15/2014
This program is supposed to prompt user to enter a double, then take the estimate
of the cube root of the double.  Then it prints it out and then cubes it and 
prints out the result.
*/
//import the Scanner class for use in program
import java.util.Scanner;
public class Root {
    //Main method required in every Java program
    public static void main(String[] args) {
        //declare and initialize scanner to take input
        Scanner myScanner= new Scanner(System.in);
        //prompt user to enter double
        System.out.print("Enter a double and I print its cube root- " );
        //read double user entered
        double userInput=myScanner.nextDouble();
        //next 6 lines take input and estimate the cube root first by dividing by 3
        //and then improving th accuracy of the guess by using the previous guess
        double guess=userInput/3;
        guess=(2*guess*guess*guess+userInput)/(3*guess*guess);
        guess=(2*guess*guess*guess+userInput)/(3*guess*guess);
        guess=(2*guess*guess*guess+userInput)/(3*guess*guess);
        guess=(2*guess*guess*guess+userInput)/(3*guess*guess);
        guess=(2*guess*guess*guess+userInput)/(3*guess*guess);
        //prints out cube root estimate
        System.out.println("the cube root is: "+guess);
        //cubes the estimate, then prints it out
        System.out.print(guess+"*"+guess+"*"+guess+"=");
        System.out.print(guess*guess*guess);
    }
}