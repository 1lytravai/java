import java.util.*;

public class StudentManagement {
    private AVL tree;
    private Stack<Node> undoState;
    private Stack<Node> redoState;

    public StudentManagement() {
        this.tree = new AVL();
        this.undoState = new Stack<Node>();
        this.redoState = new Stack<Node>();
    }

    public AVL getTree() {
        return this.tree;
    }

    // Requirement 1
    public boolean addStudent(Student st) {
        if (tree.contain(st.getId()))
            return false;
        tree.insert(st);
        return true;
    }

    // Requirement 2
    public Student searchStudentById(int id) {
        // code here
        if (tree.contain(id))
            return tree.search(id).getData();
        return null;
    }

    // Requirement 3
    public boolean removeStudent(int id) {
        // code here
        if (tree.contain(id)) {
            undoState.push(tree.copyTreeAVL());
            tree.delete(tree.search(id).getData());
            return true;
        }
        return false;
    }

    // Requirement 4
    public void undo() {
        // code here
        if (undoState.size() > 0) {
            redoState.push(tree.copyTreeAVL());
            tree.setRoot(undoState.pop());
        } else {
            tree.setRoot(null);
        }
    }

    // Requirement 5
    public void redo() {
        // code here
        if (redoState.isEmpty()) {
            tree.setRoot(redoState.pop());
        }
    }

    // Requirement 6
    public ScoreAVL scoreTree(AVL tree) {
        // code here
        return null;
    }
}
