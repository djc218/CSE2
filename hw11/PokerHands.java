/*
Daniel Colville
CSE 2 12/4/2014
This program is designed to construct a 5 card poker hand based on having the user input the
cards.  It does not allow for repeated cards or take invalid card suits or ranks.  
Then it will print the hand and tell the user where the hand ranks(Flush,Straight,Four of a kind, etc.)
*/
//import scanner to be used in program
import java.util.Scanner; 
public class PokerHands {
    //main method for all java programs
    public static void main(String [] args) {
        //String hold user answer from scanner
        String responseString="";
        //create a scanner object
        Scanner myScanner= new Scanner(System.in);
        //create array to hold card value as int from 0 to 51
        int[] handArray=new int[5];
        //create array to hold rank of card as int(0 to 12)
        int [] rankArray=new int[5];
        //array to hold suit of card as string
        String suitArray[]=new String[5];
        //array holding all possible ranks as strings(Ace through 2)
        String face[]={"A","K","Q","J","10","9","8","7","6","5","4","3","2"};
        //array of the possible suits
        String suit[]={"Clubs: ", "Diamonds: ", "Hearts: ", "Spades: "};
        //outer loop that controls whether user enters another hand
        do {
            //(re)sets rank array values to -1
            for(int b=0;b<5;b++) {
                rankArray[b]=-1;
            }
            //array that holds the frequency of each rank occuring in hand
            int[] rankFrequency=new int[13];
            //holds frequency of same rank(0 through 4)
            int[] frequencyCounter=new int[5];
            //asks user if they want to enter another hand
            System.out.print("Enter 'y' or 'Y' to enter a(nother) hand- ");
            //takes user response and stores in string
            responseString=myScanner.next();
            //if user enters y or Y, exit loop.
            if(!(responseString.equals("y")||responseString.equals("Y"))) {
                break;
            }
            //loop controlling the filling of array with cards stored as ints
            for(int i=0;i<handArray.length;i++) {
                //string to hold card picked
                String cardPick="";
                //string to hold rank picked
                String rankPick="";
                //boolean for whether user has picked valid suit yet
                boolean pickedSuit=false;
                //loop that runs until user enters valid suit
                do {
                    //prompts user to enter suit
                    System.out.print("Enter the suit: 'c', 'd', 'h', or 's'- ");
                    //store suit value
                    cardPick=myScanner.next();
                    switch(cardPick) {
                        //if user entered c, store clubs in suit array and set pickedSuit to true
                        case"c":suitArray[i]=suit[0];
                                pickedSuit=true;
                                break;
                         //if user entered d, store diamonds in suit array and set pickedSuit to true
                        case"d":suitArray[i]=suit[1];
                                pickedSuit=true;
                                break;
                        //if user entered h, store hearts in suit array and set pickedSuit to true
                        case"h":suitArray[i]=suit[2];
                                pickedSuit=true;
                                break;
                        //if user entered s, store spades in suit array and set pickedSuit to true
                        case"s":suitArray[i]=suit[3];
                                pickedSuit=true;
                                break;
                        //if user did not enter a proper response tell them so
                        default:System.out.println("You did not enter a valid response");
                                break;
                    }
                    //if pickedSuit is true, exit loop;otherwise, loop continues
                    if(pickedSuit) {
                        break;
                    }
                }  while(true);
                //asks user to enter a rank
                System.out.print("Enter one of 'a', 'k', 'q', 'j', '10', ...'2'- ");
                //stores rank as string
                rankPick=myScanner.next();
                //checks if user entered one of asked for ranks
                boolean validRank=false;
                //loop that checks if user entered a proper rank.  If user did, set validRank to true
                for(int g=0;g<face.length;g++) {
                    if(rankPick.equalsIgnoreCase(face[g])) {
                        validRank=true;
                    }
                }
                //if validRank is not true, tell user and continue outside loop again
                if(!validRank) {
                    System.out.println("This is not a proper card rank");
                    //decrement i so loop runs proper amount of times
                    i--;
                    continue;
                }
                //boolean to store whether duplicate has been found
                boolean duplicate=false;
                    //runs through all ranks in face
                    for(int k=0;k<13;k++) {
                        //if user input equals rank, set rank equal to k and increment rankFrequency at index of k
                        if(rankPick.equalsIgnoreCase(face[k])) {
                            rankArray[i]=k;
                            rankFrequency[k]++;
                        }
                        
                        //checks current value against all previous in array
                        for(int h=0;h<i;h++) {
                            //checks if current card has same rank and suit as previous card
                            if(rankArray[h]==rankArray[i]&&suitArray[h]==suitArray[i]&&rankFrequency[k]>0) {
                                //set duplicate to true
                                duplicate=true;
                                //resets rank and suit array at index that had just been entered
                                suitArray[i]="";
                                rankArray[i]=0;
                                //decrement rank frequency
                                rankFrequency[k]--;
                            }
                        }
                        //if duplicate is true, tell user and break out of loop
                        if(duplicate) {
                            System.out.println("You already entered that card");
                            break;
                        }
                    }
                    //if duplicate is true, decrement i and continue 2nd outermost loop
                    if(duplicate) {
                        i--;
                        continue;  
                    }
            }
            //runs through all suits of 5 cards chosen
            for(int l=0;l<suitArray.length;l++) {
                //runs through 4 suit options
                for(int j=0;j<suit.length;j++) {
                    //if suit is equal to current possible suit
                    if(suitArray[l].equals(suit[j])) {
                        //set handArray equal to rank at current array index plus 13*j
                        handArray[l]=rankArray[l]+(13*j);
                    }
                }
            }
            //runs through array counting cards of same rank
            for(int n=0;n<frequencyCounter.length;n++) {
                //checks against array storing frequency of each rank
                for(int m=0;m<rankFrequency.length;m++) {
                    //adds to frequency counter at n if frequency of current rank equals n
                    if(rankFrequency[m]==n) {
                        frequencyCounter[n]++;           
                    }
                }
            }
            //runs showOneHand method on array filled with card values
            showOneHand(handArray);
            //boolean checking if type of hand has already been printed
            boolean alreadyPrinted=false;
            //stores whether all cards are same suit
            boolean allSameSuit=handArray[0]/13==handArray[1]/13&&handArray[2]/13==handArray[1]/13&&handArray[2]/13==handArray[3]/13
            &&handArray[3]/13==handArray[4]/13;
            //stores whether cards are in straight
            boolean straight=false;
            //checks rankFrequency to see if there is a straight
            for(int o=0;o<10;o++) {
                straight=rankFrequency[o]==1&&rankFrequency[o+1]==1&&rankFrequency[o+2]==1&&rankFrequency[o+3]==1&&rankFrequency[o+4]==1;
                //if a straight has been found, break out of loop
                if(straight) {
                    break;
                }
            }
            //checks if cards are same suit, straight, and one is ace;if so, tells user this is royal flush
            if(allSameSuit&&straight&&(handArray[0]%13==0||handArray[1]%13==0||handArray[2]%13==0||handArray[3]%13==0||handArray[4]%13==0)) {
                System.out.println("This is a Royal Flush");
            }
            //checks if cards are same suit and straight
            else if(allSameSuit&&straight) {
                //tells user this is straight flush
                System.out.println("This is a Straight Flush");
            }
            //checks if this is four of a kind and tells user if it is
            else if(frequencyCounter[4]==1) {
                System.out.println("This is Four of a Kind");
            }
            //checks for hand full house and tells user if it is
            else if(frequencyCounter[3]==1&&frequencyCounter[2]==1) {
                System.out.println("This is a Full House");
            }
            //checks for flush, and tells user if it is
            else if(allSameSuit) {
                System.out.println("This is a Flush");
            }
            //checks for straight and tells user if it is
            else if(straight) {
                System.out.println("This is a Straight");
            }
            //checks for three of a kind and tells user if it is
            else if(frequencyCounter[3]==1) {
                System.out.println("This is Three of a Kind");
            }
            //checks for two pair and tells user if it is
            else if(frequencyCounter[2]==2) {
                System.out.println("This is Two Pair");
            }
            //checks one pair and tell user if it is
            else if(frequencyCounter[2]==1) {
                System.out.println("This is One Pair");
            }
            //if it is no other hand, tells user it is high card hand
            else {
                System.out.println("This is High Card");
            }
        } while(true);
    }
    //showOneHand method that prints out hand
    public static void showOneHand(int hand[]){
    //array of possible suits
	String suit[]={"Clubs: ", "Diamonds: ", "Hearts: ", "Spades: "};
	//array of possible ranks
	String face[]={
       "A ","K ","Q ","J ","10 ","9 ","8 ","7 ","6 ","5 ",
  	"4 ","3 ","2 "};
  	//creates string that will store string to print
	String out="";
	//runs through all suits
	for(int s=0;s<4;s++){
	    //add a suit to String from array
      	out+=suit[s];
      	//runs through all ranks
      	for(int rank=0;rank<13;rank++) {
      	    //runs through all cards in hand
        	for(int card=0;card<5;card++) {
        	    //if suit of card equals s and rank of card equals rank, add correct string from face array 
         	    if(hand[card]/13==s && hand[card]%13==rank) {
          	        out+=face[rank]; 
         	    }
        	}
        }
        //add a new line to String
      	out+='\n';
	}
	//prints out string once it is constructed
	System.out.println(out);
    }
}