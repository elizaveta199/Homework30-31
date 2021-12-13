package hm31orm.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ManagerId implements Serializable {
    private Integer id;
    private Integer day;

    public ManagerId() {
    }

    public ManagerId(Integer id, Integer day) {
        this.id = id;
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerId managerId = (ManagerId) o;
        return Objects.equals(id, managerId.id) && Objects.equals(day, managerId.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day);
    }

    @Override
    public String toString() {
        return "ManagerId{" +
                "id=" + id +
                ", day=" + day +
                '}';
    }
}
