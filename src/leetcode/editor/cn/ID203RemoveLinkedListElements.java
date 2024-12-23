package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new ID203RemoveLinkedListElements().new Solution();
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
        public ListNode removeElements(ListNode head, int val) {
            // 链表不为空
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            head = dummyHead;
            ListNode pre = head;
            ListNode post = head.next;
            while (post != null) {
                if (post.val == val) {
                    pre.next = post.next;
                } else {
                    pre = pre.next;
                }
                post = post.next;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
