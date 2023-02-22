import java.util.Comparator;

//giam dan 
public class Descending implements Comparator<Student>{
    public int compare(Student st1, Student st2){
        if(st1.averageGrade() == st2.averageGrade()){
            return 0;
        }
        else if(st1.averageGrade() < st2.averageGrade()){
            return 1;
        }
        else {
            return -1;
        }
    }
}
