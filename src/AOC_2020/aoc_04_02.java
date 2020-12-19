
package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class aoc_04_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_04_02.txt"));
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


                int validValue = 0;		// need to be 7 to be valid

                String[] fields = e.split(" ");
                fields = checkSortArray(fields);

                //checking byr
                String[] byrParts = fields[0].split(":");
                int byrNumber = Integer.parseInt(byrParts[1]);
                if(byrNumber >= 1920 && byrNumber <= 2002) {
                    validValue += 1;
                }
                //checking iyr
                String[] iyrParts = fields[6].split(":");
                int iyrNumber = Integer.parseInt(iyrParts[1]);
                if(iyrNumber >= 2010 && iyrNumber <= 2020) {
                    validValue += 1;
                }
                //checking eyr
                String[] eyrParts = fields[3].split(":");
                int eyrNumber = Integer.parseInt(eyrParts[1]);
                if(eyrNumber >= 2020 && eyrNumber <= 2030) {
                    validValue += 1;
                }
                //checking hgt
                String[] hgtParts = fields[5].split(":");
                if(hgtParts[1].contains("cm")) {
                    int hgtNumber = Integer.parseInt(hgtParts[1].substring(0,hgtParts[1].length()-2));
                    if(hgtNumber >= 150 && hgtNumber <= 193) {
                        validValue += 1;
                    }
                }
                else if(hgtParts[1].contains("in")) {
                    int hgtNumber = Integer.parseInt(hgtParts[1].substring(0,hgtParts[1].length()-2));
                    if(hgtNumber >= 59 && hgtNumber <= 76) {
                        validValue += 1;
                    }
                }
                //checking hcl
                String[] hclParts = fields[4].split(":");
//				int[] colorNumbers = java.util.stream.IntStream.rangeClosed(0, 9).toArray();
//				char[] colorChars = { 'a', 'b', 'c', 'd', 'e', 'f' };
                char[] hclSubParts = hclParts[1].toCharArray();

                if(hclSubParts[0] == '#' && hclSubParts.length <= 7 ) {
                    int validParts = 0;
                    for (int i = 1; i < hclSubParts.length; i++) {
                        if(	hclSubParts[i] == 'a' || hclSubParts[i] == 'b' || hclSubParts[i] == 'c' || hclSubParts[i] == 'd' || hclSubParts[i] == 'e' || hclSubParts[i] == 'f' ||
                                hclSubParts[i] == '0' || hclSubParts[i] == '1' || hclSubParts[i] == '2' || hclSubParts[i] == '3' || hclSubParts[i] == '4' ||
                                hclSubParts[i] == '5' || hclSubParts[i] == '6' || hclSubParts[i] == '7' || hclSubParts[i] == '8' || hclSubParts[i] == '9') {
                            validParts += 1;
                        }
                    }
                    if(validParts == 6) {
                        validValue += 1;
                    }
                }

                //checking ecl
                String[] eclParts = fields[2].split(":");

                if(eclParts[1].contains("amb") || eclParts[1].contains("blu") || eclParts[1].contains("brn") || eclParts[1].contains("gry") ||
                        eclParts[1].contains("grn") || eclParts[1].contains("hzl") || eclParts[1].contains("oth")) {
                    validValue += 1;
                }

                //checking pid
                String[] pidParts = fields[7].split(":");
                if(pidParts[1].length() == 9) {
                    validValue += 1;
                }

                System.out.println(fields[0] + " // " + fields[1] + " // " + fields[2] + " // " + fields[3] + " // " +
                        fields[4] + " // " + fields[5] + " // " + fields[6] + " // " + fields[7] + " ----- valid " + validValue);

                if(validValue == 7) {
                    valid = valid + 1;
                }

            } else {
                // invalid
            }

        }

        System.out.println();
        System.out.println("number of valid passports: " + valid);
    }


    // find index of CID cause its optional
    public static String[] checkSortArray(String[] fields) {

        String[] tmp = Arrays.copyOf(fields, 8);
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] == null) {
                tmp[i] = "cid:shit";
            }
        }

        Arrays.sort(tmp);
        fields = tmp;
        return fields;
    }





}