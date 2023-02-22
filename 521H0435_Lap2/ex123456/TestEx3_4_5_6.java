public class TestEx3_4_5_6 {
    public static void main(String[] args){
        Ex3Reverse A = new Ex3Reverse();
        A.pushChar("1");
        A.pushChar("2");
        A.pushChar("3");
        A.pushChar("4");
        A.pushChar("5");
        A.pushChar("6");
        A.pushChar("7");
        A.printReverse();
        System.out.println();
        //////////////////////////////////////////
        Ex4Balance B = new Ex4Balance("{[()])}");
        B.printString();
        System.out.println(B.checkBalanced());
        System.out.println();

        Ex4Balance C = new Ex4Balance("{[()]}");
        C.printString();
        System.out.println(C.checkBalanced());
        System.out.println();

        Ex4Balance D = new Ex4Balance("{{[()]}");
        D.printString();
        System.out.println(D.checkBalanced());
        System.out.println();
        /////////////////////////////////////////
        Ex5<Integer> F = new Ex5<Integer>();
        F.enQueue(1);
        F.enQueue(2);
        F.enQueue(3);
        F.enQueue(4);
        F.enQueue(5);
        F.print();
            System.out.println("Contains 1:" +F.contains(1));
        System.out.println(F.getFront());
        F.deQueue();
        System.out.println("After deQueue:");
        F.print();
            System.out.println("Contains 1:" +F.contains(1));
        System.out.println("Contains 0:" + F.contains(0));
        System.out.println(F.getFront());
        System.out.println();
        ///////////////////////////////////////////////////////
        Ex6 lab2_bai6 = new Ex6(" A man, a plan, a canal: Panama");
        System.out.println("Palindrome:"+lab2_bai6.palindrome());
        Ex6 lab2 = new Ex6("mon");
        System.out.println("Palindrome:"+lab2.palindrome());
    }

    
}
