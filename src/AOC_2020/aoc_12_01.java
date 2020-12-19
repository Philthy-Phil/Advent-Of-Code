package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_12_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_12_01.txt"));
        ArrayList<Character> actions = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            actions.add(line.substring(0, 1).toCharArray()[0]);
            values.add(Integer.parseInt(line.substring(1, line.length())));
        }
        br.close();

        int[] ship = {0, 0, 90};
        int facing = 90;     // North = 0, East = 90, South = 180, West = 270

        for (int i = 0; i < actions.size(); i++) {

            int amount = values.get(i);

            if (actions.get(i) == 'N') {
                ship[1] += amount;
            }
            else if (actions.get(i) == 'E') {
                ship[0] += amount;
            }
            else if (actions.get(i) == 'S') {
                ship[1] -= amount;
            }
            else if (actions.get(i) == 'W') {
                ship[0] -= amount;
            }

            if (actions.get(i) == 'L') {
                facing = (360 + facing - values.get(i)) % 360;
            }
            else if (actions.get(i) == 'R') {
                facing = (facing + values.get(i)) % 360;
            }
            else if (actions.get(i) == 'F'){
                if (facing == 0) {
                    ship[1] += amount;
                }
                else if (facing == 90) {
                    ship[0] += amount;
                }
                else if (facing == 180) {
                    ship[1] -= amount;
                }
                else if (facing == 270) {
                    ship[0] -= amount;
                }
            }
        }

        System.out.println("final ship position & orientation: " + ship[0] + " " + ship[1] + " " + ship[2]);
        if (ship[0] < 0) {
            ship[0] = ship[0] * -1;
        }
        else if (ship[1] < 0) {
            ship[1] = ship[1] * -1;
        }
        int manhattanDistance = ship[0] + ship[1];
        System.out.println("part 1: ship's manhatten distance = " + manhattanDistance);

    }
}
