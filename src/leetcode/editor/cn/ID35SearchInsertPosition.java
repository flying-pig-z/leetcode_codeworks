package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new ID35SearchInsertPosition().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            System.out.println(left + " " + right);

            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            // right left
            // right=mid left right小于target ，target应该在right的右边,target=right+1
            // right left=mid left大于target,target应该在left的坐标，target=left
            if (mid == left) {
                return left;
            } else {
                // left右移
                return right+1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
