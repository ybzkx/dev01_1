package com.fc.vo;

import com.fc.entity.TbNote;
import lombok.Data;
import lombok.EqualsAndHashCode;

//主页上显示日记日期分类以及类别分类
@EqualsAndHashCode(callSuper = true)
@Data
public class NoteVO extends TbNote {
    //日记类型id
    private Integer typeId;
    //日记的名称
    private String typeName;
    //日记数量
    private Integer noteCount;
    //分组名称
    private String groupName;


}
