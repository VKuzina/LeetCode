package leet;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Problem_2301 {
	public boolean matchReplacement(String s, String sub, char[][] mappings) {
        LinkedHashMap<Character, Set<Character>> map = new LinkedHashMap<Character, Set<Character>>();
        char[] s_chars = s.toCharArray();
        char[] sub_chars = sub.toCharArray();

        for (char[] mapping : mappings) {
            char old_c = mapping[0];
            char new_c = mapping[1];

            if (map.containsKey(old_c)) map.get(old_c).add(new_c);
            else {
                Set<Character> new_chars = new HashSet<Character>();
                new_chars.add(new_c);
                new_chars.add(old_c);
                map.put(old_c, new_chars);
            }
        }

        for (int i = 0; i <= s_chars.length - sub_chars.length; i++) {
            boolean check = true;
            for(int j = 0; j < sub_chars.length; j++) {
                if (map.get(sub_chars[j]) == null) {
                    if (s_chars[i+j] == sub_chars[j]) continue;
                    check = false;
                    break;
                }

                if (!map.get(sub_chars[j]).contains(s_chars[i+j])) {
                    check = false;
                    break;
                }
            }

            if (check) return true;
        }

        return false;
    }
}
