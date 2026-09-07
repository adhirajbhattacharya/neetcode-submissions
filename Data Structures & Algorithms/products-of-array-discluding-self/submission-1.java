class Solution {

    public int[] productExceptSelf(int[] nums) {
        int zeroes = 0;
        int allProductExceptZero = 1;

        for (int num : nums) {
            if (num != 0) allProductExceptZero *= num;
            else zeroes++;
        }

        int n = nums.length;
        int[] answer = new int[n];

        if (zeroes > 1) return answer;

        int i = 0;

        while (i < n) {
            int num = nums[i];
            if (num == 0)
                answer[i] = allProductExceptZero;
            else if (zeroes == 0)
                answer[i] = allProductExceptZero / num;
            else
                answer[i] = 0;
            
            i++;
        }
        return answer;
    }
}