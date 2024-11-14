package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new ID349IntersectionOfTwoArrays().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> resultSet = new HashSet<>();
            HashSet<Integer> numSet = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                numSet.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (numSet.contains(nums2[i])) {
                    resultSet.add(nums2[i]);
                }
            }
            return resultSet.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
