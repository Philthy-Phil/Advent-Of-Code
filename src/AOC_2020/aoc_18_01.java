package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_18_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_18_01_test.txt"));
        ArrayList<String> allInputLines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {

            String lineMod = line.replace(" ", "");
            allInputLines.add(lineMod);
        }
        br.close();

        for (String n : allInputLines) {
            int sum = 0;

                char[] splittedToSigns = n.toCharArray();

                for (int i = 0; i < splittedToSigns.length; i++) {

                    if (sum == 0) {
                        sum += Integer.parseInt(String.valueOf(splittedToSigns[i]));
                    }

// checking without parentheses

                    if (splittedToSigns[i] == '+') {
                        sum += Integer.parseInt(String.valueOf(splittedToSigns[i+1]));
                    }
                    else if (splittedToSigns[i] == '*') {
                        sum *= Integer.parseInt(String.valueOf(splittedToSigns[i+1]));
                    }

// checking with parentheses



                }
            System.out.println(n + " ===== " + sum);
        }
    }

}
