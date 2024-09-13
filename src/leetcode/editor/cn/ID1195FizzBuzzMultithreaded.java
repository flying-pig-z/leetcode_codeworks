package leetcode.editor.cn;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class ID1195FizzBuzzMultithreaded {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FizzBuzz {
        private int n;

        private AtomicInteger pos = new AtomicInteger(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public synchronized void fizz(Runnable printFizz) throws InterruptedException {
            while (pos.get() <= n) {
                if (pos.get() % 3 == 0 && pos.get() % 5 != 0) {
                    printFizz.run();
                    System.out.println(pos.get());
                    pos.set(pos.get() + 1);
                    notifyAll();
                } else {
                    wait();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public synchronized void buzz(Runnable printBuzz) throws InterruptedException {

            while (pos.get() <= n) {

                if (pos.get() % 5 == 0 && pos.get() % 3 != 0) {
                    printBuzz.run();
                    System.out.println(pos.get());
                    pos.set(pos.get() + 1);
                    notifyAll();
                } else {
                    wait();
                }
            }

        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

            while (pos.get() <= n) {
                if (pos.get() % 5 == 0 && pos.get() % 3 == 0) {

                    printFizzBuzz.run();
                    System.out.println(pos.get());
                    pos.set(pos.get() + 1);
                    notifyAll();

                } else {
                    wait();
                }
            }

        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void number(IntConsumer printNumber) throws InterruptedException {

            while (pos.get() <= n) {
                if (pos.get() % 5 != 0 && pos.get() % 3 != 0) {
                    System.out.println(pos);
                    printNumber.accept(pos.get());
                    pos.set(pos.get() + 1);
                    notifyAll();

                } else {
                    wait();
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
