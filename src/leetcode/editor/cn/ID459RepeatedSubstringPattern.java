package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID459RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new ID459RepeatedSubstringPattern().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            return (s + s).substring(1, s.length() * 2 - 1).contains(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
