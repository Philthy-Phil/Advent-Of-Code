package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class aoc_07_01 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_07_01.txt"));
        ArrayList<String> bagLines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            bagLines.add(line);
        }

        HashMap<String, HashMap<String, Integer>> bagsMap = new HashMap<>();
        bagsMap = getMap(bagLines);

        int colorCount = 0;
        for(String bag : bagsMap.keySet()) {
            if (containsGoldenBag(bag, bagsMap)) {
                colorCount++;
            }
        }

        for (String bags : bagsMap.keySet()) {
            System.out.println("outerBag = " + bags + "\t\t //////\t\t innerBags = " + bagsMap.get(bags));
        }

        System.out.println();
        System.out.println("part1 - number of bag colors: "+ colorCount);
    }

    public static boolean containsGoldenBag(String color, HashMap<String, HashMap<String, Integer>> bags) {
        HashMap<String, Integer> subBags = bags.get(color);
        if (subBags.containsKey("shiny gold")) {
            return true;
        }
        for (String bag : subBags.keySet()) {
            if (containsGoldenBag(bag, bags)) {
                return true;
            }
        }
        return false;
    }

    public static HashMap<String, HashMap<String, Integer>> getMap(ArrayList<String> bagLines) {
        HashMap<String, HashMap<String, Integer>> bagsMap = new HashMap<>();
        for (String bag : bagLines) {
            String[] outer = bag.split(" bags contain ");
            String[] inner = outer[1].split(", ");
            HashMap<String, Integer> innerBags = new HashMap<>();
            for (String bags : inner) {
                bags = bags.replace("bags.", "").trim();
                bags = bags.replace("bags", "").trim();
                bags = bags.replace("bag.", "").trim();
                bags = bags.replace("bag", "").trim();

                String color = bags.trim().substring(2,bags.length()).trim();
                if (!color.equals("other")) {
                    int bagCount = Integer.parseInt(bags.substring(0, 1).trim());
                    innerBags.put(color, bagCount);
                }
            }
            bagsMap.put(outer[0].trim(),innerBags);
        }
        return bagsMap;
    }
}
