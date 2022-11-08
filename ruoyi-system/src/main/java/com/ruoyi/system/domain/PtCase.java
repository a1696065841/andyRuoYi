package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 pt_case
 * 
 * @author ruoyi
 * @date 2022-11-08
 */
public class PtCase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String describe;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String picInfo;

    /** $column.columnComment */
    private Integer caseId;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
    }
    public void setPicInfo(String picInfo) 
    {
        this.picInfo = picInfo;
    }

    public String getPicInfo() 
    {
        return picInfo;
    }
    public void setCaseId(Integer caseId) 
    {
        this.caseId = caseId;
    }

    public Integer getCaseId() 
    {
        return caseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("describe", getDescribe())
            .append("picInfo", getPicInfo())
            .append("caseId", getCaseId())
            .toString();
    }
}
