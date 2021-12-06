import exception.IllegalDayException;
import exception.IllegalStepsException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ManagerImpl implements ManagerI {
    private final Map<Integer, Integer> store;

    public ManagerImpl(Map<Integer, Integer> store) {
        this.store = store;
    }

    /**
     * Метод добавляет в store по ключу день количество пройденных шагов
     * Если данный день уже присутствует в store, то он прибавляет шаги к существующим
     *
     * @param day   - день
     * @param steps - количество пройденных шагов
     */
    @Override
    public void add(int day, int steps) throws IllegalDayException, IllegalStepsException {
        if (day > 365 || day < 1) {
            throw new IllegalDayException("День не может быть > 365 или < 1");
        }
        if (steps < 0) {
            throw new IllegalStepsException("Шаги не могут быть отрицательными");
        }

        if (store.containsKey(day)) {
            store.put(day, store.get(day) + steps);
        } else {
            store.put(day, steps);
        }
    }

    /**
     * Получение количества шагов превыщаюшего максимум
     *
     * @param day - данный день
     * @return - возвращает количество шагов в данный до превышения макс количества шагов за любой другой день
     */
    public int getStepsToMax(int day) {
        int maxSteps = 0;

        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            if (maxSteps < entry.getValue()) {
                maxSteps = entry.getValue() + 1;
            }
        }

        return store.containsKey(day) ? maxSteps - store.get(day) : maxSteps;
    }

    /**
     * Геттер для store
     *
     * @return store
     */
    public Map<Integer, Integer> getStore() {
        return store;
    }

    /**
     * Сумма всех шагов за все дни у текущего менеджера
     *
     * @return
     */
    public int getSumSteps() {
        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    /**
     * Который возвращает стрим из всех дней, когда было больше чем steps шагов
     *
     * @param steps - шаги
     * @return
     */

    public Stream<Integer> getAllAbove(int steps) {
        return store.entrySet()
                .stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue() > steps)
                .map(Map.Entry::getKey);
    }

    /**
     * Метод из интерфейса Comparable
     *
     * @param o - объект с которым сравнивается текущий объект
     * @return - результат (-1 0 1)
     */
    @Override
    public int compareTo(ManagerI o) {
        return o.getSumSteps() - getSumSteps();
    }

    /**
     * Переопределение метода класса Object
     *
     * @return string
     */
    @Override
    public String toString() {
        return "ManagerImpl{" +
                "store steps=" + getSumSteps() + " " +
                "days count=" + store.size() +
                '}';
    }
}




