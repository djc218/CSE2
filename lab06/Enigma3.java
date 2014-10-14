/* Insert System.out.println() statements in the code
 * below, displaying the status of n and k, which 
 * should help you identify when n  or k becomes 0 and causes
 * the program to crash
 */

import java.util.Scanner;
public class Enigma3{
  public static void main(String [] arg){
    int n=40,k=60;
    String out="";
    switch(k%14){
      case 12: 
      case 13: out+=13;
         break;
      default: out+=40;
          n/=3;
          k-=7;
          //print test
    }
    if(n*k%12< 12){
      n-=20;
      out+=n;
     // print test
    }
    if(n*n>k){
      n=42;
      out+=n+k;
      //print test
    }
    else {
      n=45;
      out+=n+k;
     // print test
    }
    switch(n+k){
      case 114: 
        n-=11;
        k-=3;
        break;
      case 97:
        n-=14;
        k-=2;
        break;
      case 98:
        n/=5;
        k/=9;
        //print test
      default:
        n-=3;
        k-=4;
        //print test
     out+=1/n + 1/k;   
    System.out.println(out);
  }
}
/*
 * Error report:
 * k became 0 in line 51 causing an error in line 53 because of dividing by 0
 * all the places commented "print test" are places where I tried to insert print
 * statements to find out where the problem was. I fixed the runtime error by subtracting
 * 4 instead of 5 from k in line 51. 
 */

