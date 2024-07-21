package leetcode.editor.cn;


import java.math.BigInteger;

import leetcode.editor.util.*;

public class ID2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new ID2AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode nowl1 = l1.next;
            ListNode nowl2 = l2.next;

            int carry = 0;
            // 先确定新链表的头结点
            ListNode head = new ListNode((l1.val + l2.val + carry) % 10);
            ListNode nowNew = head;
            if ((l1.val + l2.val + carry) >= 10) {
                carry = 1;
            }

            while (nowl1 != null || nowl2 != null) {
                if (nowl1 == null) {
                    nowl1 = new ListNode(0);
                }
                if (nowl2 == null) {
                    nowl2 = new ListNode(0);
                }
                // 计算结果
                ListNode newNode = new ListNode((nowl1.val + nowl2.val + carry) % 10);
                // 更新数据
                if ((nowl1.val + nowl2.val + carry) >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                nowNew.next = newNode;
                nowNew = nowNew.next;
                nowl1 = nowl1.next;
                nowl2 = nowl2.next;
            }
            if (carry == 1) {
                nowNew.next = new ListNode(1);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
