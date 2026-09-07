public class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        
        int idx  = 0;
        
        while (idx < s.length()) {
            int nextLen = 0;
            int i = idx;
            while (s.charAt(i) != '#') {
                nextLen *= 10;
                nextLen += (s.charAt(i) - '0');
                i++;
            }

            i++;
            idx = i;

            

            StringBuilder sb = new StringBuilder();
            while (i < idx + nextLen) {
                sb.append(s.charAt(i));
                i++;
            }

            res.add(sb.toString());
            idx = i;
        }
        return res;
    }
}