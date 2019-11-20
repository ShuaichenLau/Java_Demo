package com.alice.mapper;

import com.alice.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM Student WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO Student(NAME, AGE,ADDRESS) VALUES(#{name}, #{age},#{address})")
    int insert(@Param("name") String name, @Param("age") Integer age, @Param("address") String address);

    @Select("select * from Student")
    List<Student> findAll();

}
