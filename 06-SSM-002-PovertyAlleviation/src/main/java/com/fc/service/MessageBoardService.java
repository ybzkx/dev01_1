package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVO;

public interface MessageBoardService {
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(MessageBoardWithBLOBs messageBoardWithBLOBs);

    ResultVO update(MessageBoardWithBLOBs messageBoardWithBLOBs);

    ResultVO delete(Long id);
}
