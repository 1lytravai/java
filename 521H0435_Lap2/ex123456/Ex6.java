public class Ex6 {
    private MyStack<Character> stack = new MyStack<Character>();
    private MyQueue<Character> queue = new MyQueue<Character>();
    private String str;

    public Ex6(String str){
        this.str = str;
    }

    public boolean palindrome(){
        //getEachChar
        char tmp;
        for(int i=0; i<this.str.length(); i++){
            tmp = this.str.charAt(i);
            if(Character.isLetter(tmp)) {
                stack.push(tmp);
                queue.enQueue(tmp);
            }
        }
        //checkPalindrome
        while(!stack.isEmpty()){
            while(!queue.isEmpty()){
                char charStack = stack.pop();
                char charQueue = queue.deQueue();
                if(Character.toString(charStack).equalsIgnoreCase(Character.toString(charQueue))==false){
                    return false;
                }
            }
        }
        return true;
    }
}