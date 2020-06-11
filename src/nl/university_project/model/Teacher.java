package nl.university_project.model;

import java.io.Serializable;

public class Teacher extends User implements Serializable {

    private double salary;

    public Teacher(int id, String firstName, String lastName, String birthdate, int age, String email, String password, double salary) {
        super(id, firstName, lastName, birthdate, age, email, password);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
