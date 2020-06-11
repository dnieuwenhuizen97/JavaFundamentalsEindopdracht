package nl.university_project;

import nl.university_project.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InitUsers {

    private List<User> allUsers;
    private List<Report> allReports;

    public InitUsers() {
        this.allUsers = new ArrayList<User>();
        this.allReports = new ArrayList<>();
        loadAllUsers();
        loadAllReports();
    }

    public int generateUserId() {
        return allUsers.size() + 1;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void deleteStudentUser(Student s) {
        allUsers.remove(s);
        allReports.remove(findReportByStudent(s));
        saveAllUsers();
        saveAllReports();
    }

    public Report findReportByStudent(Student s) {
        for (Report r : allReports) {
            if (r.getStudent() == s)
                return r;
        }
        return null;
    }

    public void updateStudentReport(Report report, int java, int cSharp, int python, int php) {
        report.setJavaGrade(java);
        report.setCSharpGrade(cSharp);
        report.setPythonGrade(python);
        report.setPhpGrade(php);
        saveAllReports();
    }

    public List<Report> getAllReports() {
        return allReports;
    }

    public void createReport(Report report) {
        allReports.add(report);
    }

    private void saveAllUsers()
    {
        System.out.println("Saving...");
        try (FileOutputStream fos = new FileOutputStream(new File("src/nl/university_project/initFiles/allUsers.doc"));
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            for (User u : allUsers)
            {
                oos.writeObject(u);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void saveAllReports()
    {
        System.out.println("Saving...");
        try (FileOutputStream fos = new FileOutputStream(new File("src/nl/university_project/initFiles/studentReports.doc"));
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            for (Report r : allReports)
            {
                oos.writeObject(r);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void loadAllUsers()
    {
        allUsers.clear();
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(new File("src/nl/university_project/initFiles/allUsers.doc"));
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            while (true)
            {
                try
                {
                    User item = (User) ois.readObject();
                    allUsers.add(item);
                }
                catch (EOFException eofe)
                {
                    break;
                }
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File not found");
        }
        catch (IOException ioe)
        {
            System.out.println("other exception");
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
    }

    public void addStudentUser(Student user) {
        allUsers.add(user);
        saveAllUsers();
    }

    private void loadAllReports()
    {
        allReports.clear();
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(new File("src/nl/university_project/initFiles/studentReports.doc"));
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            while (true)
            {
                try
                {
                    Report item = (Report) ois.readObject();
                    allReports.add(item);
                }
                catch (EOFException eofe)
                {
                    break;
                }
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File not found");
        }
        catch (IOException ioe)
        {
            System.out.println("other exception");
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
    }
}
