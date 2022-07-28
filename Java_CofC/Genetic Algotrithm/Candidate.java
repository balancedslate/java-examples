// Shell for the Candidate class of the GA assignment.
// Last Modified: 01/27/2022
// Modified by Levi Kenley
// This is the base class for the genetic algorithm package. 
//
// It has standard getter/setter methods, alongside a given 
// method that randomly seeds the candidates values.
//
// It also has a getFitness function that returns an integer 
// with respect to a given formula.

import java.io.*;
import java.util.BitSet;
import java.util.Random;
import java.util.*;

// Since we are trying to focus on the GA aspect of the
// project, we simply associate variable 'a' with index 0
// in the candidate. Subsequent indices represent variables
// 'b', 'c', etc.j

public class Candidate {
    
    private BitSet truthVals;
    private int numVals;
    public int fitNum;
    
    public Candidate(int length){
      //Creates a new bitset size length
       truthVals = new BitSet(length);
       //Sets numVals size length
       numVals = length;
       // Sets fitness number to zero
       fitNum = 0;
    }
    
    public void seedCandidate(){
    // Randomly sets bits in the candidate
    // Gets the length of the Candidate
      int bitLength = this.getLength();
      // Iterates through the bitset
      for (int i = 0; i < bitLength; i++){
        //Random constructor
        Random ra = new Random();
        // Sets the value to a random bit
        this.setValue(i, ra.nextBoolean());
      }
 
    }
    
    public void setValue(int index, boolean val){
    // Sets the bit at the given index to correspond to val.
      truthVals.set(index, val);
    }
    
    public boolean getValue(int index){
      // Returns the value at a given index
      return truthVals.get(index);
    }
    
    public int getLength(){
      // Returns the length of the Candidate
      return numVals;
    }
    
    public int getFitness(Formula formula) {
      // Returns the fitness of a candidate; this is the number of clauses
      // in a formula made true by the candidate
      int numClauses = formula.clauses.size();
      // Iterates through the number of clauses
      for (int i = 0; i < numClauses; i++) {
          // Gets the current clause
          ArrayList<String> curClause =  new ArrayList(formula.clauses.get(i));
          // Gets the size of the current clause
          int sizeOfClause = curClause.size();
          // Iterates through the hashset
          for (int j = 0; j < sizeOfClause; j++) {
              // Checks for negation
              if(curClause.get(j) == "-"){
                // if the negation, add to the fitness number
                if(!this.getValue(j + 1)){
                  fitNum++;
                }
                // add to iterator for negative variable
                j++;
              }
              // if not negation, check for true
              else{
                if(this.getValue(j)){
                  // if true, add to fitness
                  fitNum++;
                }
              }
          }
      }
      // Return the fitness
      return fitNum;
    }
    
    public void printCandidate(){
      // Prints out the candidate
      // Creates a new string builder
      StringBuilder sb = new StringBuilder(truthVals.length());
      // iterates through the bitset
      for (int i = truthVals.length() - 1; i >= 0; i--)
      // appends truthval to the string
          sb.append(truthVals.get(i) ? 1 : 0);
      // prints the Candidate in binary
      System.out.println(sb.toString());
    }


}