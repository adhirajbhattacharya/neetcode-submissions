class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    void subsets(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[idx]);
        subsets(nums, idx + 1, path, res);
        path.remove(path.size() - 1);
        subsets(nums, idx + 1, path, res);
    }
}