### 一.遇到的问题

刚开始我写的代码是下面这样的，思想和前面1114通过的思想差不多

```java
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

        private int fooNum = 0;
        private int barNum = 0;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (i != 0 && i != barNum + 1) {

                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooNum++;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (barNum != fooNum - 1) {
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barNum++;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

```

但是超时了，怎么进一步优化呢？这就涉及到了等待和忙等待的知识。

### 等待和忙等待

在并发编程中，线程同步和线程调度是重要的课题。等待（waiting）和忙等待（busy waiting）是两种不同的等待机制，用于让线程在等待某个条件时的行为。

#### 忙等待（Busy Waiting）

忙等待指的是线程不断地轮询检查某个条件是否满足，而在这期间不会放弃CPU时间片。忙等待通常会在一个循环中不断地检查条件，直到条件满足为止。

##### 优点：

- 实现简单，不需要特殊的同步机制。
- 在某些低延迟的情况下，可能比其他机制更有效。

##### 缺点：

- 高CPU使用率，可能导致资源浪费。
- 不适用于等待时间不确定或较长的情况。
- 会导致其他线程的执行机会减少，从而降低系统的整体性能。

**刚刚那样就是典型的忙等待，什么都不做，只是不断地轮询查询条件。**

### 等待（Waiting）

等待指的是线程在等待某个条件时，会释放CPU资源并进入等待状态，直到被通知条件满足为止。在 Java 中，通常使用 `wait()` 和 `notify()` / `notifyAll()` 方法来实现线程等待和唤醒机制。

#### 优点：

- 低CPU使用率，线程在等待时不会消耗CPU时间。
- 更加高效，适用于等待时间不确定或较长的情况。
- 可以更好地与其他线程协调，提高系统的整体性能。

#### 缺点：

- 实现稍微复杂，需要使用同步机制（如`synchronized`关键字）。
- 需要注意避免死锁和虚假唤醒等问题。

### 优化代码

```java
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
```

> 注：在调用 `wait()` 和 `notify()` 方法时必须使用 `synchronized` 关键字，以确保线程在等待和唤醒时正确获取和释放对象的监视器锁，避免竞争条件和死锁问题，从而实现线程间的正确协调与通信。这是 Java 线程同步机制的重要部分，有助于编写安全和可靠的多线程程序。

- **忙等待（Busy Waiting）**：线程不断轮询检查条件，CPU资源消耗高，适用于短期等待或低延迟场景。
- **等待（Waiting）**：线程进入等待状态，释放CPU资源，适用于不确定或较长时间的等待，效率更高。

选择哪种机制取决于具体的应用场景和性能需求。在大多数情况下，使用等待（waiting）机制会更加高效和资源友好。