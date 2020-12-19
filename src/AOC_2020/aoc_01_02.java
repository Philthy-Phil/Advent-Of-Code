package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_01_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_01_02.txt"));

        ArrayList<String> allStrings = new ArrayList<>();
        ArrayList<Integer> allInts = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            allStrings.add(line);
            allInts.add(Integer.parseInt(line));
        }

        System.out.println();
        System.out.println(allInts);
        System.out.println();

        int[] entries = new int[3];
        int solution = 0;

        for (int i = 0; i < allInts.size(); i++) {
            int a = allInts.get(i);

            for (int j = 0; j < allInts.size(); j++) {
                int b = allInts.get(j);

                for (int k = 0; k < allInts.size(); k++) {
                    int c = allInts.get(k);

                    if (sum(a, b, c) == 2020) {

                        solution = multiply(a, b, c);
                        entries[0] = a;
                        entries[1] = b;
                        entries[2] = c;
                        break;

                    } else {
//					System.out.println("something wrong");
                    }

                }
            }
        }
        System.out.println(" entry-1: " + entries[0] + "\n\n entry-2: " + entries[1] + "\n\n entry-3: " + entries[2] + "\n\n sum = 2020");
        System.out.println();

        System.out.println("the multiplied number is: " + solution);

    }

    public static int sum(int x, int y, int z) {
        return x + y + z;
    }

    public static int multiply(int x, int y, int z) {
        return x * y * z;
    }

}
