/*
Daniel Colville 
CSE 2 10/21/2014
The purpose of this program is to take a user input of an int between 1 and 9
and print out a stack of numbers from 1 to the number the user entered.  The number of times
per line a number should be printed is 1 less than two times that number and the number of rows
that numbers should be printed out on is equal to that number.  There should also be a row
of dashes after each number with the same number of dashes as the number of times the number was 
printed per row.  This problem was solved 3 different ways using the 3 different types of 
loops separately.  
*/
//import Scanner so we can use it in program
import java.util.Scanner;
public class NumberStack {
    //main method for every Java program
    public static void main(String [] args) {
        //declare and initialize Scanner to take user input
        Scanner myScanner = new Scanner(System.in);
        //prompt user to enter an int between 1 and 9
        System.out.print("Enter an int between 1 and 9- ");
        //initialize userInput to a number outside range of 1 through 9
        int userInput=0;
        //if user entered int, set value to variable userInput
        if(myScanner.hasNextInt()) {
            userInput=myScanner.nextInt();
        }
        //if user did not enter an int, tell them they did not and end the program
        else {
            System.out.println("you did not enter an int");
            return;
        }
        //check if int is between 1 and 9
        if(userInput>=1&&userInput<=9) {
            //tell user what type of loop is used for this stack
            System.out.println("using for loops");
            //outermost loop ensuring max number of times through is equal to user Input
            for(int i=1;i<=userInput;i++) {
                //this loop prints out the proper number of spaces before the numbers
                //the number of spaces if fewer if the number is larger
                for(int l=0;l<=userInput-i;l++) {
                System.out.print(" ");   
                }
                //this loop ensures that numbers are printed on correct number of rows
                for(int h=0;h<i;h++) {
                    //this loop prints out i the given amount of times on a line
                    for(int j=1;j<=(i*2)-1;j++) {
                        System.out.print(i);
                    }
                    //creates a new line
                    System.out.println("");
                    //adds appropriate number of spaces to new line
                    for(int m=0;m<=userInput-i;m++) {
                     System.out.print(" ");   
                    }
                }
                //this loop prints out the correct number of dashes on a line
                for(int k=1;k<=(i*2)-1;k++) {
                    System.out.print("-");
                }
                //creates a new line
                System.out.println("");
            }
            //declare and initialize variable to control outermost loop
            int a=1;
            //tell user type of loop
            System.out.println("using while loops");
            //loop with max number of times running equal to number user entered
            while(a<=userInput) {
                //initialize variables to control other loops.  These variables get reset each time through the outermost loop
                int b=0;
                int c=0;
                int f=1;
                //loop that prints out spaces
                while(b<=(userInput-a)){
                    System.out.print(" "); 
                    b++;
                }
                //loop controlling the number of rows which have numbers printed on them
                while(c<a) {
                    //sets value for variables that control loops inside this loop.  
                    //They are reset each time through this loop
                    int d=1;
                    int e=0;
                    //loop that prints out number a on a given line a certain number of times
                    while(d<=(a*2)-1) {
                        System.out.print(a);
                        d++;
                    }
                    //creates a new line
                    System.out.println("");
                    //loop that adds spaces before each row of numbers
                    while(e<=userInput-a) {
                        System.out.print(" ");
                        e++;
                    }
                    c++;
                }
                //prints out dashes
                while(f<=((a*2)-1)) {
                    System.out.print("-");
                    f++;
                }
                //creates a new line
                System.out.println("");
                a++;
            }
            //tells user the type of loop we are using
            System.out.println("Using do while loops:");
            //initialize variables that will be used to control the loops
            int u=1; 
            int y=0;
            int v=0;
            //outermost loop to make sure max number if the number user entered
            do {
                //initialize these variables inside the loop so they will be reset each time
                int w=0;
                int z=1;
                //loop controlling how many rows numbers are printed on
                do {
                    //loop that prints out spaces before numbers
                    do {
                        System.out.print(" ");
                        v++;
                    } while(v<=(userInput-u));
                    //resets variables that control interior loops
                    int x=1;
                    y=0;
                    //loop that prints out the corrrect amount of numbers on a line
                    do {
                        System.out.print(u);
                        x++;
                    } while(x<=(u*2)-1);
                    //create a new line
                    System.out.println("");
                    w++;
                    //reset variable for interior space printing loop
                    v=0;
                } while(w<u);
                //loop that prints out spaces before the dashes
                do {
                    System.out.print(" ");
                    y++;
                } while(y<=userInput-u);
                //loop that prints out an appropriate number of dahes
                do {
                    System.out.print("-");
                    z++;
                } while(z<=((u*2)-1));
                //create a new line
                System.out.println("");
                u++;   
            } while(u<=userInput);
            
        }
        //if the int user entered wasn't between 1 and 9, tell the user
        else {
            System.out.println("you did not enter a number between 1 and 9");
        }
    }
}