package leetcode.editor.cn;

import java.lang.reflect.Parameter;
import java.util.*;

import leetcode.editor.util.*;

public class ID24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new ID24SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null)
                return head;
            ListNode pre = head;
            ListNode post = head.next;
            ListNode prepre = head;

            while (true) {
                if (pre == head) {
                    head = post;
                }
                pre.next = post.next;
                post.next = pre;
                // 如果是让前一个结点指向交换后在前的结点
                if (head != post) {
                    // 让前一个结点指向现在交换后的第一个结点
                    prepre.next = post;
                }
                prepre = pre;
                pre = pre.next;
                if (pre == null) {
                    break;
                }
                post = pre.next;
                if (post == null) {
                    break;
                }

            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
