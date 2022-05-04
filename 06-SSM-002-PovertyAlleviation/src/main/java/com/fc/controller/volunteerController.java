package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")
public class volunteerController {
    @Autowired
    private VolunteerService volunteerService;

    //志愿者招聘数据获取
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                            Long id){
        return volunteerService.getList(pageNum,pageSize,id);
    }



    //志愿者招聘数据添加
    @PostMapping("add")
    public ResultVO add(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerService.add(volunteerRecruitment);
    }



    //志愿者招聘数据修改
    @PostMapping("update")
    public ResultVO update(@RequestBody VolunteerRecruitment volunteerRecruitment){
        return volunteerService.update(volunteerRecruitment);
    }


    //志愿者招聘数据删除
    @GetMapping("delete")
    public ResultVO delete(Long id){
        return volunteerService.delete(id);
    }




    //点击
    @PostMapping("click")
    public ResultVO click(VolunteerRecruitment volunteerRecruitment){
        return volunteerService.click(volunteerRecruitment.getId(),volunteerRecruitment.getCreateTime());
    }
}
