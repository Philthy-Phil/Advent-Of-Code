package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_05_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_05_01.txt"));
        ArrayList<String> boardingPasses = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            boardingPasses.add(line.trim());
        }
        br.close();

        int highestSeatID = 0;

        for(String seat : boardingPasses) {

            char[] rows = seat.substring(0, 7).toCharArray();
            char[] cols = seat.substring(7, 10).toCharArray();

            int rowNumber = rowNum(rows);
            int colNumber = colNum(cols);
            int seatID = (rowNumber * 8) + colNumber;

            System.out.println("row number: " + rowNumber + " col number: " + colNumber + " " + " seatID: " + seatID);

            if(seatID > highestSeatID) {
                highestSeatID = seatID;
            } else {
                // current seatID is lower than highestSeatID
            }
        }

        System.out.println();
        System.out.println("highestSeatID: " + highestSeatID);

    }
    // 1/2/4/8/16/32/64 - parameter for binary multiplication
    public static int rowNum(char[] rows) {
        // F = 0 // B = 1
        int[] binaryValue = new int[rows.length];
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == 'F') {
                binaryValue[i] = 0;
            } else {
                binaryValue[i] = 1;
            }
        }
        int rowNumber = binaryValue[6] * 1 + binaryValue[5] * 2 + binaryValue[4] * 4 +
                binaryValue[3] * 8 + binaryValue[2] * 16 + binaryValue[1] * 32 + binaryValue[0] * 64;
        return rowNumber;
    }
    // 1/2/4/8/16/32/64 - parameter for binary multiplication
    public static int colNum(char[] cols) {
        // R = 1 // L = 0
        int[] binaryValue = new int[cols.length];
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 'R') {
                binaryValue[i] = 1;
            } else {
                binaryValue[i] = 0;
            }
        }
        int rowNumber = binaryValue[2] * 1 + binaryValue[1] * 2 + binaryValue[0] * 4;
        return rowNumber;
    }
}
