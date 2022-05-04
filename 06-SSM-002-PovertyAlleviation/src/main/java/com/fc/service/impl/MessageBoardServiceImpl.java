package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    //留言板获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {

        List<MessageBoardWithBLOBs> messageBoards;
        ResultVO resultVO;

        try {
            if (id == null){
                PageHelper.startPage(pageNum,pageSize);
                messageBoards = messageBoardMapper.selectByExampleWithBLOBs(null);

            }else {
                MessageBoardWithBLOBs messageBoardWithBLOBs = messageBoardMapper.selectByPrimaryKey(id);
                messageBoards= new ArrayList<>();

                messageBoards.add(messageBoardWithBLOBs);
            }
            PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoards);

            DataVO<MessageBoardWithBLOBs> dataVO = new DataVO<>(pageInfo.getTotal(),messageBoards,pageNum,pageSize);

            resultVO = new ResultVO(200,"留言板获取成功",true,dataVO);
        }catch (Exception e){
            resultVO = new ResultVO(-1,"留言板获取失败",false,null);

        }

        return resultVO;
    }


    //留言板添加
    @Override
    public ResultVO add(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        if (messageBoardWithBLOBs.getCreateTime() == null){
            messageBoardWithBLOBs.setCreateTime(new Date());
        }

        int affectedRows = messageBoardMapper.insertSelective(messageBoardWithBLOBs);

        ResultVO resultVO;
        if (affectedRows > 0){
            resultVO = new ResultVO(200, "留言板添加成功", true, messageBoardWithBLOBs);
        }else {
            resultVO = new ResultVO(-1, "留言板添加失败", false, null);
        }


        return resultVO;
    }


    //留言表修改
    @Override
    public ResultVO update(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        int affectedRows = messageBoardMapper.updateByPrimaryKeySelective(messageBoardWithBLOBs);
        ResultVO resultVO;
        if (affectedRows > 0){
            MessageBoardWithBLOBs result = messageBoardMapper.selectByPrimaryKey(messageBoardWithBLOBs.getId());

            resultVO = new ResultVO(200, "留言表修改成功", true, result);
        }else {
            resultVO = new ResultVO(-1, "留言表修改失败", false, null);
        }

        return resultVO;
    }


    //留言表删除
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (affectedRows > 0){
            resultVO = new ResultVO(200, "留言表删除成功", true, null);
        }else {
            resultVO = new ResultVO(-1, "留言表删除失败", false, null);
        }

        return resultVO;
    }
}
