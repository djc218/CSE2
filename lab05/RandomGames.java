/*
Daniel Colville
CSE 2 9/26/2014
This program should take user output to choose one of 3 chance based games, roulette, 
craps, or picking one card from a deck of playing cards.  The program will then simulate
the game which the user picked and print out the result of the game.
*/
//import scanner so it can be used later in program
import java.util.Scanner;
//import math class so we can use random number generator
import java.lang.Math;
public class RandomGames {
    //main method required for every Java program
    public static void main(String[] args) {
        //declare and intialize a Scanner to take input from keyboard
        Scanner myScanner= new Scanner(System.in);
        //next 7 lines declare variables that will be used to score specific random outcomes for the games
        int spinResult;
        int rollOne;
        int rollTwo;
        int crapsTotal;
        int suitNumber;
        int cardNumber;
        String suit="";
        //prompt user to enter one letter to pick game they want
        System.out.print("Enter R or r for Roulette," + 
        "C or c for craps, P or p for pick a card- ");
        //stores what user entered as a string
        String userInput=myScanner.next();
        //checks if user typed in R or r
        if(userInput.equalsIgnoreCase("R")) {
                //generates random number from 0 to 37
                spinResult=(int)(Math.random()*38); 
                //switch statement with random number as input
                switch(spinResult) {
                    //if random number is 0, print 00
                    case 0:
                        System.out.println("Roulette:00");
                        break;
                    //all other cases print the randomly generated number minus 1    
                    default:
                        System.out.println("Roulette: "+(spinResult-1));
                }
        }
        //Checks if user inputs C or c
        else if(userInput.equalsIgnoreCase("C")) {
            //next two lines each generate a random number from 1 to 6 and store it 
            rollOne=(int)(Math.random()*6)+1;
            rollTwo=(int)(Math.random()*6)+1;
            //sums the result of the two random numbers
            crapsTotal=rollOne+rollTwo;
            //print out the result of each number and the sum of the two
            System.out.println(rollOne+"+"+rollTwo+"="+crapsTotal);
        }
        //checks if user entered P or p
        else if(userInput.equalsIgnoreCase("P")) {
            //generates random number from 0 to 3 to represent suit
            suitNumber=(int)(Math.random()*4);
            //generates random number from 1 to 13 to represent card number
            cardNumber=(int)(Math.random()*13)+1;
            switch(suitNumber) {
                //0 represents clubs so string suit is set to clubs
                case 0:
                    suit+="clubs";
                    break;
                //1 represents spades, so string is changed to spades
                case 1:
                    suit+="spades";
                    break;
                //2 is diamonds, so string becomes diamonds
                case 2:
                    suit+="diamonds";
                    break;
                //3 is hearts, so string becomes hearts
                case 3:
                    suit+="hearts";
                    break;
            }
            switch(cardNumber) {
                //this case represents ace.  Prints out card and suit
                case 1:
                    System.out.println("Ace of "+suit);
                    break;
                //Prints out if number is 11(Jack)
                case 11:
                    System.out.println("Jack of "+suit);
                    break;
                //prints if number is 12(Queen)
                case 12:
                    System.out.println("Queen of "+suit);
                    break;
                //prints if number is 13(King)
                case 13:
                    System.out.println("King of "+suit);
                    break;
                //all other cards just print out their number and suit
                default:
                    System.out.println(cardNumber+" of "+suit);
            }
        }
        //if user inputs more than one letter. tell them one character is expected
        else if(!(userInput.length()==1)) {
            System.out.println("a single character expected");
        }
        //if user did not enter one of requested characters, tell them that they didn't
        else {
                System.out.println(userInput+" is not one of 'R', 'r', 'C', 'c', 'P', or 'p'");
                return;
        }
        
    }
}