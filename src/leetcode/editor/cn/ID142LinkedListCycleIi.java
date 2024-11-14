package leetcode.editor.cn;

import java.lang.reflect.Parameter;
import java.util.*;

import leetcode.editor.util.*;

public class ID142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new ID142LinkedListCycleIi().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if(head == null)
                return null;
            HashSet<ListNode> listNodes = new HashSet<>();
            ListNode now = head;
            while (true) {
                if (now.next == null) {
                    return null;
                }
                // 检查和之前有没有重复
                if (listNodes.contains(now)) {
                    return now;
                }
                listNodes.add(now);
                now = now.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
