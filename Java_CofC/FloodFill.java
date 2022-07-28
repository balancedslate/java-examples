class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            // Establish a helper directional array
            int[] directional = new int[]{0, 1, 0, -1, 0};
            // Establish variables for the row and column sizes
            int rowSize = image.length;
            int columnSize = image[0].length;
            // Establish a holder variable for the origin
            int origin = image[sr][sc];
            // Replace newColor with the origin node
            image[sr][sc] = newColor;
            // Create an array to keep track of visited nodes
            boolean[][] visitedNode = new boolean[rowSize][columnSize];
            // Create a queue for future nodes
            Queue<int[]> queue = new LinkedList<>();
            // Add the current coordinates to the queue
            queue.add(new int[]{sr, sc});
            // Start the Breadth-first Search
            while (!queue.isEmpty()) {
                // Remove the current node of the queue
                int[] currentNode = queue.remove();
                // Establish the visited node to true
                visitedNode[currentNode[0]][currentNode[1]] = true;
                // For each direction, add to the list
                for (int i = 0; i < directional.length - 1; i++) {
                    // Establish helper variables for the directions
                    int X  = currentNode[0] + directional[i];
                    int Y = currentNode[1] + directional[i + 1];
                    // Check validity of the nodes
                    if (X < 0 || Y < 0) {
                        continue;
                    } 
                    if (X >= rowSize || Y >= columnSize) {
                        continue;
                    }
                    if (image[X][Y] != origin || visitedNode[X][Y]) {
                        continue;
                    }
                    // Establish the node as the newColor variable
                    image[X][Y] = newColor;
                    // Add the node to the queue if passes validity checks
                    queue.add(new int[]{X,Y});
                }
            }
            // Return the integer grid
            return image;
        }
}