import exception.IllegalDayException;
import exception.IllegalStepsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ExceptionTest {

    @Test
    public void addThrowIllegalDayExceptionCase1() {
        ManagerImpl manager = new ManagerImpl(new HashMap<>());
        Assertions.assertThrows(IllegalDayException.class, () -> manager.add(0, 200));
    }

    @Test
    public void addThrowIllegalDayExceptionCase2() {
        ManagerImpl manager = new ManagerImpl(new HashMap<>());
        Assertions.assertThrows(IllegalDayException.class, () -> manager.add(366, 200));
    }

    @Test
    public void addThrowIllegalDayExceptionCase3() {
        ManagerImpl manager = new ManagerImpl(new HashMap<>());
        Assertions.assertThrows(IllegalDayException.class, () -> manager.add(-100, 200));
    }

    @Test
    public void addThrowIllegalStepsException() {
        ManagerImpl manager = new ManagerImpl(new HashMap<>());
        Assertions.assertThrows(IllegalStepsException.class, () -> manager.add(2, -2));
    }
}
