package leetcode.editor.cn;
import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore secondSemaphore = new Semaphore(0);  // 开始时，second 线程不能执行
    private Semaphore thirdSemaphore = new Semaphore(0);   // 开始时，third 线程不能执行

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        secondSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondSemaphore.acquire();
        printSecond.run();
        thirdSemaphore.release();
    }

    public void third(Runnable printSecond) throws InterruptedException {
        printSecond.run();
    }
}
