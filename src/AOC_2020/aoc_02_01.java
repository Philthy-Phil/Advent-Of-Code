package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_02_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_02_01.txt"));

        ArrayList<String> stringSets = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            stringSets.add(line);
        }
        br.close();

        System.out.println("catching the whole stringSet-list");
        System.out.println(stringSets);
        System.out.println();

        ArrayList<Integer> minNumbers = new ArrayList<>();
        ArrayList<Integer> maxNumbers = new ArrayList<>();
        ArrayList<String> charSets = new ArrayList<>();
        ArrayList<String> rangeSets = new ArrayList<>();

        for (int i = 0; i < stringSets.size(); i++) {

            String[] splitted = stringSets.get(i).split(" ");

            String[] numberRange = splitted[0].split("-");
            minNumbers.add(Integer.parseInt(numberRange[0]));
            maxNumbers.add(Integer.parseInt(numberRange[1]));

            splitted[1] = (splitted[1].substring(0, splitted[1].length() - 1));
            charSets.add(splitted[1]);

            rangeSets.add(splitted[2]);
        }

        String validOrNot;
        int correct = 0;

        for (int i = 0; i < stringSets.size(); i++) {

            if(check(minNumbers.get(i),maxNumbers.get(i),charSets.get(i),rangeSets.get(i)) == true) {
                validOrNot = "VALID";
                correct++;
            } else {
                validOrNot = "INVALID";
            }

            System.out.println("min. '" + minNumbers.get(i) + "' max. '" + maxNumbers.get(i)  + "' of '" + charSets.get(i) + "' in '" + rangeSets.get(i) + "' --- " + validOrNot);

        }

        System.out.println();
        System.out.println("there are " + correct + " valid passwords");
    }


    //*** check if valid or not valid ***///
    public static boolean check(int minNumber, int maxNumber, String character, String set) {
        Boolean validOrNot = false;
        int count = 0;
        char sign = character.charAt(0);
        char[] signSet = set.toCharArray();

        for (char c : signSet) {
            if (c == sign) {
                count++;
            }
        }

        if (count >= minNumber && count <= maxNumber) {
            validOrNot = true;
        } else {
            validOrNot = false;
        }

        return validOrNot;

    }


}
