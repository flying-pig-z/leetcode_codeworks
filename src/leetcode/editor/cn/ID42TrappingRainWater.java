package leetcode.editor.cn;

import java.lang.reflect.Parameter;
import java.util.*;

import leetcode.editor.util.*;

public class ID42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new ID42TrappingRainWater().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            // 核心思想：计算每一格的蓄水量相加
            // 每一格子的蓄水量 = min(左边最大，右边最大) - 当前格子高度

            // 相当于要找右边最大
            // 所以从右向左遍历，单调递减栈
            int result = 0;
            int[] biggerIndex = new int[height.length];
            for (int i = 0; i < height.length; i++) {
                biggerIndex[i] = -1;
            }
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = height.length - 1; i >= 0; i--) {
                while (!stack.empty()) {
                    // 递减，所以新来的要比原来的小才能插入
                    if (height[stack.peek()] >= height[i]) {
                        biggerIndex[i] = stack.peek();
                        stack.push(i);
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (stack.empty()) {
                    stack.push(i);
                }
            }

            for (int i = 0; i < height.length - 1; i++) {


                if (biggerIndex[i] != -1) {
                    int wide = biggerIndex[i] - i - 1;
                    int length = height[i];
                    result = result + wide * length;
                    for (int j = i + 1; j < biggerIndex[i]; j++) {
                        result = result - height[j];
                    }

                    i = biggerIndex[i] - 1;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
