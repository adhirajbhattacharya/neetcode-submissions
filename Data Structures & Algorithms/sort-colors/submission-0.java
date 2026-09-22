class Solution {
    Random rand = new Random();
    public void sortColors(int[] nums) {
        threeWayQsort(nums, 0, nums.length - 1);
    }

    void threeWayQsort(int[] nums, int st, int en) {
        if (st > en) return;

        int lt = st, gt = en, i = st;
        int pivot = nums[getPivot(nums, st, en)];

        while (i <= gt) {
            int c = nums[i];

            if (c == pivot) {
                i++;
            } else if (c < pivot) {
                swap(nums, i, lt);
                i++;
                lt++;
            } else {
                swap(nums, i, gt);
                gt--;
            }
        }

        threeWayQsort(nums, st, lt - 1);
        threeWayQsort(nums, gt + 1, en);
    }

    int getPivot(int[] nums, int st, int en) {
        int randomIndex = st + rand.nextInt(en - st + 1);
        swap(nums, st, randomIndex);
        return st;
    }

    void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}