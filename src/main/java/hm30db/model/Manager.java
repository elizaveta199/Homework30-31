package hm30db.model;

public class Manager {
    private int id;
    private int day;
    private int steps;

    public Manager(int id, int day, int steps) {
        this.id = id;
        this.day = day;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", day=" + day +
                ", steps=" + steps +
                '}';
    }
}
