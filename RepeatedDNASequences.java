// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Long> map = new HashMap<>();
        map.put('A', 1l);
        map.put('C', 2l);
        map.put('G', 3l);
        map.put('T', 4l);

        HashSet<Long> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        long res = 0;
        int n = s.length();

        long kl = (long) Math.pow(4, 9);
        for (int i = 0; i < n; i++) {
            // outgoing element
            if (i >= 10) {
                char out = s.charAt(i - 10);
                res = res % map.get(out) * kl;
            }

            char in = s.charAt(i);
            res *= 4;
            res += map.get(in);

            if (set.contains(res))
                result.add(s.substring(i - 9, i + 1));

            else
                set.add(res);

        }

        return new ArrayList<>(result);
    }
}