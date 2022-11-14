package com.ruoyi.system.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 【请填写功能名称】对象 pt_category
 * 
 * @author ruoyi
 * @date 2022-11-07
 */
public class PtCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    @JsonSerialize(using = ToStringSerializer.class)
    /** $column.columnComment */
    private Long cid;

    /** 父级编号ID */
    @Excel(name = "父级编号ID")
    private String parentid;

    /** 层级 顶级为0 */
    @Excel(name = "层级 顶级为0")
    private Long levels;

    /** 名称 */
    @Excel(name = "名称")
    private String names;

    List<String> childName;

    public List<PtCategory> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(List<PtCategory> childCategory) {
        this.childCategory = childCategory;
    }

    List<PtCategory> childCategory;
    public List<String> getChildName() {
        return childName;
    }

    public void setChildName(List<String> childName) {
        this.childName = childName;
    }

    /** 人工排序值 */
    @Excel(name = "人工排序值")
    private Integer sort;

    public void setCid(Long cid) 
    {
        this.cid = cid;
    }

    public Long getCid() 
    {
        return cid;
    }
    public void setParentid(String parentid) 
    {
        this.parentid = parentid;
    }

    public String getParentid() 
    {
        return parentid;
    }
    public void setLevels(Long levels) 
    {
        this.levels = levels;
    }

    public Long getLevels() 
    {
        return levels;
    }
    public void setNames(String names) 
    {
        this.names = names;
    }

    public String getNames() 
    {
        return names;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cid", getCid())
            .append("parentid", getParentid())
            .append("levels", getLevels())
            .append("names", getNames())
            .append("sort", getSort())
            .toString();
    }
}
