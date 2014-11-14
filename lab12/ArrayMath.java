/*
Daniel Colville
CSE 2 11/14/2014
The purpose of this program is to write two methods for arrays- one to check if 
two arrays are equal and another to add the values of two arrays.  If one array
is longer than the other for the add method, it is assumed that the shorter array has 0
to add to longer array
*/
public class ArrayMath {
  //main method for all Java programs
  public static void main(String[] arg) {
      //declare several arrays and fill them with values
      double x[] = {2.3, 3, 4, -2.1, 82, 23},
        y[] = { 2.3, 3, 4, -2.1, 82, 23 },
        z[] = {2.3, 13, 14},
        w[] = {2.3, 13, 14, 12 },
        v[],
        u[] = { 2.3, 12, 14};
      //call the addArrays method for two of the arrays
      v = addArrays(x, y);
      //display the arrays being added and the result
      System.out.println(display(x) + " \n  + " + display(y) + "\n   = " + display(v));
      //display a separate array addition
      System.out.println(display(x) + " \n  + " + display(z) + "\n   = " + display(addArrays(x, z)));
      //these three statements print out the result of the equals method we write later for two different arrays on each line
      System.out.println("It is " + equals(x, y) + " that " + display(x) +
        " == " + display(y));
      System.out.println("It is " + equals(z, w) + " that " + display(z) +
        " == " + display(w));
      System.out.println("It is " + equals(u, z) + " that " + display(u) +
        " == " + display(z));
    }
    //method display to print out an array
  public static String display(double[] x) {
      //start a string that array will be added to
      String out = "{";
      //runs through all the elements in array
      for (int j = 0; j < x.length; j++) {
        //after the first value, and each subsequent value print a comma
        if (j > 0) {
          out += ", ";
        }
        //add the value at current index of array to the string
        out += x[j];
      }
      //return the array inside a pair of braces
      return out + "}";
    }
    // method to check if two arrays are equal
  public static boolean equals(double[] array1, double[] array2) {
    //if the arrays have different lengths, return false
    if (array2.length != array1.length) {
      return false;
    }
    //loop that compares all the elements in both arrays
    for (int i = 0; i < array1.length; i++) {
      //if the values for the two arrays at current index don't match, return false
      if (array1[i] != array2[i]) {
        return false;
      }
    }
    //return true if arrays haven't been found to be different
    return true;
  }
  //method to add two arrays
  public static double[] addArrays(double[] array1, double[] array2) {
    //declare array to hold sum
    double[] sumArray;
    //declare a variable to hold length of shorter array, whether it is 1 or 2
    int smallerArrayLength;
    //if array 2 is longer
    if (array2.length >= array1.length) {
      //make the length of sum array equal to length of array2
      sumArray = new double[array2.length];
      //store length of array1
      smallerArrayLength = array1.length;
    }
    //if array1 is longer
    else {
      //make length of sum array equal to length of array1
      sumArray = new double[array1.length];
      //store length of array2
      smallerArrayLength = array2.length;
    }
    //for each index that both arrays have a value, set sumArray equal to sum of values from two arrays
    for (int k = 0; k < smallerArrayLength; k++) {
      sumArray[k] = array1[k] + array2[k];
    }
    //runs for each index where only one array has a value
    for (int l = smallerArrayLength; l < sumArray.length; l++) {
      //if array2 is longer set sum value equal to array2 value(array1 assumed 0)
      if (array2.length > array1.length) {
        sumArray[l] = array2[l];
      }
      //otherwise, array1 is longer and set sum value equal to array1 value(array2 assumed 0)
      else {
        sumArray[l] = array1[l];
      }
    }
    //return the sum of the two arrays
    return sumArray;
  }
}