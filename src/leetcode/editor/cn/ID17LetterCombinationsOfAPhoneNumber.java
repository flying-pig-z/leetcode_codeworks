package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new ID17LetterCombinationsOfAPhoneNumber().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 2024/8/10 20:10
        public List<String> letterCombinations(String digits) {
            ArrayList<String> result = new ArrayList<>();
            char[] chars = digits.toCharArray();
            HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
            hashMap.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
            hashMap.put(3, new ArrayList<>(Arrays.asList("d", "", "g")));
            hashMap.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
            hashMap.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
            hashMap.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
            hashMap.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
            hashMap.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
            hashMap.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
            for (int i = 0; i < digits.length(); i++) {
                if (result.size() == 0) {
                    ArrayList<String> stringArrayList = hashMap.get(chars[i] - 48);
                    result.addAll(stringArrayList);
                } else {
                    ArrayList<String> newResult = new ArrayList<>();
                    for (int j = 0; j < result.size(); j++) {
                        String pre = result.get(j);
                        ArrayList<String> stringArrayList = hashMap.get(chars[i] - 48);
                        for (int z = 0; z < stringArrayList.size(); z++) {
                            String add = pre + stringArrayList.get(z);
                            newResult.add(add);
                        }
                    }
                    result = newResult;
                }
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
