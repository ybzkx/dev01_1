package com.fc.dao;

import com.fc.entity.Student;
import com.fc.entity.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExampleWithBLOBs(StudentExample example);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record,@Param("example") StudentExample example);

    int updateByExampleWithBLOBs(@Param("record") Student record,@Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record,@Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);
}