// Author: Levi Kenley
// Class: CSCI230 
// Professor: Dr. Sun
// Purpose: to find the kth largest element within the data stream
// Runtime: 

class KthLargest {
    // Establish the priority queue
    PriorityQueue<Integer> kthQ;
    // Establish a k variable to hold the kth element
    int k = 0;
    
    public KthLargest(int k, int[] nums) {
        // Set k to the input value
        this.k = k;
        // Initialize the Priority Queue
        kthQ = new PriorityQueue<Integer>();
        // Iterate through the queue
        for (int i : nums) {
            // Add the items using the created function
            this.add(i);
        }
    }
    
    public int add(int val) {
        // Add the value to the queue
        kthQ.add(val);
        // If the queue is larger than k, remove it
        if (kthQ.size() > k) {
            kthQ.remove();
        }
        // Return the head
        return kthQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
