package com.fc.test;

import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class ORMTest {
    @Test
    public void testFindAll(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAll();

        for (Account account : accounts){
            System.out.println(account);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testFindAllOnMap(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAllOnMap();

        for (Account account : accounts){
            System.out.println(account);
        }
        MyBatisUtil.commit();
    }


    @Test
    public void testFindById(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findById(1);

        System.out.println(accounts);

        MyBatisUtil.commit();
    }
}
