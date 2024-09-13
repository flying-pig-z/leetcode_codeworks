package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID1115PrintFoobarAlternately {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 简单说思路就是打印完一个Foo才能打印bar
    class FooBar {
        private int n;

        private boolean order = true;//order为true打印foo

        public FooBar(int n) {
            this.n = n;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!order) {
                    wait();
                }
                printFoo.run();
                order = false;
                notifyAll();
            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (order) {
                    wait();
                }
                printBar.run();
                order = true;
                notifyAll();
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
