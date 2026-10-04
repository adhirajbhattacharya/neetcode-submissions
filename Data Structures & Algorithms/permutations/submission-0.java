class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0, new ArrayList<>(), new boolean[nums.length], new ArrayList<>());
    }

    List<List<Integer>> permute(int[] nums, int idx, List<Integer> path, boolean[] visited, List<List<Integer>> result) {
        int n = nums.length;
        if (idx == n) {
            result.add(new ArrayList<>(path));
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            path.add(nums[i]);
            permute(nums, idx + 1, path, visited, result);
            path.remove(path.size() - 1);
            visited[i] = false;

        }

        return result;
    }
}