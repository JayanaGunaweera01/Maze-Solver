//H.K.J.N.Gunaweera
//w1810567
//20200003

import org.junit.jupiter.api.Test;
import puzzles.BFS;
import puzzles.Location;
import puzzles.util.InputReader;
import java.util.ArrayList;
import java.util.List;

class MainTest {

    //Doubling the node count
    public void doubleIndex(int count, List<List<String>> grid) {

        List<String> testRow = new ArrayList<>();

        for (int i = 0; i < (Math.pow(2, count) - 1); i++) {
            testRow.addAll(grid.get(1));
        }

        for (List<String> strings : grid) {
            strings.addAll(testRow);
        }

        System.out.println("row: " + grid.size());
        System.out.println("col: " + grid.get(0).size());
        System.out.println("Node count: " + grid.get(0).size()*grid.size());
    }

    //Analyzer
    @Test
    void analyze() {

        List<List<String>> grid;

        for(int x = 0; x< 14; x++) {
            grid = InputReader.readFile("defaultWorst.txt");
            doubleIndex(x, grid);

            List<Double> timeList = new ArrayList();
            for (int i = 0; i < 11; i++) {

                long start = System.currentTimeMillis();

                BFS pathFinder = new BFS(grid);
                pathFinder.find();

                long current = System.currentTimeMillis();
                double elapsed = (current - start) / 1000.0;


                timeList.add(elapsed);

            }

            timeList.remove(0);

            double mean = timeList.stream().mapToDouble(n -> n).sum() / 10;

            System.out.println("time : " + mean);
            System.out.println("-------------------------------------------------------------------\n");
        }
    }

    //Getting example files
    @Test
    void runExamplesFiles() {

        String[] examples1FileArray = {
                "examples/maze10_1.txt",
                "examples/maze10_2.txt",
                "examples/maze10_3.txt",
                "examples/maze10_4.txt",
                "examples/maze10_5.txt",
                "examples/maze15_1.txt",
                "examples/maze15_2.txt",
                "examples/maze15_3.txt",
                "examples/maze15_4.txt",
                "examples/maze15_5.txt",
                "examples/maze20_1.txt",
                "examples/maze20_2.txt",
                "examples/maze20_3.txt",
                "examples/maze20_4.txt",
                "examples/maze20_5.txt",
                "examples/maze25_1.txt",
                "examples/maze25_2.txt",
                "examples/maze25_3.txt",
                "examples/maze25_4.txt",
                "examples/maze25_5.txt",
                "examples/maze30_1.txt",
                "examples/maze30_2.txt",
                "examples/maze30_3.txt",
                "examples/maze30_4.txt",
                "examples/maze30_5.txt"};


        List<List<String>>  grid ;

        for (String fileName : examples1FileArray) {
            System.out.println("File name : "+ fileName);

            grid = InputReader.readFile(fileName);
            long start = System.currentTimeMillis();

            BFS pathFinder = new BFS(grid);
            List<Location> path = pathFinder.find();
            pathFinder.showPath(path);

            long current = System.currentTimeMillis();
            double elapsed = (current - start) / 1000.0;

            System.out.println("time : " + elapsed);
            System.out.println("-------------------------------------------------------------------\n");
        }
    }

    //Getting example_2 files
    @Test
    void runExample2() {

        String[] examples2FileArray = {
                "examples_2/puzzle_20.txt",
                "examples_2/puzzle_40.txt",
                "examples_2/puzzle_80.txt",
                "examples_2/puzzle_160.txt",
                "examples_2/puzzle_320.txt",
                "examples_2/puzzle_640.txt",
                "examples_2/puzzle_1280.txt",
                "examples_2/puzzle_2560.txt"
        };

        List<List<String>>  grid ;

        for (String fileName : examples2FileArray) {

            System.out.println("File name : "+ fileName);

            grid = InputReader.readFile(fileName);
            long start = System.currentTimeMillis();

            BFS pathFinder = new BFS(grid);
            List<Location> path = pathFinder.find();
            System.out.println(path);

            long current = System.currentTimeMillis();
            double elapsed = (current - start) / 1000.0;

            System.out.println("time : " + elapsed);
            System.out.println("-------------------------------------------------------------------\n");
        }
    }
}
