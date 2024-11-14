package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID26RemoveDuplicatesFromSortedArray().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int size = nums.length;
            for (int i = 0; i <= size - 2; i++) {
                if (nums[i] == nums[i + 1]) {
                    for (int j = i + 1; j <= size - 1; j++) {
                        nums[j - 1] = nums[j];
                    }
                    size--;
                    i--;
                }
            }
            return size;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
