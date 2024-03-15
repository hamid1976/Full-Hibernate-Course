package com.OneToOne;


import javax.persistence.*;

@Entity
public class Student1{

    @Id
    @Column(name="student_id")
    private int studentId;
    private String name;
    private int age;

    @OneToOne
    @JoinColumn(name="dept_id")
    private Department dept;

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Student1(){
        super();
    }
    public Student1(int studentId, String name, int age) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
