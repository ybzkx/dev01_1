package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BindTest {
    @Test
    public void testFindByIdAndName(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findByIdAndName(1, "李易峰");

            System.out.println(student);

            session.commit();

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindByIdAndAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findByIdAndAge(3, 20);

            System.out.println(student);

            session.commit();

            session.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByNameAndAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findByNameAndAge("谭松韵", 22);

            System.out.println(student);

            session.commit();

            session.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByIdAndGender(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Map<String , Object> map = new HashMap<>();

            map.put("id",2);
            map.put("gender",'女');

            Student student = studentDao.findByIdAndGender(map);

            System.out.println(student);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("派大星");
            student.setAge((byte) 6);
            student.setGender("男");
            student.setBirthday(new Date(2015,7,7));
            student.setInfo("五角大星");

            int affectedRows = studentDao.insert(student);

            session.commit();

            session.close();

            System.out.println("受影响的行数："+affectedRows);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findById(13);

            System.out.println(student);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
