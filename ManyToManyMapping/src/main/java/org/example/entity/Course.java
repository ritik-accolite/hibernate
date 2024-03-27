package org.example.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int courseId;

    @ManyToMany(mappedBy = "course")
    private List<Student> student;

    public int getId() {
        return id;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getcourseId() {
        return courseId;
    }

    public void setcourseId(int courseId) {
        this.courseId = courseId;
    }



    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", student=");

        for(Student s : getStudent()){
            res.append(s.getfName()).append(" ").append(s.getlName()).append(", ");
        }

        res.append("}");

        return res.toString();
    }
}