package nl.saxion.application;

import nl.saxion.domain.*;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Grading {

    public static void main(String[] args) {
        new Grading().run();
    }

    private void populateDomain() {
        new Student("001234", "Dick Heijink").save();
        new Student("009876", "Jan Jaap Sandee").save();
        new Student("005678", "Etto Salomons").save();
        new Student("004321", "Michel Lammertink").save();
        new Course("SD314", "2021", "2").save();
        new Course("OOP201", "2020", "3").save();
        new Course("DUH42", "2022", "1").save();
    }

    private void run() {
        // populate domain with some objects for testing purposes
        populateDomain();
        var scanner = new Scanner(new BufferedInputStream(System.in));
        while (true) {
            System.out.print("Please enter the student number: ");
            var studentNumber = scanner.next();
            // look up student with given student number
            var student =
                    Student.getAllStudents()
                            .filter(s -> s.getNumber().equals(studentNumber))
                            .findFirst()
                            .get();
            System.out.print("Please enter the course code: ");
            var courseCode = scanner.next();
            // look up course with given course code
            var course =
                    Course.getAllCourses()
                            .filter(c -> c.getCode().equals(courseCode))
                            .findFirst()
                            .get();
            System.out.print("Please enter the grade: ");
            var score = scanner.next();
            // create new grade and save it 'persistently'
            new Grade(student, course, score).save();
            System.out.print("More grades to enter? (Yes/No) ");
            if (!scanner.next().equalsIgnoreCase("Yes")) {
                break;
            }
        }
        // show entered grades
        final String format = "%-20s %-10s %-5s\n";
        System.out.printf(format, "Student", "Course", "Score");
        System.out.printf(format, "=".repeat(20), "=".repeat(10), "=".repeat(5));
        Grade.getAllGrades().forEach(grade -> {
            var student = grade.getStudent();
            var course = grade.getCourse();
            System.out.printf(format, student.getName(), course.getCode(), grade.getScore());
        });
    }
}
