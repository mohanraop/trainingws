package com.corejava.interviewquestions;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import static java.math.BigDecimal.valueOf;

public class CollegeStudents {
    public static void main(String[] args) {
        Student studentc1 = new Student("student78", valueOf(78));
        Student studentc2 = new Student("student60", valueOf(60));
        Student studentc3 = new Student("student77", valueOf(77));
        Student studentc4 = new Student("student35", valueOf(35));
        Student studentc5 = new Student("student25", valueOf(25));
        Student studentc6 = new Student("student87", valueOf(87));

        College college = new College("College1", List.of(studentc1, studentc2, studentc3));
        College college1 = new College("College2", List.of(studentc4));
        College college2 = new College("College3", List.of(studentc5, studentc6));

        Predicate<Student> predicate = student -> student.grade().compareTo(valueOf(75)) >= 0;

        List.of(college, college1, college2)
                .stream()
                .map(clg -> {
                    List<Student> filteredStudents = clg.students().stream()
                            .filter(predicate).toList();
                    return filteredStudents.isEmpty() ? null : new College(clg.name(), filteredStudents);
                })
                .filter(Objects::nonNull)
                .forEach(collegeWithFilteredStudents -> {
                    System.out.println("College: " + collegeWithFilteredStudents.name());
                    collegeWithFilteredStudents.students().forEach(student ->
                            System.out.println(" - " + student.name() + ": " + student.grade()));
                });
    }
}

record College(String name, List<Student> students) {}

record Student(String name, BigDecimal grade) {}
