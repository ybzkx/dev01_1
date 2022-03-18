package com.fc.text;

import com.fc.config.ApplicationContextConfig;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        List<User> users = userDao.findAll();

        System.out.println(users);
    }

    @Test
    public void testFindByID() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);


        User user = userDao.findById(3);

        System.out.println(user);
    }


    @Test
    public void testFindCount(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int count = userDao.findCount();

        System.out.println(count);
    }


    @Test
    public void testInsert(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int insert = userDao.insert(new User(null, "杨幂", "123"));

        System.out.println(insert);
    }


    @Test
    public void testUpdate(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int update = userDao.update(new User(3, null, "333"));

        System.out.println(update);

    }

    @Test
    public void testDelete(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int delete = userDao.delete(6);

        System.out.println(delete);
    }
}
