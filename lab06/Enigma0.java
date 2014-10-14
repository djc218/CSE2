/*Sample of expected output:
 *   Enter an int- 9
 *   You entered 9
 *   sum is 25
 *   Again, you entered 9
 */

import java.util.Scanner;
public class Enigma0{
  public static void main(String arg []){
    int n=0;  
    System.out.print("Enter an int- ");  
    Scanner scan=new Scanner(System.in);
    if(scan.hasNextInt()){
      n=scan.nextInt();
      System.out.println("You entered "+n);
      int k=4,p=6,q=7,r=8;
    switch(k+p+q+r){
      case 24: 
      break;
      case 25:
          System.out.println("sum is 25\nAgain, you entered "+n);
      break;
    }
    }
    else{
      System.out.println("You did not enter an int");
    }
  }
}

/* Error report:
 * In the orginial code, n could potentially not be initialized
 * because it was only assigned a value if the scope of the if statement
 * Also there was a logic error where if the user did not enter an int
 * then the program would say the user entered 4 rather than print an error 
 * message.  To correct this, I made the else statement print an error message
 * and put the switch statement inside the if statement checking if the input 
 * was an int
 */