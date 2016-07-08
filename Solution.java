public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] sol = new int[2];
        HashMap<Integer, ArrayList<Integer>> indexpairs = new HashMap<Integer, ArrayList<Integer>>();
        
        for (int i = 0; i < nums.length; i++){
            if (indexpairs.containsKey(nums[i])){
                indexpairs.get(Integer.valueOf(nums[i])).add(Integer.valueOf(i));
            }
            else{
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(Integer.valueOf(i));
                indexpairs.put(Integer.valueOf(nums[i]), tmp);
            }
            
        }
        
        Set<Integer> keys = indexpairs.keySet();
        for (Integer k : keys){
            //If we need to return the list
            if (indexpairs.containsKey(Integer.valueOf(target-k.intValue())) && (indexpairs.get(Integer.valueOf(target-k.intValue()))).size()==2){
                ArrayList<Integer> dummy = indexpairs.get(Integer.valueOf(target-k.intValue()));
                if (dummy.get(0)<dummy.get(1)){
                    sol[0] = dummy.get(0).intValue();
                    sol[1] = dummy.get(1).intValue();
                }
                else{
                    sol[0] = dummy.get(1).intValue();
                    sol[1] = dummy.get(0).intValue();
                }
                break;
            }
            else if (indexpairs.containsKey(Integer.valueOf(target-k.intValue()))){
                ArrayList<Integer> l1 = indexpairs.get(Integer.valueOf(target-k.intValue()));
                ArrayList<Integer> l2 = indexpairs.get(Integer.valueOf(k.intValue()));
                if (l1.get(0)<l2.get(0)){
                    sol[0] = l1.get(0).intValue();
                    sol[1] = l2.get(0).intValue();
                }
                else{
                    sol[0] = l2.get(0).intValue();
                    sol[1] = l1.get(0).intValue();
                }
                break;
            }
            else
                continue;
        }
        
        return sol;
    }
}