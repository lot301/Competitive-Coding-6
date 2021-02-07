public class BeautifulNumbers {
// Time Complexity :o(m), m is valid permutations
// Space Complexity :O(n), n is size of visited array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

    // Your code here along with comments explaining your approach
    class Solution {
        private int count =0;//global counter

        public int countArrangement(int n) {
            boolean[] visited = new boolean[n+1];
            calculate(n,1,visited );
            return count;
        }

        //helper method to use backtracking to count number of beautiful combinations
        private void calculate(int n, int pos, boolean[] visited){
            if(pos > n) count++;
            for (int i = 1; i <= n ; ++i) {
                if(!visited[i] && (pos%i==0 || i%pos==0)){
                    visited[i]=true;
                    calculate(n, pos+1, visited);
                    visited[i]=false;
                }
            }
        }
    }


}
