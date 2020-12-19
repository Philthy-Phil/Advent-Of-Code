package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class aoc_09_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_09_01.txt"));
        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Long> preamble = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            numbers.add(Long.parseLong(line.trim()));
        }

        for (int idx = 25; idx < numbers.size(); idx++) {
            if (!containsSum(idx, numbers)) {
                System.out.println("part1: " + numbers.get(idx));
            }
        }
    }

    public static boolean containsSum(int idx, ArrayList<Long> numbers) {
        for (int i = idx - 25; i < numbers.size(); i++) {
            for (int j = idx - 25; j < numbers.size(); j++){
                if (i != j) {
                    if (numbers.get(idx) == numbers.get(i) + numbers.get(j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
