package y_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import AdventUtils.*;

public class Day01 implements Day {

    public static void main(String[] args) {
        new Day01().runAll();
    }

    @Override
    public void part1() {

        System.err.println("Part 1:");
        try {
            File myObj = new File("./2015/Day_01/input1.txt");
            Scanner scan = new Scanner(myObj);
            part1(scan);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void part2() {

        System.err.println("Part 2:");
        try {
            File myObj = new File("./2015/Day_01/input1.txt");
            Scanner scan = new Scanner(myObj);
            part2(scan);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void part1(Scanner s) {

        int floorNumber = 0;

        while (s.hasNextLine()) {
            for (String c : s.nextLine().split("")) {

                if (c.equals("(")) {
                    floorNumber++;
                }
                if (c.equals(")")) {
                    floorNumber--;
                }

            }
        }

        System.out.println(floorNumber);
    }

    public void part2(Scanner s) {
        int floorNumber = 0;
        int char_count = 0;
        while (s.hasNextLine()) {
            for (String c : s.nextLine().split("")) {
                char_count++;
                if (c.equals("(")) {
                    floorNumber++;
                }
                if (c.equals(")")) {
                    floorNumber--;
                }

                if (floorNumber < 0) {
                    System.out.println(char_count);
                    break;
                }
            }
        }

    }
}