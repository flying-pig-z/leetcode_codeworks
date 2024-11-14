package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new ID283MoveZeroes().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int size = nums.length;
            for (int i = 0; i < size; i++) {
                if (nums[i] == 0) {
                    for (int j = i + 1; j < size; j++) {
                        nums[j - 1] = nums[j];
                    }
                    nums[size - 1] = 0;
                    i--;
                    size--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
