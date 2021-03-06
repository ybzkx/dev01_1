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
import java.util.List;

public class CRUDTest {
//    @Test
//    public void testFindAll(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            List<Student> students = studentDao.findAll();
//
//            for (Student student :students){
//                System.out.println(student);
//            }
//
//            session.commit();
//
//            session.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void testFindById(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = studentDao.findById(3);
//
//            System.out.println(student);
//
//            session.commit();
//            session.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testInsert(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = new Student();
//
//            student.setName("??????A???");
//            student.setAge((byte) 12);
//            student.setGender("???");
//            student.setBirthday(new Date(10,2,2));
//            student.setInfo("????????????");
//            int insert = studentDao.insert(student);
//
//            System.out.println(insert);
//
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testDelete(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            int delete = studentDao.delete(5);
//
//            System.out.println(delete);
//
//            session.commit();
//
//            session.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = new Student();
//
//            student.setId(3);
//
//            student.setInfo("???????????????");
//
//            int update = studentDao.update(student);
//
//            System.out.println(update);
//
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    public void testFindByKeyword(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            List<Student> students = studentDao.findByKeyword("%???-%");
//
//            for (Student student : students){
//                System.out.println(student);
//            }
//
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testGetAutoIncrement(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = new Student();
//
//            student.setName("??????");
//            student.setAge((byte) 16);
//            student.setGender("???");
//            student.setBirthday(new Date(117,10,1));
//            student.setInfo("???????????????");
//
//            int autoIncrement = studentDao.getAutoIncrement(student);
//
//            System.out.println("?????????????????????"+autoIncrement);
//            System.out.println("????????????id:"+student.getId());
//
//            session.commit();
//
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

//    }













//    @Test
//    public void testFindAll(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            List<Student> students = studentDao.findAll();
//
//            for (Student student : students){
//                System.out.println(student);
//            }
//
//            session.commit();
//
//            session.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testFindById(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = studentDao.findById(2);
//
//            System.out.println(student);
//
//            session.commit();
//
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Test
//    public void testInsert(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = new Student();
//
//            student.setName("??????");
//            student.setAge((byte) 18);
//            student.setGender("???");
//            student.setBirthday(new Date(123,2,5));
//            student.setInfo("?????????");
//
//            int insert = studentDao.insert(student);
//
//            System.out.println(insert);
//
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testDelete(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            int delete = studentDao.delete(14);
//
//            System.out.println(delete);
//
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testUpdate(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = new Student();
//
//            student.setId(4);
//            student.setInfo("???????????????");
//
//            int update = studentDao.update(student);
//
//            System.out.println(update);
//
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void testFindByKeyword(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            List<Student> students = studentDao.findByKeyword("%???%");
//
//            for (Student student :students){
//                System.out.println(student);
//            }
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    @Test
//    public void testGetAutoIncrement(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
//
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            SqlSession session = factory.openSession();
//
//            StudentDao studentDao = session.getMapper(StudentDao.class);
//
//            Student student = new Student();
//
//            student.setName("?????????");
//            student.setAge((byte) 2);
//            student.setGender("???");
//            student.setBirthday(new Date(222,2,2));
//            student.setInfo("??????");
//
//            int autoIncrement = studentDao.getAutoIncrement(student);
//
//            System.out.println("?????????????????????"+autoIncrement);
//            System.out.println("????????????id:"+student.getId());
//
//            session.commit();
//
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }









    @Test
    public void testFindAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            for (Student student : students){
                System.out.println(student);
            }

            session.commit();

            session.close();


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

            Student student = studentDao.findById(2);

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

            student.setName("??????");
            student.setAge((byte) 18);
            student.setGender("???");
            student.setBirthday(new Date(123,2,5));
            student.setInfo("?????????");

            int insert = studentDao.insert(student);

            System.out.println(insert);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDelete(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            int delete = studentDao.delete(14);

            System.out.println(delete);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdate(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setId(4);
            student.setInfo("???????????????");

            int update = studentDao.update(student);

            System.out.println(update);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByKeyword(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findByKeyword("%???%");

            for (Student student :students){
                System.out.println(student);
            }
            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testGetAutoIncrement(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("??????");
            student.setAge((byte) 2);
            student.setGender("???");
            student.setBirthday(new Date(222,2,2));
            student.setInfo("???????????????");

            int autoIncrement = studentDao.getAutoIncrement(student);

            System.out.println("?????????????????????"+autoIncrement);
            System.out.println("????????????id:"+student.getId());

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
