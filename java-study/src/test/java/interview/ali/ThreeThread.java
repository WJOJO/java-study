package interview.ali;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三线程打印A L I
 */
public class ThreeThread implements Runnable{

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile int times;

    private String str;
    private int threadCount;

    @Override
    public void run(){
        try {
            while(times <= 30){
                lock.lock();
                while(times % 3 != threadCount){
                    condition.await();
                }
                System.out.println(str);
                times ++;
                condition.signalAll();
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreeThread(String str, int threadCount) {
        this.str = str;
        this.threadCount = threadCount;
    }

    public static void main(String[] args) {
        new Thread(new ThreeThread("A", 0)).start();
        new Thread(new ThreeThread("l", 1)).start();
        new Thread(new ThreeThread("i", 2)).start();
    }

}
