package puzzles.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    private InputReader() {}

    /**
     * this method can read text file. and create ArrayList including all the element from text file
     *
     * @param fileName text file name need to read
     */
    public static List<List<String>> readFile(String fileName) {

        List<List<String>> grid = new ArrayList<>();

        try {
            File inputFile = new File(fileName);
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                List<String> dList = new ArrayList<>();

                for (int i = 0; i < data.length(); i++) {
                    dList.add(String.valueOf(data.charAt(i)));
                }
                grid.add(dList);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return grid;
    }
}
