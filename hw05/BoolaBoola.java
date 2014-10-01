/*
Daniel Colville
CSE 2 9/30/2014
This program is designed to generate a random sequence of 3 booleans separated by
2 random logical operators and print to user.  It will prompt the user to enter an evaluation
of the expression (t for true, f for false) and then evaluate the expression 
in the program and setting a string to t or f based on result.  The comparison
to the user entered string will tell user determine whether user is correct. 
Then the program will tell user whether they are correct or not.
*/
//import Scanner class so it can be used in program
import java.util.Scanner;
//import math class so we can use it to generate random numbers
import java.lang.Math;
public class BoolaBoola {
    //main method required in every Java program
    public static void main(String[] args) {
        //declare and initialize a scanner
        Scanner myScanner=new Scanner(System.in);
        //declare 3 booleans and give them a default value of false
        boolean random1=false;
        boolean random2=false;
        boolean random3=false;
        //declare two empty strings to hold operators
        String operator1="";
        String operator2="";
        //declare a string that will hold true evaluation of statement(t or f)
        String booleanEvaluation="";
        //generates 3 random numbers (0 or 1). 0 sets boolean to false and 1 sets to true
        random1=(int)(Math.random()*2)>0;
        random2=(int)(Math.random()*2)>0;
        random3=(int)(Math.random()*2)>0;
        //if random number(0 or 1) is 1, operator is ||(or)
        if ((int)(Math.random()*2)>0) {
            operator1="||";        
        } 
        //if random number is 0, operator is &&(and)
        else {
            operator1="&&";
        }
        //generates another random number(0 or 1). If it is 1, set second operator string to ||
        if((int)(Math.random()*2)>0) {
            operator2="||";
        }
        //if random number was 0, set second operator to &&
        else {
            operator2="&&";
        }
        //prints out random booleans and logical operators together with spaces in between
        //and asks user if the value is true or false
        System.out.print("Does "+random1+" "+operator1+ " "+random2+ " "+ operator2
        + " "+ random3+ " have the value true(t/T) or false(f/F)? ");
        //sets a string to take letter user entered
        String userResponse=myScanner.next();
        //checks if both operator strings are ||(or)
        if(operator1.equals("||")&&operator2.equals("||")) {
            //evaluates randomly generated expression if both operators are or
            if((random1)||(random2)||(random3)) {
                booleanEvaluation="t"; //sets a String to t to represent true
            }
            else {
                booleanEvaluation="f";  //sets String to f because statement was false
            }
        }
        //checks the case where first operator is || and second is &&
        else if(operator1.equals("||")&&operator2.equals("&&")) {
            //checks if statement is true with previously checked operators
            if((random1)||(random2)&&(random3)) {
                booleanEvaluation="t";//sets string to t(true)
            }
            else {
                booleanEvaluation="f"; //sets string to f(false)
            }
        }
        //checks the case where both operators are &&
        else if(operator1.equals("&&")&&operator2.equals("&&")) {
            if((random1)&&(random2)&&(random3)) {
                booleanEvaluation="t"; //sets string to t(true)
            }
            else {
                booleanEvaluation="f";//sets string to f(false)
            }
        }
        //checks the case where first operator is && and second is ||
        else if(operator1.equals("&&")&&operator2.equals("||")) {
            if((random1)&&(random2)||(random3)) {
                booleanEvaluation="t";//sets string to t(true)
            }
            else {
                booleanEvaluation="f";//sets string to f(false)
            }
        }
        //checks if user response equals string representing program's evaluation
        if(userResponse.equalsIgnoreCase(booleanEvaluation)) {
            System.out.println("Correct");//tells user they are correct
        }
        else {
            //tells user they were wrong if they entered wrong evaluation or another wrong character
            System.out.println("Wrong; try again"); 
        }
        
    }
}