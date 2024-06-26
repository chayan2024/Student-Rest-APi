package org.example.studentrestapi.model;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int _id, String _name, int _age) {
        this.id = _id;
        this.name = _name;
        this.age = _age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

