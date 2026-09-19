class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int i = 0;

        List<List<Integer>> result = new ArrayList<>();

        while (i < n - 2) {
            if (nums[i] > 0) break;
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
                    while (j < k && nums[j - 1] == nums[j]) j++;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                } else if (sum < 0) {
                    j++;
                    while (j < k && nums[j - 1] == nums[j]) j++;
                } else {
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) k--;
                }
            }
            i++;
            while (i < n - 2 && nums[i - 1] == nums[i]) i++;
        }

        return result;
    }
}