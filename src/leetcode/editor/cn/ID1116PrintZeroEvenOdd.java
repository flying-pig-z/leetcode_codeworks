package leetcode.editor.cn;

import java.util.function.IntConsumer;


public class ID1116PrintZeroEvenOdd {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ZeroEvenOdd {
        private int n;

        private boolean order = false; // false output 0,true output other

        private int pos = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
            while (pos <= n) {
                if (!order) {
                    printNumber.accept(0);
                    System.out.println(0);
                    order = true;
                    notifyAll();
                }else {
                    wait();
                }

            }

        }

        public synchronized void even(IntConsumer printNumber) throws InterruptedException {
            while (pos <= n) {
                if (order && pos % 2 == 0) {
                    printNumber.accept(pos);
                    System.out.println(pos);
                    order = false;
                    pos++;
                    notifyAll();
                }else {
                    wait();
                }

            }

        }

        public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
            while (pos <= n) {
                if (order && pos % 2 != 0) {
                    printNumber.accept(pos);
                    System.out.println(pos);
                    order = false;
                    pos++;
                    notifyAll();
                } else {
                    wait();
                }
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
