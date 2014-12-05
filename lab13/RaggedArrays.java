/*
Daniel Colville
CSE 2 12/4/2014
This program creates a two dimensional ragged array with 5 rows of ints.
The length of each row should be 5+(3*j) where j goes from 0 to 4.
Then the array should be displayed using print statements.  Then the array is sorted and
displayed again
*/
//import random class to be used in program
import java.util.Random;
public class RaggedArrays {
    //main method for all java programs
    public static void main(String[] args) {
        //create a two dimensional array of ints
        int[][] raggedArray=new int[5][];
        //set the length of member arrays
        for(int i=0;i<raggedArray.length;i++) {
            raggedArray[i]=new int[i*3+5];
        }
        //create new random object
        Random randomGenerator= new Random();
        //runs through outer array
        for(int j=0;j<raggedArray.length;j++) {
            //runs through inner values of array
            for(int k=0;k<raggedArray[j].length;k++) {
                //sets array values to random number from 0 to 39
                raggedArray[j][k]=randomGenerator.nextInt(40);
            }
        }
        System.out.println("The array before sorting");
        //runs through array of arrays
        for(int h=0;h<raggedArray.length;h++) {
            //runs through inner array
            for(int i=0;i<raggedArray[h].length;i++) {
                //prints out each value in 2D array and spaces between them
                System.out.print(raggedArray[h][i]+" ");
            }
            //prints out a new line
            System.out.println();
        }
        System.out.println("\nThe array after sorting");
        //runs through outer array
        for(int l=0;l<raggedArray.length;l++) {
            //runs through inner array
            for(int m=0;m<raggedArray[l].length;m++) {
                //current min is set to first value and index is set to 0
                int currentMin=raggedArray[l][m];
                int indexOfCurrentMin=0;
                //boolean to determine if a swap is needed
                boolean swapNeeded=false;
                //runs through values to right of values in loop controlled by m
                for(int n=m+1;n<raggedArray[l].length;n++){
                    //checks if next value is smaller than current min
                    if(raggedArray[l][n]<currentMin) {
                        //sets current min to lower value and index to index where that value was found
                        currentMin=raggedArray[l][n];
                        indexOfCurrentMin=n;
                        //set swap needed to true
                        swapNeeded=true;
                    }
                    
                }
                //if swapNeeded is true, swap lowest value with value we are in loop
                if(swapNeeded) {
                    int temp=raggedArray[l][m];
                    raggedArray[l][indexOfCurrentMin]=temp;
                    raggedArray[l][m]=currentMin;
                }
            }
        }
        //runs through array of arrays
        for(int h=0;h<raggedArray.length;h++) {
            //runs through inner array
            for(int i=0;i<raggedArray[h].length;i++) {
                //print out values of array and spaces between them
                System.out.print(raggedArray[h][i]+" ");
            }
            //print a new line
            System.out.println();
        }
    }
}