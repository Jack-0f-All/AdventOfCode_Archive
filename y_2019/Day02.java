package y_2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import AdventUtils.*;

public class Day02 implements Day {

    public static void main(String[] args) {
        new Day02().runAll();
    }

    @Override
    public void part1() {
        System.out.println("Part 1:");
        try {
            File myObj = new File("./y_2019/input_02.txt");
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
            File myObj = new File("./y_2019/input_02.txt");
            Scanner scan = new Scanner(myObj);
            part2(scan);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void part1(Scanner s) {
        String[] raw_tape = s.nextLine().split(",");
        int[] tape = new int[raw_tape.length];
        for (int i = 0; i < tape.length; i++) {
            tape[i] = Integer.parseInt(raw_tape[i]);
        }

        // Sets up the "1202 ERROR"
        tape[1] = 12;
        tape[2] = 2;

        int pos = 0;

        while (tape[pos] != 99) {

            int val1, val2, newPos = 0;
            System.out.println(tape[pos]);
            switch (tape[pos]) {

                case 1:
                    val1 = tape[pos + 1];
                    val2 = tape[pos + 2];
                    newPos = tape[pos + 3];

                    // System.out.printf("Position %d is now %d", newPos, val1 + val2);
                    tape[newPos] = tape[val1] + tape[val2];
                    pos += 4;

                    System.out.println(Arrays.toString(tape));
                    break;
                case 2:
                    val1 = tape[pos + 1];
                    val2 = tape[pos + 2];
                    newPos = tape[pos + 3];
                    // System.out.printf("Position %d is now %d", newPos, val1 * val2);
                    tape[newPos] = tape[val1] * tape[val2];
                    pos += 4;

                    System.out.println(Arrays.toString(tape));
                    break;
                default:
                    System.out.println("Something has gone wrong...");
                    break;
            }
        }

        System.out.println("Halted...");
        System.out.printf("Position 0 is now --> %d%n", tape[0]);

    }

    public void part2(Scanner s) {
        String[] raw_tape = s.nextLine().split(",");
        int[] tape = new int[raw_tape.length];
        for (int i = 0; i < tape.length; i++) {
            tape[i] = Integer.parseInt(raw_tape[i]);
        }

        for (int noun = 99; noun >= 0; noun--) {
            for (int verb = 99; verb >= 0; verb--) {
                if(checkProgram(noun, verb, tape)){
                    System.out.printf("Correct input found --> %d%n", 100*noun+verb);
                    return;
                }

            }
        }

    }

    private boolean checkProgram(int v1, int v2, int[] t) {

        int[] tape = t.clone();
        int pos = 0;
        tape[1] = v1;
        tape[2] = v2;

        while (tape[pos] != 99) {

            int val1, val2, newPos = 0;
            
            switch (tape[pos]) {

                case 1:
                    val1 = tape[pos + 1];
                    val2 = tape[pos + 2];
                    newPos = tape[pos + 3];

                    // System.out.printf("Position %d is now %d", newPos, val1 + val2);
                    tape[newPos] = tape[val1] + tape[val2];
                    pos += 4;

                    
                    break;
                case 2:
                    val1 = tape[pos + 1];
                    val2 = tape[pos + 2];
                    newPos = tape[pos + 3];
                    // System.out.printf("Position %d is now %d", newPos, val1 * val2);
                    tape[newPos] = tape[val1] * tape[val2];
                    pos += 4;

                    
                    break;
                default:
                    return false;

            }
        }

        return tape[0] == 19690720 ? true : false;

    }
}