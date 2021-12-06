import exception.IllegalDayException;
import exception.IllegalStepsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ComparableAndComparatorTest {

    ManagerImpl[] managers = new ManagerImpl[3];

    @BeforeEach
    public void addManagers() throws IllegalStepsException, IllegalDayException {
        ManagerImpl manager1 = new ManagerImpl(new HashMap<>()); //600
        manager1.add(1, 200);
        manager1.add(2, 100);
        manager1.add(3, 300);

        ManagerImpl manager2 = new ManagerImpl(new HashMap<>()); //13000
        manager2.add(1, 3000);
        manager2.add(1, 10000);

        ManagerImpl manager3 = new ManagerImpl(new HashMap<>()); //1800
        manager3.add(1, 1000);
        manager3.add(4, 800);

        managers[0] = manager1;
        managers[1] = manager2;
        managers[2] = manager3;
    }

    @Test
    public void comparableIsWork() {
        Arrays.stream(managers).forEach(System.out::println);
        Arrays.sort(managers);
        System.out.println("AFTER SORT: \n");
        Arrays.stream(managers).forEach(System.out::println);
    }

    @Test
    public void ComparatorIsWork() {
        Arrays.stream(managers).forEach(System.out::println);
        Arrays.sort(managers, new DaysAfterMinComparator(2000));
        System.out.println("AFTER SORT: \n");
        Arrays.stream(managers).forEach(System.out::println);
    }
}
