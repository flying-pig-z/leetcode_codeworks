package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;


//leetcode submit region begin(Prohibit modification and deletion)
class H2O {

    int count = 0;

    int HCount = 0;
    int OCount = 0;

    public H2O() {

    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        System.out.println(HCount);
        if (HCount < 2) {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            count++;
            HCount++;
            if (count % 3 == 0) {
                HCount = 0;
                OCount = 0;
            }
            notifyAll();
            releaseHydrogen.run();
        } else {
            wait();
        }

    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        if (OCount < 1) {
            count++;
            OCount++;
            if (count % 3 == 0) {
                HCount = 0;
                OCount = 0;
            }
            notifyAll();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        } else {
            wait();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

