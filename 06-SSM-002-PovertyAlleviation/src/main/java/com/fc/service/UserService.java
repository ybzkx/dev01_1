package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVO;

public interface UserService {
    ResultVO getList(Integer pageNum, Integer pageSize, User param);

    ResultVO add(User user);

    ResultVO update(User user);

    ResultVO delete(Long id);
}
