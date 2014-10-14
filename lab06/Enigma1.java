/* The user is supposed to enter a number between 0 and 99.
 * The program interprets that as a percentage, converts it to
 * a prorportion and then displays the proportion (out of 1) 
 * remaining. It does not always work. Find out when it doesn't
 */

import java.util.Scanner;
public class Enigma1{
  public static void main(String []arg){
    double percent=0;
    Scanner myScanner= new Scanner(System.in);
    System.out.print("Enter a value for the percent (0, 1,...99)- ");
    if(myScanner.hasNextDouble()) {
        percent=myScanner.nextDouble();
        int percentInteger= (int)(percent*100);
        System.out.println("You entered "+percent+"%");
        //print out the proportion remaining for select percentages
        double proportionRemaining=(10000-percentInteger)/10000.0;
        if(proportionRemaining>=.01&&proportionRemaining<=1) {
         System.out.println("The remaining proportion is "+proportionRemaining);
        }
        else {
         System.out.println("you entered a value too big or too small");
        }
   }
   else {
        System.out.println("you did not enter a number");
    }
  }
}

/* Error report: 
 *  The logic of the program tried to make a case for each proportion for certain
 *  proportions(such as when user enters 7) rather than create a process that could 
 *  handle any user output The program also tried to compare two doubles using 
 *  the == operator, which is likely to give an incorrect result due to rounding 
 *  errors.  To fix this, instead we can use integer versions of the double values
 *  for comparisons.  The original program is only supposed to take a value 
 *  between 0 and 99, though the program does not check if the value is in a valid range.
 *  I fixed the program by checking the user input and making the math generalized for 
 *  any case in the range between 0 and 99, so it would work with any valid input 
 *  rather than checking each case individually.
 */
