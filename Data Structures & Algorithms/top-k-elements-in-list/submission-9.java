class Solution {
    static KeyComparator keyComparator = new KeyComparator();

    public int[] topKFrequent(int[] nums, int k) {
        // return minPqAlgo(nums, k);
        return bucketSortAlgo(nums, k);
        // return quickSelectAlgo(nums, k);
    }

    int[] quickSelectAlgo(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> frequencyMap = getFrequencyMap(nums, len);

        int keyLen = frequencyMap.size();

        Key[] unique = new Key[keyLen];

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            Key key = new Key(num, freq);
            unique[idx++] = key;
        }

        quickSelect(unique, 0, keyLen - 1, keyLen - k);
        
        idx = 0;
        int[] result = new int[k];
        for (int i = keyLen - k; i < keyLen; i++) {
            result[idx++] = unique[i].value;
        }

        return result;
    }

    void quickSelect(Key[] arr, int lo, int hi, int k) {
        if (lo >= hi) return;

        int idx = partition(arr, lo, hi);
        if (idx == k) return;
        if (k < idx)
            quickSelect(arr, lo, idx - 1, k);
        else
            quickSelect(arr, idx + 1, hi, k);
    }

    int partition(Key[] arr, int lo, int hi) {
        int pivot = new Random().nextInt(hi - lo + 1) + lo;
        swap(arr, lo, pivot);

        int i = lo, j = hi + 1;

        while(true) {
            while (keyComparator.compare(arr[lo], arr[++i]) == 1 || keyComparator.compare(arr[lo], arr[i]) == 0) {
                if (i == hi) break;
            }

            while (keyComparator.compare(arr[lo], arr[--j]) == -1 || keyComparator.compare(arr[lo], arr[j]) == 0) {
                if (j == lo) break;
            }
            
            if (i >= j) break;

            swap(arr, i, j);
        }

        swap(arr, lo, j);

        return j;
    }

    void swap(Key[] arr, int i, int j) {
        Key tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    int[] bucketSortAlgo(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> frequencyMap = getFrequencyMap(nums, len);

        List<Integer>[] buckets = new List[len + 1];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            List<Integer> bucket = buckets[freq];
            if (bucket == null) {
                bucket = new ArrayList<>();
                buckets[freq] = bucket;
            }

            bucket.add(num);
        }

        int[] result = new int[k];
        int resIdx = 0;

        for (int i = len; i > 0 && resIdx < k; i--) {
            if (buckets[i] == null) continue;
            
            for (Integer num : buckets[i]) {
                if (resIdx == k) break;
                result[resIdx] = num;
                resIdx++;
            }
        }

        return result;
    }

    int[] minPqAlgo(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> frequencyMap = getFrequencyMap(nums, len);

        PriorityQueue<Key> minPq = new PriorityQueue<>(keyComparator);

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            Key key = new Key(num, freq);
            minPq.offer(key);

            if (minPq.size() > k) minPq.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minPq.poll().value;
        }

        return result;

    }

    Map<Integer, Integer> getFrequencyMap(int[] nums, int len) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            int freq = frequencyMap.getOrDefault(nums[i], 0);
            freq++;
            frequencyMap.put(nums[i], freq);
        }

        return frequencyMap;
    }
}

class Key {
    int value;
    int frequency;

    Key(int value, int frequency) {
        this.value= value;
        this.frequency = frequency;
    }
}

static class KeyComparator implements Comparator<Key> {
    public int compare(Key first, Key second) {
        if (first.frequency == second.frequency) return 0;
        if (first.frequency < second.frequency) return -1;
        return 1;
    }
}