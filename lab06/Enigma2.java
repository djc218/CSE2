import java.util.Scanner;
public class Enigma2{
  public static void main(String [] arg){
    int n=40,k=60;
    String out="";
    switch(n){
      case 12: 
      case 13: out+=13;
      case 40: out+=40/1;
    }
    System.out.println(out);
  }
}
/* Error Report: Explain how you can use the java.lang exception to
 *     identify the runtime error in the above code
 * The exception that the compiler references is the divide by zero error,
 * which it say occurs in the main method.  If we look to line 9, we find that 
 * we have 40/0 as an operation for a case in the switch statement, which ends up  
 * running and causes a runtime error. To get rid of error, don't put in a number divided by
 * 0 into the calculation
 */

