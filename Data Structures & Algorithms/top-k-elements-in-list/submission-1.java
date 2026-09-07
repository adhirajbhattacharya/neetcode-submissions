class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int freq = frequencyMap.getOrDefault(nums[i], 0);
            freq++;
            frequencyMap.put(nums[i], freq);
        }

        PriorityQueue<Key> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Key key = new Key(entry.getKey(), entry.getValue());
            pq.offer(key);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().value;
        }

        return result;
    }
}

class Key implements Comparable<Key>{
    int value;
    int frequency;

    Key(int value, int frequency) {
        this.value= value;
        this.frequency = frequency;
    }

    public int compareTo(Key other) {
        if (this.frequency == other.frequency) return 0;
        if (this.frequency < other.frequency) return 1;
        return -1;
    }
}