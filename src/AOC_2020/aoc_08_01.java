package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class aoc_08_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_08_01.txt"));
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> operations = new ArrayList<>();
        ArrayList<Integer> arguments = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {

            String[] instructions = line.split(" ");
            operations.add(instructions[0].trim());
            arguments.add(Integer.parseInt(instructions[1].trim()));
            input.add(line);
        }
        br.close();
        ArrayList<Integer> positions = new ArrayList<>();
        int acc = 0;
        int jmp = 0;
        int nop = 0;
        part1(operations, arguments, positions, acc, jmp, nop);
        part2(operations, arguments, positions, input);
    }

    private static void part2(ArrayList<String> operations, ArrayList<Integer> arguments, ArrayList<Integer> positions, ArrayList<String> input) {

        for (int i : positions) {
            ArrayList<Integer> positions2 = new ArrayList<>();
            int acc = 0;
            int jmp = 0;
            boolean running = true;
            boolean finished = false;
            while (running) {
                if (input.size() == jmp) {
                    finished = true;
                    System.out.println("part2: value of accumulator = " + acc);
                    break;
                }
                String t = input.get(jmp);
                String[] split = t.split(" ");

                if (i == jmp) {
                    if (split[0].equals("jmp")) {
                        split[0] = "nop";
                    } else if (split[0].equals("nop")) {
                        split[0] = "jmp";
                    }
                }
                positions2.add(jmp);
                if (split[0].equals("acc")) {
                    acc += Integer.parseInt(split[1]);
                    jmp++;
                }
                if (split[0].equals("jmp")) {
                    jmp += Integer.parseInt(split[1]);
                }
                if (split[0].equals("nop")) {
                    jmp++;
                }
                if (positions2.contains(jmp)) {
                    running = false;
                }
            }
        }
    }

    private static void part1(ArrayList<String> operations, ArrayList<Integer> arguments, ArrayList<Integer> positions, int acc, int jmp, int nop) {
        int i = 0;
        while (i < operations.size()) {

            if (positions.contains(i)) {
                break;
            } else {
                positions.add(i);
                if (operations.get(i).equals("acc")) {
                    acc += arguments.get(i);
                    i += 1;
                } else if (operations.get(i).equals("nop")) {
                    i += 1;
                } else if (operations.get(i).equals("jmp")) {
                    i += arguments.get(i);
                }
            }
        }
        System.out.println();
        System.out.println("part1: value of accumulator = " + acc);
    }


}
