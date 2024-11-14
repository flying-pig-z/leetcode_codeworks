package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID977SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new ID977SquaresOfASortedArray().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
