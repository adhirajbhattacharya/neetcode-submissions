class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();

        if (m > n) return addBinary(b, a);

        char carry = '0';
        StringBuilder res = new StringBuilder();

        int i = 0;

        for (; i < m; i++) {
            char c = a.charAt(m - 1 - i);
            char d  = b.charAt(n - 1 - i);
            String sum = add(c, d, carry);
            res.append(sum.charAt(1));
            carry = sum.charAt(0);
        }

        while (carry == '1' && i < n) {
            char d  = b.charAt(n - 1 - i);
            String sum = add('0', d, carry);
            res.append(sum.charAt(1));
            carry = sum.charAt(0);
            i++;
        }

        while (i < n) {
            res.append(b.charAt(n - 1 - i));
            i++;
        }

        if (carry == '1') res.append('1');

        return res.reverse().toString();
    }

    String add(char a, char b, char carry) {
        if (carry == '0') {
            if (a == '0' && b == '0') return "00";
            else if (a == '0' || b == '0') return "01";
            else return "10";
        }

        if (a == '0' && b == '0') return "01";
        else if (a == '0' || b == '0') return "10";
        else return "11";
    }
}