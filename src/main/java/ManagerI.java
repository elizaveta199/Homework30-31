import exception.IllegalDayException;
import exception.IllegalStepsException;

import java.util.stream.Stream;

public interface ManagerI extends Comparable<ManagerI> {
    void add(int day, int steps) throws IllegalDayException, IllegalStepsException;

    int getStepsToMax(int day);

    int getSumSteps();

    Stream<Integer> getAllAbove(int steps);
}
