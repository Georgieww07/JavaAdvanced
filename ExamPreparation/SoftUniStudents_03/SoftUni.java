package ExamPreparation.SoftUniStudents_03;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (this.capacity > this.data.size() && !this.data.contains(student)) {
            this.data.add(student);
            return String.format("Added student " + student.getFirstName() + " " + student.getLastName() + ".");
        } else if (this.capacity > this.data.size() && this.data.contains(student)) {
            return "Student is already in the hall.";
        } else if (this.capacity <= this.data.size()){
            return "The hall is full.";
        }
return null;
    }

    public String remove(Student student) {
        if (this.data.contains(student)) {
            this.data.remove(student);
            return String.format("Removed student " + student.getFirstName() + " " + student.getLastName() + ".");
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        //Hall size: {addedStudentsCount}
        // Student: {firstName} {lastName}, Best Course = {bestCourse}
        // Student: {firstName} {lastName}, Best Couse = {bestCourse}

        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: " + this.data.size()).append(System.lineSeparator());
        this.data.stream().forEach(student -> sb.append(student).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}




























