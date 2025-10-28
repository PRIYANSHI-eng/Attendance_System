package com.school;

public class AttendanceRecord implements Storable {
    private int studentId;
    private String courseId;
    private String status; // e.g., Present/Absent

    public AttendanceRecord(int studentId, String courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}
