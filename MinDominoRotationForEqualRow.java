// Time Complexity : O(n) where n is the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We know our target number would be either of the top or bottom of the first domino
// We will first check for the top of first as target
// If the neither top or bottom is target return -1
// If top is not the target, the count of rotations to get all top to target would increase
// Similarly for the bottom. We we finally take the min of those counts and return
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = findmin(tops, bottoms, tops[0]);
        if(res == -1)
            res = findmin(tops, bottoms, bottoms[0]);
        return res;
    }
    private int findmin(int[] tops,int[] bottoms, int target){
        int topCount = 0;
        int bottomCount = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
            if(tops[i] != target)
                topCount++;
            if(bottoms[i] != target)
                bottomCount++;
        }
        return Math.min(topCount, bottomCount);
    }
}