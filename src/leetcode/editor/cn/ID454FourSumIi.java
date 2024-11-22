package leetcode.editor.cn;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

import leetcode.editor.util.*;

public class ID454FourSumIi {
    public static void main(String[] args) {
        Solution solution = new ID454FourSumIi().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> sum1 = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int sum = nums1[i] + nums2[j];
                    if (!sum1.containsKey(sum)) {
                        sum1.put(sum, 1);
                    } else {
                        sum1.put(sum, sum1.get(sum) + 1);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < nums3.length; i++) {
                for (int j = 0; j < nums4.length; j++) {
                    if (sum1.containsKey(-(nums3[i] + nums4[j]))) {
                        count = count + sum1.get(-(nums3[i] + nums4[j]));
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
