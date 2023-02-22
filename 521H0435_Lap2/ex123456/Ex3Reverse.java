public class Ex3Reverse {
    MyStack<String> stack = new MyStack<String>();

    public Ex3Reverse(){
        System.out.print("");
    }

    public void pushChar(String a){
        this.stack.push(a);
    }

    public void printReverse(){
        stack.print();
        System.out.println();
    }
}