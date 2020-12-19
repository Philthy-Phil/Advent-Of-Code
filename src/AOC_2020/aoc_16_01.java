package AOC_2020;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class aoc_16_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_16_01.txt"));
        ArrayList<String> allInputLines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {

            allInputLines.add(line);
        }
        br.close();

        ArrayList<String> allRules = new ArrayList<>();
        ArrayList<String> myTicket = new ArrayList<>();
        ArrayList<String> nearbyTickets = new ArrayList<>();
        ArrayList<Integer> allNumberRanges = new ArrayList<>();

        int parra = 0;
        for (String s : allInputLines) {
//            System.out.println(s);

            if (s.trim().isEmpty()) {
                parra++;
            }
            else if (!s.trim().isEmpty() && parra == 0) {
                allRules.add(s);

                String[] split = s.split(": ");
//                System.out.println(split[0].trim() + " " + split[1].trim());
                String[] splitSplit = split[1].trim().split("or");
//                System.out.println(splitSplit[0].trim() + " " + splitSplit[1].trim());
                String[] range1 = splitSplit[0].trim().split("-");
                String[] range2 = splitSplit[1].trim().split("-");
//                System.out.println(range1[0] + " " + range1[1] + " " + range2[0] + " " + range2[1]);
                int range1Min = Integer.parseInt(range1[0]);
                int range1Max = Integer.parseInt(range1[1]);
                int range2Min = Integer.parseInt(range2[0]);
                int range2Max = Integer.parseInt(range2[1]);
//                System.out.println(range1Min + " " + range1Max + " " + range2Min + " " + range2Max);
                List<Integer>ranges1 = IntStream.range(range1Min, range1Max+1).boxed().collect(Collectors.toList());
                List<Integer>ranges2 = IntStream.range(range2Min, range2Max+1).boxed().collect(Collectors.toList());
                allNumberRanges.addAll(ranges1);
                allNumberRanges.addAll(ranges2);
            }
            else if (!s.trim().isEmpty() && parra == 1) {
                myTicket.add(s.trim());
            }
            else if (!s.trim().isEmpty() && parra == 2) {
                nearbyTickets.add(s.trim());
            }
        }

        myTicket.remove(0);
        nearbyTickets.remove(0);

        ArrayList<Integer> failNumbers = new ArrayList<>(); // get our fail stacks
        int failStackSum = 0;

        System.out.println("#############################################");
        System.out.println("GENERAL RULES");
        for (String e : allRules) {
            System.out.println(e);
        }

        System.out.println("#############################################");
        for (String r : myTicket) {
            String[] myTicketNums = r.split(",");
            int myTicketNumsValid = 0;

            for (int i = 0; i < myTicketNums.length; i++) {
                if (allNumberRanges.contains(Integer.parseInt(myTicketNums[i]))) {
                    myTicketNumsValid++;
                } else {
                    failNumbers.add(Integer.parseInt(myTicketNums[i]));
                }
            }
            if (myTicketNumsValid == myTicketNums.length) {
                System.out.println("myTicket: " + r + "\t --- \t valid");
            } else {
                System.out.println("myTicket: " + r + "\t --- \t invalid");
            }
        }

        System.out.println("#############################################");
        for (String t : nearbyTickets) {
            String[] nearbyTicketsNums = t.split(",");
            int nearbyTicketsNumsValid = 0;

            for (int i = 0; i < nearbyTicketsNums.length; i++) {
                if (allNumberRanges.contains(Integer.parseInt(nearbyTicketsNums[i]))) {
                    nearbyTicketsNumsValid++;
                } else {
                    failNumbers.add(Integer.parseInt(nearbyTicketsNums[i]));
                }
            }
            if (nearbyTicketsNumsValid == nearbyTicketsNums.length) {
                System.out.println("nearbyTicket: " + t + "\t --- \t valid");
            } else {
                System.out.println("nearbyTicket: " + t + "\t --- \t invalid");
            }
        }

        for (int num : failNumbers) {
            failStackSum += num;
        }
        System.out.println("#############################################");
        System.out.println("failStackSum = " + failStackSum);

    }
}
