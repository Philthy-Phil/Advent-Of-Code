
package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_04_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_04_01.txt"));
        ArrayList<String> passports = new ArrayList<>();

        String line;
        StringBuilder tmp = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (!line.isBlank()) {
                tmp.append(" ");
                tmp.append(line);
            } else {
                passports.add(tmp.toString().trim());
                tmp.setLength(0);
            }
        }

        line = tmp.toString().trim();
        if (!line.isBlank()) {
            passports.add(line);
        }

        br.close();

        int valid = 0;

        for (String e : passports) {

            if (e.contains("byr") && e.contains("iyr") && e.contains("eyr") && e.contains("hgt")
                    && e.contains("hcl") && e.contains("ecl") && e.contains("pid")) {
                valid++;
            }

            System.out.println(e);
        }

        System.out.println();
        System.out.println("number of valid passports: " + valid);
    }

}