//import Scanner class to use in program
import java.util.Scanner;
public class Methods{
  //main method
  public static void main(String [] arg){
    //declare and initialize a scanner to take user input
	Scanner scan=new Scanner(System.in);
	//declare 3 ints a,b, and c
	int a,b,c;
	//prompt user to enter three ints
	System.out.println("Enter three ints");
	//uses getInt method(written later) to get 3 ints from users
	a=getInt(scan);
	b=getInt(scan);
	c=getInt(scan);
	//prints out the larger of first two numbers user larger method
	System.out.println("The larger of "+a+" and "+b+" is "+larger(a,b));
	//prints out largest of all 3 numbers by using larger method twice
	System.out.println("The larger of "+a+", "+b+", and "+c+
                   	" is "+larger(a,larger(b,c)));
  //prints out whether numbers were entered in ascending order using ascending method
	System.out.println("It is "+ascending(a,b,c)+" that "+a+", "+b+
                   	", and "+c+" are in ascending order");
  }
  //writing getInt method that returns int and takes Scanner as input
  public static int getInt(Scanner scan) {
      //checks if user has entered an int
      int n=0;
      System.out.print("Enter an int- ");
      while(!scan.hasNextInt()) {
          //tells user they didn't enter an int
          System.out.print("you did not enter an int try again- ");
          //get rid of what user entered
          scan.next();
          //method calls on itself again until it gets int and sets value to m
      }
      if(scan.hasNextInt()) {
        //sets n equal to user entered int
          n=scan.nextInt();
         //returns value user entered
          
      }
      //if user didn't enter int
      
      return n;
  }
  //larger method- returns int and takes two ints as input
  public static int larger(int a,int b) {
      //checks if a is greater than or equal to b
      if(a>=b) {
        //returns a because it is larger or equal to b
          return a;
      }
      //if b is larger, return b
      else {
          return b;
      }
  }
  //ascending method that returns boolean based on 3 ints
  public static boolean ascending(int x,int y,int z) {
      //mathematically checks if numbers are in ascending order, if they are returns true
      if(x<y&&y<z) {
          return true;
      }
      //if numbers are not ascending, return false
      else {
          return false;
      }
  }
}
