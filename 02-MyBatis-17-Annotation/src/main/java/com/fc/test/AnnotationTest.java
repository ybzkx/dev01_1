package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.Date;

public class AnnotationTest {
    @Test
    public void testFindAll(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        studentDao.findAll();

        MyBatisUtil.commit();
    }

    @Test
    public void testFindById(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        studentDao.findById(3);

        MyBatisUtil.commit();
    }

    @Test
    public void testInsert(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setName("猪小肠");
        student.setGender("男");
        student.setAge((byte) 3);
        student.setBirthday(new Date());
        student.setInfo("大肠包小肠");

        studentDao.insert(student);

        MyBatisUtil.commit();
    }

    @Test
    public void testUpdate(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(1);
        student.setInfo("国民大叔");

        studentDao.update(student);
        MyBatisUtil.commit();
    }


    @Test
    public void testDelete(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        studentDao.delete(16);
        MyBatisUtil.commit();
    }
}

