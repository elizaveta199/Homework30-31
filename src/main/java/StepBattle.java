import exception.IllegalDayException;
import exception.IllegalStepsException;

import java.util.List;

public class StepBattle {

    private final List<ManagerI> members;

    public StepBattle(List<ManagerI> members) {
        this.members = members;
    }

    public void addSteps(int player, int day, int steps) throws IllegalDayException, IllegalStepsException {
        this.members.get(player).add(day, steps);
    }

    public int winner() {
        int max = 0;
        int winner = -1;

        for (int i = 0; i < members.size(); i++) {
            int sumSteps = members.get(i).getSumSteps();

            if (max <= sumSteps) {
                max = sumSteps;
                winner = i;
            }
        }

        return winner;
    }
}

