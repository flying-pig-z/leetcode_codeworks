package leetcode.editor.cn;

import java.io.CharArrayReader;
import java.util.*;

import leetcode.editor.util.*;

public class ID5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new ID5LongestPalindromicSubstring().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            // 考虑特殊情况
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i, j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            char[] charArray = s.toCharArray();

            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            for(int j=0;j<len;j++){
                for(int i=0;i<j;i++){
                    if(charArray[i]!=charArray[j]){
                        dp[i][j]=false;
                    } else{
                        if((j-i+1)<3){
                            dp[i][j]=true;
                        }else{
                            dp[i][j]=dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j]&&(j-i+1)>maxLen){
                        maxLen=j-i+1;
                        begin=i;
                    }
                }

            }
            return s.substring(begin, begin+maxLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
