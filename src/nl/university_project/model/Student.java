package nl.university_project.model;

import java.io.Serializable;

public class Student extends User implements Serializable {

    private String group;

    public Student(int id, String firstName, String lastName, String birthdate, int age, String email, String password, String group) {
        super(id, firstName, lastName, birthdate, age, email, password);
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
