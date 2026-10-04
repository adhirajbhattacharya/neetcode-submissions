class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSumBt(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
    }

    List<List<Integer>> combinationSumBt(   int[] candidates,
                                            int target,
                                            int idx,
                                            List<Integer> track,
                                            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(track));
            return result;
        }

        for (int i = idx; i < candidates.length; i++) {
            int rem = target - candidates[i];
            if (rem < 0) break;

            track.add(candidates[i]);
            result = combinationSumBt(candidates, rem, i, track, result);
            track.remove(track.size() - 1);
        }

        return result;
    }
}