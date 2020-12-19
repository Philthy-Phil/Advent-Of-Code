package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_06_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_06_02.txt"));
        ArrayList<String> input = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            input.add(line);
        }
        br.close();

        int total = 0;
        ArrayList<Character> yesTo = new ArrayList<>();
        boolean first = true;
        for(String s : input) {
            if(s.trim().isEmpty()) {
                total += yesTo.size();
                yesTo.clear();
                first = true;
            } else {
                if(first) {
                    for(char c : s.trim().toCharArray())
                        yesTo.add(c);
                } else {
                    for(int i = yesTo.size() - 1; i >= 0; i--) {
                        char c = yesTo.get(i);
                        boolean contains = false;
                        for(char c2 : s.trim().toCharArray()) {
                            if(c2 == c) {
                                contains = true;
                                break;
                            }
                        }
                        if(!contains) yesTo.remove(i);
                    }
                }
                first = false;
            }
        }
        total += yesTo.size();
        System.out.println("Yes-Answers: " + total);
    }
}
