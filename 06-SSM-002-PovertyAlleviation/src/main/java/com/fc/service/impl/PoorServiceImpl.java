package com.fc.service.impl;
import com.fc.dao.PoorMapper;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;


    //贫困户获取
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {

        List<PoorWithBLOBs> poor;
        ResultVO resultVO;
        try{
            if (id == null){
                PageHelper.startPage(pageNum,pageSize);
                poor = poorMapper.selectByExampleWithBLOBs(null);
            }else {
                PoorWithBLOBs poorWithBLOBs = poorMapper.selectByPrimaryKey(id);
                poor = new ArrayList<>();

                poor.add(poorWithBLOBs);
            }
            PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(poor);
            DataVO<PoorWithBLOBs> dataVO = new DataVO<>(pageInfo.getTotal(), poor, pageNum, pageSize);

            resultVO = new ResultVO(200, "贫困户获取成功", true, dataVO);
        }catch (Exception e){
            e.printStackTrace();
            resultVO = new ResultVO(-1, "贫困户获取失败", false, null);

        }

        return resultVO;
    }


    //贫困户添加
    @Override
    public ResultVO add(PoorWithBLOBs poorWithBLOBs) {
        if (poorWithBLOBs.getCreateTime() == null){
            poorWithBLOBs.setCreateTime(new Date());
        }

        int affectedRows = poorMapper.insertSelective(poorWithBLOBs);

        ResultVO resultVO;
        if (affectedRows > 0){
            resultVO = new ResultVO(200, "贫困户添加成功", true, poorWithBLOBs);
        }else {
            resultVO = new ResultVO(-1, "贫困户添加失败", false, null);

        }
        return resultVO;
    }


    //贫困户修改
    @Override
    public ResultVO update(PoorWithBLOBs poorWithBLOBs) {
        int affectedRows = poorMapper.updateByPrimaryKeySelective(poorWithBLOBs);
        ResultVO resultVO;

        if (affectedRows > 0){
            resultVO = new ResultVO(200, "贫困户修改成功", true, poorWithBLOBs);
        }else {
            resultVO = new ResultVO(200, "贫困户修改成功", true, poorWithBLOBs);

        }
        return resultVO;
    }



    //贫困户删除
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = poorMapper.deleteByPrimaryKey(id);
        ResultVO resultVO;
        if (affectedRows > 0){
            resultVO = new ResultVO(200, "贫困户修改成功", true, null);
        }else {
            resultVO = new ResultVO(-1, "贫困户修改失败", false, null);

        }
        return resultVO;
    }


    //贫困户点击
    @Override
    public ResultVO click(Long id, Date lastClickTime) {
        if(lastClickTime == null){
            lastClickTime = new Date();
        }
        Integer affectedRows = poorMapper.click(id, lastClickTime);
        ResultVO resultVO;
        if (affectedRows > 0){
            resultVO = new ResultVO(200, "点击量加1", true, null);
        }else {
            resultVO = new ResultVO(-1, "点击失败", false, null);

        }
        return resultVO;
    }


}
