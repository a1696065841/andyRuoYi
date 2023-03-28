package com.ruoyi.system.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long caseId;
    List<PtCategory> ptCategories;

    List<PtCaseModel> ptCaseModels;

    public List<PtCaseModel> getPtCaseModels() {
        return ptCaseModels;
    }

    public void setPtCaseModels(List<PtCaseModel> ptCaseModels) {
        this.ptCaseModels = ptCaseModels;
    }

    public List<PtCategory> getPtCategories() {
        return ptCategories;
    }

    public void setPtCategories(List<PtCategory> ptCategories) {
        this.ptCategories = ptCategories;
    }

    public List<String> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<String> categoryId) {
        this.categoryId = categoryId;
    }
    private List<String> categoryId;
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
    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
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
            .append("caseId", getCaseId())
            .toString();
    }
}
