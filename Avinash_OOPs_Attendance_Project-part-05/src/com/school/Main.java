package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Part-5: create people
        Student s1 = new Student("Alice", "10th");
        Student s2 = new Student("Bob", "9th");

        Teacher t1 = new Teacher("Mr. Smith", "Mathematics");
        Staff st1 = new Staff("Mrs. Clark", "Administrator");

        s1.displayDetails();
        System.out.println();
        t1.displayDetails();
        System.out.println();
        st1.displayDetails();
        System.out.println();

        // Part-6: create lists and persist
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        List<Course> courses = new ArrayList<>();
        Course c1 = new Course("C101", "Mathematics");
        Course c2 = new Course("C102", "Science");
        courses.add(c1);
        courses.add(c2);

        List<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(s1.getId(), c1.getCourseId(), "Present"));
        records.add(new AttendanceRecord(s2.getId(), c2.getCourseId(), "Absent"));

        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("Data saved to students.txt, courses.txt, attendance_log.txt");
    }
}
