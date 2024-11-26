package leetcode.editor.cn;

import java.security.DrbgParameters;
import java.util.*;

import leetcode.editor.util.*;

public class ID206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ID206ReverseLinkedList().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试

        System.out.println(sb);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            List<ListNode> listNodes = new ArrayList<>();
            ListNode now = head;
            while (now != null) {
                listNodes.add(now);
                now = now.next;
            }
            for (int i = listNodes.size() - 1; i > 0; i--) {
                listNodes.get(i).next = listNodes.get(i-1);
            }
            listNodes.get(0).next = null;
            return listNodes.get(listNodes.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
