package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface StudentDao {
    Student findById(Integer id);
    Student findByIdAndName(Integer id, String name);
    Student findByIdAndAge(int i, Integer id);
    Student findByNameAndAge(@Param("name") String name,@Param("age") Integer age);

    Student findByIdAndGender(Map<String,Object> map);
    //使用对象进行参数绑定
    int insert(Student student);
}

