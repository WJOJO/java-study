package interview.ali;

import java.util.Stack;

/**
 * 2020�Ա����˴���������
 * ʹ������ջ��Ϊ����
 */
public class StackAsQueue {

    /**
     * ������ӵ�ջ
     */
    private Stack<Integer> stackOffer = new Stack<>();
    /**
     * ���ڳ��ӵ�ջ
     */
    private Stack<Integer> stackPoll = new Stack<>();

    /**
     * ������
     * @return
     */
    public Integer poll(){
        if(stackOffer.isEmpty() && stackPoll.isEmpty()){
            throw new RuntimeException("����Ϊ��");
        }
        if(! stackPoll.isEmpty()){
            return stackPoll.pop();
        }
        if(! stackOffer.isEmpty()){
            do{
                stackPoll.push(stackOffer.pop());
            }while (stackOffer.isEmpty());
        }
        return stackOffer.pop();
    }

    /**
     * �����
     * @param e
     */
    public void offer(int e){
        stackOffer.push(e);
    }

}
