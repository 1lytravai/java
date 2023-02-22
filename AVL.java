import java.util.ArrayList;

public class AVL {
    protected Node root;

    public AVL() {
        root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(Student key) {
        this.root = insert(this.root, key);
    }

    private Node insert(Node node, Student key) {
        // code here
        if (node == null)
            return (new Node(key));

        int cmp = key.compareTo(node.getData());
        if (cmp == -1)
            node.setLeft(insert(node.getLeft(), key));
        if (cmp == 1)
            node.setRight(insert(node.getRight(), key));

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        return balance(node);
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node node, int key) {

        // code here
        if (node == null)
            return null;
        if (node.getData().getId() > key)
            return search(node.getLeft(), key);
        else if (node.getData().getId() < key)
            return search(node.getRight(), key);
        else
            return node;
    }

    public void delete(Student key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Student key) {
        // code here
        if (x == null)
            return null;

        int cmp = key.compareTo(x.getData());
        if (cmp == -1)
            x.setLeft(delete(x.getLeft(), key));
        else if (cmp == 1)
            x.setRight(delete(x.getRight(), key));
        else {
            // node with only one child or no child
            if (x.getRight() == null)
                return x.getLeft();
            if (x.getLeft() == null)
                return x.getRight();
            // node with two children: Get the successor (smallest in the right subtree)
            x.setData(findMin(x.getRight()).getData());
            x.setRight(deleteMin(x.getRight()));
        }

        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        return balance(x);

    }

    // ------------------Supported methods------------------

    public int height() {
        return height(root);
    }

    protected int height(Node node) {
        if (node == null)
            return -1;
        return node.getHeight();
    }

    private Node rotateLeft(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        return y;
    }

    private Node rotateRight(Node x) {
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        return y;
    }

    private int checkBalance(Node x) {
        return height(x.getLeft()) - height(x.getRight());
    }

    protected Node balance(Node x) {
        if (checkBalance(x) < -1) {
            if (checkBalance(x.getRight()) > 0) {
                x.setRight(rotateRight(x.getRight()));
            }
            x = rotateLeft(x);
        } else if (checkBalance(x) > 1) {
            if (checkBalance(x.getLeft()) < 0) {
                x.setLeft(rotateLeft(x.getLeft()));
            }
            x = rotateRight(x);
        }
        return x;
    }

    public ArrayList<Node> NLR() {
        ArrayList<Node> result = new ArrayList<Node>();
        NLR(this.root, result);
        return result;
    }

    private void NLR(Node node, ArrayList<Node> result) {
        if (node != null) {
            result.add(node);
            NLR(node.getLeft(), result);
            NLR(node.getRight(), result);
        }
    }

    public Node copyTreeAVL() {
        return copyTreeAVL(this.root);
    }
    
    private Node copyTreeAVL(Node node){
        if(node == null){
            return null;
        }
        Node newNode = new Node(node.getData());
        newNode.setRight(copyTreeAVL(node.getRight()));
        newNode.setLeft(copyTreeAVL(node.getLeft())); 
        newNode.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        return newNode;
    }  
    

    private Node deleteMin(Node x) {
        if (x.getLeft() == null)
            return x.getRight();
        x.setLeft(deleteMin(x.getLeft()));
        return x;
    }

    private Node findMin(Node x) {
        if (x.getLeft() == null)
            return x;
        else
            return findMin(x.getLeft());
    }

    public boolean contain(int id) {
        return search(root, id) == null ? false : true;
    }

}
