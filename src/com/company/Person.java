package com.company;

public class Person {

    private String name;
    private String surname;
    private Integer salary;

    public Person(String name, String surname , Integer salary){
        setName(name);
        setSurname(surname);
        setSalary(salary);
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$salary = this.getSalary();
        final Object other$salary = other.getSalary();
        if (this$salary == null ? other$salary != null : !this$salary.equals(other$salary)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $salary = this.getSalary();
        result = result * PRIME + ($salary == null ? 43 : $salary.hashCode());
        return result;
    }

    public String toString() {
        return "Person(name=" + this.getName() + ", surname=" + this.getSurname() + ", salary=" + this.getSalary() + ")";
    }
}
