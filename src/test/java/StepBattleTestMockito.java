import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class StepBattleTestMockito {

    private List<ManagerI> managers;

    @Test
    public void secondManagerShouldWinWhenGetMoreSteps() {
        ManagerImpl first = mock(ManagerImpl.class);
        when(first.getSumSteps()).thenReturn(1000);

        ManagerImpl second = mock(ManagerImpl.class);
        when(second.getSumSteps()).thenReturn(2000);

        managers = Arrays.asList(first, second);
        StepBattle stepBattle = new StepBattle(managers);

        Assertions.assertEquals(1, stepBattle.winner());
    }

    @Test
    public void firstManagerShouldWinWhenGetMoreSteps() {
        ManagerImpl first = mock(ManagerImpl.class);
        when(first.getSumSteps()).thenReturn(3000);

        ManagerImpl second = mock(ManagerImpl.class);
        when(second.getSumSteps()).thenReturn(500);

        managers = Arrays.asList(first, second);
        StepBattle stepBattle = new StepBattle(managers);

        Assertions.assertEquals(0, stepBattle.winner());
    }

    @Test
    public void thirdManagerShouldWinWhenGetMoreSteps() {
        ManagerImpl first = mock(ManagerImpl.class);
        when(first.getSumSteps()).thenReturn(500);

        ManagerImpl second = mock(ManagerImpl.class);
        when(second.getSumSteps()).thenReturn(1500);

        ManagerImpl third = mock(ManagerImpl.class);
        when(third.getSumSteps()).thenReturn(3000);

        ManagerImpl fourth = mock(ManagerImpl.class);
        when(fourth.getSumSteps()).thenReturn(2000);

        StepBattle stepBattle = new StepBattle(Arrays.asList(first, second, third, fourth));

        Assertions.assertEquals(2, stepBattle.winner());
    }
}
