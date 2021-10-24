package com.example.edusystem.mapper;


import com.example.edusystem.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentMapper {

    @Insert("insert into student(student_name,student_password,student_email,student_status) " +
            "values(#{studentName},#{studentPassword},#{studentEmail},#{studentStatus})")
    int registerStudent(@Param("studentName") String studentName, @Param("studentPassword")
            String studentPassword, @Param("studentEmail") String studentEmail, @Param("studentStatus") int studentStatus);

    @Select("select * from student where student_id=#{studentId}")
    Student loginStudent(@Param("studentId") int studentId);
}
