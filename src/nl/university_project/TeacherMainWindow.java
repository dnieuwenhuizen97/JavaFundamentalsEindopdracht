package nl.university_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.university_project.model.Report;
import nl.university_project.model.Student;
import nl.university_project.model.Teacher;
import nl.university_project.model.User;

public class TeacherMainWindow {

    private FillTables fillTables;
    private User currentUser;
    private InitUsers allUsers;

    public TeacherMainWindow(User currentUser, InitUsers allUsers) {
        this.allUsers = allUsers;
        this.fillTables = new FillTables(allUsers);
        this.currentUser = currentUser;
        setUp();
    }

    public void setUp() {
        Stage stage = new Stage();
        stage.setTitle("Hello mr./mrs. " + currentUser.getLastName() + " (editor access)");
        stage.setMinWidth(600);
        stage.setMinHeight(300);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Menu");
        Menu usersMenu = new Menu("Users");
        Menu reportsMenu = new Menu("Reports");

        MenuItem studentsMenu = new MenuItem("Students");
        MenuItem teachersMenu = new MenuItem("Teachers");
        MenuItem exitMenu = new MenuItem("Logout");
        MenuItem showReportsMenu = new MenuItem("Show reports");

        menu.getItems().add(exitMenu);
        usersMenu.getItems().addAll(studentsMenu, teachersMenu);
        reportsMenu.getItems().add(showReportsMenu);
        menuBar.getMenus().addAll(menu, usersMenu, reportsMenu);

        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.getChildren().add(menuBar);


        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

        studentsMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout.getChildren().clear();
                TableView<Student> studentTableView = fillTables.studentTable();
                stage.setMinHeight(500);
                layout.getChildren().add(menuBar);
                addStudentForm(layout, studentTableView);
                layout.getChildren().add(studentTableView);
            }
        });

        teachersMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout.getChildren().clear();
                TableView<Teacher> teacherTableView = fillTables.teacherTable();
                layout.getChildren().addAll(menuBar, teacherTableView);
            }
        });

        exitMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                try {
                    new Main().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button showReportBtn = new Button("Show Report");
        showReportsMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setMinWidth(800);
                layout.getChildren().clear();
                TableView<Report> reportTableView = fillTables.reportsTable();
                layout.getChildren().addAll(menuBar, reportTableView, showReportBtn);

                showReportBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        new ShowReportWindow(reportTableView.getSelectionModel().getSelectedItem(), allUsers);
                    }
                });
            }
        });
    }

    private void addStudentForm(VBox layout, TableView<Student> tableView) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(8);

        Label fNameLabel = new Label("First name:");
        TextField fNameInput = new TextField();
        fNameInput.setPromptText("First name");

        Label lNameLabel = new Label("Last name:");
        TextField lNameInput = new TextField();
        lNameInput.setPromptText("Last name");

        Label birthDateLabel = new Label("Birth date:");
        TextField birthDateInput = new TextField();
        birthDateInput.setPromptText("Birth date dd/mm/yyyy");

        Label ageLabel = new Label("Age:");
        TextField ageInput = new TextField();
        ageInput.setPromptText("Age");

        Label emailLabel = new Label("Email:");
        TextField emailInput = new TextField();
        emailInput.setPromptText("Email");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label groupLabel = new Label("Group:");
        TextField groupInput = new TextField();
        groupInput.setPromptText("Group");

        Button addStudentbtn = new Button("Add Student");
        Button deleteStudentBtn = new Button("Delete Student");

        GridPane.setConstraints(fNameLabel, 0, 0);
        GridPane.setConstraints(fNameInput, 1, 0);
        GridPane.setConstraints(lNameLabel, 0, 1);
        GridPane.setConstraints(lNameInput, 1, 1);
        GridPane.setConstraints(birthDateLabel, 0, 2);
        GridPane.setConstraints(birthDateInput, 1, 2);
        GridPane.setConstraints(ageLabel, 0, 3);
        GridPane.setConstraints(ageInput, 1, 3);
        GridPane.setConstraints(emailLabel, 2, 0);
        GridPane.setConstraints(emailInput, 3, 0);
        GridPane.setConstraints(passwordLabel, 2, 1);
        GridPane.setConstraints(passwordField, 3, 1);
        GridPane.setConstraints(groupLabel, 2, 2);
        GridPane.setConstraints(groupInput, 3, 2);
        GridPane.setConstraints(addStudentbtn, 2, 4);
        GridPane.setConstraints(deleteStudentBtn, 3, 4);
        gridPane.getChildren().addAll(fNameLabel, fNameInput, lNameLabel, lNameInput, birthDateLabel, birthDateInput, ageLabel, ageInput, emailLabel, emailInput, passwordLabel, passwordField, groupLabel, groupInput, addStudentbtn, deleteStudentBtn);

        layout.getChildren().add(gridPane);

        addStudentbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Student s = new Student(
                        allUsers.generateUserId(),
                        fNameInput.getText(),
                        lNameInput.getText(),
                        birthDateInput.getText(),
                        Integer.parseInt(ageInput.getText()),
                        emailInput.getText(),
                        passwordField.getText(),
                        groupInput.getText());
                allUsers.addStudentUser(s);

                allUsers.createReport(new Report(s, 0, 0, 0, 0));

                fNameInput.clear();
                lNameInput.clear();
                birthDateInput.clear();
                ageInput.clear();
                emailInput.clear();
                passwordField.clear();
                groupInput.clear();

                System.out.println("User added!");
            }
        });

        deleteStudentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                allUsers.deleteStudentUser(tableView.getSelectionModel().getSelectedItem());
                System.out.println("User deleted!");
            }
        });

    }

}
