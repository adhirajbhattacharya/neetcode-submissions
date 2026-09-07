class Solution {
    Map<Integer, Integer> freqmap = new HashMap<>();
    int[] unique;
    public int[] topKFrequent(int[] nums, int k) {
        for (int num : nums) {
            freqmap.put(num, freqmap.getOrDefault(num, 0) + 1);
        }

        unique = freqmap.keySet().stream().mapToInt(i -> i).toArray();
        int n = unique.length;
        if (k == n) return unique;

        quickselect(0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickselect(int left, int right, int pos) {
        if (left == right) return;
        int partidx = partition(left, right);
        if (partidx == pos) return;
        if (partidx > pos) quickselect(left, partidx - 1, pos);
        else quickselect(partidx + 1, right, pos);
    }

    private int partition(int left, int right) {
        int partidx = getPartitionIndex(left, right);
        swap(partidx, right);
        int l = left, r = left;
        int cmp = freqmap.get(unique[right]);
        while (r < right) {
            int fr = freqmap.get(unique[r]);
            if (fr < cmp) {
                swap(l, r);
                l++;
                r++;
            } else {
                r++;
            }
        }
        swap (l, right);
        return l;
    }

    private void swap(int i, int j) {
        if (i == j) return;
        int t = unique[i];
        unique[i] = unique[j];
        unique[j] = t;
    }

    private int getPartitionIndex(int left, int right) {
        return left + new Random(29L).nextInt((right - left));
    }
}