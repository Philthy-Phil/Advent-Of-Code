package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_01_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_01_01.txt"));
        ArrayList<Integer> allInts = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            allInts.add(Integer.parseInt(line));
        }

        System.out.println();
        System.out.println(allInts);
        System.out.println();

        int solution = 0;
        int[] entries = new int[2];
        int a;
        int b;

        for (int i = 0; i < allInts.size(); i++) {
            a = allInts.get(i);

            for (int j = 0; j < allInts.size(); j++) {
                b = allInts.get(j);

                if (sum(a, b) == 2020) {
                    entries[0] = a;
                    entries[1] = b;
                    solution = multiply(a, b);
                } else {
//					System.out.println("something wrong");
                }
            }
        }

        System.out.println(" entry-1: " + entries[0] + "\n\n entry-2: " + entries[1] + "\n\n sum = 2020");
        System.out.println();
        System.out.println("the number is: " + solution);
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }
}
