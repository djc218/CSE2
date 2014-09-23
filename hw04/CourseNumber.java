/*
Daniel Colville
CSE 2 9/23/2014
This program will take a Lehigh Course number from user input and use it 
to find the semsester and year it is offered after checking that it represents
a valid year and semester for Lehigh.
*/
//import scanner so it can be used in program
import java.util.Scanner;
public class CourseNumber {
    //main method required for all Java programs
    public static void main(String[] args) {
        //declare and initialize a Scanner
        Scanner myScanner= new Scanner(System.in);
        //prompt user to enter a course number
        System.out.println("Enter a six digit number giving the course semester- ");
        //take user entered input and store as variable
        int courseDigit=myScanner.nextInt();
        //sets first four digits of number as another variable
        int firstFourDigits=(int)(courseDigit/100);
        //separates last two digits individually, then recombine them into one number
        int lastDigit=courseDigit%10;
        int fifthDigit=((int)(courseDigit/10))%10;
        int lastTwoDigits=(10*fifthDigit)+lastDigit;
        //check to make sure that course number is in valid range of potential course numbers
        if(courseDigit>=186510&&courseDigit<=201440) {
            //switch statement with various cases for last two variables
            switch(lastTwoDigits) {
                //case when last 2 digits are 10
                case 10:
                    //prints out year and semester of class
                    System.out.println("the course was offered in Spring semester of " + firstFourDigits);
                    break;
                //case when last 2 digits are 20
                case 20:
                    //prints out year and semester of class
                    System.out.println("the course was offered in Summer 1 semester of " + firstFourDigits);
                    break;
                //case when last 2 digits are 30
                case 30:
                    //prints out year and semester of class
                    System.out.println("the course was offered in Summer 2 semester of " + firstFourDigits);
                    break;
                //case when last 2 digits are 40
                case 40:
                    //prints out year and semester of class
                    System.out.println("the course was offered in Fall semester of " + firstFourDigits);
                    break;
                //default case applies when none of the others do
                default:    
                    //tells user that they didn't enter a valid semester
                    System.out.println(lastTwoDigits+" is not a valid semester");
                    break;
            
            }
            
        }
        //tells user if they didn't enter a number in the valid range
        else {
            System.out.println("The number was outside the range [186510,201440]");
        }
        
    }
}