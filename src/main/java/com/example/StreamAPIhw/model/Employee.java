package com.example.StreamAPIhw;

public class Employee {
    private final int id;
    private static int counter;
    private final String fullName;
    private int department;
    private int salary;

    public Employee(String name, int department, int salary){
        this.id = counter;
        plusOne();
        this.fullName = name;
        this.department = department;
        this.salary = salary;
    }

    public final void plusOne(){
        counter ++;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.fullName;
    }

    public int getDepartment(){
        return this.department;
    }

    public int getSalary(){
        return this.salary;
    }

    public void setDepartment(int department){
        this.department = department;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public boolean equals(Employee other) {
        return this.id == other.id && this.fullName.equals(other.fullName) && this.department == other.department && this.salary == other.salary;
    }

    @Override
    public int hashCode() {
        return 31 * this.fullName.hashCode() + this.id + this.department + this.salary;
    }

    @Override
    public String toString() {
        return "id " + id + " name " + this.fullName + " department " + this.department + " salary " + this.salary;
    }
}