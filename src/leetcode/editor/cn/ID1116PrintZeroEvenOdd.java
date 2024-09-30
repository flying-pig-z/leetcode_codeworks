package leetcode.editor.cn;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;


public class ID1116PrintZeroEvenOdd {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ZeroEvenOdd {
        private int n;

        private volatile int count = 0;

        private Semaphore zeroSemaphore = new Semaphore(1);
        private Semaphore evenSemaphore = new Semaphore(0);
        private Semaphore oddSemaphore = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (count <= 2 * n) {
                zeroSemaphore.acquire();
                printNumber.accept(0);
                System.out.println(0);
                count++;
                if ((count + 1) % 4 == 0) {
                    evenSemaphore.release();
                } else {
                    oddSemaphore.release();
                }

            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (count <= 2 * n) {
                System.out.println("even");
                evenSemaphore.acquire();
                printNumber.accept(count);
                System.out.println(count);
                count++;
                zeroSemaphore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (count <= 2 * n) {
                System.out.println("odd");
                oddSemaphore.acquire();
                printNumber.accept(count);
                System.out.println(count);
                count++;
                zeroSemaphore.release();

            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
