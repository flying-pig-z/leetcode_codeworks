package leetcode.editor.cn;

import java.awt.color.ICC_ColorSpace;
import java.util.*;

import leetcode.editor.util.*;

import javax.swing.plaf.BorderUIResource;

public class ID36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ID36ValidSudoku().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//消除重复的情况，利用之前的数据，贪心
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set<Character> numSet = new HashSet<>();
            //每一行
            for (int i = 0; i < 9; i++) {
                numSet.clear();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (numSet.contains(board[i][j])) {
                            return false;
                        }
                        numSet.add(board[i][j]);
                    }
                }
            }
            //每一列
            for (int i = 0; i < 9; i++) {
                numSet.clear();
                for (int j = 0; j < 9; j++) {
                    if (board[j][i] != '.') {
                        if (numSet.contains(board[j][i])) {
                            return false;
                        }
                        numSet.add(board[j][i]);
                    }
                }
            }
            //每一格
            for (int iBegin = 0; iBegin <= 8; iBegin = iBegin + 3) {
                for (int jBegin = 0; jBegin <= 8; jBegin = jBegin + 3) {
                    numSet.clear();
                    for (int i = iBegin; i < iBegin + 3; i++) {
                        for (int j = jBegin; j < jBegin + 3; j++) {
                            if (board[i][j] != '.') {
                                if (numSet.contains(board[i][j])) {
                                    return false;
                                }
                                numSet.add(board[i][j]);
                            }
                        }
                    }
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
