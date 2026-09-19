class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int i = 0;

        Set<List<Integer>> result = new HashSet<>();

        while (i < n - 2) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> choice = new ArrayList<>();
                    choice.add(nums[i]);
                    choice.add(nums[j]);
                    choice.add(nums[k]);
                    result.add(choice);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            i++;
        }

        return new ArrayList<>(result);
    }
}