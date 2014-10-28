/*
Daniel Colville
CSE 2 10/28/2014
This program has code that accesses 3 different versions of an overloaded method called 
getInput.  All three take different inputs but return a character.  The first method
takes a scanner and a string and forces to get the user to enter a string of length one 
that is contained in the String from the input.  The second does something similar, 
except it takes a number as an additional input, and if the user fails to enter a 
character in the String after this many times, it stops asking them and simply returns
a space.  The third method has a scanner and two strings as input.  One String is printed out
as a user prompt and the other is still used to check against user input.  It will force the 
user to enter a character from that String and then return that character.
*/
//import scanner so it can be used in program
import java.util.Scanner;
public class HW8 {
  //main method for all Java programs
  public static void main(String[] arg) {
      //deckare a char to be assigned value later
      char input;
      //declare and initialize a scanner to be used as method input
      Scanner scan = new Scanner(System.in);
      //user prompt
      System.out.print("Enter 'C' or 'c' to continue, anything else to quit- ");
      //run first getInput method
      input = getInput(scan, "Cc");
      //prints out output of method
      System.out.println("You entered '" + input + "'");
      //user prompt
      System.out.print("Enter 'y', 'Y', 'n', or 'N'- ");
      //calls second getInput method
      input = getInput(scan, "yYnN", 5); //give up after 5 attempts
      //if method returned something other than blank String, print out output
      if (input != ' ') {
        System.out.println("You entered '" + input + "'");
      }
      //call third getInput method
      input = getInput(scan, "Choose a digit.", "0123456789");
      //print out output of method
      System.out.println("You entered '" + input + "'");
    }
    //first method-input is a scanner and a string
  public static char getInput(Scanner scan, String inputTest) {
      //calls second method, but with such a large int it won't fail unless user enters very many numbers
      char output=getInput(scan,inputTest,10000000);
      //returns output from call of second method
      return output;
    }
    //second method- input is a scanner, a string, and an int
  public static char getInput(Scanner scan, String userInput, int numberAttempts) {
      //boolean for if user entered a character with match in string
      boolean stringMatch = false;
      //default output
      char output = ' ';
      //counts number of times user has failed
      int userFails = 0;
      //loop that runs while user hasn't entered character from given strin and hasn't reached maximum fails as given by int
      while (!stringMatch && userFails < numberAttempts) {
        //makes user enter a string
        String userString = scan.next();
        //if string is longer than 1 character, tell user and make them enter another string
        while (userString.length() > 1) {
          System.out.println("you should enter exactly 1 character");
          userString = scan.next();
        }
        //loop that checks character against each character in string
        for (int i = 0; i < userInput.length(); i++) {
          //character set equal to first(only) character of string
          char test = userString.charAt(0);
          //compares two chars, user entered one and one at index i of string
          if (test == (userInput.charAt(i))) {
            //sets output to proper character
            output = userString.charAt(0);
            //set boolean to true because we have just found a match in string
            stringMatch = true;
          }
        }
        //if no match in string has been found, tell user to try again
        if (!stringMatch) {
          System.out.print("you did not enter a character from the list " + userInput + " try again- ");
          userFails++; //increment user fails
        }
      }
      //if user fails has reached maximum number of fails
      if (userFails == numberAttempts) {
        //tell user number of times they failed after
        System.out.println("\nyou failed after " + numberAttempts + " times");
        return ' '; //return space character
      }
      return output; //return whatever character was entered  
    }
    //third method-inputs are a scanner and two strings
  public static char getInput(Scanner scan, String userPrompt, String userMatch) {
    //boolean checking if a match to a character in string has been found
    boolean matchingString = false;
    //default output
    char output = ' ';
    //print out string that acts as a user prompt
    System.out.println(userPrompt);
    //loop for when match has not yet been found
    while (!matchingString) {
      //gets user to enter a string
      String userString = scan.next();
      //if user entered string of more than one character, tell them and make them enter a one character string
      while (userString.length() > 1) {
        System.out.println("Enter exactly one character");
        userString = scan.next();
      }
      //loop that checks character against each character in string
      for (int i = 0; i < userMatch.length(); i++) {
        //character equal to user string 
        char test = userString.charAt(0);
        //compares character at index i of string that was an input with character from user input
        if (test == (userMatch.charAt(i))) {
          //sets output to user entered character
          output = userMatch.charAt(i);
          //set this equal to true because we have found a match in string
          matchingString = true;
        }
      }
      //if string did not have a match, tell user they did not enter proper character
      if (!matchingString) {
        System.out.println("you did not enter an acceptable character");
      }
    }
    //return the entered character as output
    return output;
  }
}