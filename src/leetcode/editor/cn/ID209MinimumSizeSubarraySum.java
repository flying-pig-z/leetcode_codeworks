package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new ID209MinimumSizeSubarraySum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0, right = 0;
            int minLen = Integer.MAX_VALUE;
            int betweenSum = nums[0];
            while (true) {
                if (betweenSum < target) {
                    right++;
                    if (right > nums.length - 1) {
                        break;
                    } else {
                        betweenSum = betweenSum + nums[right];
                    }
                } else {
                    if ((right - left + 1) < minLen) {
                        minLen = right - left + 1;
                    }
                    left++;
                    if (left > nums.length - 1) {
                        break;
                    } else {
                        betweenSum = betweenSum - nums[left-1];
                    }

                }
            }
            if (minLen == Integer.MAX_VALUE)
                return 0;
            return minLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
