package ProblemSolving;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 1;

        map.put(s.charAt(0), 0);

        int max = 1;

        while (r < s.length()) {
            char current = s.charAt(r);
            if (map.containsKey(current) && map.get(current) >= l) {
                int position = map.get(current);
                l = position + 1;
            }
            max = Integer.max(max, r - l + 1);
            map.put(current, r);
            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
