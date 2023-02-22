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
        if(!redoState.isEmpty()) redoState.clear();
        if (!tree.contain(st.getId())) {
            if (tree.getRoot() != null) {
                undoState.push(tree.copyTree());
            }
            tree.insert(st);
            return true;
        }
        return false;

    }

    // Requirement 2
    public Student searchStudentById(int id) {
        if(!redoState.isEmpty()) redoState.clear();
        if (tree.search(id) != null) {
            return tree.search(id).getData();
        }
        return null;
    }

    // Requirement 3
    public boolean removeStudent(int id) {
        if(!redoState.isEmpty()) redoState.clear();
        if (tree.contain(id)) {
            undoState.push(tree.copyTree());
            tree.delete(searchStudentById(id));
            return true;
        }
        return false;
    }

    // Requirement 4
    public void undo() {
        if (undoState.isEmpty()) {
            tree.setRoot(null);
        } else {
            redoState.push(tree.copyTree());
            tree.setRoot(undoState.pop());
        }
    }

    // Requirement 5
    public void redo() {
        if (!redoState.isEmpty()) {
            tree.setRoot(redoState.pop());
        }
    }

    // Requirement 6
    // public ScoreAVL scoreTree(AVL tree) {
        
    // }
}