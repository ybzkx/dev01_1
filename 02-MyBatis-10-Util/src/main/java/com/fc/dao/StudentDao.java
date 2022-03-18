package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查询全部
    List<Student> findAll();

    //根据id查询
    Student findById(@Param("id") Integer id);

}
