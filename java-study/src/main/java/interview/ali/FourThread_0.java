package interview.ali;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �����ͷŻᷢ��ʲô��
 */
public class FourThread_0 implements Runnable {

    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    //��ǰѭ�����������±�
    private static volatile int currentCount = 0;
    //��ӡ����ʵ��
    private PrintFunction printFunction;
    //�̱߳�־
    private int flag;

    public FourThread_0(int flag, PrintFunction printFunction) {
        this.flag = flag;
        this.printFunction = printFunction;
    }

    /**
     * ��鵱ǰ����Ԫ��Ӧ�����ĸ��߳�ִ�д�ӡ
     *
     * @param n ����Ԫ��
     * @return �̱߳�־
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
            //����ѭ������֮��ֱ��return
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
                    //����ѭ����֮��ֱ��return
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
