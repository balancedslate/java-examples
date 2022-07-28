// Assignment: Genetic Algorithms
// Last modified: 01/27/2022
// Shell of a Java program which uses a genetic algorithm to find a solution to
// an equation in conjunctive normal form.
//
//// Last Modified by Levi Kenley
// 
// Program takes as input a string representing a formula written in 
// conjunctive normal form and prints a string of 1's and 0's meant to be the
// instantiations of the variables as true/false from left to write
// which satisfy the formula.
// Example call: 
// java cnfga "(a | b) ^ (b | c) | d"
// Example output: 1011 
// This would signify that a is true, b is false,
//    c is true, and d is true. Note that this is one possible 
//    solution that makes the formula true.
// 


import java.io.*;
import java.util.*;
import java.util.Random;

public class cnfga {
   
   // You can experiment with the mutationRate.
   private static final double mutationRate = 0.01;

   public static void main(String [] args) {
   
      // Print out the input formula given as a string argument 
      // to the program:
      System.out.println("Input Formula:");
      System.out.println(args[0]);
      System.out.println();
      
      // Call the Formula class to create a data structure from
      // the input for quick access and evaluation of candidates:
      
      Formula formula = new Formula(args[0]);
      System.out.print("formula = "); 
      System.out.println(formula.clauses);
      System.out.print("uniqueVars = ");
      System.out.println(formula.numUniqueVars);
      
      //// At this point, 
      //// formula.clauses is an ArrayList of HashSets of Strings which 
      ////    represents the formula you typed in on the command line.
      ////    -- The ArrayList contains all the clauses.
      ////    -- Each HashSet is a single clause.
      ////    -- Each String is a variable, or its negation; e.g., "a" or "-a"
      //// formula.numUniqueVars is an integer which tells you how many
      ////    unique variables are in your formula.
      
      //// FROM HERE ON, YOU WILL NEED TO WRITE THE CORRESPONDING CODE.
      
      //// Set a population size (use an even number)
      //// Tip: With large population sizes and small formulas, 
      ////      it's possible that you will find a solution by accident, 
      ////      without ever going into your main loop of selection, crossover,
      ////      and mutation. Remember, GA's are meant for large search spaces.
      ////      In testing, vary your population size accordingly.

      // Sets the population size to an even number
      int popSize = 20;
      // Sets the max generations to 20
      int maxGens = 20;
      // Creates a new population with respect to the population size
      Population newCivilization = new Population(popSize);
      // creates a holder variable for the first generation
      int genNum = 1;
      // Seeds the new population with the number of unique variables
      newCivilization.seedPop(formula.numUniqueVars);
      // Creates a holder variable for the fittest candidate of a given poplation
      Candidate fittest = newCivilization.getFittest(formula);
      // While this number is not fit enough, or the number of generations is too high
      while (fittest.fitNum <= formula.numUniqueVars || genNum >= maxGens){
        // Due to selection, it will only take half as long to birth a new population
        int halfPop = popSize / 2;
        // Iterate through half the population
        for (int i = 0; i < halfPop; i++){
          // Selects the first parent based off stochastic acceptance and the formula
          Candidate parentX = selectParent(newCivilization, formula);
          // Creates a holder variable for the index of the parent
          int parentXIndex = Arrays.binarySearch(newCivilization.candidates, 0, newCivilization.size(), parentX);
          // Selects a second parent based off stochastic acceptance 
          Candidate parentY = selectParent(newCivilization, formula);
          // Creates a holder variable for the second parent
          int parentYIndex = Arrays.binarySearch(newCivilization.candidates, 0, newCivilization.size(), parentY);
          // Creates a child based off the elite parents
          Candidate firstChild = crossover(parentX, parentY);
          // Creates a second child with opposite bits from the first
          Candidate secondChild = crossover(parentY, parentX);
          // Creates a mutation variable from 0.0 - 1.0
          double mutation = Math.random();
          // Checks this against the natural mutation rate
          if (mutation > mutationRate) {
            // if true, mutate both children
            mutate(firstChild);
            mutate(secondChild);
          }
          // Save both children in the place of their parents
          newCivilization.saveCandidate(parentXIndex, firstChild);
          newCivilization.saveCandidate(parentYIndex, secondChild);

        }
        // Select a new fittest at the end of a generation
        fittest = newCivilization.getFittest(formula);
        //Increase the number of generations
        genNum++;

      }
      // If the candidate was found before the generations expired
      if(genNum < maxGens) {
        // Print the candidate
        fittest.printCandidate();
      }
      // If not print not found
      else {
        System.out.println("Candidate Not Found");
      }


  }
      
   
  private static Candidate selectParent(Population pop, Formula formula) {
    // Returns a parent based on what the selection strategy returns.
    // (In our case, we will use stochastic acceptance.)
    // -- Find the maximum fitness within the given population.
    //
    // Create a holder variable for the highest fitness
    int maxFitness = pop.getFittest(formula).fitNum;
    // Creates an empty holder parent candidate
    Candidate parent = new Candidate(pop.candidates[0].getLength());
    // Starts a random constructor
    Random ra = new Random();
    // Creates a boolean to hold the stochastic acceptance results
    Boolean ifElite = false;
    // Iterates through the list while false
    while(!ifElite){
      // Sets the parent to a random int determined from population size
      parent = pop.candidates[ra.nextInt(pop.size())];
      // Attempt stochastic acceptance on the new parent
      ifElite = stochasticAcceptance(parent, formula, maxFitness);
    }
    // -- Keep drawing candidates from the population at 
    // random and checking them with stochasticAcceptance()
    // until it returns true. Then you can return the "elite"
    // parent.
    //
    // Returns the parent if the loop is settled
    return parent;
  }   
    
  private static Boolean stochasticAcceptance(Candidate candidate, Formula formula, int maxPopFitness){     
    // Calculate the odds of keeping a candidate based on
    // odds = fitness of this candidate/maxPopFitness
    //
    // Calculates the survival rate
    double survivalRate = candidate.fitNum/maxPopFitness;
    // Calculates the random mortality rate from 0.0 - 1.0
    double mortalityRate = Math.random();
    // if the mortality rate is less than survival chances return true
    if (mortalityRate < survivalRate) {
      return true;
    }
    // Accept the candidate if a randomly generated number between
    // 0 and 1 is < the odds.
    //
    // If the mortality rate is higher than the survival rate
    // The candidate dies and is not accepted
    else {
      return false;
    }
  }

  private static Candidate crossover(Candidate parent1, Candidate parent2){
    // Creates a holder candidate based off the size of the parent
    Candidate child = new Candidate(parent1.getLength());
    // Uses standard midpoint crossover to create a new candidate.
    int midpointX = parent1.getLength() / 2;
    int midpointY = (parent2.getLength() / 2) + 1;
    // Uses two midpoints to iterate through both parents simulataniously
    for(int i = 0; i < child.getLength() / 2; i++){
      //Sets the value of the child to the first parents midpoint
      child.setValue(midpointX, parent1.getValue(midpointX));
      // Decrements the first midpoint
      midpointX--;
      // Sets the value to the midpoint of the second parent
      child.setValue(midpointY, parent2.getValue(midpointY));
      //Increments the midpoint of the parent
      midpointY++;
    }
    // If the formula has an odd number of variables,
    // the midpoint can be approximated with truncation.
    //
    // Once all values are full, return the new child candidate
    return child;
  }

  private static void mutate(Candidate candidate) {
    // Flip a random bit in the candidate.
    // Creates a random constructor
    Random mutation = new Random();
    // Creates a holder variable for the random gene
    int geneIndex = mutation.nextInt(candidate.getLength());
    // Creates a holder variable for the mutated boolean
    boolean mutatedGene = !candidate.getValue(geneIndex);
    // sets the value in the candidate to the new gene
    candidate.setValue(geneIndex, mutatedGene);
  }

}  /* end of class cnfga */