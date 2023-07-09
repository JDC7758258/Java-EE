package com.jdc.pojo;

import java.util.List;

public class IClass {
    private int id;
    private String className;

    //一对多的映射
    private List<Student> studentList;

    @Override
    public String toString() {
        return "IClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
