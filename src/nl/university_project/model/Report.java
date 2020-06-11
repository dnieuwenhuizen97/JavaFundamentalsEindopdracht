package nl.university_project.model;

import java.io.Serializable;

public class Report implements Serializable {

    private Student student;
    private int studentId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;
    private String email;
    private String group;
    private Integer javaGrade;
    private Integer cSharpGrade;
    private Integer pythonGrade;
    private Integer phpGrade;

    public Report(Student student, Integer javaGrade, Integer cSharpGrade, Integer pythonGrade, Integer phpGrade) {
        this.studentId = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.birthDate = student.getBirthdate();
        this.age = student.getAge();
        this.email = student.getEmail();
        this.group = student.getGroup();
        this.student = student;
        this.javaGrade = javaGrade;
        this.cSharpGrade = cSharpGrade;
        this.pythonGrade = pythonGrade;
        this.phpGrade = phpGrade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getJavaGrade() {
        return javaGrade;
    }

    public void setJavaGrade(Integer javaGrade) {
        this.javaGrade = javaGrade;
    }

    public Integer getCSharpGrade() {
        return cSharpGrade;
    }

    public void setCSharpGrade(Integer cSharpGrade) {
        this.cSharpGrade = cSharpGrade;
    }

    public Integer getPythonGrade() {
        return pythonGrade;
    }

    public void setPythonGrade(Integer pythonGrade) {
        this.pythonGrade = pythonGrade;
    }

    public Integer getPhpGrade() {
        return phpGrade;
    }

    public void setPhpGrade(Integer phpGrade) {
        this.phpGrade = phpGrade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
