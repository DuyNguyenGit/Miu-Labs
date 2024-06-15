package lesson11.labs.prob6;

public class Manager extends Employee {
    private int bonus;

    public Manager(int id, String n, int s, int bonus) {
        super(id, n, s);
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Manager)) {
            return false;
        }
        Manager m = (Manager) obj;
        return this.id == m.id && this.salary == m.salary && this.name.equals(m.name) && this.bonus == m.bonus;
    }
}
