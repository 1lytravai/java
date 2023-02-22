public class test {
    public static BST createTree(String strKey){   
        BST tree = new BST();
        String[] spl = strKey.split(" ");
        for(int i=0; i<spl.length; i++){
            tree.insertRoot(Integer.valueOf(spl[i]));
        }
        return tree;
    }
    
    public static void main(String[] args)
    {
        String str = "50 30 20 40 70 75 74 73 72 71 60 80";
        BST tree = createTree(str);
        System.out.println();
        System.out.println("print desc: ");
        tree.RNL(tree.getRoot());
        System.out.println();
        System.out.println("LNR: (asc)");
        tree.LNR(tree.getRoot());
        System.out.println("");
        System.out.println("NLR: ");
        tree.NLR(tree.getRoot());
        System.out.println();
        System.out.println("LRN: ");
        tree.LRN(tree.getRoot());
        System.out.println();
        System.out.println("");
        System.out.println("min: "+ tree.findMin().getKey());
        System.out.println("max: "+ tree.findMax().getKey());
        System.out.println();
        System.out.println("contain 120: " + tree.contains(120));
        System.out.println("contain 20: " + tree.contains(20));
        System.out.println();
        System.out.println("---After delete 30: ");
        tree.deleteRoot(30);
        tree.LRN(tree.getRoot());
        System.out.println();
        System.out.println("---After delete min: ");
        tree.deleteMinRoot();
        tree.LRN(tree.getRoot());
        System.out.println();
        System.out.println("---After delete max: ");
        tree.deleteMaxRoot();
        tree.LRN(tree.getRoot());
        System.out.println();
        System.out.println("---After delete 74 by delete_pre: ");
        tree.delete_pre(74);
        tree.LRN(tree.getRoot());
        System.out.println();
        System.out.println();
        System.out.println("height: "+tree.height());
        System.out.println();
        System.out.println("sum: "+tree.sum());
        System.out.println("sum subtree: "+tree.sum(tree.getRoot().getRight()));
    }
}
