package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_19_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_18_01_test.txt"));
        ArrayList<String> allInputLines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {

            String lineMod = line.replace(" ", "");
            allInputLines.add(lineMod);
        }
        br.close();






    }


}
