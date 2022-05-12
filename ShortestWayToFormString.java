// Time Complexity : O(nlogm) where n is target and m is source length
// Space Complexity : O(m) where m is length of source string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Store the source string in map of character to list of integer
// This will be use to store the indices of all the occurances of the characters
// Now we can can traverse through the target string and for each charater we will find the
// place where it is present in the source using map and binary search
// When the index reaches end we will reset it. increase the output subsequence count
// Finally we will return the count
class Solution {
    public int shortestWay(String source, String target) {
        int sourceIndex = 0;
        int targetIndex = 0;
        int count = 1;
        Map<Character, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < source.length(); i++){
            char c = source.charAt(i);
            if(!hm.containsKey(c)){
                hm.put(c, new ArrayList<>());
            }
            hm.get(c).add(i);
        }
        while(targetIndex < target.length()){
            char c = target.charAt(targetIndex);
            if(!hm.containsKey(c))
                return -1;
            List<Integer> indices = hm.get(c);
            int index = binaryS(indices, sourceIndex);
            if(index == indices.size()){
                sourceIndex = 0;
                count++;
            }
            else{
                sourceIndex = indices.get(index) + 1;
                targetIndex++;
            }
        }
        return count;
    }
    public int binaryS(List<Integer> indices, int sourceIndex){
        int s = 0;
        int e = indices.size() - 1;
        while(s <= e){
            int mid = s + (e-s)/2;
            int val = indices.get(mid);
            if(val == sourceIndex){
                return mid;
            }
            else if(sourceIndex < val){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return s;
    }
}