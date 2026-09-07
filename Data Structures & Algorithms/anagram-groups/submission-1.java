class Solution {
    public List<List<String>> groupAnagrams(String[] strs)  {
        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            List<String> value = resultMap.getOrDefault(key, new ArrayList<>());
            value.add(str);
            resultMap.put(key, value);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> value : resultMap.values()) {
            result.add(value);
        }

        return result;
    }

    String getKey(String str) {
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i) - 'a';
            count[pos] += 1;
        }

        StringBuffer key = new StringBuffer();

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) key.append(i + ":" + count[i] + ",");
        }

        return key.toString();
    }
}
