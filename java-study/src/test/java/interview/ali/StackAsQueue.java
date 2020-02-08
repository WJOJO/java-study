package interview.ali;

import java.util.Stack;

/**
 * 2020淘宝联盟代码面试题
 * 使用两个栈作为队列
 */
public class StackAsQueue {

    /**
     * 用于入队的栈
     */
    private Stack<Integer> stackOffer = new Stack<>();
    /**
     * 用于出队的栈
     */
    private Stack<Integer> stackPoll = new Stack<>();

    /**
     * 出队列
     * @return
     */
    public Integer poll(){
        if(stackOffer.isEmpty() && stackPoll.isEmpty()){
            throw new RuntimeException("队列为空");
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
     * 入队列
     * @param e
     */
    public void offer(int e){
        stackOffer.push(e);
    }

}
