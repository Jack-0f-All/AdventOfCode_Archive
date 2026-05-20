package AdventUtils;

public interface Day {
    default void runAll() {
        System.out.println("Running part 1...\n");
        part1();

        System.out.println("Running part 2...\n");
        part2();
    }

    void part1();

    void part2();
}