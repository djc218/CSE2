/*
Daniel Colville
CSE 2 11/16/2014
The purpose of this program is to take an array of ten numbers from user input and 
print out to the user whether the array has any duplicates in the array and wether is has 
exactly 1 duplicate in the array.
*/
//import scanner so we can use it in program
import java.util.Scanner;
public class FindDuplicates{
  //main method for all Java programs
  public static void main(String [] arg){
    //declare and initialize a scanner to get user input
    Scanner scan=new Scanner(System.in);
    //create an array to hold 10 ints
    int num[]=new int[10];
    //create an empty string which will be used to see if user wants to run again
    String answer="";
    //do while loop that runs until user doesn't enter y or Y when prompted
    do{
      //prompt user to enter 10 ints
      System.out.print("Enter 10 ints- ");
      //stores each of 10 values entered by user in different index of array
      for(int j=0;j<10;j++){
        num[j]=scan.nextInt();
      }
      //start constructing the statement that will tell user if array has duplicates
      String out="The array ";
      out+=listArray(num); //return a string of the form "{2, 3, -9}" with listArray method  
      //if array has duplicates, then add "has" to string
      if(hasDups(num)){
        out+="has ";
      }
      //if array does not have duplicates add "does not have" to string
      else{
        out+="does not have ";
      }
      //add "duplicates" to string
      out+="duplicates.";
      //print out the full string
      System.out.println(out);
      //reset the string
      out="The array ";
      //add the list of numbers to string again
      out+=listArray(num);    
      //if the array has exactly 1 duplicate, add "has" to string
      if(exactlyOneDup(num)){
        out+="has ";
      }
      //if array has something other than exactly 1 duplicate, add "does not have" to string
      else{
        out+="does not have ";
      }
      //adds "exactly one duplicate" to string
      out+="exactly one duplicate.";
      //prints out full string
      System.out.println(out);
      //ask user if they want to go again
      System.out.print("Go again? Enter 'y' or 'Y', anything else to quit- ");
      //store user response in string
      answer=scan.next();
      //if user entered y or Y, run again
    }while(answer.equals("Y") || answer.equals("y"));
  }
  //listArray method that returns string
  public static String listArray(int num[]){
    //prints out an open brace to format numbers in array
    String out="{";
    //loop that runs through all the values in array
    for(int j=0;j<num.length;j++){
      //if this is not first time through, add a comma to string 
      if(j>0){
        out+=", ";
      }
      //add each number in array to string 
      out+=num[j];
    }
    //add close brace to end of string
    out+="} ";
    //return the fully constructed string
    return out;
  }
  //hasDups method that returns true if there is a duplicate in array
  public static boolean hasDups(int[] inputArray) {
      //runs through once for each index in array
      for(int i=0;i<inputArray.length;i++) {
          //runs through all indices of array lesser than current index
          for(int k=0;k<i;k++) {
            //return true if value at two separate indices are the same
            if(inputArray[i]==inputArray[k]) {
                return true;
            }    
          }
      }
      //returns false if no duplicated values were found
      return false;
  }
  //method for checking if there is exactly one duplicate in array
  public static boolean exactlyOneDup(int[] inputArray) {
      //counts number of number of matches-starts at 0
      int matchCounter=0;
      //runs through all numbers in array
      for(int l=0;l<inputArray.length;l++) {
          //runs through all indices of array greater than current
          for(int m=l+1;m<inputArray.length;m++) {
            //if two array indices have same value, add 1 to match counter
            if(inputArray[l]==inputArray[m]) {
                matchCounter++;
            }    
          }
      } 
      //if number of matches is 1, return true
      if(matchCounter==1){
        return true;
      }
      //if number of matches is not 1, return false
      else {
          return false;
      }
  }
}