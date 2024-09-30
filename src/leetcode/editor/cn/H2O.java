package leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class H2O {

    private int countO = 0;
    private int countH = 0;

    public H2O() {
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (countH >= 2) {
            System.out.println("H"+countH);
            if (countH == 2 && countO == 1) {
                countH = 0;
                countO = 0;
            }
            wait();
        }

        releaseHydrogen.run();
        countH++;

        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (countO >= 1) {
            System.out.println("O"+countO);

            if (countH == 2 && countO == 1) {
                countH = 0;
                countO = 0;
            }

            wait();
        }
        releaseOxygen.run();
        countO++;
        notifyAll();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

