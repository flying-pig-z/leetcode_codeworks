package leetcode.editor.cn;

import java.util.*;

public class IDLCR038IIQa4I {

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
