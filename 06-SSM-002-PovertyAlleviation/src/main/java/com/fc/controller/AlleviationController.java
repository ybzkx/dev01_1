package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    //扶贫政策获取
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                            Long id){
        return alleviationService.getList(pageNum,pageSize,id);
    }


    //扶贫政策添加
    @PostMapping("add")
    public ResultVO add(@RequestBody Alleviation alleviation){
        return alleviationService.add(alleviation);
    }



    //扶贫政策修改
    @PostMapping("update")
    public ResultVO update(@RequestBody Alleviation alleviation){
        return alleviationService.update(alleviation);
    }



    //扶贫政策删除
    @GetMapping("delete")
    public ResultVO delete(Long id){
        return alleviationService.delete(id);
    }



    //扶贫政策点击
    @PostMapping("click")
    public ResultVO click(Alleviation alleviation){
        return alleviationService.click(alleviation.getId(),alleviation.getLastClickTime());
    }


}
