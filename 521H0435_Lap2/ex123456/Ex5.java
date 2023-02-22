import java.util.*;
public class Ex5 <E> implements QueueInterface <E> {
    private MyStack<E> stack1 = new MyStack<E>();
    private MyStack<E> stack2 = new MyStack<E>();

    @Override
    public void enQueue(E item) {
        if(stack1.isEmpty()) this.stack1.push(item);
        else {
            while(stack1.isEmpty()==false){
                stack2.push(stack1.getPeek());
                this.stack1.pop();
            }
            stack1.push(item);
            while(stack2.isEmpty()==false){
                stack1.push(stack2.getPeek());
                this.stack2.pop();
            }
        }
    }

    @Override
    public E deQueue(){
        if(this.stack1.isEmpty()) throw new EmptyStackException();
        return stack1.pop();
    }

    @Override
    public int size() {
        return this.stack1.size();
    }

    @Override
    public boolean contains(E item) {
        return this.stack1.contains(item);
    }

    @Override
    public void print() {
        this.stack1.print();    
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return this.stack1.isEmpty();
    }

    @Override
    public E getFront() {
        return this.stack1.getPeek();
    }
}
