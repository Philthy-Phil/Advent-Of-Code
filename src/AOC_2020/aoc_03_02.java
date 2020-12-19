package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_03_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_03_02.txt"));

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

        int slopeX1run = 3;
        int slopeY1run = 1;

        int slopeX2run = 1;
        int slopeY2run = 1;

        int slopeX3run = 5;
        int slopeY3run = 1;

        int slopeX4run = 7;
        int slopeY4run = 1;

        int slopeX5run = 1;
        int slopeY5run = 2;

        long trees1Run = 0;
        long trees2Run = 0;
        long trees3Run = 0;
        long trees4Run = 0;
        long trees5Run = 0;

        trees1Run = getTreeCount(rows, cols, slopeX1run, slopeY1run, map);
        trees2Run = getTreeCount(rows, cols, slopeX2run, slopeY2run, map);
        trees3Run = getTreeCount(rows, cols, slopeX3run, slopeY3run, map);
        trees4Run = getTreeCount(rows, cols, slopeX4run, slopeY4run, map);
        trees5Run = getTreeCount(rows, cols, slopeX5run, slopeY5run, map);

        System.out.println();
        System.out.println("catched trees 1run: " + trees1Run);
        System.out.println("catched trees 2run: " + trees2Run);
        System.out.println("catched trees 3run: " + trees3Run);
        System.out.println("catched trees 4run: " + trees4Run);
        System.out.println("catched trees 5run: " + trees5Run);
        System.out.println();

        long multiTrees = trees1Run * trees2Run * trees3Run * trees4Run * trees5Run;
        System.out.println();
        System.out.println("catched trees in multiRun: " + multiTrees);

    }

    public static int getTreeCount(int rows, int cols, int slopeX, int slopeY, char[][] map) {

        int posX = 0;
        int posY = 0;
        int trees = 0;

        while(posY < rows) {
            char currentPos = map[posY][posX];
            if(currentPos == '#') {
                trees++;
            }
            if((posX + slopeX) > cols - 1) {
                int rest = (posX + slopeX) % cols;
                posX = rest;
                posY = posY + slopeY;
            } else {
                posX = posX + slopeX;
                posY = posY + slopeY;
            }
        }
        return trees;
    }

}
