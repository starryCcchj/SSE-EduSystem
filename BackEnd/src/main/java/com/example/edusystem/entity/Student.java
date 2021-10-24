package com.example.edusystem.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "Student对象")
public class Student {
    public Student(int studentId, String studentName, String studentPassword,String studentEmail, String studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;

        this.studentPassword = studentPassword;
        this.studentEmail = studentEmail;
        this.studentStatus = studentStatus;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    //    student_id	int	11	0	0	0	-1	0									0	0	0	0	-1	0	0
    //    student_name	varchar	255	0	0	0	0	0							utf8	utf8_general_ci	0	0	0	0	0	0	0
    //    student_password	varchar	255	0	0	0	0	0							utf8	utf8_general_ci	0	0	0	0	0	0	0
    //    student_email	varchar	255	0	0	0	0	0							utf8	utf8_general_ci	0	0	0	0	0	0	0
    //    student_status	varchar	255	0	0	0	0	0							utf8	utf8_general_ci	0	0	0	0	0	0	0


    private int studentId;
    private String studentName;
    private String studentPassword;
    private String studentEmail;
    private String studentStatus;
}
