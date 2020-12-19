package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_03_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_03_01.txt"));

        ArrayList<String> allStrings = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            allStrings.add(line);
        }
        br.close();

        int rows = allStrings.size();
        int cols = allStrings.get(0).length();

        System.out.println("input rows: " + rows + " - " + "input colls: " + cols);
        System.out.println();

        char[][] map = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            String sequence = allStrings.get(i);
            char[] chars = sequence.toCharArray();

            for (int j = 0; j < cols; j++) {
                map[i][j] = chars[j];
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        int posX = 0;
        int posY = 0;
        int slopeX = 3;
        int slopeY = 1;

        int trees = 0;

        while(posY < rows) {

            char currentPos = map[posY][posX];

            if(currentPos == '#') {
                trees++;
            }

            if((posX + slopeX) > cols-1) {
                int rest = (posX + slopeX) % cols;
                posX = rest;
                posY = posY + slopeY;
            } else {
                posX = posX + slopeX;
                posY = posY + slopeY;
            }

        }

        System.out.println();
        System.out.println("catched trees: " + trees);

    }
}
