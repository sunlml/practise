class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (nums == null) {
            return res;
        }
        
        permuteHelper(res, nums, new ArrayList<Integer>(), new boolean[nums.size()]);
        
        return res;
    }
    
    private void permuteHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, ArrayList<Integer> sol, boolean[] mark) {
        if (sol.size() == nums.size()) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for (int i = 0, len = nums.size(); i < len; i++) {
            if (!mark[i]) {
                sol.add(nums.get(i));
                mark[i] = true;
                permuteHelper(res, nums, sol, mark);
                mark[i] = false;
                sol.remove(sol.size() - 1);
            }
        }
    }
}

