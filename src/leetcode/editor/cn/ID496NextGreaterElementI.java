package leetcode.editor.cn;

import java.time.temporal.Temporal;
import java.util.*;

import leetcode.editor.util.*;

public class ID496NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new ID496NextGreaterElementI().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 没有重复元素 -- map ， 右边更大元素 -- 单调栈
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> integerStack = new Stack<>();

            Map<Integer, Integer> resultMap = new HashMap<>();
            // 找右边最大 -- 从右到左遍历，单调递减栈
            for (int i = nums2.length - 1; i >= 0; i--) {
                // 递减，说明如果栈顶大于元素才能插入，小于要弹开
                while (!integerStack.empty() && integerStack.peek() < nums2[i]) {
                    integerStack.pop();
                }
                if (integerStack.empty()) {
                    // 本身最大
                    resultMap.put(nums2[i], -1);
                } else {
                    // 栈顶第一个大
                    resultMap.put(nums2[i], integerStack.peek());
                }
                integerStack.push(nums2[i]);
            }
            int result[] = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = resultMap.get(nums1[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
