/*
Daniel Colville
CSE 2 11/18/2014
This program is to create two methods that help simulate poker.  One that generates entirely random 
5 card poker hands until the user wants it to stop and another that simulates the odds of getting 
pairs in 10000 random hands then prints the number of paris for each rank and the number of hands 
that don't have exactly one pair
*/
//import the random and scanner classes to be used in program
import java.util.Random;
import java.util.Scanner;
public class PokerOdds{
  //main method for all Java programs
  public static void main(String [] arg){
    //calls showHands method which will generate poker hands
    showHands();
    //calls method to simulate odds of pairs in 10000 poker hands
    simulateOdds();
  }
  //showHands method returns void
  public static void showHands() {
      //create a new scanner so we can take user input
      Scanner myScanner=new Scanner(System.in);
      //create a random object to generate random numbers
      Random generateRandom= new Random();
      //a blank string to store user response
      String answer="";
      //loop that continues to run until user enters something other than y or Y-always runs at least once
      do{
        //creates array of 52 to store cards in deck
        int [] cardsInDeck=new int[52]; 
        //fill the array with values from 0 to 51
        for(int i=0;i<cardsInDeck.length;i++) {
            cardsInDeck[i]=i;
        }
        //create an array to store 5 cards in a hand, by default all -1
        int [] pokerHand= {-1,-1,-1,-1,-1};
        //loop that runs through all values in hand array
        for(int j=0;j<pokerHand.length;j++) {
          //generates random number from 0 to 51 minus the looping variable, ensuring cards can't be picked twice
          int randomCard=generateRandom.nextInt(51-j);
          //put value from random index in the poker hand array
          pokerHand[j]=cardsInDeck[randomCard];
          //next 4 lines set picked value to -1 in deck array, then swap -1 with current
          //last value in array so -1 can't be picked next time
          cardsInDeck[randomCard]=-1;
          int temp=cardsInDeck[51-j];
          cardsInDeck[51-j]=cardsInDeck[randomCard];
          cardsInDeck[randomCard]=temp;
        }
        //array of rank names to be accesed from a loop
        String[] nameLabel={"A","K","Q","J","10","9","8","7","6","5","4","3","2"};
        //loops through all 4 suits
        for(int k=0;k<4;k++) {
            //string to store all the ranks picked for a given suit
            String printOut="";
            //goes through all the different cards in hand
            for(int l=0;l<pokerHand.length;l++){
              //if suit is the same as current, add the name corresponding name label for current value
              if(pokerHand[l]/13==k) {
                printOut+=nameLabel[pokerHand[l]%13]+" ";
              }
            }
            //list of the suits
            String suitString[]={"Clubs","Diamonds","Hearts","Spades"};
            //print out current suit and then all ranks picked within that suit(if any)
            System.out.print(suitString[k]+" "+printOut+"\n");
        }
        //ask user if they want to go again
        System.out.print("\nGo again? Enter 'y' or 'Y', anything else to quit-");
        //store user input in string
        answer=myScanner.next();
        //compares user string to 'y' and 'Y'.  If neither, loop ends
      }while(answer.equals("Y")||answer.equals("y"));
  }
  //simulate odds method
  public static void simulateOdds() {
    //create a random object to generate random numbers
    Random generateRandom= new Random();
    //create an array of 13 values to store number of pairs for each rank
    int[] pairCounter=new int[13];
    //count number of times without exactly one pair
    int noPairCounter=0;
    //runs hand creation 10000 times
    for(int k=0;k<10000;k++) {
      //creates array of 52 to store cards in deck
      int [] cardsInDeck=new int[52]; 
      //fill the array with values from 0 to 51
      for(int i=0;i<cardsInDeck.length;i++) {
        cardsInDeck[i]=i;
      }
      //create an array to hold rank of cards in hand
      int [] pokerHand= {-1,-1,-1,-1,-1};
      //goes through all the values in poker hand
      for(int j=0;j<pokerHand.length;j++) {
        //generate a random card from deck
        int randomCard=generateRandom.nextInt(51-j);
        //store the rank of that card in hand but not the suit
        pokerHand[j]=cardsInDeck[randomCard]%13;
        //these lines set already picked value to -1 and swap with last value in array
        cardsInDeck[randomCard]=-1;
        int temp=cardsInDeck[51-j];
        cardsInDeck[51-j]=cardsInDeck[randomCard];
        cardsInDeck[randomCard]=temp;
      }
      //runs if method checking for exactly one match (from other program) returns true
      if(FindDuplicates.exactlyOneDup(pokerHand)) {
        //runs through all the values in the hand
        for(int h=0;h<pokerHand.length;h++) {
          //checks the values with higher index than the one outer loop is currently on
          for (int g=h+1;g<pokerHand.length;g++) { 
            //if two values are the same, add 1 to pair counting array at appropriate index
            if(pokerHand[h]==pokerHand[g]) {
              pairCounter[pokerHand[h]]++;
            }
          }
        }
      }
      //if there was not exactly 1 pair, add to variable couting that number of times
      else {
        noPairCounter++;
      }
    }
    //print out titles for the ranks and numbers to be displayed below this
    System.out.println("Rank  freq of exactly one pair");
    //array of labels for the different ranks
    String[] nameLabel={"A","K","Q","J","10","9","8","7","6","5","4","3","2"};
    //runs through the values of pair counting loop
    for(int n=0;n<pairCounter.length;n++) {
      //prints out rank
      System.out.print(nameLabel[n]);
      //these lines ensure that the number of matches for card rank 10 lines up with others
      if(n!=4) {
        System.out.print("     ");
      }
      else {
        System.out.print("    ");
      }
      //print out number of pairs for given rank
      System.out.println(pairCounter[n]);
    }
    //print out number of hands that didn't have exactly 1 pair
    System.out.println("The number with no pairs is "+noPairCounter);
  }
}