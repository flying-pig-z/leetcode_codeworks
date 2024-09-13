package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.util.*;

public class ID1226TheDiningPhilosophers {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class DiningPhilosophers {

        public DiningPhilosophers() {


        }

        // call the run() method of any runnable to execute its code
        public synchronized void wantsToEat(int philosopher,
                                            Runnable pickLeftFork,
                                            Runnable pickRightFork,
                                            Runnable eat,
                                            Runnable putLeftFork,
                                            Runnable putRightFork) throws InterruptedException {
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
                notifyAll();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
