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
        // neu het cay thi tao node moi
        if (node == null)
            return new Node(key);
        if (key.compareTo(node.getData()) == 0)
            return node;
        // nho hon sang trai
        if (key.compareTo(node.getData()) == -1)
            node.setLeft(insert(node.getLeft(), key));
        // lon hon sang phai
        if (key.compareTo(node.getData()) == 1)
            node.setRight(insert(node.getRight(), key));
        // chinh lai chieu cao
        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        // can bang cay
        return balance(node);
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node node, int key) {
        // het cay tra ra khong co
        if (node == null)
            return null;
        // nho hon sang trai tim
        if (key < node.getData().getId())
            return search(node.getLeft(), key);
        // lon hon sang phai tim
        if (key > node.getData().getId())
            return search(node.getRight(), key);
        // co node thi tra ve node chua key can tim
        return node;
    }

    public void delete(Student key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Student key) {
        // het cay khong co node can xoa thi tra ra khong co
        if (x == null)
            return null;
        // so sanh du lieu node nao can xoa
        if (key.compareTo(x.getData()) == 0) {
            // truong hop co 1 node con
            if (x.getLeft() == null)
                return x.getRight();
            if (x.getRight() == null)
                return x.getLeft();
            // truong hop 2 con thi lay predecessor
            x.setData(findMin(x.getRight()).getData());
            x.setRight(deleteMin(x.getRight()));
        }
        // nho hon sang trai tim
        if (key.compareTo(x.getData()) == -1)
            x.setLeft(delete(x.getLeft(), key));
        // lon hon sang phai tim
        if (key.compareTo(x.getData()) == 1)
            x.setRight(delete(x.getRight(), key));
        // tinh lai height
        x.setHeight(max(height(x.getRight()), height(x.getLeft())) + 1);
        // can bang cay
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

    private int max(int left, int right) {
        return (left > right) ? left : right;
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

    public ArrayList<Node> levelOrder() {
        ArrayList<Node> res = new ArrayList<Node>();
        levelOrder(this.root, res);
        return res;
    }

    private void givenLevel(Node node, int level, ArrayList<Node> res) {
        if (node != null) {
            if (level == 1)
                res.add(node);
            else {
                givenLevel(node.getLeft(), level - 1, res);
                givenLevel(node.getRight(), level - 1, res);
            }
        }
    }

    private void levelOrder(Node node, ArrayList<Node> res) {
        if (node != null) {
            for (int i = 0; i <= height(node); i++) {
                givenLevel(node, i + 1, res);
            }
        }
    }

    public Node copyTree() {
        return copyTree(this.root);
    }

    private Node copyTree(Node node) {
        if (node != null) {
            Node tmp = new Node(node.getData());
            tmp.setLeft(copyTree(node.getLeft()));
            tmp.setRight(copyTree(node.getRight()));
            tmp.setHeight(max(height(tmp.getRight()), height(tmp.getLeft())) + 1);
            return tmp;
        }
        return null;
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
