package com.fc.service.impl;

import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerService;
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
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;


    //志愿者招聘数据获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {

        List<VolunteerRecruitment> volunteerRecruitments;
        ResultVO resultVO;

        try{
            if (id == null){
                PageHelper.startPage(pageNum,pageSize);
                volunteerRecruitments = volunteerRecruitmentMapper.selectByExampleWithBLOBs(null);

            }else {
                VolunteerRecruitment volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(id);

                volunteerRecruitments = new ArrayList<>();
                volunteerRecruitments.add(volunteerRecruitment);
            }
            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);

            DataVO<VolunteerRecruitment> dataVO = new DataVO<>(pageInfo.getTotal(),volunteerRecruitments,pageNum,pageSize);

            resultVO = new ResultVO(200,"志愿者招聘数据获取成功",true,dataVO);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = new ResultVO(-1, "志愿者招聘数据获取失败", false, null);
        }
        return resultVO;
    }


    //志愿者招聘数据添加
    @Override
    public ResultVO add(VolunteerRecruitment volunteerRecruitment) {
        if (volunteerRecruitment.getCreateTime() == null){
            volunteerRecruitment.setCreateTime(new Date());
        }

        int affectedRows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);
        ResultVO resultVO;

        if (affectedRows > 0){
            resultVO = new ResultVO(200, "志愿者数据添加成功", true, volunteerRecruitment);
        }else {
            resultVO = new ResultVO(-1, "志愿者数据添加失败", false, null);


        }

        return resultVO;
    }


    //志愿者招聘数据修改
    @Override
    public ResultVO update(VolunteerRecruitment volunteerRecruitment) {
       int affectedRows = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);


        ResultVO resultVO;
       if (affectedRows > 0){
           resultVO = new ResultVO(200, "志愿者招聘数据修改成功", true, volunteerRecruitment);
       }else {
           resultVO = new ResultVO(-1, "志愿者招聘数据修改失败", false, null);

       }


        return resultVO;
    }

    //志愿者招聘数据删除
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (affectedRows > 0){
            resultVO = new ResultVO(200, "志愿者招聘数据删除成功", true, null);
        }else {
            resultVO = new ResultVO(-1, "志愿者招聘数据删除失败", false, null);

        }

        return resultVO;
    }



    //志愿者招聘数据点击
    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if (lastClickTime == null){
            lastClickTime = new Date();
        }
        ResultVO resultVO;
        Integer affectedRows = volunteerRecruitmentMapper.click(id, lastClickTime);

        if (affectedRows > 0){
            resultVO = new ResultVO(200, "点击量+1", true, null);

        }else {
            resultVO = new ResultVO(-1, "点击失败", false, null);

        }

        return resultVO;
    }


}
