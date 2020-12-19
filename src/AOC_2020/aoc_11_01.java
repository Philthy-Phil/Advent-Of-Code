package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class aoc_11_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_11_01.txt"));
        ArrayList<String> seatLines = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            seatLines.add(line.trim());
        }
        br.close();

        char emptySeat = 'L';
        char occupiedSeat = '#';
        char floor = '.';

        int rows = seatLines.size()+2;
        int cols = seatLines.get(0).toCharArray().length+2;

        char[][] seats = setGrid(seatLines, rows, cols);
        System.out.println("starting seatLayout:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("part1 - seatCount: " + count(seats, occupiedSeat));

        int currOC = 0;
        int updatedOC = 1;
        int i = 1;
        char[][] current = deepCopy(seats);

        while (currOC != updatedOC) {
            currOC = count(current, occupiedSeat);
            System.out.println();
            System.out.println(i + " run seatLayout:");
            char[][] updated = updateRule(current, occupiedSeat, emptySeat, floor, rows, cols);
            updatedOC = count(updated, occupiedSeat);
            System.out.println("part1 - seatCount: " + updatedOC);
            current = deepCopy(updated);
            i++;
        }
    }


    //both rules
    public static char [][] updateRule (char[][] original, char occupiedSeat, char emptySeat, char floor, int rows, int cols) {
        char[][] updated = deepCopy(original);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (original[i][j] == emptySeat) {
                    if (trueNeighbours(i, j, original, occupiedSeat, emptySeat, floor) == 0) {
                        updated[i][j] = occupiedSeat;
                    }
                }
                else if (original[i][j] == occupiedSeat) {
                    if (trueNeighbours(i, j, original, occupiedSeat, emptySeat, floor) >= 4) {
                        updated[i][j] = emptySeat;
                    }
                }
                System.out.print(updated[i][j] + " ");
            }
            System.out.println();
        }
        return updated;
    }

    public static int count(char[][] arr, char occupiedSeat) {

        int ocCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == occupiedSeat) {
                    ocCount++;
                }
            }
        }
        return ocCount;
    }

    // check for neighbours
    public static int trueNeighbours(int i, int j, char[][] seats, char occupiedSeat, char emptySeat, char floor) {
        int trueNeighbours = 0;
        int[][] dirs = {
                // 	topLeft, topMiddle, topRight, middleRight, bottomRight, bottomMiddle, bottomLeft, middleLeft
                { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }
        };
        if (seats[i][j] != '0' && seats[i][j] != floor) {
            for (int n = 0; n < 8; n++) {
                if (seats[i + dirs[n][0]][j + dirs[n][1]] == occupiedSeat) {
                    trueNeighbours++;
                }
            }
        }
        return trueNeighbours;
    }

    public static char[][] setGrid(ArrayList<String> seatLines, int rows, int cols) {
        char[][] seats = new char[rows][cols];
        for (int i = 1; i < rows-1; i++) {
            String seatRow = seatLines.get(i-1);
            char[] chars = seatRow.toCharArray();
            for (int j = 1; j < cols-1; j++) {
                seats[i][j] = chars[j-1];

                // add border - preventing bound
                for (int x = 0; x < seats.length; x++) {
                    for (int y = 0; y < seats[x].length; y++) {
                        seats[x][0] = '0'; // margin left
                        seats[x][seats[x].length - 1] = '0'; // margin right
                        seats[0][y] = '0'; // margin top
                        seats[seats.length - 1][y] = '0'; // margin bottom
                    }
                }
            }
        }
        return seats;
    }

    public static char[][] deepCopy(char[][] original) {
        if (original == null) {
            return null;
        }

        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
            // For Java versions prior to Java 6 use the next:
            // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }



}


