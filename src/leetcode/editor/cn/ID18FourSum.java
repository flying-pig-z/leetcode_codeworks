package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID18FourSum {
    public static void main(String[] args) {
        Solution solution = new ID18FourSum().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int a, b, c, d;
            for (a = 0; a <= nums.length - 4; a++) {
                if (a != 0 && nums[a] == nums[a - 1]) {
                    continue;
                }
                for (b = a + 1; b <= nums.length - 3; b++) {
                    if (b != a + 1 && nums[b] == nums[b - 1]) {
                        continue;
                    }
                    c = b + 1;
                    d = nums.length - 1;
                    while (c < d) {
                        if (c != b + 1 && nums[c] == nums[c - 1]) {
                            c++;
                            continue;
                        }
                        long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                        if (sum == target) {
                            result.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                            c++;
                        } else if (sum < target) {
                            c++;
                        } else {
                            d--;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
