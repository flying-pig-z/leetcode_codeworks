package leetcode.editor.cn;

import leetcode.editor.util.*;

public class ID19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
    }
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // 双指针
            ListNode pre = head;
            ListNode post = head;
            int count = 1;
            if (head.next == null) {
                return null;
            }
            while (post != null) {
                post = post.next;
                count++;
                if (count >= n + 3) {
                    pre = pre.next;
                }
            }
            if (count == n + 1) {
                head = head.next;
            } else {
                pre.next = pre.next.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
