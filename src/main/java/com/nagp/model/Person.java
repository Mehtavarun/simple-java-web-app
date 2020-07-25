package com.nagp.model;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private Boolean isCitizen;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, Boolean isCitizen) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isCitizen = isCitizen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsCitizen() {
        return isCitizen;
    }

    public void setIsCitizen(Boolean isCitizen) {
        this.isCitizen = isCitizen;
    }
}
