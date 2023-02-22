import java.util.*;
import java.util.Scanner;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMathematics() {
        return mathematics;
    }

    public void setMathematics(double mathematics) {
        this.mathematics = mathematics;
    }

    public double getProgramming() {
        return programming;
    }

    public void setProgramming(double programming) {
        this.programming = programming;
    }

    public double getDSA1() {
        return DSA1;
    }

    public void setDSA1(double dSA1) {
        DSA1 = dSA1;
    }
    
    public static void main(String[] args) {
        Iteration test = new Iteration();
        System.out.println(test.calculationExp(2, 4));
        System.out.println(test.calculationFactorial(5));
        System.out.println(test.countDigit(1025));
        System.out.println(test.isPrime(4));
        System.out.println(test.isPrime(5));
        System.out.println(test.gcd(10, 45));
        System.out.println(test.gcd(45,30));

        
    }
}