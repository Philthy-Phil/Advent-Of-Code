package AOC_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class aoc_12_02 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("inputs/input_12_02.txt"));
        ArrayList<Character> actions = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            actions.add(line.substring(0, 1).toCharArray()[0]);
            values.add(Integer.parseInt(line.substring(1, line.length())));
        }
        br.close();

        double[] ship = {0, 0};
        double[] waypoint = {10, 1};
        double facing = 90;     // North = 0, East = 90, South = 180, West = 270

        for (int i = 0; i < actions.size(); i++) {
            double amount = values.get(i);
            if (actions.get(i) == 'N') {
                waypoint[1] += amount;
//                System.out.println("ship: " + ship[0] + " " + ship[1]);
            }
            else if (actions.get(i) == 'E') {
                waypoint[0] += amount;
//                System.out.println("ship: " + ship[0] + " " + ship[1]);
            }
            else if (actions.get(i) == 'S') {
                waypoint[1] -= amount;
//                System.out.println("ship: " + ship[0] + " " + ship[1]);
            }
            else if (actions.get(i) == 'W') {
                waypoint[0] -= amount;
//                System.out.println("ship: " + ship[0] + " " + ship[1]);
            }
            else if (actions.get(i) == 'L') {
                double angle = Math.toRadians(amount);
                double[] waypointNew = rotatePoint(waypoint, angle);
//                System.out.println("ship: " + ship[0] + " " + ship[1]);
            }
            else if (actions.get(i) == 'R') {
                double angle = Math.toRadians(amount);
                double[] waypointNew = rotatePoint(waypoint, -angle);
//                System.out.println("ship: " + ship[0] + " " + ship[1]);
//                System.out.println(waypoint[0] + " " + waypoint[1]);
            }
            else if (actions.get(i) == 'F') {
                ship[0] += waypoint[0] * amount;
                ship[1] += waypoint[1] * amount;
//                System.out.println("ship: " + ship[0] + " " + ship[1]);
            }
        }

//        System.out.println("final ship position & orientation: " + ship[0] + " " + ship[1]);
//        System.out.println("final waypoint position & orientation: " + waypoint[0] + " " + waypoint[1]);

        double manhattanDistance = Math.round(Math.abs(ship[0]) + Math.abs(ship[1]));

        System.out.println("part 2: ship's manhatten distance = " + (int)manhattanDistance);



    }

//    public static double degreeToRadians (double degrees) {
//        return (degrees * (Math.PI / 180));
//    }
//    xRot = xCenter + cos(Angle) * (x - xCenter) - sin(Angle) * (y - yCenter)
//    yRot = yCenter + sin(Angle) * (x - xCenter) + cos(Angle) * (y - yCenter)

    public static  double[] rotatePoint (double[] waypoint, double angle) {
        double newX = (0 + Math.cos(angle) * (waypoint[0] - 0)) - (Math.sin(angle) * (waypoint[1] - 0));
        double newY = (0 + Math.sin(angle) * (waypoint[0] - 0)) + (Math.cos(angle) * (waypoint[1] - 0));
        waypoint[0] = newX;
        waypoint[1] = newY;
        return waypoint;
    }

    public static  double rotatePointX (double[] waypoint, double angle) {
        return (0 + Math.cos(angle) * (waypoint[0] - 0)) - (Math.sin(angle) * (waypoint[1] - 0));
    }
    public static  double rotatePointY (double[] waypoint, double angle) {
        return (0 + Math.sin(angle) * (waypoint[0] - 0)) + (Math.cos(angle) * (waypoint[1] - 0));
    }

//    public static double rotatePointX (double[] waypoint, double angle) {
//        return (waypoint[0] * Math.cos(angle)) - (waypoint[1] * Math.sin(angle));
//
//    }
//    public static double rotatePointY (double[] waypoint, double angle) {
//        return (waypoint[1] * Math.cos(angle)) + (waypoint[0] * Math.sin(angle));
//    }

}
