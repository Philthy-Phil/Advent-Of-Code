package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_06_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_06_01.txt"));
        ArrayList<String> forms = new ArrayList<>();
        ArrayList<Integer> personsOnForm = new ArrayList<>();

        String line;
        StringBuilder tmp = new StringBuilder();
        int personCount = 0;
        while ((line = br.readLine()) != null) {
            if (!line.isBlank()) {
//				tmp.append(" ");
                tmp.append(line);

                personCount++;

            } else {
                personsOnForm.add(personCount);

                forms.add(tmp.toString().trim());
                tmp.setLength(0);	// reset
                personCount = 0;	// reset
            }
        }
        line = tmp.toString().trim();
        if (!line.isBlank()) {
            forms.add(line);

            personsOnForm.add(personCount);
        }

        br.close();

        int allQuestions = 0;

        int i = 0;
        for (String e : forms) {

            int personsCount = personsOnForm.get(i);
            char[] splitQuestions = e.substring(0, e.length()).toCharArray();
            int questionsCount = questionsCount(splitQuestions);

            System.out.println(e + "\t\t\t -- " +  "#persons: " + personsCount + " -- " + "#questions: " + questionsCount);

            i++;
            allQuestions += questionsCount;

        }

        System.out.println();
        System.out.println("sum of questions: " + allQuestions);

    }

    public static int questionsCount(char[] splitQuestions) {

        ArrayList<Character> checkin = new ArrayList<>();
        for (int i = 0; i < splitQuestions.length; i++) {
            char toCheck = splitQuestions[i];
            if(!checkin.contains(toCheck)) {
                checkin.add(toCheck);
            }
        }
        int questionsCount = checkin.size();
        return questionsCount;
    }
}
