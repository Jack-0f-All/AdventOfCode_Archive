package y_2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import AdventUtils.*;

public class Day04 implements Day {

    public static void main(String[] args) {
        new Day04().runAll();
    }

    @Override
    public void part1() {
        System.out.println("Part 1:");
        try {
            File myObj = new File("./y_2019/input_04.txt");
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
            File myObj = new File("./y_2019/input_04.txt");
            Scanner scan = new Scanner(myObj);
            part2(scan);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void part1(Scanner s) {
        Scanner range = new Scanner(s.nextLine().replace("-", " "));

        int number = range.nextInt();
        int end = range.nextInt();

        int passwordCount = 0;
        boolean isValid;
        while (number <= end) {

            int password = number;
            isValid = false;

            while (password > 0) {

                int digit = password % 10;

                // Checks if password has ascending digits
                // If not, immediatley falsifies and breaks loop
                if (digit < (password / 10) % 10) {
                    isValid = false;
                    break;
                }

                // checks if there is a repeated digit in the password
                // Only way for the isValid to be true.
                if (digit == (password / 10) % 10) {

                    isValid = true;

                }

                password = password / 10;
            }
            if (isValid) {
                passwordCount++;
            }
            number++;
        }

        System.out.println(passwordCount);
    }

    public void part2(Scanner s) {
        Scanner range = new Scanner(s.nextLine().replace("-", " "));

        int number = range.nextInt();
        int end = range.nextInt();

        int passwordCount = 0;
        boolean isIncreasing;
        while (number <= end) {

            int password = number;
            isIncreasing = true;
            int lastDouble = -1;
            boolean validDouble = false;
            while (password > 0) {

                int digit = password % 10;

                // Checks if password has ascending digits
                // If not, immediatley falsifies and breaks loop
                if (digit < (password / 10) % 10) {
                    isIncreasing = false;
                    break;
                }

                // checks if there is a repeated digit in the password
                // if a double digit is found, check previous digit and the
                // next digit (if possible) to make sure that the double group
                // is only of size two.

                if (!validDouble && digit == (password / 10) % 10) {

                    if (digit != lastDouble) {

                        if (digit != (password / 100) % 10 || password < 10)
                            validDouble = true;
                    }
                }
                lastDouble = digit;
                password = password / 10;
            }

            if (isIncreasing && validDouble) {
                passwordCount++;
            }
            number++;
        }

        System.out.println(passwordCount);
    }
}