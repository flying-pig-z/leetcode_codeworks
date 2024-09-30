package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new ID739DailyTemperatures().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 从右到左遍历，递减单调栈


        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> index = new ArrayDeque<>();
            int result[] = new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i--) {
                while (!index.isEmpty() && temperatures[index.peek()] <= temperatures[i]) {
                    index.pop();
                }
                if (index.isEmpty()) {
                    result[i] = 0;
                } else {
                    result[i] = index.peek() - i;
                }
                index.push(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
