package ru.ldwx.crm.model;

import java.util.Objects;

public class PersonDto {
    private Long id;
    private String name;
    private int age;

    public PersonDto(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return age == personDto.age &&
                Objects.equals(id, personDto.id) &&
                Objects.equals(name, personDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
