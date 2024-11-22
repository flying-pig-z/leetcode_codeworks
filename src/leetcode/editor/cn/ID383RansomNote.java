package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID383RansomNote {
    public static void main(String[] args) {
        Solution solution = new ID383RansomNote().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> magazineMap = new HashMap<>();
            for (int i = 0; i < magazine.length(); i++) {
                if (!magazineMap.containsKey(magazine.charAt(i))) {
                    magazineMap.put(magazine.charAt(i), 1);
                } else {
                    magazineMap.put(magazine.charAt(i), magazineMap.get(magazine.charAt(i)) + 1);
                }
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                if (!magazineMap.containsKey(ransomNote.charAt(i))) {
                    return false;
                }
                magazineMap.put(ransomNote.charAt(i), magazineMap.get(ransomNote.charAt(i)) - 1);
                if (magazineMap.get(ransomNote.charAt(i)) == 0) {
                    magazineMap.remove(ransomNote.charAt(i));
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
