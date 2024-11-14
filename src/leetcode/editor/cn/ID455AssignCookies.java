package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

import leetcode.editor.util.*;

public class ID455AssignCookies {
    public static void main(String[] args) {
        Solution solution = new ID455AssignCookies().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            // 拿最小的饼干给最小的孩子吃
            Arrays.sort(g);
            Arrays.sort(s);
            int count = 0;
            for (int i = 0; i < s.length && count < g.length; i++) {
                if (s[i] >= g[count]) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
