public class Node{
    private Integer key;
    private Node left, right;

    public Node(Integer key){
        this.key = key;
        this.left = this.right = null;
    }

    public void setKey(Integer x){
        key = x;
    }

    public Integer getKey(){
        return key;
    }

    public void setLeft(Node x){
        left = x;
    }

    public Node getLeft(){
        return left;
    }

    public void setRight(Node x){
        right = x;
    }

    public Node getRight(){
        return right;
    }
}