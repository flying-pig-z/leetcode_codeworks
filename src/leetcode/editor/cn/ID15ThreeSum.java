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
            Hashtable<Integer, Integer> countHashTable = new Hashtable<>();
            for (int i = 0; i < nums.length; i++) {
                if (!countHashTable.containsKey(nums[i])) {
                    countHashTable.put(nums[i], 1);
                } else {
                    countHashTable.put(nums[i], countHashTable.get(nums[i]) + 1);
                }
            }
            HashSet<List<Integer>> result = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int search = -nums[i] - nums[j];
                    if (countHashTable.get(search) != null) {
                        List<Integer> addList = new ArrayList<>();
                        addList.add(nums[i]);
                        addList.add(nums[j]);
                        addList.add(search);
                        Collections.sort(addList);
                        if (search != nums[i] && search != nums[j]) {
                            result.add(addList);
                        } else if (search != nums[i] || search != nums[j]) {
                            if (countHashTable.get(search) >= 2) {
                                result.add(addList);
                            }
                        } else {
                            if (countHashTable.get(search) >= 3) {
                                result.add(addList);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
