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
        private boolean fooTurn = true; // 表示是否该打印foo

        public FooBar(int n) {
            this.n = n;
        }

        public synchronized void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!fooTurn) { // 如果不是foo的回合，等待
                    wait();
                }
                printFoo.run();
                fooTurn = false; // 该bar的回合
                notifyAll(); // 通知等待的bar线程
            }
        }

        public synchronized void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (fooTurn) { // 如果是foo的回合，等待
                    wait();
                }
                printBar.run();
                fooTurn = true; // 该foo的回合
                notifyAll(); // 通知等待的foo线程
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
