package AdventUtils;

public interface Day {
    default void runAll() {
        part1();
        part2();
    }

    void part1();

    void part2();
}