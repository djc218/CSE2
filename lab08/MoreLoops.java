import java.util.Scanner;
public class MoreLoops{
    public static void main(String[] arg){
	Scanner scan=new Scanner(System.in);
	int n=0;
    System.out.print("Enter an int- ");
    do {
	if(scan.hasNextInt()) {
	    break;   
	}   
	else {
	System.out.print("you did not enter an int; try again-  ");
	scan.next();
	}
	} while(!scan.hasNextInt());
	/*
	while(!scan.hasNextInt()){
	scan.next(); //get rid of the junk entered by user
	System.out.print("You did not enter an int; try again- ");
	}
	*/
	
	//COMMENT OUT THE ABOVE 5 LINES AND REPLACE THE CODE WITH A 
	//DO-WHILE LOOP
    n=scan.nextInt();
    int j=0;
    while(j<n&&j<40) {
        int i=0;
        while(i<(j+1)) {
            System.out.print('*');
            i++;
        }
        System.out.println();
        j++;
    }
    /*
	for(int j=0;j<n && j<40;j++){
	   for(int k=0;k<j+1;k++){
		System.out.print('*');
	  }
	    System.out.println();
	}
	*/
	//COMMENT OUT THE ABOVE SIX LINES OF CODE AND REPLACE WITH 
	//WHILE STATEMENTS
      
	int k=4;
    while(k<5) {
        System.out.println("k="+k);
        k++;
    }
    /*
	do{
      System.out.println("k="+k);
    k++;
	}
         while(k<4);
    */
        //COMMENT OUT THE ABOVE FIVE LINES AND REPLACE THE CODE
	//WITH A WHILE LOOP

        int count=0;
        for(int h=0;h<11;h++) {
        	if(n>=1&&n<3) {
        		System.out.println("Case 2");
        		h--;
        	}
        	else if(n==3) {
        		break;
        	}
        	else if(n==4) {
        		System.out.println("Case "+ n +"\n"+ "Case "+(n+1));
        	}
        	else if(n==5) {
        		System.out.println("Case "+ n);
        	}
        	else {
        		System.out.println(n+ " is >5 or <1");
        	}
        }
    /*
        while(true){
	    switch(n){
	    default: System.out.println(n + " is > 5 or <1");
		break;
	    case 1: 
	    case 2: System.out.print("Case 2 "); 
		continue;
	    case 3: break;
	    case 4: System.out.println("Case 4");
	    case 5: System.out.println("Case 5");
		break;
	    }
	    count++;
	    if(count>10)
		break;
	}
	*/
	
	//COMMENT OUT THE ABOVE 16 LINES AND REWRITE THE CODE UING
	// ONLY FOR LOOPS AND IF STATEMENS. BEFORE DOING SO, TRY
	//RUNNING THE CODE WITH VARIOUS INPUTTED VALUES, E.G., 
	//   -5, 1, 20, 5, ETC.
	//IF YOU GET AN INFINITE LOOP, YOU CAN STOP IT BY 
	//SIMULTANEOUSLY PRESSING THE CTRL KEY AND THE C KEY
    }
}