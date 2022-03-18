package com.fc.dao;

import com.fc.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    List<Account> findAllOnMap();

    List<Account> findById(@Param("id") Integer tId);
}
