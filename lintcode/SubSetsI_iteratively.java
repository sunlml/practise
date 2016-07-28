class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (nums == null) {
            return res;
        }
        
        Arrays.sort(nums);
        
        long rsize = (long)Math.pow(2, nums.length);
        
        for (long l = 0; l < rsize; l++) {
            ArrayList<Integer> sol = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((1<<i & l) != 0) {
                    sol.add(nums[i]);
                }
            }
            res.add(new ArrayList<Integer>(sol));
        }
        
        return res;
    }
}
