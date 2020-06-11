package nl.university_project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nl.university_project.model.Student;
import nl.university_project.model.Teacher;
import nl.university_project.model.User;

import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception{

        InitUsers initUsers = new InitUsers();
        window.setTitle("University Application");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(8);

        Label userLabel = new Label("Username:");
        TextField userInput = new TextField();
        userInput.setPromptText("username");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("password");

        Button loginButton = new Button("Log in");

        Label wrongCredentialsLabel = new Label();

        loginButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {

                String username = userInput.getText();
                String password = passwordField.getText();

                List<User> allUsers = initUsers.getAllUsers();

                for (User u : allUsers) {
                    if (username.equals(u.getEmail()) && password.equals(u.getPassword())) {
                        System.out.println("Logged in!");
                        window.close();
                        toMainWindow(u, initUsers);
                    }
                }
                wrongCredentialsLabel.setText("Invalid username or password!");
            }
        });

        GridPane.setConstraints(userLabel, 0, 0);
        GridPane.setConstraints(userInput, 1, 0);
        GridPane.setConstraints(passwordLabel, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(loginButton, 1, 2);
        GridPane.setConstraints(wrongCredentialsLabel, 1, 4);
        gridPane.getChildren().addAll(userLabel, userInput, passwordLabel, passwordField, loginButton, wrongCredentialsLabel);

        Scene scene = new Scene(gridPane, 300, 200);

        window.setScene(scene);
        window.show();

    }

    private void toMainWindow(User currentUser, InitUsers initUsers) {

        if (currentUser instanceof Student) {
            new StudentMainWindow(currentUser, initUsers);
        }
        else if (currentUser instanceof Teacher) {
            new TeacherMainWindow(currentUser, initUsers);
        }
        else {
            new ManagerMainWindow(currentUser, initUsers);
        }

    }


}
