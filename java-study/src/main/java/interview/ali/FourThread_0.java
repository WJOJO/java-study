package interview.ali;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁不释放会发生什么？
 */
public class FourThread_0 implements Runnable {

    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    //当前循环到的数组下标
    private static volatile int currentCount = 0;
    //打印方法实现
    private PrintFunction printFunction;
    //线程标志
    private int flag;

    public FourThread_0(int flag, PrintFunction printFunction) {
        this.flag = flag;
        this.printFunction = printFunction;
    }

    /**
     * 检查当前数组元素应该由哪个线程执行打印
     *
     * @param n 数组元素
     * @return 线程标志
     */
    private int checkFlag(int n) {
        if (n % 15 == 0) {
            return 0;
        } else if (n % 5 == 0) {
            return 1;
        } else if (n % 3 == 0) {
            return 2;
        } else {
            return 3;
        }
    }

    @FunctionalInterface
    interface PrintFunction {
        void print(int n);
    }


    @Override
    public void run() {
        while (true) {
            lock.lock();
            //数组循环结束之后直接return
            if (currentCount >= array.length) {
//                lock.unlock();
                return;
            }
            while (checkFlag(array[currentCount]) % 4 != flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (currentCount >= array.length) {
                    //数组循环完之后直接return
//                    lock.unlock();
                    return;
                }
            }
            printFunction.print(array[currentCount]);
            currentCount++;
            condition.signalAll();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new FourThread_0(0, (n) -> System.out.print("C"))).start();
        new Thread(new FourThread_0(1, (n) -> System.out.print("B"))).start();
        new Thread(new FourThread_0(2, (n) -> System.out.print("A"))).start();
        new Thread(new FourThread_0(3, System.out::print)).start();
    }

}
