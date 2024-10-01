package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;
            // 模拟
            int mid = 0;
            boolean exitOrNot = false;
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] == target) {
                    exitOrNot = true;
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (!exitOrNot) {
                return new int[]{-1, -1};
            } else {
                int i;
                boolean iBound = false;
                for (i = mid; i < nums.length; i++) {
                    if (nums[i] != target) {
                        iBound = true;
                        break;
                    }
                }
                if(i==nums.length){
                    i--;
                }
                int j;
                boolean jBound = false;
                for (j = mid; j >= 0; j--) {
                    if (nums[j] != target) {
                        jBound = true;
                        break;
                    }
                }
                if(j==-1){
                    j++;
                }
                if (iBound) {
                    i = i - 1;
                }
                if (jBound) {
                    j = j + 1;
                }
                return new int[]{j, i};
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
