public class Ex4Balance {
    MyStack<Character> stack = new MyStack<Character>();
    private String str ;


    public Ex4Balance(String str){
        this.str = str;
    }

    public void printString(){
        System.out.println(this.str);
    }

    public boolean checkBalanced(){
        char c = str.charAt(0);
        // if( c=='}'|| c==')'|| c==']'){
        //     return false;
        // }
        for(int i =0; i<str.length();i++){
            c= str.charAt(i);
            if( c=='{'||c=='('||c=='[') {
                this.stack.push(c);
            }
            if( c=='}'){
                if(this.stack.getPeek()=='{') this.stack.pop();
                else return false;
            }
            if(c==')'){
                if(this.stack.getPeek()=='(') this.stack.pop();
                else return false;
            }
            if(c==']'){
                if(this.stack.getPeek()=='[') this.stack.pop();
                else return false;
            }
        }      
        if(this.stack.isEmpty()) return true;
        return false;  
    }
}