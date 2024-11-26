package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new ID160IntersectionOfTwoLinkedLists().new Solution();
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
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode nowA = headA;
            ListNode nowB = headB;
            // 先遍历链表A存到Hash表中
            HashSet<ListNode> listNodes = new HashSet<>();
            while (nowA != null) {
                listNodes.add(nowA);
                nowA = nowA.next;
            }
            while (nowB != null) {
                if (listNodes.contains(nowB)) {
                    return nowB;
                }
                nowB = nowB.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
