import java.util.Comparator;  

//tang dan
public class Ascending implements Comparator<Student>{
    public int compare(Student st1, Student st2){
        if(st1.averageGrade() == st2.averageGrade()){
            return 0;
        }
        else if(st1.averageGrade() > st2.averageGrade()){
            return 1;
        }
        else {
            return -1;
        }
    }
}
