package org.riwi.EjerciciosArrays.calculator;

public class Grade {
    private double grade;
    private String studentName;

    public Grade() {
    }

    public Grade(double grade, String studentName) {
        this.grade = grade;
        this.studentName = studentName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
