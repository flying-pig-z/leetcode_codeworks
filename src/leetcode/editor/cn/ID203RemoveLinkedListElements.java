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
            // 头部不为val
            while (head != null && head.val == val) {
                head = head.next;
            }
            // 再次检查链表是否为空
            if (head == null) {
                return null;
            }
            ListNode now = head.next;
            ListNode pre = head;
            while (now != null) {
                if (now.val == val) {
                    pre.next = now.next;
                    now = now.next;
                    continue;
                }
                now = now.next;
                pre = pre.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
