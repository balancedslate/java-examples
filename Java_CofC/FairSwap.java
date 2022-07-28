// Author: Levi Kenley
// Class: CSCI230
// Professor: Dr. Sun
// Purpose: To make sure bob and alice have a fair candy swap

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // Initialize new hashset
        HashSet<Integer> hash = new HashSet<>();
        // Initialize variables for the sum of each array
        int aliceSum = 0;
        int bobSum = 0;
        // Iterate through Alice and add to the stack
        for (int alice : aliceSizes) {
            // Add to the sum
            aliceSum = aliceSum + alice;
            hash.add(alice);
        }
        // Iterate bob and add to bob's sum
        for (int bob : bobSizes) {
            bobSum = bobSum + bob;
        }
        // Iterate through bob for fair candy swap
        for(int i: bobSizes) {
            // Create a variable to hold to hold the correct candy amount
            int delta = (aliceSum - bobSum + 2 * i) / 2;
            // if the hashset contains the variable, return an array of it with i
            if(hash.contains(delta)) {
                // return the answer array
                int[] answer = new int[]{delta, i};
                return answer;
            }
        }
        // Added return statement for debug purposes
        return new int[]{0,0};  
    }
}