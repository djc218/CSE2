/*
Daniel Colville
CSE 2 12/5/2014
This program is designed to generate a ragged 3d array of random numbers from 1 to 99.  
Then it will display the 3d array by splitting it into slabs.  Then it sorts the individual 
rows on the 3rd 2D array. Then it sorts the arrays in order by which has
the smallest first value in the first column of each row.
*/
//import random class to use later in program
import java.util.Random;
public class MatrixSorter{
    //main method for all java programs
    public static void main(String arg[]){
        //declare a 3d array
        int mat3d[][][];
        //call buildMat3d method
        mat3d=buildMat3d();
        //boolean tracking whether array has been sorted
        boolean sorted=false;
        //shows array
        show(mat3d,sorted);
        //prints out min using findMin method
        System.out.println("The smallest entry in the 3D matrix is "+findMin(mat3d));
        //tells user that this is sorted array
        System.out.println("After sorting the 3rd matrix we get");
        //sort 3rd slab of 3d array
        sort(mat3d[2]);
        //set sorted to true
        sorted=true;
        //show array with 3rd slab sorted
        show(mat3d,sorted);
  }
    public static int[][][] buildMat3d() {
        //create a random object
        Random randomGenerator= new Random();
        //declare a 3d array of ints
        int mat3d [][][];
        //create an int large enough to hold all the values
        mat3d=new int[3][7][9];
        //outer loop to control which slab numbers are entered into
        for(int s=0;s<3;s++)  {
            //loop making sure that makes sure all rows are gone through
            for(int j=0;j<3+2*s;j++) {
                //go through all the indices in each row
                for(int k=0;k<s+1+j;k++) {
                    //generate a random number between 1 and 99
                    int randomNumber=1+randomGenerator.nextInt(98);
                    //sets current index of array to random number
                    mat3d[s][j][k]=randomNumber;
                }
            }
        }
        //return 3d array
        return mat3d;
    }
    //show method
    public static void show (int[][][]InputArray, boolean sorted) {
        //runs through all the slabs
        for(int s=0;s<3;s++)  {  
            //prints out dashes and then "Slab" with number of slab
            System.out.print("-------------------Slab "+(s+1));
            //if array has already been sorted, print out sorted
            if(sorted) {
                System.out.println(" Sorted");
            }
            //otherwise, start a new line
            else {
                System.out.println("");
            }
            //controls the process of runnning through rows
            for(int j=0;j<7;j++) {
                //boolean that will check if current row has any nonzero numbers
                boolean hasNumbers=false;
                //makes sure every column of row is printed
                for(int k=0;k<9;k++) {
                    //if number is nonzero, print it and set hasNumbers to true 
                    if(InputArray[s][j][k]!=0) {
                        System.out.print(InputArray[s][j][k]+" ");
                        hasNumbers=true;
                    }
                }
                //prints out a new line if row had numbers
                if(hasNumbers) {
                    System.out.println("");
                }
            }
            //prints out dashes after last slab
            if(s==2) {
                System.out.println("-------------------");
            }
        }
    }
    //findMin method to return smallest int in array
    public static int findMin(int[][][]inputArray) {
        //sets current min to first element of array
        int currentMin=inputArray[0][0][0];
        //runs through slabs
        for(int s=0;s<3;s++)  {
            //runs through all rows
            for(int j=0;j<3+2*s;j++) {
                //runs through all numbers on each row
                for(int k=0;k<s+1+j;k++) {
                    //if value at current index is smaller than current min, it replaces current min
                    if(inputArray[s][j][k]<currentMin) {
                        currentMin=inputArray[s][j][k];
                    }
                }
            }
        }
        return currentMin;
    }
    //sort with input and output of 2d array
    public static int[][] sort(int[][]inputArray) {
        //calls 1d sort method for each row
        for(int i=0;i<inputArray.length;i++) {
        inputArray[i]=sort(inputArray[i]);
        }
        //runs through the all the rows
        for(int m=0;m<inputArray.length-1;m++) {
            //if value to right of current value is smaller than current
            if(inputArray[m][0]>inputArray[m+1][0]) {
                //make a new array to store values of smaller array
                int lowArray[]=new int[inputArray[m+1].length];
                //puts value from smaller array into lowArray
                for(int j=0;j<lowArray.length;j++) {
                    lowArray[j]=inputArray[m+1][j];
                }
                //replaces values in smaller array with those from larger
                for(int k=0;k<inputArray[m+1].length;k++) {
                    inputArray[m+1][k]=inputArray[m][k];
                }
                //replaces values in larger with those of lower(stored in lowArray)
                for(int l=0;l<inputArray[m].length;l++) {
                    inputArray[m][l]=lowArray[l];
                }
                //if the value we swapped from right is not in 0 position, reduce loop variable so it is compared against new value to its left
                if(m>=1) {
                    m-=2;
                }
            }
        }
        //return sorted 2d array
        return inputArray;
    }
    //1d version of sorting method
    public static int[] sort(int[]innerArray) {
        //runs through all the values in row
        for(int h=0;h<innerArray.length;h++) {
            //set lowest to first value in array and index of lowest to 0
            int lowest=innerArray[h];
            int indexOfLowest=0;
            //boolean checking whether swap is needed
            boolean swapNeeded=false;
            //runs through values to right of current value of outer loop
            for(int l=h+1;l<innerArray.length;l++) {
                //if next value is lower than current low and greater than 0
                if(innerArray[l]<lowest&&innerArray[l]>0) {
                    //set this value to new lowest
                    lowest=innerArray[l];
                    //store l as new index of lowest value
                    indexOfLowest=l;
                    //set swapNeeded to true
                    swapNeeded=true;
                }
            }
            //swaps the values if swapNeeded is true
            if(swapNeeded) {
                int temp=innerArray[h];
                innerArray[h]=lowest;
                innerArray[indexOfLowest]=temp;
            }
        }
        //return sorted 1d array
        return innerArray;
    }
}
