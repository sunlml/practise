class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (S == null) {
            return res;
        }
        
        Collections.sort(S);
        subsetsHelper(S, res, new ArrayList<Integer>(), new boolean[S.size()], 0);
        return res;
    }
    
    private void subsetsHelper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> sol, boolean[] used, int pos) {
        res.add(new ArrayList<Integer>(sol));
        
        for (int i = pos, len = nums.size(); i < len; i++) {
            if (i > 0 && nums.get(i-1) == nums.get(i) && !used[i-1]) {
                continue;
            }
            sol.add(nums.get(i));
            used[i] = true;
            subsetsHelper(nums, res, sol, used, i + 1);
            used[i] = false;
            sol.remove(sol.size() - 1);
        }
        
    }
}

