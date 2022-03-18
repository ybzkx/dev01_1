package com.fc.test;

import com.fc.dao.StudentMapper;
import com.fc.entity.Student;
import com.fc.entity.StudentExample;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class GeneratorTest {

    //查询全部
    @Test
    public void testFindAll(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectByExample(null);

        for (Student student : students) {
            System.out.println(student);
        }

    }

    @Test
    public void testInsert(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);

        Student student = new Student();

        student.setName("汤布里不");
        student.setAge((byte) 2);

        int i = mapper.insertSelective(student);

        MyBatisUtil.commit();
    }

    //查询条件
    @Test
    public void testCountByAgeEqual(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);

        StudentExample example = new StudentExample();

        //获取标准规范
        StudentExample.Criteria criteria = example.createCriteria();

        //添加查询条件
        criteria.andNameLike("%凯%");
        long count = mapper.countByExample(example);

        System.out.println(count);
    }

    //查询全部并且携带大文本
    @Test
    public void testCount(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);

        long num = mapper.countByExample(null);

        System.out.println(num);
    }

    //查询全部并且携带大文本
    @Test
    public void testFindAllWithText(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectByExampleWithBLOBs(null);

        for (Student student: students){
            System.out.println(student);
        }
    }
}
