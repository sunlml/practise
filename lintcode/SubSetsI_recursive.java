ass Solution {
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
        subsetsHelper(nums, res, new ArrayList<Integer>(), 0);
        
        return res;
    }
    
    private void subsetsHelper(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int pos) {
        
        res.add(new ArrayList(cur));
        
        for (int i = pos; i < nums.length; i++) {
            cur.add(nums[i]);
            subsetsHelper(nums, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
