package wsb.po.szescTODO;

import java.util.Objects;

public class Osoba implements Comparable<Osoba> {

    private String name;
    private int priority;

    public int getPriority() {
        return priority;
    }

    public Osoba(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Osoba)) return false;
        Osoba osoba = (Osoba) o;
        return getPriority() == osoba.getPriority() && name.equals(osoba.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getPriority());
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Osoba o) {
        return Integer.compare(this.getPriority(),o.getPriority());
    }
}
