
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex3 {
    static EdgeList EL;

    public static void readfile(String path) throws FileNotFoundException {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            EL = new EdgeList();

            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                String arr[] = temp.split(" ");

                EL.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        readfile("ex3.txt");
        EL.printGraph();
        System.out.println(EL.countEdge());
        System.out.println(EL.countVertext());
        System.out.println(EL.EnumerateNeighbors(1));
        System.out.println(EL.checkNeighbors(1, 1));
    }
}
