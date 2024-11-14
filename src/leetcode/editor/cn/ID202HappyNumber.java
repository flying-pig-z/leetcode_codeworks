package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new ID202HappyNumber().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> hashSet = new HashSet<>();
            while (true) {
                int result = 0;
                while (n != 0) {
                    int ys = n % 10;
                    n = n / 10;
                    result = result + ys * ys;
                }
                if (result == 1) {
                    break;
                }
                if (hashSet.contains(result)) {
                    return false;
                } else {
                    hashSet.add(result);
                }
                n = result;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
