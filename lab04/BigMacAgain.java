/*
Daniel Colville
CSE 2 9/19/2014
This program will use scanner class to obtain how many big Macs the user wants
and whether or not they want an order of fries.
Then it prints out the cost of the meal.  Big mac cost is $2.22 and cost of fries is $2.15
*/
//import scanner to be used in program
import java.util.Scanner;
public class BigMacAgain {
    //main method needed for every Java program
    public static void main(String[] args) {
        //declare and initialize scanner
        Scanner myScanner= new Scanner(System.in);
        //prompt user to enter number of Big Macs
        System.out.print("Enter the number of Big Macs:");
        //declare Big Macs
        int nBigMacs;
        //checks if user entered int.  If user entered int, sets number of big macs to
        //the int entered by user
        if(myScanner.hasNextInt()) 
            nBigMacs=myScanner.nextInt(); 
            //if user did not enter int, print out statement telling user
        else{
            System.out.println("You did not enter an int");
            return; //terminates program
        }
        double bigMacCost;//declares bigMacCost as variable
        //if Big Mac number is greater than zero, run text inside brackets
        if(nBigMacs>0) {
        bigMacCost=nBigMacs*2.22;//find cost of Big Macs by multiplying by cost
        bigMacCost=(int)(bigMacCost*100)/100.0;//cuts off any digits beyond 2 after decimal
        //prints out statement telling user number ordered and total cost of Big Macs
        System.out.println("You ordered "+ nBigMacs+ " Big Macs for a cost of " 
        + nBigMacs+ "* $" + "2.22= $"+ bigMacCost);
        }
        // if Big Mac number is not greater than zero, tell user and end program
        else {
            System.out.println("You did not enter an int greater than 0");
            return; //terminates program
        }
        //prompts user to answer whether they want fries
        System.out.print("Do you want an order of fries (Y/y/N/n)?");
        //takes next user input as a string
        String answer=myScanner.next();
        //checks if user answer is y(yes) in lower case or upper case
        if(answer.equals("Y")||answer.equals("y")) {
            double totCost=bigMacCost+2.15;//add cost of fries to cost of Big Macs
            totCost=(int)(totCost*100)/100.0;//cuts off any digits after 2nd decimal
            System.out.println("The cost of french fries is $2.15");//tells user cost of fries
            System.out.println("The total cost of the meal is $"+totCost);//tells user total cost
        }
        //checks if user enters n(no) in lower or upper case
        else if(answer.equals("N")||answer.equals("n")) {
            System.out.println("the total cost of the meal is $ "+ bigMacCost);//prints out total cost
        }
        //runs if neither of first two cases are true.  Tells user error they made, then exits program
        else {
            System.out.println("you did not answer with 'y', 'Y', 'n', or 'N'");
            return;  //terminates program
        }
    }
}