package com.fc.test;

import com.fc.dao.UserDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        userDao.add();
    }

    @Test
    public void testFactory(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao2 = applicationContext.getBean("userDao2", UserDao.class);

        userDao2.add();
    }

    @Test
    public void testStaticFactory(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao3 = applicationContext.getBean("userDao3", UserDao.class);

        userDao3.add();
    }
}
