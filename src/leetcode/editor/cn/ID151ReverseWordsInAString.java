package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ID151ReverseWordsInAString().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                if (words[i].length() > 0) {
                    stringBuilder.append(words[i]).append(" ");
                }
            }
            // 如果结果不为空，去除最后的空格
            if (stringBuilder.length() > 0) {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            return stringBuilder.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
