package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import leetcode.editor.util.*;

public class ID15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ID15ThreeSum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                // 跳过重复的a[这一个i与上一个一样]
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    // 移动left指针，并跳过重复的ab[这一个left与上一个一样]
                    if (left != i+1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    // 移动right指针，并跳过重复的abc
                    if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(new ArrayList<>(
                                List.of(nums[i], nums[left], nums[right])));
                        left++;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
