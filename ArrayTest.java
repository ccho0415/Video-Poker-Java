//********************************************************************
//  
//  ArrayTest.java       Author: Christine Chong cc4190
//
//  For testing the Array Methods
//********************************************************************

public class ArrayTest{

 
    public static void main(String[] args){
            ValidateString arr = new ValidateString(args);
            if(arr.checkArray(args) == true){
                int[] intargs = new int[args.length];
                for(int i =0; i< args.length; i++){
                    intargs[i] = Integer.parseInt(args[i]);
                }
                ArrayMethods ar = new ArrayMethods(intargs);
                ar.printArray(); 
                System.out.println("A. Swapping First and Last");
                ar.swapFirstAndLast();
                System.out.println("B. Shifting Right");
                ar.shiftRight();
                System.out.println("C: Replacing All Evens");
                ar.replaceEven();
                System.out.println("D: Replace Middle");
                ar.replaceMiddle();                
                System.out.println("E: Removing Middle");
                ar.removeMiddle();
                System.out.println("F: Moving Evens");
                ar.moveEven();
                System.out.println("G: Second Largest");
                System.out.println(ar.secondLargest());
                System.out.println("H: Sorted Increasing Order");
                System.out.println(ar.sortedIncreasing());
                System.out.println("I: Adjacent Duplicate Elements");
                System.out.println(ar.adjacentDups());
                System.out.println("J: Any Duplicates");
                System.out.println(ar.containsDups());
            }else{
                System.out.println("Please put in a valid input. \n "+
                                   "(Integer Numbers seperated by Spaces)");
            }

    }

}
