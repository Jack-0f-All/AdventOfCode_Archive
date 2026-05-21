package y_2019;

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
        System.out.println("Part 1:");
        try {
            File myObj = new File("./y_2019/input_01.txt");
            Scanner scan = new Scanner(myObj);
            part1(scan);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void part2() {
        System.out.println("Part 2:");
        try {
            File myObj = new File("./y_2019/input_01.txt");
            Scanner scan = new Scanner(myObj);
            part2(scan);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void part1(Scanner s) {
        int totalFuel = 0;
        while (s.hasNextDouble()) {

            totalFuel += (int) Math.floor(s.nextDouble() / 3) - 2;
        }

        System.out.println(totalFuel);
    }

    public void part2(Scanner s) {

        int totalFuel = 0;
        while (s.hasNextDouble()) {
            int fuelWeight = (int) Math.floor(s.nextDouble() / 3) - 2;
            while (fuelWeight > 0) {

                totalFuel += fuelWeight;

                fuelWeight = (int) Math.floor(fuelWeight / 3) - 2;
            }
        }

        System.out.println(totalFuel);
    }
}
