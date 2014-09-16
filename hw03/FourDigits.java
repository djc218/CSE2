/*
Daniel Colville
9/15/2014 CSE2
The program takes a double from user input and prints out the first four digits 
after the decimal point using division and the remainder operator
to get the digits from the input
*/
//import Scanner for use in program
import java.util.Scanner;
public class FourDigits {
    //main method required in Java program
    public static void main(String[] args) {
        //declare scanner and intialize it
        Scanner myScanner= new Scanner(System.in);
        //prompt user to enter double
        System.out.print("please enter a double to have first four digits" + 
        "after decimal printed:");
        //read double user typed and set to variable
        double digitSource=myScanner.nextDouble();
        //cut off any digits after 4 by multiplying by 10000 then taking int
        digitSource=(int)(digitSource*10000);
        //take last digit by using remainder and dividing by 10
        int lastDigit=(int)(digitSource%10);
        digitSource/=10;//takes 4th digit off number
        //uses remainder to find 3rd digit
        int thirdDigit=(int)(digitSource%10);
        digitSource/=10;//takes 3rd digit off number
       // uses remainder to find 2nd digit
        int secondDigit=(int)(digitSource%10);
        digitSource/=10;//takes 2nd digit off number
       //uses remainder to find first digit 
        int firstDigit=(int)(digitSource%10);
        System.out.println("The four digits are "+firstDigit+secondDigit
        +thirdDigit+lastDigit);
    }
}