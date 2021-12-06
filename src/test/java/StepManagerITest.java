import exception.IllegalDayException;
import exception.IllegalStepsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

public class StepManagerITest {

    Map<Integer, Integer> store = new HashMap<>();
    ManagerImpl managerImpl = new ManagerImpl(store);

    @BeforeEach
    public void createAddSteps() throws IllegalStepsException, IllegalDayException {
        managerImpl.add(1, 2000);
        managerImpl.add(1, 3500);
        managerImpl.add(2, 3000);
        managerImpl.add(1, 300);
        managerImpl.add(4, 300);
    }

    @CsvSource({"1,1", "2, 2801", "3,5801", "4,5501", "5,5801"})
    @ParameterizedTest
    public void testStepsToMax(int day, int steps) {

        Assertions.assertEquals(steps, managerImpl.getStepsToMax(day));
    }
}
