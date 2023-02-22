public class IntLinkedList{
    private Node head;
    private int numNode;
    
    public IntLinkedList(){
        this.head = null;
        this.numNode =0;
    }
    public void addFirst(int data) {
        head = new Node(data,head);
        numNode++;
    }
    public boolean addLast(int data) {
        //checl contains
        Node tmp = head;
        while(tmp!= null) {
            if(tmp.getData() == data) {
                return false;
            }
            tmp = tmp.getNext();
        }
        if(head==null) addFirst(data);
        else { 
            Node temp = head;
            while(temp.getNext()!= null){
                temp=temp.getNext();
            }
            Node newNode = new Node(data,null);
            temp.setNext(newNode);
            numNode++;
        }
        return true;
    }
    public boolean removeAt(int position) {
        if(position>this.numNode) return false;
        Node tmp = head;
        Node preTmp = null;
        int dem =1;
        while(tmp!=null && dem!=position){
            preTmp=tmp;
            tmp=tmp.getNext();
            dem++;
        }
        preTmp.setNext(tmp.getNext());
        numNode--;
        return true;
    }
    public int countOdd() {
        Node tmp = head;
        int count=0;
        while(tmp!=null) {
            if( tmp.getData()%2!=0) {
                count++;
            }
        }
        return count;
    }
    public int searchKey(int key) {
        Node tmp = head;
        int dem=1;
        while(tmp!=null) {
            if(tmp.getData()==key) {
                return dem;
            }
            tmp=tmp.getNext();
            dem++;
        }
        return -1;
    }


    
    public void print(){
        Node tmp = head.getNext();
        System.out.print(""+head.getData());
        while(tmp!=null) {
            System.out.print(" -> "+ tmp.getData());
            tmp=tmp.getNext();
        }
        System.out.println();
    }
}