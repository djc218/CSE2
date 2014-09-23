/*
This class will take a user input of a month in the form an integer from 1 to 12, 
checking to make sure it is positive and an int.  Then check what month it is and 
print out the number of days in the month.  If the month is February, ask user to input 
the year and print appropriate number of days based on whether or not it is a leap year
*/
//import scanner to be used in program
import java.util.Scanner;
public class Month {
    //main method required for all Java programs
    public static void main(String[] args) {
        //declare and initialize a scanner
        Scanner myScanner=new Scanner(System.in);
        //declare month of year and year to be used later
        int monthOfYear;
        int year;
        //user prompt to enter month as int
        System.out.print("enter an int giving the number of a month (1-12):");
        //checks if number is int, 
        if(myScanner.hasNextInt()) {
            monthOfYear=myScanner.nextInt(); //sets month of year to int
        }
        //if user didn't enter int, tell them and end program
        else{
            System.out.println("you did not enter an int");
            return;
        }
        //checks if month is between 1 and 12
        if(1<=monthOfYear&&monthOfYear<=12) {
            //checks if month is one of 30 day months
            if(monthOfYear==4||monthOfYear==6||monthOfYear==8||monthOfYear==7||
            monthOfYear==8||monthOfYear==11) {
                System.out.println("This month has 30 days");//prints out month has 30 days
            }
            //checks if month if February
            else if(monthOfYear==2) {
                //user prompt to enter year
                System.out.print("enter an int giving the year:");
                //check if year is int
                if(myScanner.hasNextInt()) {
                year=myScanner.nextInt(); // set year equal to user entered int
                    //checks if year is positive
                
                    if(year>0) {
                        //checks if it is leap year not divisible by 100
                        if(year%4==0&&!((year%100)==0)) {
                            System.out.println("This month has 29 days"); //tells user 29 days
                        }
                        
                        //checks if year is divisible by 100 and 400, if so it is a leap year
                        else if(year%100==0&&year%400==0) {
                            System.out.println("This month has 29 days"); //tells user 29 days
                        }
                        //any years that haven't been counted as leap years have 28 days
                        else {
                            System.out.println("This month has 28 days"); 
                        }
                    }
                    //if year wan't greater than 0, tell user and terminate program
                    else{
                        System.out.println("you did not enter a positive int");
                        return;
                    }
                }
                //tells user and ends program if user didn't enter int
                else{
                System.out.println("you did not enter an int");
                return;
                }
            }
            //all other months that we haven't checked for have 31 days
            else { 
                System.out.println("This month has 31 days");  //print that months have 31 days
            } 
        }
        //tell user they did not enter int in right range and terminate program
        else {
            System.out.println("you did not enter a number in the range of 1-12");
            return;
        }
    }
}