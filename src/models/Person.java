package models;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    protected String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected int getAge() {
        return this.age;
    }

}