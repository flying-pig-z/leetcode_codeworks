package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID707DesignLinkedList {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        class Node {
            int val;
            Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }

        int length;

        Node head;

        Node tail;

        public MyLinkedList() {
            length = 0;
            head = null;
            tail = null;
        }

        public int get(int index) {
            if (index < 0 || index > length - 1) {
                return -1;
            }
            Node now = head;
            for (int i = 1; i <= index; i++) {
                now = now.next;
            }
            return now.val;
        }

        public void addAtHead(int val) {
            Node newnode = new Node(val, head);
            head = newnode;
            if (length == 0) {
                tail = newnode;
            }
            length++;
        }

        public void addAtTail(int val) {
            Node newnode = new Node(val, null);
            if (length != 0)
                tail.next = newnode;
            tail = newnode;
            if (length == 0) {
                head = newnode;
            }
            length++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > length) {
                return;
            } else if (index == 0) {
                addAtHead(val);
            } else if (index == length) {
                addAtTail(val);
            } else {
                Node now = head;
                for (int i = 1; i <= index - 1; i++) {
                    now = now.next;
                }
                Node newnode = new Node(val, now.next);
                now.next = newnode;
                length++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= length) {
                return;
            } else if (index == 0) {
                head = head.next;
                if (length == 1) {
                    tail = null;
                }
                length--;
            } else if (index == length - 1) {
                Node now = head;
                while (now.next.next != null) {
                    now = now.next;
                }
                now.next = null;
                tail = now;
                length--;
            } else {
                Node now = head;
                for (int i = 1; i <= index - 1; i++) {
                    now = now.next;
                }
                now.next = now.next.next;
                length--;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
