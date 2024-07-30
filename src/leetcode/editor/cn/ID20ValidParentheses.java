package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ID20ValidParentheses().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> characters = new Stack<>();
            char chars[] = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                if (characters.size() == 0) {
                    characters.push(chars[i]);
                } else {
                    if (chars[i] == ')' && characters.peek() == '(') {
                        characters.pop();
                    } else if (chars[i] == ']' && characters.peek() == '[') {
                        characters.pop();
                    } else if (chars[i] == '}' && characters.peek() == '{') {
                        characters.pop();
                    } else {
                        characters.push(chars[i]);
                    }
                }
            }
            return characters.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
