package ru.hogwarts.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;

    public Faculty() {}
    public Faculty(String name, String color) {
        this.id = 0L;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }


}
