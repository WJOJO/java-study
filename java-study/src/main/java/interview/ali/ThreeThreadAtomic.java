package interview.ali;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ԭ�Ӳ�����ʵ�����̴߳�ӡ
 * */

public class ThreeThreadAtomic implements Runnable{

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    //�̱߳�־
    private int flag;
    //������еĴ�ӡ�ַ���
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
