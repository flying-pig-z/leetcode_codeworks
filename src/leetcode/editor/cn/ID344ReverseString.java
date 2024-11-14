package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID344ReverseString {
    public static void main(String[] args) {
        Solution solution = new ID344ReverseString().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            // mid怎么取
            // 0 1 2 3 -- 2 4/2-1+1 mid = length/2
            // 0 1 2 3 4 -- 2 mid = length / 2
            for (int i = s.length - 1; i >= s.length / 2; i--) {
                int left = s.length - 1 - i;
                char temp = s[left];
                s[left] = s[i];
                s[i] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
