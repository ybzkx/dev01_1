package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    //获取收藏表数据
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                            Long id){

        return collectionService.getList(pageNum,pageSize,id);

    }


    //添加收藏表数据
    @PostMapping("add")
    public ResultVO add(@RequestBody Collection collection){

        return collectionService.add(collection);
    }


    //修改收藏表数据
    @PostMapping("update")
    public ResultVO update(@RequestBody Collection collection){
        return collectionService.update(collection);
    }



    //删除收藏表数据
    @GetMapping("delete")
    public ResultVO delete(Long id){
        return collectionService.delete(id);
    }

}
