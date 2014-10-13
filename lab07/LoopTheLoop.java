/*
Daniel Colville
CSE 2 10/10/2014
This program will the user to enter an int between 1 and 15 then print that number
of lines of stars where the number of stars in the line is also its number among 
the rows of star(e.g first line is one star, second is two stars).  After stars 
are printed, ask the user if they want to run star printing again.  If the user 
wants to run it again, the program will run again until the user doesn't want
to run again or enters an invalid input.
*/
import java.util.Scanner; //import Scanner to be used in program
public class LoopTheLoop {
    //main method required in every Java program
    public static void main(String[] args) {
        //declare and initialize a scanner that will take user inputs
        Scanner myScanner=new Scanner(System.in);
        //outermost loop. only stops if user enters invalid input or doesn't want another iteration
        while(true) {
            int nStars=-1;//default value is outside range, so program doesn't run if value is overwritten later
            int j=0;//counter variable for line number
            int k=0;//counter variable for stars in a loop
            //user prompt to enter int in range
            System.out.print("Enter an int between 1 and 15- ");
            //if user did not enter an int
            if(!myScanner.hasNextInt()) {
                //tell user they did not enter int, then end program
                System.out.println("You did not enter an int");
                return;
            }
            //if user entered an int
            while(myScanner.hasNextInt()) {
                //sets number of stars equal to user input
                nStars=myScanner.nextInt();
                //checks if user entered number between 1 and 15
                if(nStars>=1&&nStars<=15) {
                    //This loop prints out the number of stars the user entered on one line
                    while(k<nStars) {
                        System.out.print("*"); //prints a star each time through
                        k++; //incrementing counting variable in loop
                    }
                    //this loop makes sure that stars are printed on proper number of lines
                    //nStars is the sentinel variable
                    while(j<nStars) {
                        int i=0; //declare and initialize a counter variable
                        System.out.println(""); //goes to next line
                        //prints number of stars with sentinel variable being counter variable of outer loop
                        while(i<=j) {
                            System.out.print("*");//prints star
                            i++;//increments counter variable i
                        }
                        j++;// increments counter variable j
                    }
                }
                //case if user entered number outside range
                else {
                    //tells user the problem, then exits program
                    System.out.println("your int was not in range [1,15]");
                    return;
                }
                //user prompt for running again
                System.out.print("\nEnter y or Y to go again- ");
                //stores user response in String
                String runAgain=myScanner.next();
                //if user entered y or Y, go back to outermost loop
                if(runAgain.equalsIgnoreCase("y")) {
                    break; //break out loop based on having an int
                }
                // statements inside run if user doesn't enter y or Y
                else {
                    return; //end program
                }  
            }
        }
    }
}