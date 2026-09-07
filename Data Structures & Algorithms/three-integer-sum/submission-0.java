class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        Set<Result> results = new HashSet<>();
        
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    Result r = new Result(nums[i], nums[j], nums[k]);
                    results.add(r);
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return results.stream().map(Result::asList).collect(Collectors.toList());
    }
}

class Result {
    int a, b, c;

    Result(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    List<Integer> asList() {
        return List.of(a, b, c);
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result other = (Result) o;

        return this.a == other.a && this.b == other.b && this.c == other.c;
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }
}