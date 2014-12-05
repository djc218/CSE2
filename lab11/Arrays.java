/*
Daniel Colville
CSE 2 11/14/2014
This program is supposed to use an array to store user entered ints and accomplish several other tasks
The program uses loops to find the maximum and minimum of the entered values and 
the sum of all the values entered. It also creates an array with the same elements 
in reverse order. Then it prints all the values it found and both arrays side by side
in columns
*/
//import scanner so it can be used in program
import java.util.Scanner;
public class Arrays {
    //main method for all Java programs
    public static void main(String [] args) {
        //create an array with 10 elements
        int[] userInts=new int[10];
        //declare and initialize a scanner
        Scanner myScanner= new Scanner(System.in);
        //prompt user to enter 10 ints
        System.out.print("Enter 10 ints-- ");
        //loop that runs through 10 times to get 10 ints
        for(int i=0;i<userInts.length;i++) {
            //stores user input in index i of array
            userInts[i]=myScanner.nextInt();
        }
        //sets current max to element in first index of array
        int currentMax= userInts[0];
        //loop that compares all the other elements in the array to current max
        for(int j=1;j<userInts.length;j++) {
          if(userInts[j]>currentMax) {
              //if value at current index of array is greater than current, replace max with that value
             currentMax=userInts[j];
          }
        }
        
        //sets current min to value at index of 0
        int currentMin=userInts[0];
        //loop that compares each value to current min
        for(int k=0;k<userInts.length;k++) {
            //if current value is less than current min, replace current min with current value
            if(userInts[k]<currentMin) {
                currentMin=userInts[k];
            }
        }
        //prints out lowest entry
        System.out.println("The lowest entry is "+currentMin);
        //prints out highest entry
        System.out.println("The highest entry is "+currentMax);
        //declare and initialize variable to store sum of all values in array
        int arraySum=0;
        //loops through all values in the array
        for(int l=0;l<userInts.length;l++) {
            //adds value at current index to sum
            arraySum+=userInts[l];
        }
        //prints out sum
        System.out.println("The sum is "+arraySum);
        //declare array of length 10 to store reversed array
        int[] reversedArray=new int[10];
        //goes through each element in original array
        for(int m=0;m<userInts.length;m++) {
            //stores values in second array in reversed order
            reversedArray[9-m]=userInts[m];
        }
        //loop to print out the arrays in 2 columns next to each other 
        for(int n=0;n<userInts.length;n++) {
            System.out.println(userInts[n]+" "+reversedArray[n]);
        }
    }
}