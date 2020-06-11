package nl.university_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.university_project.model.Student;
import nl.university_project.model.Teacher;
import nl.university_project.model.User;

public class StudentMainWindow {

    private FillTables fillTables;
    private User currentUser;

    public StudentMainWindow(User currentUser, InitUsers allUsers) {
        this.fillTables = new FillTables(allUsers);
        this.currentUser = currentUser;
        setUp();
    }

    public void setUp() {
        Stage stage = new Stage();
        stage.setTitle("Hello " + currentUser.getFirstName() + " (basic access)");
        stage.setMinWidth(600);
        stage.setMinHeight(300);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Menu");
        Menu usersMenu = new Menu("Users");

        MenuItem studentsMenu = new MenuItem("Students");
        MenuItem teachersMenu = new MenuItem("Teachers");
        MenuItem exitMenu = new MenuItem("Logout");

        menu.getItems().addAll(exitMenu);
        usersMenu.getItems().addAll(studentsMenu, teachersMenu);
        menuBar.getMenus().addAll(menu, usersMenu);

        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.getChildren().add(menuBar);

        studentsMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                layout.getChildren().clear();
                TableView<Student> studentTableView = fillTables.studentTable();
                stage.setMinHeight(500);
                layout.getChildren().add(menuBar);
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

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }


}
