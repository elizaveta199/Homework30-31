import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DaysAfterMinComparator implements Comparator<ManagerImpl> {
    private int minSteps;

    public DaysAfterMinComparator(int minSteps) {
        this.minSteps = minSteps;
    }

    /**
     * сравнение по количеству дней, в которых шагов больше минимума (минимум должен задаваться в конструкторе компаратора).
     *
     * @param o1 - 1 менеджер
     * @param o2 - 2 менеджер
     * @return - результат сравнения
     */
    @Override
    public int compare(ManagerImpl o1, ManagerImpl o2) {
        int temp1 = 0, temp2 = 0;

        for (Map.Entry<Integer, Integer> entry : o1.getStore().entrySet()) {
            if (entry.getValue() > minSteps) {
                temp1++;
            }
        }

        for (Map.Entry<Integer, Integer> entry : o2.getStore().entrySet()) {
            if (entry.getValue() > minSteps) {
                temp2++;
            }
        }
        return temp2 - temp1;
    }

//    public static void main(String[] args) {
//        ManagerImpl managerImpl1 = new ManagerImpl(new HashMap<>());
//        managerImpl1.add(1, 1500);
//        managerImpl1.add(3, 3500);
//        managerImpl1.add(2, 500);
//        managerImpl1.add(9, 10000);
//
//        ManagerImpl managerImpl2 = new ManagerImpl(new HashMap<>());
//        managerImpl1.add(1, 600);
//        managerImpl1.add(3, 6500);
//        managerImpl1.add(7, 2200);
//        managerImpl1.add(9, 5500);


//        DaysAfterMinComparator daysAfterMinComparator = new DaysAfterMinComparator(599);
//        System.out.println(daysAfterMinComparator.compare(managerImpl1, managerImpl2));


}

