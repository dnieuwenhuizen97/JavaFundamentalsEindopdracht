package nl.university_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.university_project.model.Report;
import nl.university_project.model.Student;
import nl.university_project.model.Teacher;
import nl.university_project.model.User;

public class FillTables {


    private ObservableList<Student> students;
    private ObservableList<Teacher> teachers;
    private ObservableList<Report> reports;
    private InitUsers allUsers;

    public FillTables(InitUsers allUsers) {
        this.students = FXCollections.observableArrayList();
        this.teachers = FXCollections.observableArrayList();
        this.reports = FXCollections.observableArrayList();
        this.allUsers = allUsers;
    }

    private ObservableList<Student> getStudents() {
        for (User u : allUsers.getAllUsers()) {
            if (u instanceof Student)
                students.add((Student)u);
        }
        return students;
    }

    private ObservableList<Teacher> getTeachers() {
        for (User u : allUsers.getAllUsers()) {
            if (u instanceof Teacher)
                teachers.add((Teacher)u);
        }
        return teachers;
    }

    private ObservableList<Report> getReports() {
        for (Report r : allUsers.getAllReports()) {
            reports.add(r);
        }
        return reports;
    }

    public TableView studentTable() {
        students.clear();
        TableView<Student> tableView = new TableView<>();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableColumn<Student, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Student, String> fNameColumn = new TableColumn<>("First Name");
        TableColumn<Student, String> lNameColumn = new TableColumn<>("Last Name");
        TableColumn<Student, String> birthColumn = new TableColumn<>("Birth Date");
        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<Student, String> emailColumn = new TableColumn<>("E-mail");
        TableColumn<Student, String> groupColumn = new TableColumn<>("Group");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setMinWidth(20);
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        fNameColumn.setMinWidth(50);
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lNameColumn.setMinWidth(100);
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        birthColumn.setMinWidth(75);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageColumn.setMinWidth(20);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setMinWidth(150);
        groupColumn.setCellValueFactory(new PropertyValueFactory<>("group"));
        groupColumn.setMinWidth(30);

        tableView.getColumns().addAll(idColumn, fNameColumn, lNameColumn, birthColumn, ageColumn, emailColumn, groupColumn);
        tableView.setItems(getStudents());

        return tableView;
    }

    public TableView teacherTable() {
        teachers.clear();
        TableView<Teacher> tableView = new TableView<>();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableColumn<Teacher, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Teacher, String> fNameColumn = new TableColumn<>("First Name");
        TableColumn<Teacher, String> lNameColumn = new TableColumn<>("Last Name");
        TableColumn<Teacher, String> birthColumn = new TableColumn<>("Birth Date");
        TableColumn<Teacher, Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<Teacher, String> emailColumn = new TableColumn<>("E-mail");
        TableColumn<Teacher, Double> salaryColumn = new TableColumn<>("Salary");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setMinWidth(20);
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        fNameColumn.setMinWidth(50);
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lNameColumn.setMinWidth(100);
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        birthColumn.setMinWidth(75);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageColumn.setMinWidth(20);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setMinWidth(150);
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        salaryColumn.setMinWidth(30);

        tableView.getColumns().addAll(idColumn, fNameColumn, lNameColumn, birthColumn, ageColumn, emailColumn, salaryColumn);
        tableView.setItems(getTeachers());

        return tableView;
    }

    public TableView reportsTable() {
        reports.clear();
        TableView<Report> tableView = new TableView<>();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableColumn<Report, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Report, String> fNameColumn = new TableColumn<>("First Name");
        TableColumn<Report, String> lNameColumn = new TableColumn<>("Last Name");
        TableColumn<Report, String> birthColumn = new TableColumn<>("Birth Date");
        TableColumn<Report, Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<Report, String> emailColumn = new TableColumn<>("E-mail");
        TableColumn<Report, String> groupColumn = new TableColumn<>("Group");
        TableColumn<Report, Integer> javaColumn = new TableColumn<>("Java");
        TableColumn<Report, Integer> cSharpColumn = new TableColumn<>("CSharp");
        TableColumn<Report, Integer> pythonColumn = new TableColumn<>("Python");
        TableColumn<Report, Integer> phpColumn = new TableColumn<>("PHP");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        idColumn.setMinWidth(20);
        fNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        fNameColumn.setMinWidth(50);
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lNameColumn.setMinWidth(100);
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        birthColumn.setMinWidth(75);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ageColumn.setMinWidth(20);
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailColumn.setMinWidth(150);
        groupColumn.setCellValueFactory(new PropertyValueFactory<>("group"));
        groupColumn.setMinWidth(30);
        javaColumn.setCellValueFactory(new PropertyValueFactory<>("javaGrade"));
        cSharpColumn.setCellValueFactory(new PropertyValueFactory<>("cSharpGrade"));
        pythonColumn.setCellValueFactory(new PropertyValueFactory<>("pythonGrade"));
        phpColumn.setCellValueFactory(new PropertyValueFactory<>("phpGrade"));

        tableView.getColumns().addAll(idColumn, fNameColumn, lNameColumn, birthColumn, ageColumn, emailColumn, groupColumn, javaColumn, cSharpColumn, pythonColumn, phpColumn);
        tableView.setItems(getReports());

        return tableView;
    }

}
