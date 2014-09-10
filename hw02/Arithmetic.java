/*
Daniel Colville
9/10/2014
CSE 2
This program should calculate the cost of a shopping trip at Walmart
based on the cost of each item we buy, the number of each item
we buy, and the PA sales tax rate.  The result should be cut off 
at 2 numbers after the decimal point
*/
public class Arithmetic {
    public static void main(String[] args) {
       // input numbers for calculations
       int nSocks=3;
       double sockCost$=2.58;
       //above are number of sock pairs bought and the cost per pair
       //cost of drinking glasses and number bought
       int nGlasses=6;
       double glassCost$=2.29;
       //envelopes bought and cost per envelopes
       int nEnvelopes=1;
       double envelopeCost$=3.25;
       double taxRate=0.06;
       //prints out all the input data on individual lines
       System.out.println("item bought:socks");
       System.out.println("socks bought " + nSocks);
       System.out.println("cost per sock $" + sockCost$);
       System.out.println("item bought:drinking glasses");
       System.out.println("glasses bought " + nGlasses);
       System.out.println("cost per glass $" + glassCost$);
       System.out.println("item bought:envelopes ");
       System.out.println("envelopes bought " + nEnvelopes);
       System.out.println("cost per envelope $" + envelopeCost$);
       //calculates tax for each type of item based on tax rate and number bought
       double sockTax=sockCost$*taxRate*nSocks;
       double glassTax= glassCost$*taxRate*nGlasses;
       double envelopeTax=envelopeCost$*taxRate*nEnvelopes;
       //calculates cost of each item type before tax
       double totSockCostNoTax$= nSocks*sockCost$;
       double totGlassCostNoTax$= nGlasses*glassCost$;
       double totEnvelopeCostNoTax$= nEnvelopes*envelopeCost$;
       //prints previously calculated data
       System.out.println("cost of socks before tax $" +totSockCostNoTax$);
       System.out.println("total tax on socks $" +(int)(sockTax*100)/100.0);
       System.out.println("cost of glasses before tax $" +totGlassCostNoTax$);
       System.out.println("total tax on glasses $" +(int)(glassTax*100)/100.0);
       System.out.println("cost of envelopes before tax $" +totEnvelopeCostNoTax$);
       System.out.println("total tax on envelopes $" +(int)(envelopeTax*100)/100.0);
       //calculate cost of all items before tax, then the tax on all the items
       double tripCostNoTax=totSockCostNoTax$+totGlassCostNoTax$+totEnvelopeCostNoTax$;
       double totalTax=sockTax+glassTax+envelopeTax;
       System.out.println("cost of purchases before tax $" +tripCostNoTax );
       System.out.println("total sales tax on purchases $" +(int)(totalTax*100)/100.0);
       double totalTripCost=tripCostNoTax+totalTax;
       System.out.println("total cost of purchases $" +(int)(totalTripCost*100)/100.0);
       
       
        
    }
}
