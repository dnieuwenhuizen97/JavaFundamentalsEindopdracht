package nl.university_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nl.university_project.model.Report;
import nl.university_project.model.Student;

public class ShowReportWindow {

    private Report report;
    private InitUsers allUsers;
    private Stage stage;

    public ShowReportWindow(Report report, InitUsers allUsers) {
        this.report = report;
        this.allUsers = allUsers;
        this.stage = new Stage();
        setUp();
    }

    private void setUp() {
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Report of: " + report.getLastName() + ", " + report.getFirstName());
        stage.setMinWidth(600);
        stage.setMinHeight(300);

        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));

        updateReportForm(layout);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private void updateReportForm(VBox layout) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(8);

        Label reportNameLabel = new Label("Report of student:   " + report.getFirstName() + " " + report.getLastName());
        reportNameLabel.setStyle("-fx-font-weight: bold");
        Label sIdLabel = new Label("Student Id:                 " + report.getStudentId());
        sIdLabel.setStyle("-fx-font-weight: bold");
        Label fNameLabel = new Label("First name:               " + report.getFirstName());
        fNameLabel.setStyle("-fx-font-weight: bold");
        Label lNameLabel = new Label("Last name:                " + report.getLastName());
        lNameLabel.setStyle("-fx-font-weight: bold");
        Label ageLabel = new Label("Age:                            " + report.getAge());
        ageLabel.setStyle("-fx-font-weight: bold");

        Label javaLabel = new Label("Java:");
        TextField javaGradeInput = new TextField(report.getJavaGrade().toString());

        Label cSharpLabel = new Label("CSharp:");
        TextField cSharpGradeInput = new TextField(report.getCSharpGrade().toString());

        Label pythonLabel = new Label("Python:");
        TextField pythonGradeInput = new TextField(report.getPythonGrade().toString());

        Label phpLabel = new Label("PHP:");
        TextField phpGradeInput = new TextField(report.getPhpGrade().toString());

        Button updateReportBtn = new Button("Update Report");

        Label passedLabel = new Label();
        passedLabel.setStyle("-fx-font-weight: bold");

        GridPane.setConstraints(reportNameLabel, 0, 0);
        GridPane.setConstraints(sIdLabel, 0, 1);
        GridPane.setConstraints(fNameLabel, 0, 2);
        GridPane.setConstraints(lNameLabel, 0, 3);
        GridPane.setConstraints(ageLabel, 0, 4);
        GridPane.setConstraints(javaLabel, 0, 5);
        GridPane.setConstraints(javaGradeInput, 1, 5);
        GridPane.setConstraints(cSharpLabel, 0, 6);
        GridPane.setConstraints(cSharpGradeInput, 1, 6);
        GridPane.setConstraints(pythonLabel, 0, 7);
        GridPane.setConstraints(pythonGradeInput, 1, 7);
        GridPane.setConstraints(phpLabel, 0, 8);
        GridPane.setConstraints(phpGradeInput, 1, 8);
        GridPane.setConstraints(updateReportBtn, 1, 10);
        GridPane.setConstraints(passedLabel, 0, 12);


        gridPane.getChildren().addAll(reportNameLabel, sIdLabel, fNameLabel, lNameLabel, ageLabel, javaLabel, javaGradeInput, cSharpLabel, cSharpGradeInput, pythonLabel, pythonGradeInput, phpLabel, phpGradeInput, updateReportBtn, passedLabel);

        layout.getChildren().add(gridPane);

        if (report.getJavaGrade() > 54 && report.getCSharpGrade() > 54 && report.getPythonGrade() > 54 && report.getPhpGrade() > 54) {
            passedLabel.setText("Passed");
        }
        else {
            passedLabel.setText("Not passed");
        }

        updateReportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                allUsers.updateStudentReport(report, Integer.parseInt(javaGradeInput.getText()), Integer.parseInt(cSharpGradeInput.getText()), Integer.parseInt(pythonGradeInput.getText()), Integer.parseInt(phpGradeInput.getText()));

                System.out.println("Report updated!");
                stage.close();
            }
        });
    }

}
