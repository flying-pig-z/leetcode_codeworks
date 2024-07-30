package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new ID21MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode p1 = list1;
            ListNode p2 = list2;
            ListNode newNode = new ListNode();
            ListNode p3 = newNode;
            while (p1 != null || p2 != null) {
                int max = -1000;
                if (p1 != null && p2 != null) {
                    if (p1.val < p2.val) {
                        max = p1.val;
                        p1 = p1.next;
                    } else {
                        max = p2.val;
                        p2 = p2.next;
                    }
                } else if (p1 != null) {
                    max = p1.val;
                    p1 = p1.next;
                } else if (p2 != null) {
                    max = p2.val;
                    p2 = p2.next;
                }
                p3.next = new ListNode(max);
                p3 = p3.next;
            }
            return newNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
