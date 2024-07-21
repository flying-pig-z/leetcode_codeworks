package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new ID3LongestSubstringWithoutRepeatingCharacters().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> characters = new HashSet<>();
            char charArray[] = s.toCharArray();
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!characters.contains(charArray[i])) {
                    characters.add(charArray[i]);
                } else {
                    if (characters.size() > maxLen) {
                        maxLen = characters.size();
                    }
                    i = i - characters.size() + 1;
                    characters.clear();
                    characters.add(charArray[i]);
                }
            }
            return Math.max(maxLen, characters.size());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
