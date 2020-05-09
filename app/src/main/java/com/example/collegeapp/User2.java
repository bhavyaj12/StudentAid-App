package com.example.collegeapp;

public class User2 {
    private String Author;
    private String BookName;
    private String Branch;
    private Long Contact;
    private String StudentName;

    public User2() {
    }

    public User2(String author, String bookName, String branch, Long contact, String studentName) {
        Author = author;
        BookName = bookName;
        Branch = branch;
        Contact = contact;
        StudentName = studentName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public Long getContact() {
        return Contact;
    }

    public void setContact(Long contact) {
        Contact = contact;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
}
