/*
Daniel Colville
CSE 2 9/28/2014
This program is designed to use a scanner to take a choice for burger, soda or fries
at Burger King.  Then based on the choice, it should prompt user with what toppings 
they want, what type of soda, or whether they want large or small fries.  If 
user enters more than one character or does not enter proper character for input,
tells the user that they did so.
*/
//import Scanner to be used in program
import java.util.Scanner;
public class BurgerKing {
    //main method for all Java programs
    public static void main(String[] args) {
        //declare and intialize a Scanner
        Scanner myScanner=new Scanner(System.in);
        //prompt user to enter their choice for food
        System.out.print("Enter a letter to indicate a choice of \n Burger (B or b)"+
        "\n Soda (S or s) \n Fries (F or f)  ") ;
        String foodChoice=myScanner.next(); //store user choice in a string
        //if user enters more than one character, tells them
        if(foodChoice.length()>1) {
            System.out.println("a single character expected");
        }
        //case if user orders burger
        else if(foodChoice.equals("B")||foodChoice.equals("b")) {
            //prompt user to enter topping option
            System.out.print("Enter A or a for \"all the fixins\" \n C or c for cheese"+
            "\n N or n for none of the above- ");
            //stores topping user wants as string
            String burgerToppings=myScanner.next();
            //checks if user ordered all the fixins 
            if(burgerToppings.equals("A")||burgerToppings.equals("a")) {
                //prints what user ordered
                System.out.println("You ordered a burger with all the fixins");
            }
            //checks if user ordered with cheese
            else if(burgerToppings.equals("C")||burgerToppings.equals("c")) {
                //prints user order
                System.out.println("You ordered a burger with cheese");
            }
            //runs if user didn't want the other toppings
            else if(burgerToppings.equals("N")||burgerToppings.equals("n")) {
                //prints user order
                System.out.println("You ordered a burger");
            }
            //tells user that they did not enter valid option
            else {
                System.out.println("You did not enter A,a,C,c,N,or n");
            }
        }
        //case if user ordered a soda
        else if(foodChoice.equals("S")||foodChoice.equals("s")) {
            //prompts user to enter a choice of soda
            System.out.print("Do you want Pepsi(p or P), Coke(c or C), Sprite (s or S)"+
            "or Mountain Dew (M or m) ");
            //takes user soda choice and stores in string
            String sodaChoice=myScanner.next();
            //case if user ordered Pepsi
            if(sodaChoice.equals("P")||sodaChoice.equals("p")) {
                //prints user order
                System.out.println("You ordered a Pepsi");
            }
            //case if user ordered Coke
            else if(sodaChoice.equals("C")||sodaChoice.equals("c")) {
                //prints user order
                System.out.println("You ordered a Coke");
            }
            //case if user ordered Sprite
            else if(sodaChoice.equals("S")||sodaChoice.equals("s")) {
                //prints user order
                System.out.println("You ordered a Sprite");
            }
            //case if user ordered Mountain Dew
            else if(sodaChoice.equals("M")||sodaChoice.equals("m")) {
                //prints user order
                System.out.println("You ordered a Mountain Dew");
            }
            //if user did not enter a proper character for soda choice
            else {
                //tells user they didn't enter valid option
                System.out.println("You did not enter p,P,c,C,s,S,m,or M");
            }
        }
        //Case if user ordered Fries
        else if(foodChoice.equals("F")||foodChoice.equals("f")) {
            //prompts user to ask if they want large or small fries
            System.out.print("Do you want a large or small order of fries(l,L,s, or S)- ");
            String frySize=myScanner.next(); //stores user input in String
            //if user ordered large, prints that they ordered large fries
            if(frySize.equals("l")||frySize.equals("L")) {
                System.out.println("You ordered large fries");
            }
            //if user ordered small fries, prints that they ordered small fries
            else if(frySize.equals("S")||frySize.equals("s")) {
                System.out.println("You ordered small fries");
            }     
            //tells user if they did not order character for small or large
            else {
                System.out.println("You did not enter L,l,S, or s");
            }
        }
        //tells user if they did not enter a correct character for food choice
        else {
            System.out.println("You did not enter any of B,b,S,s,F, or f");
        }
    }
}