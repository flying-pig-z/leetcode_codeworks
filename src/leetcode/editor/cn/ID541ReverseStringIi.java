package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID541ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ID541ReverseStringIi().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            int left = 0;
            int leftBound = 0;
            int right = left + k - 1;
            char[] chars = s.toCharArray();
            while (left < s.length()) {
                if (right > s.length() - 1) {
                    right = s.length() - 1;
                }
                while (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
                leftBound = leftBound + 2 * k;
                left = leftBound;
                right = left + k - 1;
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
