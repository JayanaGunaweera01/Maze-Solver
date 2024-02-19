//H.K.J.N.Gunaweera
//w1810567
//20200003

package puzzles;
import puzzles.util.InputReader;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("                               WELCOME \n" +
                " ==========================SLIDING PUZZLES=====================\n\n");
        System.out.println("Type \"quit\" as file name to exit !");
        System.out.println("When inserting the file name, use the absolute path or relative path w.r.t. the path of the executing code...");

        Scanner scanner = new Scanner(System.in);
        String filename;
        while (true) {
            System.out.println("\n\n==============================================================================\n");
            System.out.print("Enter file name: ");
            filename = scanner.nextLine();
            if (filename.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                List<List<String>> grid = InputReader.readFile(filename);
                long start = System.currentTimeMillis();
                BFS pathFinder = new BFS(grid);
                pathFinder.find();
                List<Location> path = pathFinder.find();
                pathFinder.showPath(path);

                long current = System.currentTimeMillis();
                double elapsed = (current - start) / 1000.0;

                System.out.println("time : " + elapsed);
            } catch (Exception e) {
                System.out.println("An error occurred... " + e.getMessage());
            }

        }
        scanner.close();
    }
}
