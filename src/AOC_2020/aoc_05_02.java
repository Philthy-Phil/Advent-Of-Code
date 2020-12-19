package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class aoc_05_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_05_02.txt"));
        ArrayList<String> boardingPasses = new ArrayList<>();
        ArrayList<Integer> allSeatIDs = new ArrayList<>();

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

            allSeatIDs.add(seatID);

//			System.out.println("row number: " + rowNumber + " col number: " + colNumber + " " + " seatID: " + seatID);

            if(seatID > highestSeatID) {
                highestSeatID = seatID;
            } else {
                // current seatID is lower than highestSeatID
            }
        }

        System.out.println("highest seatID: " + highestSeatID);
        System.out.println();

        /* Sort statement*/
        Collections.sort(allSeatIDs);


        int lastID = allSeatIDs.get(0)-1;

        for(int seatID : allSeatIDs) {
//			System.out.println(seatID);
            if(lastID != seatID-1 && seatID - lastID > 1) {
                int missingID = seatID -1 ;
                System.out.println("missing seatID: " + missingID);
            }
            lastID = seatID;
        }






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
