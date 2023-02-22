import java.util.Comparator;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList <Student> st = new ArrayList<Student>();
        
        st.add(new Student("Gia My", 10, 10, 9.9));
        st.add(new Student("Bao An", 6, 7, 8));
        st.add(new Student("Be Lieng", 7, 3, 7));
        System.out.println();
        System.out.println("------------------Sort Ascending-------------------");
        Collections.sort(st, new Ascending());
        for (Student student : st) {
            System.out.println(student.toString());
        }
        System.out.println();
        
        System.out.println("------------------Sort Descending------------------");
        Collections.sort(st, new Descending());
        for (Student student : st) {
            System.out.println(student.toString());
        }
        System.out.println();
     }
 }
