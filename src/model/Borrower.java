package model;

import java.io.Serializable;

public class Borrower implements Serializable {
    private String id;
    private String name;

    public Borrower(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
