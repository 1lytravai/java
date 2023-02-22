import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex4 {
    static AdjacencyMatrix adj;

    public static void readfile(String path) throws FileNotFoundException {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            adj = new AdjacencyMatrix(Integer.parseInt(data));
            int count = 0;
            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                String arr[] = temp.split(" ");
                for (int i = 0; i < Integer.parseInt(data); i++) {
                    adj.setEgde(count, i, Integer.parseInt(arr[i]));
                }
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static AdjacencyList convertAL() {
        AdjacencyList AL = new AdjacencyList(adj.countVertex());
        for (int i = 0; i < adj.countVertex(); i++) {
            for (int j = 0; j < adj.countVertex(); j++) {
                if (adj.getEgde(i, j) == 1) {
                    AL.addEdge(i, j);
                }
            }
        }
        return AL;
    }

    public static void main(String[] args) throws FileNotFoundException {
        readfile("ex1.txt");

        AdjacencyList AL = convertAL();
        AL.printGraph();
    }
}
