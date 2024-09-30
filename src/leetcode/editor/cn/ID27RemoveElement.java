package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID27RemoveElement {
    public static void main(String[] args) {
        Solution solution = new ID27RemoveElement().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int length = nums.length;
            for (int i = 0; i <= length - 1; i++) {
                if (nums[i] == val) {
                    for (int j = i; j <= length - 2; j++) {
                        nums[j] = nums[j + 1];
                    }
                    length--;
                    i--;
                }
            }
            return length;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
