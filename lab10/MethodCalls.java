/*
Daniel Colville
CSE 2 10/31/2014
This program designs two methods, addDigit and join.  addDigit adds the given digit between 0 and 9
onto the left side of the number given as the other input.  join adds two numbers together in a similar way.
join calls addDigit, except join can take two negative numbers as input and it makes its output positive
*/
public class MethodCalls{
    //main method
    public static void main(String []  arg){
        //declares variables to be called in methods
        int a=784,b=22,c;
        //sets c equal to output of addDigit method with a and 3 as inputs
        c=addDigit(a,3);
        //shows user how method works by stating inputs and output
        System.out.println("Add 3 to "+a+" to get "+c);
        //adds 4, and then 5 onto c using two method calls
        c=addDigit(addDigit(c,4),5);
        //prints out our inputs and output to user
        System.out.println("Add 3, 4, and 5 to "+a+" to get "+c);
        //demonstrates method again
        System.out.println("Add 3 to -98 to get: "+addDigit(-98,3));
        //sets c equal to a call of join method
        c=join(a,b);
        //shows user how method works
        System.out.println("Join "+a+" to "+b+" to get "+c);
        //calls join method twice and shows user output
        System.out.println("Join 87, 42, and 83 to get "+join(87, join(42,83)));
        //calls method on two negative numbers then prints the output
        System.out.println("Join -9 and -90 to get "+join(-9,-90));
    }
    public static int addDigit(int number, int digit) {
        //if number isn't between 0 and 9, return number
        if(digit<0||digit>9) {
            return number;
        }
        //declare variable to count digits of number
        int digits=0;
        //create new variable to store value of number
        int addToDigit=number;
        //loop that counts the number of digits by adding to counting variable and dividing number by 10 until it reaches 0
        while(!(number==0)) {
            digits++;
            number/=10;
        }
        //loop multiplies digit that is to be added by 10 for each digit in number
        for(int i=0;i<digits;i++) {
            digit*=10;
        }
        //if number is negative, make digit negative too
        if(addToDigit<0) {
            digit*=-1;
        }
        //return sum of digit and number
        return (digit+addToDigit);
    }
    public static int join(int inputOne,int inputTwo) {
        
        
        //if inputOne is less than 0, make it positive so it can be used with addDigit method
        if(inputOne<0) {
            inputOne*=-1;
        }
        //for each digit on inputOne, call addDigit method once
        while((inputOne!=0)) {
            //calls addDigit for first digit of inputOne
            inputTwo=addDigit(inputTwo,inputOne%10);
            //cuts off first digit of inputOne
            inputOne/=10;
        }
        //if output is negative, make it positive
        if(output<0) {
            inputTwo*=-1;
        }
        //return output
        return inputTwo;
    }
}  
