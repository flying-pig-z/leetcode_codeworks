package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import leetcode.editor.util.*;

/*
    题目简单说就是要让first second third顺序输出。这里的思路是输出2的时候检查1有没有输出，输出3的时候检查2有没有输出。
 */
public class ID1114PrintInOrder {
    public static void main(String[] args) {
        System.out.println("学习并发编程ing");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Foo {

        private AtomicBoolean printFirstOrNot = new AtomicBoolean(false);
        private AtomicBoolean printSecondOrNot = new AtomicBoolean(false);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // first方法输出first，这里题目已经实现好了Runnable接口的run方法，我们直接调用输出first即可
            printFirst.run();
            // 标记first已经打印
            printFirstOrNot.set(true);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // 如果first还没打印就进行阻塞
            while (!printFirstOrNot.get()) {
            }
            // 打印second
            printSecond.run();
            // 标记second已经打印
            printSecondOrNot.set(true);

        }

        public void third(Runnable printThird) throws InterruptedException {
            // 如果second没有打印就进行阻塞
            while (!printSecondOrNot.get()) {
            }
            // 打印third
            printThird.run();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
