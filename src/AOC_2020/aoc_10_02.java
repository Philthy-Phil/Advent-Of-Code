package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class aoc_10_02 {

    private static Map<String, Long> cache;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_10_02.txt"));
        ArrayList<Integer> adapterList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            adapterList.add(Integer.parseInt(line.trim()));
        }
        br.close();

        int devJoltage = Collections.max(adapterList) + 3;
        int chargingOutlet = 0;
        adapterList.add(0);
        adapterList.add(devJoltage);
        Collections.sort(adapterList);

        int differenceOfOneJolt = 0;
        int differenceOfTwoJolt = 0;
        int differenceOfThreeJolt = 0;

        for (int i = 0; i < adapterList.size() - 1; i++) {
            if (adapterList.get(i) + 1 == adapterList.get(i + 1)) {
                differenceOfOneJolt++;
            } else if (adapterList.get(i) + 2 == adapterList.get(i + 1)) {
                differenceOfTwoJolt++;
            } else if (adapterList.get(i) + 3 == adapterList.get(i + 1)) {
                differenceOfThreeJolt++;
            }
        }
        int multipliedDiff = differenceOfOneJolt * differenceOfThreeJolt;

//        System.out.println("differenceOfOneJolt: " + differenceOfOneJolt);
//        System.out.println("differenceOfTwoJolt: " + differenceOfTwoJolt);
//        System.out.println("differenceOfThreeJolt: " + differenceOfThreeJolt);
        System.out.println();
        System.out.println("part1:  multipliedDiff= " + multipliedDiff);
        cache = new HashMap<>();
        long arrangements = getArrangements(adapterList);
        System.out.println("part2: there are arrangements of " + arrangements);


    }

    public static long getArrangements(List<Integer> adapterList) {

        if (adapterList.size() == 1)
            return 1;

        long arrangements = 0;
        int index = 1;
        int current = adapterList.get(0);
        while (adapterList.size() > index && adapterList.get(index) - current <= 3) {
            List<Integer> subList = adapterList.subList(index, adapterList.size());
            String subListStr = Arrays.toString(subList.toArray(new Integer[0]));

            if (cache.containsKey(subListStr)) {
                arrangements += cache.get(subListStr);
            } else {
                long subArrangements = getArrangements(subList);
                cache.put(subListStr, subArrangements);
                arrangements += subArrangements;
            }
            index++;
        }
        return arrangements;
    }

}
