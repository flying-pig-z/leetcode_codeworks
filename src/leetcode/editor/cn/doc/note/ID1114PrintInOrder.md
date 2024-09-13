## 1.原子类

AtomicInteger 是 Java 中提供的一个原子操作类。

使用原子的方式更新基本类型有如下这些：

AtomicInteger：整型原子类
AtomicLong：长整型原子类
AtomicBoolean：布尔型原子类

原子类型首先来说它具有可见性，也就是线程之间获得到的数据是共通的；

另外它还是线程安全的，使用CAS乐观锁实现，可以避免多个线程同时修改一个整数时可能引发的竞态条件和数据不一致性问题。

## 2.Runnable接口

Runnable里面有run方法

使用示例：

````java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 定义任务
        System.out.println("Hello from a thread!");
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();  // 启动线程
    }
}
````

## 3.实现思路

题目简单说就是要让first second third顺序输出，就用一个全线程可见的变量控制要打印什么。

具体实现：

```java
class Foo {

    private AtomicInteger latterPrint = new AtomicInteger(1);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (latterPrint.get() != 1) {
        }
        printFirst.run();
        latterPrint.set(2);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (latterPrint.get() != 2) {
        }
        printSecond.run();
        latterPrint.set(3);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (latterPrint.get() != 3) {
        }
        printThird.run();
    }
}
```

> 其实这里并没有并发问题，使用volatile保证可见性就可以了。但是使用AtomicInteger也没什么问题就是啦。

## 4.wait+notify解决悲观锁使用过程中循环产生的忙等待

原子类使用的是CAS乐观锁，那如果我们使用的是悲观锁synchronized，那么这时候再使用while循环就会忙等待。

忙等待就是while循环会一直占着CPU不变，一直重试，这就是忙等待。

我们就要让那些不用工作的时候别在那里一直等，而是放弃CPU，先睡一会。等需要主线程工作完的时候再唤醒其他线程，看看哪些线程需要工作，它进行工作，然后还需要等待的其他线程再让它们继续睡一会。

我们要使用wait语句让它先不要占着CPU，当打印完first后，唤醒打印second，打印完second后，再唤醒打印third。

我们只要在while循环中加入wait()方法让该等待的线程进行睡眠，并在线程执行完使用notify方法通知线程看看需不需要工作就可以了。

```java
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

```

需要注意的是使用wait和notifyAll的线程需要经过synchronized修饰。

使用synchronized修饰方法相当于用synchronized将方法中的流程包起来：

````java
class Foo {
    // 比如这个方法
    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (latterPrint != 3) {
            wait();
        }
        printThird.run();
        notifyAll();
    }

    // 其实相当于
    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (latterPrint != 3) {
                wait();
            }
            printThird.run();
            notifyAll();
        }

    }
}
````

同时使用synchronized之后，因为它默认进入其中的变量都具有可见性，同时它的线程执行也有原子性。
