package y_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import AdventUtils.*;

public class Day02 implements Day {

    public static void main(String[] args) {
        new Day02().runAll();
    }

    @Override
    public void part1() {

        System.err.println("Part 1:");
        try {
            File myObj = new File("./y_2015/input_02.txt");
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
            File myObj = new File("./y_2015/input_02.txt");
            Scanner scan = new Scanner(myObj);
            part2(scan);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void part1(Scanner s) {
        int total_area = 0;
        while (s.hasNextLine()) {
            String[] dimensions = s.nextLine().split("x");
            int length = Integer.parseInt(dimensions[0]);
            int width = Integer.parseInt(dimensions[1]);
            int height = Integer.parseInt(dimensions[2]);

            total_area += calcSurfaceArea(length, width, height);
        }

        System.out.println(total_area);
    }

    public void part2(Scanner s) {
        int total_ribbon = 0;
        while (s.hasNextLine()) {
            String[] dimensions = s.nextLine().split("x");
            int length = Integer.parseInt(dimensions[0]);
            int width = Integer.parseInt(dimensions[1]);
            int height = Integer.parseInt(dimensions[2]);

            int face1 = 2 * length + 2 * width;
            int face2 = 2 * width + 2 * height;
            int face3 = 2 * height + 2 * length;

            //Finds the smallest face and then adds the "bow" length.
            total_ribbon += Integer.min(face1, Integer.min(face2, face3)) + length*width*height;
        }

        System.out.println(total_ribbon);
    }

    private int calcSurfaceArea(int l, int w, int h){


        return 2*l*w + 2*w*h + 2*h*l + calcExtra(l, w, h);
    }
    private int calcExtra(int l, int w, int h) {
        int smallest = l * w;

        if (smallest > w * h)
            smallest = w * h;
        if (smallest > h * l)
            smallest = h * l;

        return smallest;
    }
}