import java.util.*;

public class Student{
    private String name;
    private double mathematics;
    private double programming;
    private double DSA1;

    public Student(){
        this.name = "";
        this.mathematics = 0;
        this.programming = 0;
        this.DSA1 = 0;
    }

    public Student(String name, double mathematics, double programming, double DSA1){
        this.name = name;
        this.mathematics = mathematics;
        this.programming = programming;
        this.DSA1 = DSA1;
    }

    public double averageGrade(){
        return (this.mathematics + this.programming + this.DSA1) / 3;
    }

    public String toString(){
        return "Student: " + this.name +", " + this.mathematics+", "+this.programming+", " + this.DSA1+", " + this.averageGrade();
    }
}