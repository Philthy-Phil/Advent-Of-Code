package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class aoc_09_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_09_02.txt"));
        ArrayList<Long> numbers = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            numbers.add(Long.parseLong(line.trim()));
        }

        int preamble = 25;
        long invalidNumber = 0;
        int indexOfinvaliNumber = 0;

        for (int idx = preamble; idx < numbers.size(); idx++) {
            if (!containsSum(idx, numbers, preamble)) {
                invalidNumber = numbers.get(idx);
                indexOfinvaliNumber = idx;
                System.out.println("part1: invalid number = " + invalidNumber);
            }
        }

        ArrayList<Long> rangeNumbersIndex = new ArrayList<>();
        ArrayList<Long> rangeNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            long sum = 0;
            for (int j = i; j < numbers.size(); j++) {
                sum += numbers.get(j);
                if (numbers.get(i) != invalidNumber && numbers.get(j) != invalidNumber) {

                    if (sum == invalidNumber) {
                        rangeNumbersIndex.add((long) i);
                        rangeNumbersIndex.add((long) j);
                    }
                }
            }
        }

        for (long x = rangeNumbersIndex.get(0); x <= rangeNumbersIndex.get(1); x++) {
            rangeNumbers.add(numbers.get((int) x));
        }
        Collections.sort(rangeNumbers);
        Long sumOfMinAndMax = rangeNumbers.get(0) + rangeNumbers.get(rangeNumbers.size() - 1);
        System.out.println("part2: sum of minNum + maxNum in range = " + sumOfMinAndMax);
        }

        public static boolean containsSum ( int idx, ArrayList<Long > numbers,int preamble){
            for (int i = idx - preamble; i < numbers.size(); i++) {
                for (int j = idx - preamble; j < numbers.size(); j++) {
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
