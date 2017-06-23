//********************************************************************
//  
//  ArrayMethods.java       Author: Christine Chong cc4190
//
//  For manipuling Arrays.
//********************************************************************

import java.util.Arrays;
import java.util.ArrayList;

public class ArrayMethods {

	// private instance variables
	private int[] values;
	// this is for resetting purposes, otherwise not needed
	private int[] originalValues; 

	// constructor
	public ArrayMethods(int[] initialValues) {
		values = initialValues;
		originalValues = Arrays.copyOf(values, values.length);
	}

	// pretty printing for testing purposes
	public void printArray() {
		for (int i : values) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	// resetting back to original values for testing purposes
	public void resetValues() {
		values = Arrays.copyOf(originalValues, originalValues.length);
	}

    // a. swap the first and last elements
	public void swapFirstAndLast() {
        // Always going to reset values in the beginning!        
        resetValues();
		int max = values.length-1;
        int temp;
        temp = values[max];
        // Swapping here
        values[max] = values[0];
        values[0] = temp;
	    printArray();
	}

    // b. shift all element to right and wraparound
	public void shiftRight() {
	    resetValues();
        int max = values.length-1;
        int tempFirst = values[max];
        // Incrementing Downwards! (It's okay if we replace the max value)         
        for(int i=max; i>=1; i--){
            values[i] = values[i-1];
        }
        values[0] = tempFirst;
        printArray();
	}

    // c. replace even elements with zero
	public void replaceEven() {
	    resetValues();
        int max = values.length;
        for(int i=0; i<max;i++){
            // Even Modulus 2 is always 0!             
            if(values[i]%2 ==0){
                values[i] = 0;
            }
        }
        printArray();
	}

    // d. replace middle elements with larger of two neighbors
	public void replaceMiddle() {
        resetValues();
        int max = values.length;
        int first = values[0];
        int last = values[max-1];
        for(int i=1; i<max-1; i++){
            // Checking which value is bigger if it is bigger           
            if(values[i-1]>values[i+1]){
                values[i]= values[i-1];
            }else{
                values[i] = values[i+1];
            }     
        }
        printArray();

	}

    // e. Remove middle one or two elements
	public void removeMiddle() {
        resetValues();
        int max = values.length;
        // If the length is even!      
        if(max%2==0){
                int[] temp = new int[max-2];
                int j = temp.length/2;
                // Let's leave out the middle value (do not include j in this loop)                 
                for(int i=0; i<j; i++){
                        temp[i] = values[i];
                }
                // Here from j index set the current value as 2 above (as we are leaving)
                // out 2 elements.             
                for(int i=j; i< temp.length; i++){
                        temp[i] = values[i+2];
                }
                // Set the values array as a copy of this new array                 
                values=Arrays.copyOf(temp, temp.length);
        }else{
            int[] temp = new int[max-1];
            int j = temp.length/2;
                // Let's leave out the middle value!       
                for(int i=0; i<j; i++){
                        temp[i] = values[i];
                }
                for(int i=j; i< temp.length; i++){
                        temp[i] = values[i+1];
                }
                values=Arrays.copyOf(temp, temp.length);
        }
		printArray();
	}

    // f. Move even elements to the front
	public void moveEven() {
	    resetValues();
        int max = values.length;
        int temp = 0;
        int k = 0;
        for(int i=0; i <max; i++ ){
            if(values[i]%2 ==0){
                // Set the value of the even index as the max and move it down one index                 
                for(int j=i; j>k; j--){
                    temp = values[j-1];
                    values[j-1]=values[j];
                    values[j]=temp;
                }
                // The Location After where are Even Indexes are.                 
                k++;               
            }    
        }
        printArray();
	}

    // g. Return second-largest element
	public int secondLargest() {
        resetValues();
        int max = values.length;
        int largest = 0;
        int secondlarge = 0;
        for(int i=0; i<max; i++){
            // Set the Larget and Second Largest Here             
            if(values[i]>largest){
                secondlarge = largest;
                largest = values[i]; 
            // If the above condition isn't fulfilled but this condition
            // still is.             
            }else if(values[i]> secondlarge){
                secondlarge = values[i];
            }
        }
        return secondlarge;
	}

    // h. Check if sorted in increasing order
	public boolean sortedIncreasing() {
        resetValues();
        int max = values.length-1;
        for(int i=0; i<max; i++){
            // The first instance this fails return false            
            if( (values[i]<values[i+1]) == false){
                return false;
            }   
        }
        return true;
	}

    // i. Check if contains two adjacent duplicate elements
	public boolean adjacentDups() {
        resetValues();
        int max = values.length -1;
        for(int i=1; i<max; i++){
            // The first instance this succeeds. Return true.          
            if(values[i] == values[i-1] && values[i] == values[i+1]){
                return true;
            }    
        }
        return false;
	}

    // j. Check if contains any duplicate elements
	public boolean containsDups() {
        resetValues();
        int max = values.length;
        for(int i=0; i<max; i++){
            for(int j=1; j<max; j++){
                // The first instance this succeeds. Return true.                
                if(values[i] == values[j]){
                    return true;
                }
            }
        }

        return false;
	}



}
