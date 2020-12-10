package com.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashEqualContract {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setName("test");
        Map<Employee,Integer> empMap = new HashMap<>();
        empMap.put(e,1);
        empMap.forEach((k,v)-> System.out.println(v+"="+k));
        System.out.println("hashcode override in Employee");
        Employee e2 =new Employee("test");
        System.out.println("hash code e1="+e.hashCode());
        System.out.println("hash code e2="+e2.hashCode());
        System.out.println(e.equals(e2));
        System.out.println(empMap.get(e2));
        empMap.put(e2,2);
        System.out.println(empMap.get(e2));

        Student s = new Student();
        s.setName("test");
        Map<Student,Integer> stdMap = new HashMap<>();
        stdMap.put(s,1);
        stdMap.forEach((k,v)-> System.out.println(v+"="+k));
        System.out.println("equals override in Employee");
        Student s2 =new Student("test");
        System.out.println("hash code s1="+s.hashCode());
        System.out.println("hash code s2="+s2.hashCode());
        System.out.println(stdMap.get(s2));

    }
}


class Employee{
    String name;

    public Employee(String name) {
        this.name=name;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student{

    String name;
    public Student(String name) {
        this.name=name;
    }

    public Student() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }
}
