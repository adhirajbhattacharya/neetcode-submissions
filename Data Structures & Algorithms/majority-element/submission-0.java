class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count =  new HashMap<>();
        int maj_ele = nums[0], maj_cnt = 1;

        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
            if (count.get(i) > maj_cnt) {
                maj_cnt = count.get(i);
                maj_ele = i;
            }
        }
        return maj_ele;
    }
}