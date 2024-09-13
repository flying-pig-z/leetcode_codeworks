package leetcode.editor.cn;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
    题目简单说就是要让first second third顺序输出。这里的思路是输出2的时候检查1有没有输出，输出3的时候检查2有没有输出。
 */
public class ID1114PrintInOrder {
    public static void main(String[] args) {
        System.out.println("学习并发编程ing");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {

        private int latterPrint = 1;

        public Foo() {
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {
            while (latterPrint != 1) {
                wait();
            }
            printFirst.run();
            latterPrint = 2;
            notifyAll();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {
            while (latterPrint != 2) {
                wait();
            }
            printSecond.run();
            latterPrint = 3;
            notifyAll();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {
            while (latterPrint != 3) {
                wait();
            }
            printThird.run();
            notifyAll();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
