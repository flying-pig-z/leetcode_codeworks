package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new ID69Sqrtx().new Solution();
        //执行测试
        System.out.println(solution.mySqrt(2147483647));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int left = 1;
            int right = x;
            while (left <= right) {
                long mid = ((long) right + left) / 2;
                if (mid * mid == x) {
                    return (int) mid;
                } else if (mid * mid < x) {
                    left = (int) mid + 1;
                } else if (mid * mid > x) {
                    right = (int) mid - 1;
                }
            }
            return right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
