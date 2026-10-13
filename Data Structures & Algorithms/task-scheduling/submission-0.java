class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        if (n == 0) return m;

        int[] counts = new int[26];

        for (char c : tasks) {
            counts[c - 'A']++;
        }
        System.out.println(Arrays.toString(counts));
        int max = 0, maxcount = 0;

        for (int count : counts) {
            if (count > max) {
                max = count;
                maxcount = 1;
            } else if (count == max) {
                maxcount++;
            }
        }

        
        System.out.println("max: " + max + ", maxcount: " + maxcount);

        int time = (max - 1) * (n + 1) + 1 + (maxcount - 1);
        return time > m ? time : m;
    }
}