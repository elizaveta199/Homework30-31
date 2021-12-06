import exception.IllegalDayException;
import exception.IllegalStepsException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.stream.Stream;

public class GetAllAboveTest {
    @Test
    public void getAllAboveIsWork() throws IllegalStepsException, IllegalDayException {
        ManagerImpl managerImpl1 = new ManagerImpl(new HashMap<>());
        managerImpl1.add(1, 1500);
        managerImpl1.add(3, 3500);
        managerImpl1.add(2, 500);
        managerImpl1.add(7, 4500);
        managerImpl1.add(9, 10000);

        Stream<Integer> integerStream = managerImpl1.getAllAbove(1500);
        integerStream.forEach(System.out::println);
    }
}
