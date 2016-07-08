public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexpairs = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++){
                indexpairs.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int c = target-nums[i];
            if (indexpairs.containsKey(c) && indexpairs.get(c) !=i)
                return new int [] {i, indexpairs.get(c)};
        }
        throw new IllegalArgumentException("No Solution.");
    }
}