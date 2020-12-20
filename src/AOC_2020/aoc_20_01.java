package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_20_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_test.txt"));
        ArrayList<String> allInputLines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {

            allInputLines.add(line);
        }
        br.close();





    }

}
