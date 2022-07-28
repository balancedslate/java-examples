// Shell for the Population class of the GA assignment.
// Last modified: 1/27/2022
// Modified by Levi Kenley
// This class creates a population based off the candidate class
// To be used for a genetic algortithm that inputs CNF truth arguements


public class Population {

    Candidate[] candidates;

    
    // Constructor
    public Population(int populationSize) {
      //Creates a new candidate array based off population size
      candidates = new Candidate[populationSize];
    }
    
    public void seedPop(int candidateLength) {
        // Seed a population with candidates of length candidateLength
        int popSize = this.size();
        // iternate through candidates, seeding with inputted size
        for (int i = 0; i < popSize; i++) {
          candidates[i] = new Candidate(candidateLength);
          // Sets bits to random using created function
          candidates[i].seedCandidate();
        }
         
    }      

    public Candidate getCandidate(int index) {
        // Return the candidate at a given index
        return candidates[index];
    }

    public Candidate getFittest(Formula formula) {
      // Returns the fittest candidate of the population with 
      // respect to a formula
      int popSize = this.size();
      // Selects the first candidate as the fittest for comparison
      Candidate curFittest = candidates[0];
      // Creates a variable to hold fitness comparison
      int grtFitness = curFittest.getFitness(formula);
      // iterates through the population size, omitting the first
      for (int i = 1; i < popSize; i++){
        // creates a fitness variable for each loop
        int fitness = candidates[i].getFitness(formula);
        // if the new fitness is higher than the greatest
        if(fitness > grtFitness){
          // Set the fittest the the current
          curFittest = candidates[i];
          // calculate new greatest fitness
          grtFitness = curFittest.getFitness(formula);
        }
      }
      // return the fittest once done with the population
      return curFittest;
    }

  
    public int size() {
       // Returns the population size
       return candidates.length;
    }

    public void saveCandidate(int index, Candidate candidate) {
       // Adds a candidate to the population
       candidates[index] = candidate;
    }
    
    public void printPop(){ 
       // Prints out all the candidates in a population
       // You can use my code, but you must implement printCandidate
       // in the Candidate class for it to work:
      System.out.println("Population");
      for(int i = 0; i < candidates.length; i++){
        candidates[i].printCandidate();
      }
      System.out.println();
     
    }
}
    