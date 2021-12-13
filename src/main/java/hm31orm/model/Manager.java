package hm31orm.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "manager")
@Entity(name = "Manager")
public class Manager {
    @EmbeddedId
    private ManagerId managerId;
    private int steps;

    public Manager() {
    }

    public Manager(ManagerId managerId, int steps) {
        this.managerId = managerId;
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public ManagerId getManagerId() {
        return managerId;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", steps=" + steps +
                '}';
    }
}
