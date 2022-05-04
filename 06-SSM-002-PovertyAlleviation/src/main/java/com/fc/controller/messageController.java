package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msgboard")
public class messageController {
    @Autowired
    private MessageBoardService messageBoardService;

    //留言板获取
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                            Long id){
        return messageBoardService.getList(pageNum,pageSize,id);
    }



    //留言板添加
    @PostMapping("add")
    public ResultVO add(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        return messageBoardService.add(messageBoardWithBLOBs);
    }



    //留言板修改
    @PostMapping("update")
    public ResultVO update(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs){
        return messageBoardService.update(messageBoardWithBLOBs);
    }



    //留言板删除
    @GetMapping("delete")
    public ResultVO delete(Long id){
        return messageBoardService.delete(id);
    }


}
