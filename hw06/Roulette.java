/*
Daniel Colville
CSE 2 10/14/2014
This program simulates 1000 sets of 100 spins on a Roulette wheel.  For the spins, 
the program counts the number of sets that had no wins, sets that were profitable(3+ wins)
and the total amount of money won from all the spins
*/
//import Math class so we can generate random numbers
import java.lang.Math;
public class Roulette {
    //main method required in every Java program
    public static void main(String[] args) {
        //sentinel variable for 1st loop-represents 1000 simulations
        int simulationNumber=1000;
        //counter variable for 1st loop
        int i=0;
        //counts total earnings from winnings in all rounds
        int totalEarnings=0;
        //counter number of times with 0 wins
        int noWinCounter=0;
        //counts number of profitable rounds
        int profitRoundCounter=0;
        //outer loop which should run 1000 simulations
        while(i<simulationNumber) {
            //counts number of spins in a round
            int spinNumber=100;
            //counter variable for inner loop
            int j=0;
            //random number representing number which player picks for 100 spins
            //the number is same for all 100 spins
            int pick=(int)(Math.random()*38);
            //counts earnings in current round
            int thisRoundEarnings=0;
            //tracks whether there were any wins in a round
            boolean wonOnce=false;
            //inside loop running 100 spins per simulation
            while(j<spinNumber) {
                //random number for each individual spin
                int thisSpin=(int)(Math.random()*38);
                //cheks if player pick is equal to spin number
                if(pick==thisSpin) {
                    //next rows add $36 to current and total earnings and sets boolean
                    //tracking whether there has been a win to true
                    thisRoundEarnings+=36;
                    wonOnce=true;
                    totalEarnings+=36;
                }
                //increment inner loop variable
                j++;
                //if this is last spin, and earnings are over 100, count round as profitable
                if(thisRoundEarnings>100&&j==99) {
                    profitRoundCounter++;
                }
            }//end of inner loop
             //adds to counter of 0 win rounds if there were no wins in 100 spins
            if(!(wonOnce)) {
                noWinCounter=noWinCounter+1;
            }
            //increments outer loop variable
            i++;
        } //end of outer loop
        //prints out number of rounds with no wins
        System.out.println("rounds with no win: "+noWinCounter);
        //prints out number of profitable rounds
        System.out.println("profitable rounds: "+profitRoundCounter);
        //prints out total money from wins
        System.out.println("Total winnings: $"+totalEarnings);
    }
}