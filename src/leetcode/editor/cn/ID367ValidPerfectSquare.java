package leetcode.editor.cn;

import java.lang.reflect.Parameter;
import java.util.*;

import leetcode.editor.util.*;

public class ID367ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ID367ValidPerfectSquare().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            long left = 1;
            long right = num;
            while (left <= right) {
                long mid = ((long) left + right) / 2;
                if (mid * mid == num) {
                    return true;
                } else if (mid * mid < num) {
                    left = mid + 1;
                } else if (mid * mid > num) {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
