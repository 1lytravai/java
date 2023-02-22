import java.util.*;
public class BST {
    private Node root;

    public BST(){
        root = null;
    }

    public BST(Integer Key){
        root = new Node(Key);
    }

    public Node getRoot(){
        return this.root;
    }
    //ex1:
    public void insertRoot(Integer key){
        root = insert(root, key);
    }

    private Node insert(Node x, Integer key){
        if(x==null){
            x= new Node(key);
            return x;
        }
        int cmp = key.compareTo(x.getKey());
        if(cmp<0)
            x.setLeft(insert(x.getLeft(), key));
        else if(cmp>0)
            x.setRight(insert(x.getRight(), key));
        else
            x.setKey(key);
        return x;
    }

    public void NLR(Node x){
        if(x!=null){
            System.out.print(x.getKey()+" ");
            NLR(x.getLeft());
            NLR(x.getRight());
        }
    }
    //ex2
    public void LNR(Node x){
        if(x!=null){
            LNR(x.getLeft());
            System.out.print(x.getKey()+" ");
            LNR(x.getRight());
        }
    }
    public void LRN(Node x){
        if(x!=null){
            LRN(x.getLeft());
            LRN(x.getRight());
            System.out.print(x.getKey()+" ");
        }
    }
    //ex3
    public void RNL(Node x){
        if(x!=null){
            RNL(x.getRight());
            System.out.print(x.getKey()+" ");
            RNL(x.getLeft());
        }
    }
    public Node searchRoot(Integer Key){
        return search(root, Key);
    }

    
    private Node search(Node x, Integer key){
        if(x==null){
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if(cmp<0){
            return search(x.getLeft(), key);
        }
        else if(cmp>0){
            return search(x.getRight(), key);
        }
        else
            return x;
    }

    public Node findMin(){
        return min(root);
    }

    private Node min(Node x){
        if (x.getLeft() == null){
            return x;
        }
        else{
            return min(x.getLeft());
        }
    }

    public Node findMax(){
        return max(root);
    }

    private Node max(Node x){
        if (x.getRight() == null){
            return x;
        }
        else{
            return max(x.getRight());
        }
    }

    public Node deleteMinRoot(){
        return deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.getLeft() == null){
            return x.getRight();
        }
        x.setLeft(deleteMin(x.getLeft()));
        return x;
    }

    public Node deleteMaxRoot(){
        return deleteMax(root);
    }

    private Node deleteMax(Node x){
        if (x.getRight() == null){
            return x.getLeft();
        }
        x.setRight(deleteMax(x.getRight()));
        return x;
    }

    public Node deleteRoot(Integer Key){
        return delete(root, Key);
    }

    private Node delete(Node x, Integer Key){
        if(x==null){
            return null;
        }
        int cmp = Key.compareTo(x.getKey());
        if(cmp<0){
            x.setLeft(delete(x.getLeft(), Key));
        }
        else if(cmp>0){
            x.setRight(delete(x.getRight(), Key));
        }
        else{
            if (x.getRight() == null)
                return x.getLeft();
            if (x.getLeft() == null)
                return x.getRight();

            Node t = x;
            x = min(t.getRight());

            x.setRight(deleteMin(t.getRight()));

            x.setLeft(t.getLeft());
        }
        return x;
    }

    public void delete_pre(Integer Key){
        deletePre(root, Key);
    }

    private Node deletePre(Node x, Integer Key){
        if(x==null){
            return null;
        }
        int cmp = Key.compareTo(x.getKey());
        if(cmp<0){
            x.setLeft(delete(x.getLeft(), Key));
        }
        else if(cmp>0){
            x.setRight(delete(x.getRight(), Key));
        }
        else{
            if (x.getRight() == null)
                return x.getLeft();
            if (x.getLeft() == null)
                return x.getRight();

            Node t = x;
            x = min(t.getLeft());

            x.setRight(deleteMin(t.getLeft()));

            x.setLeft(t.getRight());
        }
        return x;
    }

    public boolean contains(Integer Key){
        return find(root, Key);
    }

    private boolean find(Node x, Integer Key){
        if(x==null){
            return false;
        }
        int cmp = Key.compareTo(x.getKey());
        if(cmp>0){
            return find(x.getRight(), Key);
        }
        else if(cmp < 0){
            return find(x.getLeft(),Key);
        }
        else{
            return true;
        }
    }

    public int height(){
        return maxHeight(root);
    }

    private int maxHeight(Node x){
        if(x==null){
            return 0;
        }
        else{
            if(maxHeight(x.getLeft())>maxHeight(x.getRight())){
                return maxHeight(x.getLeft())+1;
            }
            else{
                return maxHeight(x.getRight())+1;
            }
        }
    }

    public Integer sum(Node x){
        if(x == null){
            return 0;
        }
        else{
            return sum(x.getLeft())+sum(x.getRight())+x.getKey();
        }
    }

    public Integer sum(){
        return sum(root);
    }
    
}

