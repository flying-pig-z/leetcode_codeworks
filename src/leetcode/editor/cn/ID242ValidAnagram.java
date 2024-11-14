package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ID242ValidAnagram().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            HashMap<Character, Integer> countS = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (countS.containsKey(c)) {
                    countS.put(c, countS.get(c) + 1);
                } else {
                    countS.put(c, 1);
                }
            }
            HashMap<Character, Integer> countT = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (countT.containsKey(c)) {
                    countT.put(c, countT.get(c) + 1);
                } else {
                    countT.put(c, 1);
                }
            }
            if (countS.equals(countT)) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
