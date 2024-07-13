package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ID11ContainerWithMostWater().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int result = 0;

            int minLen = height[left];
            if (height[left] > height[right]) {
                minLen = height[right];
            }
            while (left < right) {
                int water = (right - left) * minLen;
                if (water > result) {
                    result = water;
                }

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
                if (height[left] < height[right]) {
                    minLen=height[left];
                } else {
                    minLen=height[right];
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
