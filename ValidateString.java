//********************************************************************
//  
//  ValidateString.java       Author: Christine Chong cc4190
//
//  For validating inputs
//********************************************************************

import java.util.ArrayList;
import java.util.Collections;
public class ValidateString {
    
    public String[] hand;
    public String input;
    public String[] arr;

//  A constructor 
    public ValidateString(String[] hand){
        this.hand = hand;        
    }
    public ValidateString(String input){
        this.input = input;
    }

// Checking the Length of the Hand
    public boolean checkLength(){
        if(hand.length != 5){
            return false;
        }else{
            return true;
        }
    }

// Checking Repeats for the Hand
    public boolean checkRepeat(){
        for(int i=0; i<hand.length; i++){
            int k=i+1;     
            while(k<hand.length){
                if(hand[i].equals(hand[k])){
                    return false;
                }else{
                    k++;    
                }

            }            
        }
        return true;
    }
// Checking for Alpha
    public boolean checkAlpha(){
        if(input.matches("^[0-4](,[0-4])*$") == true){
            return false;
        }else{
            return true;
        }
    }
// Checking the Array Method
    public boolean checkArray(String[] arg){
        boolean valid = true;
        for(int i=0; i<arg.length; i++)
            if(arg[i].matches("[0-9]+") != true){
                valid = false;
            }
        return valid;
    }
}