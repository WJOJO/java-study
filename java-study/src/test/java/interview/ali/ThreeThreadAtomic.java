package interview.ali;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子操作类实现三线程打印
 * */

public class ThreeThreadAtomic implements Runnable{

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    //线程标志
    private int flag;
    //对象持有的打印字符串
    private String str;


    public ThreeThreadAtomic(String str, int flag) {
        this.flag = flag;
        this.str = str;
    }

    @Override
    public void run() {
        while(true){
            while(atomicInteger.get() % 3 == flag){
                System.out.print(str);
                atomicInteger.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreeThreadAtomic("A", 0)).start();
        new Thread(new ThreeThreadAtomic("B", 1)).start();
        new Thread(new ThreeThreadAtomic("C", 2)).start();
    }
}
